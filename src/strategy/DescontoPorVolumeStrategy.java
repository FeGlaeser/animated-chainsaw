package strategy;

import interfaces.IDescontoStrategy;
import model.ItemPedido;
import model.Pedido;
import java.math.BigDecimal;


public class DescontoPorVolumeStrategy implements IDescontoStrategy {
    private final int quantidadeMinima; 
    private final BigDecimal percentualDesconto;

    public DescontoPorVolumeStrategy(int quantidadeMinima, BigDecimal percentualDesconto) {
        this.quantidadeMinima = quantidadeMinima;
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public BigDecimal calcularDesconto(Pedido pedido, ItemPedido item) {
        if (item.getQuantidade() >= quantidadeMinima) { 
            return item.getValorTotalItem().multiply(percentualDesconto);
        }
        return BigDecimal.ZERO;
    }
}