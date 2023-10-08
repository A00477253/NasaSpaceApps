package com.nasaspaceapps.marketplace.controller;


import com.nasaspaceapps.marketplace.entity.Credentials;
import com.nasaspaceapps.marketplace.entity.Owners;
import com.nasaspaceapps.marketplace.service.ICredentialService;
import com.nasaspaceapps.marketplace.service.IOwnerService;
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

    @Autowired
    private IOwnerService ownerService;

    @GetMapping("/fetch")
    public ResponseEntity<Credentials> getCredentials( @RequestParam(name = "emailId")String emailId){
        Credentials credentials=credentialService.getCredentialsByEmailId
                (emailId.toLowerCase());
        log.info("The credential object is {}",credentials);
        return new ResponseEntity<>
                (credentials
                        , HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<Owners> login(@RequestBody Credentials providedCredentials) {
        Owners owner=new Owners();
        Credentials actualCredentials=credentialService.getCredentialsByEmailId(providedCredentials.getEmailId());
        if(providedCredentials.getPassword().equals(actualCredentials.getPassword())) {
            owner=ownerService.getOwnerByEmailId(providedCredentials.getEmailId());
            return new ResponseEntity<>(owner,HttpStatus.OK);
        } else {
            owner.setErrorMessage("Incorrect credentials provided");
            return new ResponseEntity<>(owner,HttpStatus.BAD_REQUEST);
        }
    }
}
