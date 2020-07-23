package com.cepheid.cloud.skel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cepheid.cloud.skel.model.*;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
Optional<Description> findBymId(Long mId);
List<Description> findAll();
void deleteBymId(Long mId);
 Description save(Description d);
}
