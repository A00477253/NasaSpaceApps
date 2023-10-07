package com.nasaspaceapps.marketplace.controller;


import com.nasaspaceapps.marketplace.entity.Owners;
import com.nasaspaceapps.marketplace.service.IOwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
@Slf4j
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    @PostMapping("/save")
    public ResponseEntity<Owners> saveOwner(@RequestBody Owners owners) throws Exception {
        log.info("The owner object is {}",owners);
        Owners savedOwner=ownerService.getOwnerByEmailId(owners.getEmailId());
        if(savedOwner!=null){
            Owners errorOwner=new Owners();
            errorOwner.setErrorMessage("Owner Email id is already available");
            return new ResponseEntity<>(errorOwner, HttpStatus.BAD_REQUEST);
        }
        List<String> techStacksList = owners.getTechStack()
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        owners.setTechStack(techStacksList);

        ownerService.saveOwnerCredentials(owners);
        return new ResponseEntity<>(ownerService.saveOwner(owners), HttpStatus.OK);
    }

    @GetMapping("/getOwnerByEmailId/{emailId}")
    public ResponseEntity<Owners> getOwnerByEmailId(@PathVariable("emailId") String emailId){
        Owners savedOwner=ownerService.getOwnerByEmailId(emailId);
        return new ResponseEntity<>(savedOwner,HttpStatus.OK);
    }


}
