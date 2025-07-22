package strategy;

import interfaces.IImpostoStrategy;
import interfaces.IProduto;
import java.math.BigDecimal;


public class ImpostoAssinaturaStrategy implements IImpostoStrategy {
    private final BigDecimal aliquota; 

    public ImpostoAssinaturaStrategy(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    @Override
    public BigDecimal calcularImposto(IProduto produto, BigDecimal valorBase) {
        return valorBase.multiply(aliquota); }
}