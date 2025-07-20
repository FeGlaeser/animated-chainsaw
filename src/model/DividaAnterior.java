package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DividaAnterior {
    private BigDecimal valor;
    private String status;
    private LocalDate dataVencimento;

    public DividaAnterior(BigDecimal valor, String status, LocalDate dataVencimento) {
        this.valor = valor;
        this.status = status;
        this.dataVencimento = dataVencimento;
    }


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
