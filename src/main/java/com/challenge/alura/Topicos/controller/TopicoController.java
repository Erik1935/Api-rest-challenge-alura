package com.challenge.alura.Topicos.controller;

import com.challenge.alura.Topicos.dto.TopicDto;
import com.challenge.alura.Topicos.dto.TopicDtoUpdate;
import com.challenge.alura.Topicos.entity.Topico;
import com.challenge.alura.Topicos.service.TopicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TopicoController {
    private final TopicoService topicoService;

    @GetMapping("/topicos")
    public ResponseEntity<List<Topico>>getAllTopicos(){
        return new ResponseEntity<List<Topico>>(topicoService.getAllTopicos(), HttpStatus.OK);
    }
    @PostMapping("/topicos")
    public ResponseEntity<String>createNewTopic(@RequestBody TopicDto topicDto){
        return new ResponseEntity<String>(topicoService.createNewTopic(topicDto),HttpStatus.CREATED);
    }
    @PutMapping("/topicos")
    public ResponseEntity<String>updateTopic(@RequestBody TopicDtoUpdate topicDtoUpdate){
        return new ResponseEntity<String>(topicoService.updateTopic(topicDtoUpdate),HttpStatus.OK);
    }
    @DeleteMapping("/topicos/{id}")
    public ResponseEntity<String>deleteTopic(@PathVariable int id){
        return new ResponseEntity<String>(topicoService.deleteTopic(Long.valueOf(id)),HttpStatus.OK);
    }
}
