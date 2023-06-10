package com.challenge.alura.Topicos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Topico> topicos;
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Respuesta> respuestas;
}
