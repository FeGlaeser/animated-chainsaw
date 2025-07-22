package model;

import interfaces.IProduto;
import java.math.BigDecimal;


public class ItemPedido {
    private final IProduto produto; 
    private final int quantidade; 
    private final BigDecimal valorUnitario;
    private BigDecimal descontoAplicado = BigDecimal.ZERO; 
    private BigDecimal impostoAplicado = BigDecimal.ZERO; 

    public ItemPedido(IProduto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = produto.getValorBase();
    }
    
    public BigDecimal getValorTotalItem() {
        return valorUnitario.multiply(new BigDecimal(quantidade));
    }

    public BigDecimal getValorLiquidoItem() {
        return getValorTotalItem().subtract(descontoAplicado).add(impostoAplicado); 
    }

    public IProduto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public BigDecimal getValorUnitario() { return valorUnitario; }
    public BigDecimal getDescontoAplicado() { return descontoAplicado; }
    public void setDescontoAplicado(BigDecimal descontoAplicado) { this.descontoAplicado = descontoAplicado; }
    public BigDecimal getImpostoAplicado() { return impostoAplicado; }
    public void setImpostoAplicado(BigDecimal impostoAplicado) { this.impostoAplicado = impostoAplicado; }
}