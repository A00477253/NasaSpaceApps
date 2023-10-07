package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Credentials;
import com.nasaspaceapps.marketplace.entity.Owners;

public interface ICredentialService {

    Credentials getCredentialsByEmailId(String emailId);

}
