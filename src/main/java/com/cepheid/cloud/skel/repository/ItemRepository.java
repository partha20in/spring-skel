package com.cepheid.cloud.skel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cepheid.cloud.skel.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
Optional<Item> findBymId(Long mId);
List<Item> findAll();
void deleteBymId(Long mId);
 Item save(Item i);
}
