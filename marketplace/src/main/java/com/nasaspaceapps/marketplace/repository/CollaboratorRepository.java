package com.nasaspaceapps.marketplace.repository;

import com.nasaspaceapps.marketplace.entity.Collaborator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CollaboratorRepository extends MongoRepository<Collaborator,String> {

    Collaborator findByEmailId(String emailId);

    List<Collaborator> findBySkillsInIgnoreCase(List<String> techStacks);
}
