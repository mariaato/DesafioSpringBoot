package com.example.springboot.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.model.Usuario;
import jakarta.persistence.EntityManager;
import com.example.repository.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@DataJpaTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {


    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EntityManager entityManager;


    private Usuario inserir(Usuario usuario){
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setExcluido(false);
    
        entityManager.persist(usuario);
        return usuario;
    }

    @Test
    void findTop1ByCpfSuccess(){
        String cpf = "14495985957";
        Usuario usuario = new Usuario(null, "Maria Antonia", null, cpf, false);
        this.inserir(usuario);

        Usuario result = this.usuarioRepository.findTop1ByCpf(cpf);

        assertNotNull(result);
    }


    @Test
    void findTop1ByCpfFail(){
        String cpf = "14495985957";

        Usuario result = this.usuarioRepository.findTop1ByCpf(cpf);

        assertNull(result);
        }
}
