package model;

import java.math.BigDecimal;
import java.util.List;


public class Cliente {
    private String cpf; // [cite: 191]
    private String nome; // [cite: 192]
    private BigDecimal rendaMensal; // [cite: 193]
    private int scoreSerasa; // [cite: 194]
    private boolean temNomeLimpo; // [cite: 195]
    private int tempoEmpregoMeses; // [cite: 196]
    private int idade; // [cite: 198]
    private List<DividaAnterior> historicoDividas; // [cite: 197]

    public Cliente(String cpf, String nome, BigDecimal rendaMensal, int scoreSerasa, boolean temNomeLimpo, int tempoEmpregoMeses, int idade, List<DividaAnterior> historicoDividas) {
        this.cpf = cpf;
        this.nome = nome;
        this.rendaMensal = rendaMensal;
        this.scoreSerasa = scoreSerasa;
        this.temNomeLimpo = temNomeLimpo;
        this.tempoEmpregoMeses = tempoEmpregoMeses;
        this.idade = idade;
        this.historicoDividas = historicoDividas;
    }
    
    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public BigDecimal getRendaMensal() { return rendaMensal; }
    public int getScoreSerasa() { return scoreSerasa; }
    public boolean isTemNomeLimpo() { return temNomeLimpo; }
    public int getTempoEmpregoMeses() { return tempoEmpregoMeses; }
    public int getIdade() { return idade; }
    public List<DividaAnterior> getHistoricoDividas() { return historicoDividas; }
}
