package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Pedido {
    private final String id; 
    private final LocalDateTime dataPedido; 
    private final Cliente cliente; 
    private final List<ItemPedido> itens = new ArrayList<>(); 
    private BigDecimal valorTotalBruto = BigDecimal.ZERO; 
    private BigDecimal valorTotalDescontos = BigDecimal.ZERO; 
    private BigDecimal valorTotalImpostos = BigDecimal.ZERO; 
    private BigDecimal valorTotalLiquido = BigDecimal.ZERO; 

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString(); 
        this.cliente = cliente;
        this.dataPedido = LocalDateTime.now();
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public void calcularTotais() {
        this.valorTotalBruto = itens.stream()
                .map(ItemPedido::getValorTotalItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.valorTotalDescontos = itens.stream()
                .map(ItemPedido::getDescontoAplicado)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.valorTotalImpostos = itens.stream()
                .map(ItemPedido::getImpostoAplicado)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.valorTotalLiquido = this.valorTotalBruto.subtract(this.valorTotalDescontos).add(this.valorTotalImpostos); // [cite: 59]
    }
    
    public String getId() { return id; }
    public LocalDateTime getDataPedido() { return dataPedido; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }
    public BigDecimal getValorTotalBruto() { return valorTotalBruto; }
    public BigDecimal getValorTotalDescontos() { return valorTotalDescontos; }
    public BigDecimal getValorTotalImpostos() { return valorTotalImpostos; }
    public BigDecimal getValorTotalLiquido() { return valorTotalLiquido; }
}