package com.challenge.alura.Topicos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_autor",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario autor;
    private Boolean solucion = false;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_topico",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Topico topico;
}
