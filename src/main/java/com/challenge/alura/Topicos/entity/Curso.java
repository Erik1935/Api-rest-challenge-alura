package com.challenge.alura.Topicos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Topico> topicos = new ArrayList<>();
}
