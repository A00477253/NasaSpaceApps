package com.nasaspaceapps.marketplace.repository;

import com.nasaspaceapps.marketplace.entity.Owners;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends MongoRepository<Owners,String> {

    Owners findByEmailId(String emailId);

    List<Owners> findByTechStackInIgnoreCase(List<String> skills);
}
