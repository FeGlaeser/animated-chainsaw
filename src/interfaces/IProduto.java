package interfaces;

import enums.TipoProduto;
import java.math.BigDecimal;


public interface IProduto {
    String getNome(); 
    BigDecimal getValorBase(); 
    TipoProduto getTipo(); 
}