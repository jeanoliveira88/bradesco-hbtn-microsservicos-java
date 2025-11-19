// java
package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private Calculator calculator;

    @Test
    void messageWelcome() throws Exception {
        mvc.perform(get("/calculator/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string("Bem vindo à CALCULATOR API REST."));
    }

    @Test
    void addNumbers() throws Exception {
        when(calculator.sum(5.0, 3.0)).thenReturn(8.0);
        mvc.perform(get("/calculator/addNumbers")
                        .param("number1", "5")
                        .param("number2", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    void subNumbers() throws Exception {
        when(calculator.sub(10.0, 3.0)).thenReturn(7.0);
        mvc.perform(get("/calculator/subNumbers")
                        .param("number1", "10")
                        .param("number2", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("7.0"));
    }

    @Test
    void divideNumbers() throws Exception {
        when(calculator.divide(10.0, 2.0)).thenReturn(5.0);
        mvc.perform(get("/calculator/divideNumbers")
                        .param("number1", "10")
                        .param("number2", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void factorial() throws Exception {
        when(calculator.factorial(5)).thenReturn(120);
        mvc.perform(get("/calculator/factorial")
                        .param("factorial", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("120"));
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        LocalDate d1 = LocalDate.of(2020, 3, 15);
        LocalDate d2 = LocalDate.of(2020, 3, 29);
        when(calculator.calculeDayBetweenDate(d1, d2)).thenReturn("14");
        when(calculator.calculeDayBetweenDate(d2, d1)).thenReturn("14");

        mvc.perform(get("/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-15")
                        .param("localDate2", "2020-03-29"))
                .andExpect(status().isOk())
                .andExpect(content().string("14"));

        mvc.perform(get("/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-29")
                        .param("localDate2", "2020-03-15"))
                .andExpect(status().isOk())
                .andExpect(content().string("14"));
    }

    @Test
    void integerToBinary() throws Exception {
        when(calculator.integerToBinary(20)).thenReturn("10100");
        mvc.perform(get("/calculator/integerToBinary")
                        .param("number1", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("10100"));
    }

    @Test
    void integerToHexadecimal() throws Exception {
        when(calculator.integerToHexadecimal(170)).thenReturn("AA");
        mvc.perform(get("/calculator/integerToHexadecimal")
                        .param("number1", "170"))
                .andExpect(status().isOk())
                .andExpect(content().string("AA"));
    }
}
