package strategy;

import interfaces.IDescontoStrategy;
import model.ItemPedido;
import model.Pedido;
import java.math.BigDecimal;


public class DescontoMesAniversarioStrategy implements IDescontoStrategy {
    private final BigDecimal percentualDesconto; 

    public DescontoMesAniversarioStrategy(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public BigDecimal calcularDesconto(Pedido pedido, ItemPedido item) {
        boolean mesmoMes = pedido.getDataPedido().getMonth() == pedido.getCliente().getDataNascimento().getMonth(); // [cite: 114]
        
        boolean condicaoValor = item.getValorTotalItem().compareTo(new BigDecimal("300")) > 0;

        if (mesmoMes && condicaoValor) {
            return item.getValorTotalItem().multiply(percentualDesconto);
        }
        return BigDecimal.ZERO;
    }
}