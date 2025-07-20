package avaliadores;

import interfaces.IAvaliadorCredito;
import model.SolicitacaoCredito;

public class ValidadorCpfLimpo implements IAvaliadorCredito {
    @Override
    public boolean Avaliar(SolicitacaoCredito solicitacao) {
        return solicitacao.getCliente().isTemNomeLimpo();
    }

    @Override
    public String getNomeRegra() {
        return "Validador de CPF Limpo";
    }
    
    @Override
    public String getMensagemReprovacao() {
        return "Cliente possui restrições no CPF.";
    }
}
