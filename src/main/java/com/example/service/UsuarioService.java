package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;


	@Override
	public Iterable<Usuario> buscarTodos() {
		// Buscar todos os Clientes.
		return usuarioRepository.findAll();
	}
}
