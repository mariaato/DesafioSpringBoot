package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;



@Service
public class UsuarioServiceImp implements UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;


	@Override
	public Iterable<Usuario> buscarTodos() {
		// Buscar todos os Clientes.
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

	@Override
	public void inserir(Usuario usuario){
		usuarioRepository.save(usuario);
	}

	@Override
	public void atualizar(Long id, Usuario usuario){
		Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
		if(usuarioBd.isPresent()){
			usuarioRepository.save(usuario);
		}
	}

	@Override
	public void deletar(Long id){
		usuarioRepository.deleteById(id);
	}

}
