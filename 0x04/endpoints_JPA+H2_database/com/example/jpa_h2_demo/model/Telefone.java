package com.example.jpa_h2_demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ddd;
    private String numero;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

}

