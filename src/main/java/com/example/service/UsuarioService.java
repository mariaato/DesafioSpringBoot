package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.model.Usuario;

import jakarta.validation.Valid;

public interface UsuarioService {

    Page<Usuario> buscarTodos(Pageable pageable); 

    Usuario buscarPorId(Long Id);

    Usuario inserir( @Valid Usuario usuario) throws Exception;

    Usuario atualizar(Long id, Usuario usuario) throws Exception;;

    void deletar(Long id) throws Exception;

}
