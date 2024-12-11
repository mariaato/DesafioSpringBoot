package com.example.model; 
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

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


    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Column (name = "dataCriacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column (name = "cpf", unique = true, nullable = false)
    @CPF
    @NotBlank
    private String cpf;


    @Column(name = "excluido")

    private boolean excluido;

    // // Construtor padrão necessário para o Hibernate
    // public Usuario() {
    // } 
    
    // public Usuario(Long id, String nome, LocalDateTime dataCriacao, String cpf, boolean excluido) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.dataCriacao = dataCriacao;
    //     this.cpf = cpf;
    //     this.excluido = excluido;
    // }

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

    public boolean getExcluido(){
        return excluido;
    }

    public void setExcluido(boolean excluido){
        this.excluido = excluido;
    }
}
