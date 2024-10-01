package com.example.IdentityService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/identity")
public class IdentityController {
    private List<Identity> identities = new ArrayList<>();


    @PostMapping("/add")
    public String addIdentity(@RequestParam String ci, @RequestParam String name) {
        Identity identity = new Identity(ci, name);
        identities.add(identity);
        System.out.println("Identidad guardada: " + identity.getCi() + " - " + identity.getName());
        return "Identidad agregada con éxito: " + name;
    }

    @GetMapping("/verify/{ci}")
    public String verifyIdentity(@PathVariable String ci) {
        Optional<Identity> identity = identities.stream()
                .filter(i -> i.getCi().equals(ci))
                .findFirst();

        if (identity.isPresent()) {
            return "Identidad verificada: " + identity.get().getName();
        } else {
            return "Identidad no encontrada.";
        }
    }
}
