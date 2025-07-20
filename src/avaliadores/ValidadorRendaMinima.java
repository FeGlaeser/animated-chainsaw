package avaliadores;

import interfaces.IAvaliadorCredito;
import model.SolicitacaoCredito;
import java.math.BigDecimal;

public class ValidadorRendaMinima implements IAvaliadorCredito {
    private final BigDecimal rendaMinimaExigida;

    public ValidadorRendaMinima(BigDecimal rendaMinimaExigida) {
        this.rendaMinimaExigida = rendaMinimaExigida;
    }

    @Override
    public boolean Avaliar(SolicitacaoCredito solicitacao) {
        return solicitacao.getCliente().getRendaMensal().compareTo(this.rendaMinimaExigida) >= 0;
    }

    @Override
    public String getNomeRegra() {
        return "Validador de Renda Mínima";
    }

    @Override
    public String getMensagemReprovacao() {
        return "Renda mensal do cliente é inferior à mínima exigida de R$ " + this.rendaMinimaExigida;
    }
}
