package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping( value= "/{id}")
    public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id) {
       return ResponseEntity.ok(usuarioRepository.findById(id).get());
    }
}
