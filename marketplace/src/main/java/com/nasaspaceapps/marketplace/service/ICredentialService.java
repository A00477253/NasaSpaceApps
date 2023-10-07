package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Credentials;

public interface ICredentialService {

    Credentials getCredentialsByEmailId(String emailId);
}
