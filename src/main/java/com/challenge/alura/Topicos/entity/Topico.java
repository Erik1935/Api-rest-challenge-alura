package com.challenge.alura.Topicos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_curso",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Curso curso;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario autor;
    @OneToMany(mappedBy = "topico",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Respuesta> respuestas = new ArrayList<>();
}
