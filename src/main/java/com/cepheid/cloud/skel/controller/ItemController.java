package com.cepheid.cloud.skel.controller;

import java.util.Collection;
import java.util.Optional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.service.ItemService;
import io.swagger.annotations.Api;


// curl http:/localhost:8444/app/api/1.0/items/item/{id} getby Id
//curl http:/localhost:8444/app/api/1.0/items/item/{id} delete by id
// curl http:/localhost:8444/app/api/1.0/items get all items
//curl http:/localhost:8444/app/api/1.0/items  POST insert new items
//curl http:/localhost:8444/app/api/1.0/items  PUT update items

@Component
@Path("/api/1.0/items")
@Api()
public class ItemController {
  

	@Autowired
	private ItemService service;


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public Collection<Item> getItems() {
	
    return service.getItemsService();
  }
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Item postItems(@RequestBody Item it) {
  return service.postItemsService(it);
  }
  
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Item updateItems(@RequestBody Item it) {
  return service.updateItems(it);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/item/{id}")
  public Optional<Item> getItemById(@PathParam(value = "id") Long id) {
   
   return service.getItemById(id);
  }
  
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  @Path("/item/{id}")
  public void deleteItemById(@PathParam(value = "id") Long id) {
   service.deleteItemById(id);
   
  }
 
  
}
