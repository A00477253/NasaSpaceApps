package com.nasaspaceapps.marketplace.repository;

import com.nasaspaceapps.marketplace.entity.CollaboratorMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorMatchRepository extends MongoRepository<CollaboratorMatch,String> {

    CollaboratorMatch findByOwnerEmailAndProjectName(String OwnerEmail,String projectName);
}
