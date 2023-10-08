package com.nasaspaceapps.marketplace.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ownerMatch")
@ToString
@Getter
@Setter
public class OwnerMatch {
    private String ownerEmail;
    private String collabEmail;
    private String projectName;
}
