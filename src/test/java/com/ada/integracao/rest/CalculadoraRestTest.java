package com.ada.integracao.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraRestTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    @Test
    public void teste_somar() throws Exception {
        String n1 = "4";
        String n2 = "6";
        String retorno = "10.0";
        String uri = "/calculadora/somar";

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                        .param("n1", n1)
                        .param("n2", n2)
        ).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.primeiroNumero").value(n1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.segundoNumero").value(n2))
        .andExpect(MockMvcResultMatchers.jsonPath("$.resultados[0]").value(retorno))
        .andExpect(MockMvcResultMatchers.jsonPath("$.resultados[1]").value("5"))
        ;
    }
     */


    @Test
    public void teste_multiplicar() throws Exception {
        String n1 = "4";
        String n2 = "6";
        String retorno = "24.0";
        String uri = "/calculadora/multiplicar";

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("n1",n1)
                        .param("n2",n2)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.n1").value(n1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.n2").value(n2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultado").value(retorno));
    }

    @Test
    public void teste_dividir() throws Exception {
        String n1 = "10";
        String n2 = "2";
        String retorno = "5.0";
        String uri = "/calculadora/dividir";

        mockMvc.perform(
                        MockMvcRequestBuilders.get(uri)
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("n1",n1)
                                .param("n2",n2)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.n1").value(n1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.n2").value(n2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultado").value(retorno));
    }

    @Test
    public void teste_dividir_por_zero() throws Exception {
        String n1 = "10";
        String n2 = "0";
        String retorno = "número inválido";
        String uri = "/calculadora/dividir";

        mockMvc.perform(
                        MockMvcRequestBuilders.get(uri)
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("n1",n1)
                                .param("n2",n2)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(retorno));
    }

    @Test
    public void teste_dividir_maior_por_menor() throws Exception {
        String n1 = "10";
        String n2 = "2";
        String retorno = "5.0";
        String uri = "/calculadora/dividir";

        mockMvc.perform(
                        MockMvcRequestBuilders.get(uri)
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("n1",n1)
                                .param("n2",n2)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.n1").value(n1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.n2").value(n2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultado").value(retorno));
    }

    @Test
    public void teste_dividir_menor_por_maior() throws Exception {
        String n1 = "2";
        String n2 = "10";
        String retorno = "número inválido";
        String uri = "/calculadora/dividir";

        mockMvc.perform(
                        MockMvcRequestBuilders.get(uri)
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("n1",n1)
                                .param("n2",n2)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(retorno));
    }

}