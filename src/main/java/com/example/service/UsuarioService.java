package com.example.service;

import java.util.List;

import com.example.model.Usuario;

import jakarta.validation.Valid;

public interface UsuarioService {

    List<Usuario> buscarTodos(int page, int size); //Este método não recebe parâmetros e retorna que é uma coleção que pode ser percorrida

    Usuario buscarPorId(Long Id);

    Usuario inserir( @Valid Usuario usuario) throws Exception;

    Usuario atualizar(Long id, @Valid Usuario usuario) throws Exception;;

    void deletar(Long id) throws Exception;

}
