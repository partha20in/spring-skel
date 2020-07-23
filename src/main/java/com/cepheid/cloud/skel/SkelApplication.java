package com.cepheid.cloud.skel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.cepheid.cloud.skel.controller.DescriptionController;
import com.cepheid.cloud.skel.controller.ItemController;
import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.DescriptionRepository;
import com.cepheid.cloud.skel.repository.ItemRepository;

@SpringBootApplication(scanBasePackageClasses = { ItemController.class, DescriptionController.class, SkelApplication.class })
@EnableJpaRepositories(basePackageClasses = { ItemRepository.class,DescriptionRepository.class })
public class SkelApplication {

  public static void main(String[] args) {
    SpringApplication.run(SkelApplication.class, args);
  }


  
  @Bean
  public CommandLineRunner mappingDemo(ItemRepository Itemrepo,DescriptionRepository Descrepo
                                       ) {
      return args -> {

          // create a new book
          Item item = new Item("Car","valid");
 
          Long price1=(long) 2000;
          Long price2=(long) 1000;
          Long price3=(long) 1000;
          Long Id1=(long) 1;
          Long Id2=(long) 2;
          Long Id3=(long) 3;
          String type1= "Mercedes";
          String type2= "Audi";
          String type3= "Volvo";
          Description de1=new Description(Id1,type1,price1,item);
          Description de2=new Description(Id2,type2,price2,item);
          Description de3=new Description(Id3,type3,price3,item);

          // save the item
          Itemrepo.save(item);
          Descrepo.save(de1);
          Descrepo.save(de2);
          Descrepo.save(de3);


      };
  }
}
