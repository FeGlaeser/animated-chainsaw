import avaliadores.*;
import interfaces.IAvaliadorCredito;
import java.math.BigDecimal;
import java.util.ArrayList;
import model.Cliente;
import model.SolicitacaoCredito;
import service.ProcessadorAnaliseCredito;

public class Application {

    public static void main(String[] args) {
        System.out.println("--- Início da Simulação de Análise de Crédito ---");

        ProcessadorAnaliseCredito processador = new ProcessadorAnaliseCredito();
        processador.adicionarAvaliador(new ValidadorCpfLimpo());
        processador.adicionarAvaliador(new ValidadorIdadeMinima(18));
        processador.adicionarAvaliador(new ValidadorScoreCredito(500));
        processador.adicionarAvaliador(new ValidadorRendaMinima(new BigDecimal("2000.00")));
        processador.adicionarAvaliador(new ValidadorTempoEmprego(12));


        Cliente cliente1 = new Cliente("111.222.333-44", "João da Silva", new BigDecimal("5000.00"), 750, true, 24, 30, new ArrayList<>());
        SolicitacaoCredito solicitacao1 = new SolicitacaoCredito(cliente1, new BigDecimal("10000.00"), 24);
        
        System.out.println("\nAnalisando Solicitação 1 (Cliente: " + cliente1.getNome() + ")");
        processador.analisar(solicitacao1);
        imprimirResultado(solicitacao1);

        Cliente cliente2 = new Cliente("555.666.777-88", "Maria Oliveira", new BigDecimal("6000.00"), 450, true, 36, 45, new ArrayList<>());
        SolicitacaoCredito solicitacao2 = new SolicitacaoCredito(cliente2, new BigDecimal("15000.00"), 36);

        System.out.println("\nAnalisando Solicitação 2 (Cliente: " + cliente2.getNome() + ")");
        processador.analisar(solicitacao2);
        imprimirResultado(solicitacao2);

        System.out.println("\n--- Adicionando nova regra de negócio dinamicamente ---");
        
        IAvaliadorCredito validadorComprometimentoRenda = new IAvaliadorCredito() {
            private final BigDecimal percentualMaximo = new BigDecimal("0.30");
            
            @Override
            public boolean Avaliar(SolicitacaoCredito solicitacao) {
                BigDecimal valorParcela = solicitacao.getValorEmprestimoDesejado().divide(BigDecimal.valueOf(solicitacao.getPrazoPagamentoMeses()), 2, BigDecimal.ROUND_HALF_UP);
                BigDecimal rendaComprometida = solicitacao.getCliente().getRendaMensal().multiply(percentualMaximo);
                return valorParcela.compareTo(rendaComprometida) <= 0;
            }

            @Override
            public String getNomeRegra() {
                return "Validador de Comprometimento de Renda";
            }

            @Override
            public String getMensagemReprovacao() {
                return "Valor da parcela excede 30% da renda mensal do cliente.";
            }
        };

        processador.adicionarAvaliador(validadorComprometimentoRenda);
        System.out.println("Nova regra 'Validador de Comprometimento de Renda' adicionada ao pipeline.");

        Cliente cliente3 = new Cliente("999.888.777-66", "Pedro Martins", new BigDecimal("2100.00"), 600, true, 18, 28, new ArrayList<>());
        SolicitacaoCredito solicitacao3 = new SolicitacaoCredito(cliente3, new BigDecimal("10000.00"), 12); // Parcela > 30% da renda
        
        System.out.println("\nAnalisando Solicitação 3 com a nova regra (Cliente: " + cliente3.getNome() + ")");
        processador.analisar(solicitacao3);
        imprimirResultado(solicitacao3);

        System.out.println("\n--- Fim da Simulação ---");
    }

    private static void imprimirResultado(SolicitacaoCredito solicitacao) {
        System.out.println("Resultado da Análise: " + solicitacao.getStatusAprovacao());
        if (solicitacao.getStatusAprovacao() == enums.StatusAprovacao.REPROVADO) {
            System.out.println("Motivo: " + solicitacao.getMotivoReprovacao());
        }
    }
}