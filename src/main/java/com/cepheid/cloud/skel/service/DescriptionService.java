package com.cepheid.cloud.skel.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cepheid.cloud.skel.model.*;
import com.cepheid.cloud.skel.repository.*;

@Service
public class DescriptionService {
	
	@Autowired
	private DescriptionRepository mDescriptionRepository;
	
	public List<Description> getDescriptionService() {
	    return mDescriptionRepository.findAll();
	  }
	
	public Description postDescriptionService(Description de) {
		return mDescriptionRepository.save(de) ;
		  }
	
	public Optional<Description> getDescriptionById(Long id) {
		   Optional<Description> desc= mDescriptionRepository.findBymId(id);
		   return desc;
		  }
	
	public void deleteDescriptionById(Long id) {
		   
		mDescriptionRepository.deleteBymId(id);
		   
		  }
	
	public Description updateDescription(Description de) {
		  return mDescriptionRepository.save(de) ;
		  }
}
