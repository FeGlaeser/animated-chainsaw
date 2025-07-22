package produtos;

import enums.TipoProduto;
import interfaces.IProduto;
import java.math.BigDecimal;


public class ProdutoDigital implements IProduto {
    private final String nome;
    private final BigDecimal valorBase;
    private final String urlDownload; 
    private final BigDecimal tamanhoMB; 

    public ProdutoDigital(String nome, BigDecimal valorBase, String urlDownload, BigDecimal tamanhoMB) {
        this.nome = nome;
        this.valorBase = valorBase;
        this.urlDownload = urlDownload;
        this.tamanhoMB = tamanhoMB;
    }

    @Override public String getNome() { return nome; }
    @Override public BigDecimal getValorBase() { return valorBase; }
    @Override public TipoProduto getTipo() { return TipoProduto.DIGITAL; } 
    
    public String getUrlDownload() { return urlDownload; }
    public BigDecimal getTamanhoMB() { return tamanhoMB; }
}