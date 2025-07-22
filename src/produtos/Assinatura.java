package produtos;

import enums.TipoProduto;
import enums.TipoRecorrencia;
import interfaces.IProduto;
import java.math.BigDecimal;


public class Assinatura implements IProduto {
    private final String nome;
    private final BigDecimal valorBase;
    private final int periodoMeses;
    private final TipoRecorrencia recorrencia; 

    public Assinatura(String nome, BigDecimal valorBase, int periodoMeses, TipoRecorrencia recorrencia) {
        this.nome = nome;
        this.valorBase = valorBase;
        this.periodoMeses = periodoMeses;
        this.recorrencia = recorrencia;
    }

    @Override public String getNome() { return nome; }
    @Override public BigDecimal getValorBase() { return valorBase; }
    @Override public TipoProduto getTipo() { return TipoProduto.ASSINATURA; } 
    
    public int getPeriodoMeses() { return periodoMeses; }
    public TipoRecorrencia getRecorrencia() { return recorrencia; }
}