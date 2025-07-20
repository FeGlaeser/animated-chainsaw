package avaliadores;

import interfaces.IAvaliadorCredito;
import model.SolicitacaoCredito;

public class ValidadorTempoEmprego implements IAvaliadorCredito {
    private final int tempoMinimoMeses;

    public ValidadorTempoEmprego(int tempoMinimoMeses) {
        this.tempoMinimoMeses = tempoMinimoMeses;
    }

    @Override
    public boolean Avaliar(SolicitacaoCredito solicitacao) {
        return solicitacao.getCliente().getTempoEmpregoMeses() >= this.tempoMinimoMeses;
    }

    @Override
    public String getNomeRegra() {
        return "Validador de Tempo de Emprego";
    }

    @Override
    public String getMensagemReprovacao() {
        return "Cliente não atende ao tempo mínimo de emprego de " + this.tempoMinimoMeses + " meses.";
    }
}
