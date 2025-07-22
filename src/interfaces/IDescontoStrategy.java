package interfaces;

import model.ItemPedido;
import model.Pedido;
import java.math.BigDecimal;


public interface IDescontoStrategy {
    BigDecimal calcularDesconto(Pedido pedido, ItemPedido item);
}