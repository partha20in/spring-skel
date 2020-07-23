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
import com.cepheid.cloud.skel.model.*;
import com.cepheid.cloud.skel.service.*;
import io.swagger.annotations.Api;


// curl http:/localhost:8444/app/api/1.0/descriptions/description/{id} getById
//curl http:/localhost:8444/app/api/1.0/descriptions/description/{id}  delete
//curl http:/localhost:8444/app/api/1.0/descriptions getAll 
//curl http:/localhost:8444/app/api/1.0/descriptions  update using PUT
//curl http:/localhost:8444/app/api/1.0/descriptions  insert using POST

@Component
@Path("/api/1.0/descriptions")
@Api()
public class DescriptionController {
  

  @Autowired
  private DescriptionService service;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public Collection<Description> getDescriptions() {
	
    return service.getDescriptionService();
  }
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Description postDescription(@RequestBody Description de) {
  return service.postDescriptionService(de);
  }
  
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Description updateItems(@RequestBody Description de) {
  return service.updateDescription(de);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  @Path("/description/{id}")
  public Optional<Description> getItemById(@PathParam(value = "id") Long id) {
   
   return service.getDescriptionById(id);
  }
  
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  @Path("/description/{id}")
  public void deleteDescriptionById(@PathParam(value = "id") Long id) {
   service.deleteDescriptionById(id);
   
  }
 
  
}
