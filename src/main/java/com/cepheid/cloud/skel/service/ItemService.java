package com.cepheid.cloud.skel.service;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cepheid.cloud.skel.model.*;
import com.cepheid.cloud.skel.repository.*;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository mItemRepository;
	
	public Collection<Item> getItemsService() {
	    return mItemRepository.findAll();
	  }
	
	public Item postItemsService(Item it) {
		return mItemRepository.save(it) ;
		  }
	
	public Optional<Item> getItemById(Long id) {
		   Optional<Item> item= mItemRepository.findBymId(id);
		   return item;
		  }
	
	public void deleteItemById(Long id) {
		   
		   mItemRepository.deleteBymId(id);
		   
		  }
	
	public Item updateItems(Item it) {
		  return mItemRepository.save(it) ;
		  }
}
