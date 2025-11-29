package com.xev.springboot_test_devsu_1_client.controller;

import com.xev.springboot_test_devsu_1_client.repository.ClienteRepository;
import com.xev.springboot_test_devsu_1_client.utils.JwtTestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtTestUtil jwtTestUtil;


    @Test
    void createClient() throws Exception {

        String json = """
        {
            "identificacion": 2002,
            "nombre": "Carlos Diaz",
            "genero": "MASCULINO",
            "edad": 28,
            "direccion": "Av 45",
            "telefono": "3213334444",
            "clientId": 2002,
            "contrasena": "12345",
            "estado": true
        }
        """;

        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Carlos Diaz"))
                .andExpect(jsonPath("$.genero").value("MASCULINO"))
                .andExpect(jsonPath("$.clientId").value(2002));
    }
}