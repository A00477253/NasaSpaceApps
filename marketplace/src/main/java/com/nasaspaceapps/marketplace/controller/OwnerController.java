package com.nasaspaceapps.marketplace.controller;


import com.nasaspaceapps.marketplace.entity.Owners;
import com.nasaspaceapps.marketplace.service.IOwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
@Slf4j
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    @PostMapping("/save")
    public Owners saveOwner(@RequestBody Owners owners){
        log.info("The owner object is {}",owners);
        return ownerService.saveOwner(owners);
    }
}
