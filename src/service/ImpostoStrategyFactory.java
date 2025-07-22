package service;

import enums.TipoProduto;
import interfaces.IImpostoStrategy;
import strategy.*;
import java.math.BigDecimal;


public class ImpostoStrategyFactory {
    public IImpostoStrategy getStrategy(TipoProduto tipoProduto) {
        switch (tipoProduto) {
            case DIGITAL:
                return new ImpostoProdutoDigitalStrategy(new BigDecimal("0.12")); 
            case FISICO:
                return new ImpostoProdutoFisicoStrategy(new BigDecimal("0.07"), new BigDecimal("0.05")); // [cite: 135]
            case ASSINATURA:
                return new ImpostoAssinaturaStrategy(new BigDecimal("0.05")); 
            default:
                return new IsencaoImpostoStrategy();
        }
    }
}