package strategy;

import interfaces.IDescontoStrategy;
import model.ItemPedido;
import model.Pedido;
import java.math.BigDecimal;
import java.time.Month;


public class DescontoBlackFridayStrategy implements IDescontoStrategy {
    private final BigDecimal percentualDesconto; 

    public DescontoBlackFridayStrategy(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public BigDecimal calcularDesconto(Pedido pedido, ItemPedido item) {
        if (pedido.getDataPedido().getMonth() == Month.NOVEMBER) {
            return item.getValorTotalItem().multiply(percentualDesconto);
        }
        return BigDecimal.ZERO;
    }
}