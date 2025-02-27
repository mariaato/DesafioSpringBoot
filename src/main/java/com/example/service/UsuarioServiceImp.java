package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;
import com.example.util.BeanUtil;

import jakarta.validation.Valid;



@Service
public class UsuarioServiceImp implements UsuarioService {
    

	
    @Autowired
    UsuarioRepository usuarioRepository;


	@Override
	public Page<Usuario> buscarTodos(Pageable pageable) {
		
		return usuarioRepository.findByExcluidoFalse(pageable);
		
	}

	@Override
	public Usuario buscarPorId(Long id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);

		try{
			if(usuario != null){
				return usuario.get();

			}
		}catch(Exception e){
			throw new RuntimeException("Usuario não encontrado", e);
		}
		return null;
	}

	@Override
	public Usuario inserir( @Valid Usuario usuario)throws Exception{
		if(usuarioRepository.findTop1ByCpf(usuario.getCpf()) != null) {
			throw new Exception("O cpf inserido já pertence a outro usuario");
		}
		usuario.setDataCriacao(LocalDateTime.now());
		usuario.setExcluido(false);
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario atualizar(Long id, @Valid Usuario usuarioAtualizado)throws Exception{

		Optional<Usuario> usuarioBd = usuarioRepository.findById(id);

		if(usuarioRepository.findTop1ByCpf(usuarioAtualizado.getCpf()) != null) {
			throw new Exception("O cpf inserido já pertence a outro usuario");
		}
		if(usuarioBd.isPresent()){
			// usuarioAtualizado.setDataCriacao(usuarioBd.get().getDataCriacao());
			Usuario user = usuarioBd.get();
			BeanUtil.copyNonNullProperties(usuarioAtualizado, user);

			return usuarioRepository.save(user);
		}
			
		throw new Exception("Usuário não encontrado");
	}
	

	@Override
	public void deletar(Long id) throws Exception{
		try {
			// usuarioRepository.deleteById(id);
			Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
			
			Usuario usuario = usuarioBd.get();
			usuario.setExcluido(true);
			usuarioRepository.save(usuario);

		} catch (Exception e) {
			throw new Exception("Usuario não encontrado");
		}
	}

}
