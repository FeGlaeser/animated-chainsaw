package service;

import interfaces.IDescontoStrategy;
import interfaces.IImpostoStrategy;
import model.ItemPedido;
import model.Pedido;
import java.math.BigDecimal;


public class CalculadoraPedido {
    private final IDescontoStrategy descontoStrategy; 
    private final ImpostoStrategyFactory impostoStrategyFactory;

    public CalculadoraPedido(IDescontoStrategy descontoStrategy, ImpostoStrategyFactory impostoStrategyFactory) {
        this.descontoStrategy = descontoStrategy;
        this.impostoStrategyFactory = impostoStrategyFactory;
    }

    public void processarPedido(Pedido pedido) {
        for (ItemPedido item : pedido.getItens()) {
            BigDecimal desconto = descontoStrategy.calcularDesconto(pedido, item);
            item.setDescontoAplicado(desconto);

            BigDecimal valorBaseParaImposto = item.getValorTotalItem().subtract(desconto);
            IImpostoStrategy impostoStrategy = impostoStrategyFactory.getStrategy(item.getProduto().getTipo());
            BigDecimal imposto = impostoStrategy.calcularImposto(item.getProduto(), valorBaseParaImposto);
            item.setImpostoAplicado(imposto);
        }
        
        pedido.calcularTotais(); 
    }
}