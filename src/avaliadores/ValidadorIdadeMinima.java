package avaliadores;

import interfaces.IAvaliadorCredito;
import model.SolicitacaoCredito;

public class ValidadorIdadeMinima implements IAvaliadorCredito {
    private final int idadeMinima;

    public ValidadorIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    @Override
    public boolean Avaliar(SolicitacaoCredito solicitacao) {
        return solicitacao.getCliente().getIdade() >= this.idadeMinima;
    }

    @Override
    public String getNomeRegra() {
        return "Validador de Idade Mínima";
    }

    @Override
    public String getMensagemReprovacao() {
        return "Cliente não possui a idade mínima de " + this.idadeMinima + " anos.";
    }
}
