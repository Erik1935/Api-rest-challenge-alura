package com.challenge.alura.Topicos.service;

import com.challenge.alura.Topicos.dto.TopicDto;
import com.challenge.alura.Topicos.dto.TopicDtoUpdate;
import com.challenge.alura.Topicos.entity.Curso;
import com.challenge.alura.Topicos.entity.Topico;
import com.challenge.alura.Topicos.entity.Usuario;
import com.challenge.alura.Topicos.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicoService {
    private final TopicoRepository topicoRepository;

    public String createNewTopic(TopicDto topicDto){
        Optional<Topico> topicos = topicoRepository.findByTituloAndMensaje(topicDto.getTitulo(),topicDto.getMensaje());
        if(topicos.isEmpty()){
            Topico topico = new Topico();
            topico.setTitulo(topicDto.getTitulo());
            topico.setMensaje(topicDto.getMensaje());
            Curso curso = new Curso();
            curso.setId(Long.valueOf(topicDto.getCurso()));
            topico.setCurso(curso);
            Usuario usuario = new Usuario();
            usuario.setId(Long.valueOf(topicDto.getAutor()));
            topico.setAutor(usuario);
            topicoRepository.save(topico);
            return "Nuevo topico añadido";
        }
        return "No se admiten titulos y mensajes duplicados";
    }
    //actualizar
    public String updateTopic(TopicDtoUpdate topicDtoUpdate){
        Topico topico = topicoRepository.findById(topicDtoUpdate.getId()).get();
        if(topico != null){
            topico.setTitulo(topicDtoUpdate.getTitulo());
            topico.setMensaje(topicDtoUpdate.getMensaje());
            Curso curso = new Curso();
            curso.setId(Long.valueOf(topicDtoUpdate.getCurso()));
            topico.setCurso(curso);
            Usuario usuario = new Usuario();
            usuario.setId(Long.valueOf(topicDtoUpdate.getAutor()));
            topico.setAutor(usuario);
            topicoRepository.save(topico);
            return "Topico Actualizado";
        }
        return "Datos invalidos";
    }
    //obtener
    public List<Topico> getAllTopicos(){
        return topicoRepository.findAll();
    }
    //borrar
    public String deleteTopic(Long id){
        Topico topico = topicoRepository.findById(id).get();
        if(topico != null){
            topicoRepository.delete(topico);
            return "Topico eliminado";
        }
        return "Topico invalido";
    }
}
