package com.example.model; 
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column (name = "dataCriacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column (name = "cpf", unique = true)
    @CPF
    @NotBlank
    private String cpf;


    // Construtor padrão necessário para o Hibernate
    public Usuario() {
    } 
    
    public Usuario(Long id, String nome, LocalDateTime dataCriacao, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.cpf = cpf;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
