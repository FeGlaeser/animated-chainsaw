package model;

import enums.StatusAprovacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class SolicitacaoCredito {
    private final String id;
    private final Cliente cliente;
    private final BigDecimal valorEmprestimoDesejado;
    private final int prazoPagamentoMeses;
    private final LocalDateTime dataSolicitacao;
    private StatusAprovacao statusAprovacao;
    private String motivoReprovacao;

    public SolicitacaoCredito(Cliente cliente, BigDecimal valorEmprestimoDesejado, int prazoPagamentoMeses) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.valorEmprestimoDesejado = valorEmprestimoDesejado;
        this.prazoPagamentoMeses = prazoPagamentoMeses;
        this.dataSolicitacao = LocalDateTime.now();
        this.statusAprovacao = StatusAprovacao.PENDENTE;
    }


    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public BigDecimal getValorEmprestimoDesejado() { return valorEmprestimoDesejado; }
    public int getPrazoPagamentoMeses() { return prazoPagamentoMeses; }
    public LocalDateTime getDataSolicitacao() { return dataSolicitacao; }
    public StatusAprovacao getStatusAprovacao() { return statusAprovacao; }
    public String getMotivoReprovacao() { return motivoReprovacao; }

    public void aprovar() {
        this.statusAprovacao = StatusAprovacao.APROVADO;
        this.motivoReprovacao = null;
    }

    public void reprovar(String motivo) {
        this.statusAprovacao = StatusAprovacao.REPROVADO;
        this.motivoReprovacao = motivo;
    }
}
