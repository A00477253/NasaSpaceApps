package com.nasaspaceapps.marketplace.repository;

import com.nasaspaceapps.marketplace.entity.Credentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CredentialsRepository extends MongoRepository<Credentials,String> {

    Credentials findByEmailId(String emailId);
}
