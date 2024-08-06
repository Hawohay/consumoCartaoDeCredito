import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCartao {

    private List<Cartao> cartoes;
    private Scanner scanner;

    public MenuCartao() {
        cartoes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void exibirMenuCartao() {
        while (true) {
            System.out.println("Menu de Opções:");
            System.out.println("1. Adicionar Cartão");
            System.out.println("2. Exibir Cartões");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    adicionarCartao();
                    break;
                case 2:
                    exibirCartoes();
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                case 9:
                    System.out.println("Saindo...");
                    System.exit(0); // Termina o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarCartao() {
        // Solicitar o CPF do cliente para associar o cartão
        System.out.print("Digite o CPF do cliente para associar o cartão: ");
        String cpf = scanner.nextLine();

        Titular cliente = Titular.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Primeiro cadastre um cliente.");
            return;
        }

        // Verificar se o cliente já possui um cartão
        Cartao cartaoExistente = cliente.getCartao(); // Supondo que Titular tem um método getCartao()

        if (cartaoExistente != null) {
            // Atualizar informações do cartão existente
            System.out.println("Atualizando informações do cartão existente.");

            System.out.print("Bandeira: ");
            String bandeira = scanner.nextLine();

            System.out.print("Função do Cartão: ");
            String funcaoDoCartao = scanner.nextLine();

            System.out.print("Anos de Validade: ");
            int anosDeValidade = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            System.out.print("Limite de Crédito: ");
            double limiteDeCredito = scanner.nextDouble();
            scanner.nextLine(); // Consumir nova linha

            cartaoExistente.setBandeira(bandeira);
            cartaoExistente.setFuncaoDoCartao(funcaoDoCartao);
            cartaoExistente.setDataDeValidade(LocalDate.now().plusYears(anosDeValidade));
            cartaoExistente.setLimiteDeCredito(limiteDeCredito);
            System.out.println("Cartão atualizado com sucesso!");
        } else {
            // Criar um novo cartão
            System.out.println("Criando um novo cartão.");

            String numeroDoCartao = GeradorCartao.gerarNumeroCartaoValido(cartoes);
            int cvv = GeradorCartao.gerarCVV(cartoes);
            System.out.println("Número do Cartão Gerado: " + numeroDoCartao);
            System.out.println("Número do CVV: " + cvv);

            System.out.print("Bandeira: ");
            String bandeira = scanner.nextLine();

            System.out.print("Função do Cartão: ");
            String funcaoDoCartao = scanner.nextLine();

            System.out.print("Anos de Validade: ");
            int anosDeValidade = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            System.out.print("Limite de Crédito: ");
            double limiteDeCredito = scanner.nextDouble();
            scanner.nextLine(); // Consumir nova linha

            // Criar o cartão e associá-lo ao cliente
            Cartao cartao = new Cartao(cliente.getNome(), cliente.getDataDeNascimento(), cliente.getRg(),
                    cliente.getOrgaoEmissorRg(), cliente.getCpf(), bandeira, funcaoDoCartao, anosDeValidade,
                    limiteDeCredito, cliente.getCep(), cliente.getUnidadeFederativa(), cliente.getMunicipio(),
                    cliente.getBairro(), cliente.getLogradouro(), cartoes);

            cartoes.add(cartao);
            cliente.setCartao(cartao); // Supondo que Titular tem um método setCartao()
            System.out.println("Cartão adicionado com sucesso!");
        }
    }


    private void exibirCartoes() {
        if (cartoes.isEmpty()) {
            System.out.println("Nenhum cartão cadastrado.");
        } else {
            for (Cartao cartao : cartoes) {
                cartao.exibirInfo();
                System.out.println();
            }
        }
    }
}
