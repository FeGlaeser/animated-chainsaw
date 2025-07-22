package produtos;

import enums.TipoProduto;
import interfaces.IProduto;
import java.math.BigDecimal;


public class ProdutoFisico implements IProduto {
    private final String nome;
    private final BigDecimal valorBase;
    private final BigDecimal pesoKG; 
    private final String dimensoes; 
    private int estoque; 

    public ProdutoFisico(String nome, BigDecimal valorBase, BigDecimal pesoKG, String dimensoes, int estoque) {
        this.nome = nome;
        this.valorBase = valorBase;
        this.pesoKG = pesoKG;
        this.dimensoes = dimensoes;
        this.estoque = estoque;
    }

    @Override public String getNome() { return nome; }
    @Override public BigDecimal getValorBase() { return valorBase; }
    @Override public TipoProduto getTipo() { return TipoProduto.FISICO; } // [cite: 92]

    public BigDecimal getPesoKG() { return pesoKG; }
    public String getDimensoes() { return dimensoes; }
    public int getEstoque() { return estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }
}