package com.example.IdentityService;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {
    private final IdentityRepository identityRepository;

    public IdentityService(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    public boolean existsByCi(String ci) {
        return identityRepository.findByCi(ci).isPresent();
    }
}

