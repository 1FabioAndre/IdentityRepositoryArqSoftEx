package com.example.IdentityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentityController {
    private final IdentityService identityService;

    public IdentityController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @GetMapping("/verify-ci")
    public ResponseEntity<String> verifyCi(@RequestParam String ci) {
        boolean exists = identityService.existsByCi(ci);
        if (exists) {
            return ResponseEntity.ok("El CI existe.");
        } else {
            return ResponseEntity.ok("El CI no existe.");
        }
    }
}
