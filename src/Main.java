
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import produtos.Assinatura;
import produtos.ProdutoDigital;
import produtos.ProdutoFisico;
import service.CalculadoraPedido;
import service.ImpostoStrategyFactory;
import strategy.DescontoBlackFridayStrategy;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ImpostoStrategyFactory impostoFactory = new ImpostoStrategyFactory();
        
        DescontoBlackFridayStrategy descontoStrategy = new DescontoBlackFridayStrategy(new BigDecimal("0.30"));
        
        CalculadoraPedido calculadora = new CalculadoraPedido(descontoStrategy, impostoFactory);

        Cliente cliente = new Cliente("João da Silva", "joao@email.com", LocalDate.of(1990, 11, 25), "Rua A, 123");
        
        ProdutoFisico notebook = new ProdutoFisico("Notebook Gamer", new BigDecimal("7500.00"), new BigDecimal("2.5"), "45x30x5cm", 10);
        ProdutoDigital antivirus = new ProdutoDigital("Software Antivírus", new BigDecimal("150.00"), "http://download.antivirus.com", new BigDecimal("200"));
        Assinatura streaming = new Assinatura("Serviço de Streaming", new BigDecimal("49.90"), 1, enums.TipoRecorrencia.MENSAL);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(notebook, 1));
        pedido.adicionarItem(new ItemPedido(antivirus, 2));
        
        calculadora.processarPedido(pedido);

        imprimirDetalhesPedido(pedido);
    }
    
    private static void imprimirDetalhesPedido(Pedido pedido) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Locale brLocale = new Locale("pt", "BR");

        System.out.println("===================================================");
        System.out.println("              DETALHES DO PEDIDO");
        System.out.println("===================================================");
        System.out.printf("ID do Pedido: %s\n", pedido.getId());
        System.out.printf("Data do Pedido: %s\n", pedido.getDataPedido().format(dtf));
        System.out.printf("Cliente: %s (%s)\n", pedido.getCliente().getNome(), pedido.getCliente().getEmail());
        System.out.println("---------------------------------------------------");
        System.out.println("ITENS DO PEDIDO:");
        
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("- Produto: %s\n", item.getProduto().getNome());
            System.out.printf("  Qtd: %d | V. Unit.: %s | V. Total: %s\n", 
                item.getQuantidade(), 
                String.format(brLocale, "R$ %.2f", item.getValorUnitario()),
                String.format(brLocale, "R$ %.2f", item.getValorTotalItem()));
            System.out.printf("  Desconto Aplicado: %s | Imposto Aplicado: %s\n", 
                String.format(brLocale, "R$ %.2f", item.getDescontoAplicado()),
                String.format(brLocale, "R$ %.2f", item.getImpostoAplicado()));
            System.out.printf("  => Valor Líquido do Item: %s\n", String.format(brLocale, "R$ %.2f", item.getValorLiquidoItem()));
        }
        
        System.out.println("---------------------------------------------------");
        System.out.println("TOTAIS DO PEDIDO:");
        System.out.printf("Valor Bruto: \t\t%s\n", String.format(brLocale, "R$ %.2f", pedido.getValorTotalBruto()));
        System.out.printf("Total de Descontos: \t%s\n", String.format(brLocale, "R$ %.2f", pedido.getValorTotalDescontos()));
        System.out.printf("Total de Impostos: \t%s\n", String.format(brLocale, "R$ %.2f", pedido.getValorTotalImpostos()));
        System.out.println("===================================================");
        System.out.printf("VALOR LÍQUIDO FINAL: \t%s\n", String.format(brLocale, "R$ %.2f", pedido.getValorTotalLiquido()));
        System.out.println("===================================================");
    }
}