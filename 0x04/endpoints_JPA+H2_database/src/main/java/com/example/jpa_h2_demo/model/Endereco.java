package com.example.jpa_h2_demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

}

