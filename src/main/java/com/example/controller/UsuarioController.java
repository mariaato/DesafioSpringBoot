package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Usuario;
import com.example.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Validated
@RestController
@RequestMapping("/usuarios/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    
    //Listagem Geral
    @GetMapping
    public ResponseEntity<Page<Usuario>> buscarTodos(@RequestParam(name = "page",defaultValue = "0")int page, @RequestParam(name = "size",defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodos(pageable));
    }

    //Consulta po ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id){
       return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorId(id));
    }

    // Cadastrar
    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody @Valid Usuario usuario ) throws Exception {
        usuarioService.inserir(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable  Long id, @RequestBody Usuario usuario) throws Exception{
        usuarioService.atualizar(id, usuario);        
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
    
    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) throws Exception{
        usuarioService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    } 
}
