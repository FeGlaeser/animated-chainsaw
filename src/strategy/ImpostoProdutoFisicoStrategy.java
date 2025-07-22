package strategy;

import interfaces.IImpostoStrategy;
import interfaces.IProduto;
import java.math.BigDecimal;


public class ImpostoProdutoFisicoStrategy implements IImpostoStrategy {
    private final BigDecimal aliquotaNacional; 
    private final BigDecimal aliquotaEstadual; 

    public ImpostoProdutoFisicoStrategy(BigDecimal aliquotaNacional, BigDecimal aliquotaEstadual) {
        this.aliquotaNacional = aliquotaNacional;
        this.aliquotaEstadual = aliquotaEstadual;
    }

    @Override
    public BigDecimal calcularImposto(IProduto produto, BigDecimal valorBase) {
        BigDecimal impostoTotal = valorBase.multiply(aliquotaNacional).add(valorBase.multiply(aliquotaEstadual)); // [cite: 141]
        return impostoTotal;
    }
}