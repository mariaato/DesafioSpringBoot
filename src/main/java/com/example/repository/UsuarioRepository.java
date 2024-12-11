package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.model.Usuario;


@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>{
    public Usuario findTop1ByCpf(String cpf);

    public Page<Usuario> findByExcluidoFalse(Pageable pageable);
}
