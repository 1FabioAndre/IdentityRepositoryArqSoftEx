package com.example.IdentityService;

import com.example.IdentityService.IdentityServiceApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class IdentityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // Aquí podrías limpiar o inicializar datos si es necesario
    }

    @Test
    public void testAddIdentity() throws Exception {
        mockMvc.perform(post("/identity/add?ci=12345&name=Fabio"))
                .andExpect(status().isOk())
                .andExpect(content().string("Identidad agregada con éxito: Fabio"));
    }

    @Test
    public void testVerifyIdentity() throws Exception {
        // Primero agrega una identidad
        mockMvc.perform(post("/identity/add?ci=12345&name=Fabio"));

        // Luego verifica la identidad
        mockMvc.perform(get("/identity/verify/12345"))
                .andExpect(status().isOk())
                .andExpect(content().string("Identidad verificada: Fabio"));
    }

    @Test
    public void testVerifyNonExistentIdentity() throws Exception {
        mockMvc.perform(get("/identity/verify/99999"))
                .andExpect(status().isOk())
                .andExpect(content().string("Identidad no encontrada."));
    }
}
