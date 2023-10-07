package com.nasaspaceapps.marketplace.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "credentials")
@Getter
@Setter
@ToString
public class Credentials {
    private String emailId;
    private String password;
    private String type;
}
