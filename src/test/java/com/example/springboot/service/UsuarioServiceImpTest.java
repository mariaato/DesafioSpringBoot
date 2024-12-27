package com.example.springboot.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;
import com.example.service.UsuarioService;
import com.example.service.UsuarioServiceImp;



@DataJpaTest
@ActiveProfiles("test")

public class UsuarioServiceImpTest{

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private UsuarioServiceImp usuarioServiceImp;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void inserirTest() throws Exception {
        String cpf = "14495985957";
        Usuario usuario = new Usuario(123L, "Maria Antonia", null, cpf, false);

        when(usuarioRepository.findTop1ByCpf(cpf)).thenReturn(usuario);
        when(usuarioServiceImp.inserir(usuario)).thenReturn(usuario);

        Usuario result = usuarioServiceImp.inserir(usuario);

        assertNotNull(result);
        assertThat(usuarioRepository.findTop1ByCpf(result.getCpf())).isNotNull();
        verify(usuarioServiceImp, atMostOnce()).inserir(usuario); 
    }

}


