package strategy;

import interfaces.IImpostoStrategy;
import interfaces.IProduto;
import java.math.BigDecimal;


public class IsencaoImpostoStrategy implements IImpostoStrategy {
    @Override
    public BigDecimal calcularImposto(IProduto produto, BigDecimal valorBase) {
        return BigDecimal.ZERO; 
    }
}