package service;

import interfaces.IAvaliadorCredito;
import model.SolicitacaoCredito;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorAnaliseCredito {
    private final List<IAvaliadorCredito> avaliadores;

    public ProcessadorAnaliseCredito() {
        this.avaliadores = new ArrayList<>();
    }

    public void adicionarAvaliador(IAvaliadorCredito avaliador) {
        this.avaliadores.add(avaliador);
    }

    public void analisar(SolicitacaoCredito solicitacao) {
        for (IAvaliadorCredito avaliador : this.avaliadores) {
            if (!avaliador.Avaliar(solicitacao)) {
                solicitacao.reprovar(avaliador.getMensagemReprovacao());
                return;
            }
        }
        solicitacao.aprovar();
    }
}
