package com.nasaspaceapps.marketplace.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "collaboratorMatch")
@ToString
@Getter
@Setter
public class CollaboratorMatch {
    private String collaboratorEmail;
    private String ownerEmail;
    private String projectName;

}
