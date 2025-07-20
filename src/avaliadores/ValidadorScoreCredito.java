package avaliadores;

import interfaces.IAvaliadorCredito;
import model.SolicitacaoCredito;

public class ValidadorScoreCredito implements IAvaliadorCredito {
    private final int scoreMinimoExigido;

    public ValidadorScoreCredito(int scoreMinimoExigido) {
        this.scoreMinimoExigido = scoreMinimoExigido;
    }

    @Override
    public boolean Avaliar(SolicitacaoCredito solicitacao) {
        return solicitacao.getCliente().getScoreSerasa() >= this.scoreMinimoExigido;
    }

    @Override
    public String getNomeRegra() {
        return "Validador de Score de Crédito";
    }

    @Override
    public String getMensagemReprovacao() {
        return "Score de crédito do cliente (" + scoreMinimoExigido + ") é inferior ao mínimo exigido.";
    }
}
