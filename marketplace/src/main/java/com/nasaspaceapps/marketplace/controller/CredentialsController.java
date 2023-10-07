package com.nasaspaceapps.marketplace.controller;


import com.nasaspaceapps.marketplace.entity.Credentials;
import com.nasaspaceapps.marketplace.service.ICredentialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credential")
@Slf4j
public class CredentialsController {

    @Autowired
    private ICredentialService credentialService;

    @GetMapping("/fetch")
    public ResponseEntity<Credentials> getCredentials( @RequestParam(name = "emailId")String emailId){
        Credentials credentials=credentialService.getCredentialsByEmailId
                (emailId.toLowerCase());
        log.info("The credential objetc is {}",credentials);
        return new ResponseEntity<>
                (credentials
                        , HttpStatus.OK);

    }
}
