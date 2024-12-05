package com.example.service;

import java.util.List;

import com.example.model.Usuario;

public interface UsuarioService {

    List<Usuario> buscarTodos(); //Este método não recebe parâmetros e retorna que é uma coleção que pode ser percorrida

    Usuario buscarPorId(Long Id);

    Usuario inserir(Usuario usuario) throws Exception;

    Usuario atualizar(Long id, Usuario usuario) throws Exception;;

    void deletar(Long id);

}
