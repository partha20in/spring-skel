package com.cepheid.cloud.skel;

import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;

@RunWith(SpringRunner.class)
public class DescriptionControllerTest extends TestBase {

  @Test
  public void testGetItems() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions");
    
    Collection<Description> desc = descriptionController.get(new GenericType<Collection<Description>>() {
    });

  }
  
  @Test
  public void testInsertItems() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions");
    Item i=new Item("Bike","valid");
    Long id=(long) 1;
    Description d=new Description(id,"BMW",1000l,i);
    Response description = descriptionController.post(Entity.json(d));

  }
  
  @Test
  public void testUpdateItems() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions");
    Item i=new Item("Bike","valid");
    Long id=(long) 1;
    Description d=new Description(id,"BMW",1000l,i);
    Response description = descriptionController.put(Entity.json(d));


  }
  @Test
  public void testGetItemsById() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions/description/1");
    
    Item items = descriptionController.get(new GenericType<Item>() {
    });

  }
  
  @Test
  public void testDeleteItemsById() throws Exception {
    Builder descriptionController = getBuilder("/app/api/1.0/descriptions/description/1");
    
    descriptionController.delete();

  }
  
  
}
