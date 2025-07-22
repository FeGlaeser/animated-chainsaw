package interfaces;

import java.math.BigDecimal;

public interface IImpostoStrategy {
    BigDecimal calcularImposto(IProduto produto, BigDecimal valorBase);
}