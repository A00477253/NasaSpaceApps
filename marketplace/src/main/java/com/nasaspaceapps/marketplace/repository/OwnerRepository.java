package com.nasaspaceapps.marketplace.repository;

import com.nasaspaceapps.marketplace.entity.Owners;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends MongoRepository<Owners,String> {

    Owners findByEmailId(String emailId);
}
