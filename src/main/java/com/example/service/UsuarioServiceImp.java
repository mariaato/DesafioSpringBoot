package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
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
	public List<Usuario> buscarTodos() {
		// Buscar todos os Clientes.
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

	@Override
	public Usuario inserir(Usuario usuario){
		usuario.setDataCriacao(LocalDateTime.now());
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario atualizar(Long id, Usuario usuario){
		Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
		if(usuarioBd.isPresent()){
			return usuarioRepository.save(usuario);
		}
		return null;
	}

	@Override
	public void deletar(Long id){
		usuarioRepository.deleteById(id);
	}

}
