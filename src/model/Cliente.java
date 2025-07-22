package model;

import java.time.LocalDate;
import java.util.UUID;

public class Cliente {
    private final String id; 
    private final String nome; 
    private final String email; 
    private final LocalDate dataNascimento; 
    private final String endereco; 

    public Cliente(String nome, String email, LocalDate dataNascimento, String endereco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome; 
        this.email = email; 
        this.dataNascimento = dataNascimento;
        this.endereco = endereco; 
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEndereco() { return endereco; }
}