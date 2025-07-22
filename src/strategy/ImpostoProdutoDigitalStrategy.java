package strategy;

import interfaces.IImpostoStrategy;
import interfaces.IProduto;
import java.math.BigDecimal;

public class ImpostoProdutoDigitalStrategy implements IImpostoStrategy {
    private final BigDecimal aliquota; 

    public ImpostoProdutoDigitalStrategy(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    @Override
    public BigDecimal calcularImposto(IProduto produto, BigDecimal valorBase) {
        return valorBase.multiply(aliquota); 
    }
}