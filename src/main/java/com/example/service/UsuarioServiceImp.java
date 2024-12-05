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
	public Usuario inserir(Usuario usuario)throws Exception{
		if(usuarioRepository.findTop1ByCpf(usuario.getCpf()) != null) {
			throw new Exception("O cpf inserido já pertence a outro usuario");
		}
		usuario.setDataCriacao(LocalDateTime.now());
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario atualizar(Long id, Usuario usuarioAtualizado)throws Exception{

		Optional<Usuario> usuarioBd = usuarioRepository.findById(id);

		Usuario usuarioExistente = usuarioRepository.findTop1ByCpf(usuarioAtualizado.getCpf());

		if(usuarioExistente != null && !usuarioAtualizado.getId().equals(usuarioExistente.getId())){
			throw new Exception("O CPF inserido já pertence a outro usuário");
		}

		if(usuarioBd.isPresent()){
			usuarioAtualizado.setDataCriacao(usuarioBd.get().getDataCriacao());
			return usuarioRepository.save(usuarioAtualizado);
		}
			
		throw new Exception("Usuário não encontrado");
	}
	

	@Override
	public void deletar(Long id){
		usuarioRepository.deleteById(id);
	}

}
