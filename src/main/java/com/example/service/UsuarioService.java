package com.example.service;

import com.example.model.Usuario;

public interface UsuarioService {

    Iterable<Usuario> buscarTodos(); //Este método não recebe parâmetros e retorna que é uma coleção que pode ser percorrida

    Usuario buscarPorId(Long Id);

    void inserir(Usuario usuario);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);

}
