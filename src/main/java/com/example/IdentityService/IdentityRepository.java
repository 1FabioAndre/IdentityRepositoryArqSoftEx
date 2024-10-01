package com.example.IdentityService;
import com.example.IdentityService.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IdentityRepository extends JpaRepository<Identity, String> {
    Optional<Identity> findByCi(String ci);
}