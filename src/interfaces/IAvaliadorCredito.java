package interfaces;

import model.SolicitacaoCredito;

public interface IAvaliadorCredito {

    boolean Avaliar(SolicitacaoCredito solicitacao);

    String getNomeRegra();
    
    String getMensagemReprovacao();
}
