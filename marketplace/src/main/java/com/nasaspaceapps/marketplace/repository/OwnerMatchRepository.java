package com.nasaspaceapps.marketplace.repository;

import com.nasaspaceapps.marketplace.entity.OwnerMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerMatchRepository extends MongoRepository<OwnerMatch,String> {
    OwnerMatch findByCollabEmailAndProjectName(String collabEmailId,String projectName);
}
