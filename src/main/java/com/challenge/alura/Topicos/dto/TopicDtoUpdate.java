package com.challenge.alura.Topicos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDtoUpdate {
    private Long id;
    private String titulo;
    private String mensaje;
    private int autor;
    private int curso;
}
