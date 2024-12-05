package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

		if(usuarioBd.isPresent()){
			// usuarioAtualizado.setDataCriacao(usuarioBd.get().getDataCriacao());
			var user = usuarioBd.get();
			BeanUtils.copyProperties(usuarioAtualizado, user, "id","dataCriacao");

			return usuarioRepository.save(user);
		}
			
		throw new Exception("Usuário não encontrado");
	}
	

	@Override
	public void deletar(Long id){
		usuarioRepository.deleteById(id);
	}

}
