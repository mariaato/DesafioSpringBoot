package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Usuario;
import com.example.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Listagem Geral
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodos());
    }

    //Consulta po ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id) {
       return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorId(id));
    }

    // Cadastrar
    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario ) {
        usuarioService.inserir(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.atualizar(id, usuario);        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
    }
    
    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    } 
}
