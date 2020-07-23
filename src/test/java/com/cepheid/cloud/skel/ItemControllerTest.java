package com.cepheid.cloud.skel;

import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cepheid.cloud.skel.model.Item;

@RunWith(SpringRunner.class)
public class ItemControllerTest extends TestBase {

  @Test
  public void testGetItems() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items");
    
    Collection<Item> items = itemController.get(new GenericType<Collection<Item>>() {
    });

  }
  
  @Test
  public void testInsertItems() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items");
    Item i=new Item("Bike","valid");
    Response items = itemController.post(Entity.json(i));

  }
  
  @Test
  public void testUpdateItems() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items");
    Item i=new Item("Cycle","valid");
    Response items = itemController.put(Entity.json(i));

  }
  @Test
  public void testGetItemsById() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items/item/1");
    
    Item items = itemController.get(new GenericType<Item>() {
    });

  }
  
  @Test
  public void testDeleteItemsById() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items/item/1");
    
    itemController.delete();

  }
  
  
}
