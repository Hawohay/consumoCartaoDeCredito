import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void exibirMenu() {
        while (true) {
            System.out.println("Menu de Opções:");
            System.out.println("1. Adicionar Cartão");
            System.out.println("2. Exibir Cartões");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (escolha) {
                case 1:
                    adicionarCartao();
                    break;
                case 2:
                    exibirCartoes();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarCartao() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataDeNascimentoStr = scanner.nextLine();
        LocalDate dataDeNascimento = LocalDate.parse(dataDeNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("RG: ");
        int rg = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Órgão Emissor do RG: ");
        String orgaoEmissorRg = scanner.nextLine();

        String cpf;
        do {
            System.out.print("CPF: ");
            cpf = scanner.nextLine();
            if (!CPFValidator.validarCPF(cpf)) {
                System.out.println("CPF inválido. Tente novamente.");
            }
        } while (!CPFValidator.validarCPF(cpf));

        System.out.print("Dígito Verificador do CPF: ");
        int digitoVerificadorCpf = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String numeroDoCartao = GeradorCartao.gerarNumeroCartaoValido(cartoes);
        System.out.println("Número do Cartão Gerado: " + numeroDoCartao);

        System.out.print("Bandeira: ");
        String bandeira = scanner.nextLine();

        System.out.print("Função do Cartão: ");
        String funcaoDoCartao = scanner.nextLine();

        System.out.print("CVV: ");
        int cvv = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Anos de Validade: ");
        int anosDeValidade = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Limite de Crédito: ");
        double limiteDeCredito = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Unidade Federativa: ");
        String unidadeFederativa = scanner.nextLine();

        System.out.print("Município: ");
        String municipio = scanner.nextLine();

        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Logradouro: ");
        String logradouro = scanner.nextLine();

        Cartao cartao = new Cartao(nome, dataDeNascimento, rg, orgaoEmissorRg, cpf, digitoVerificadorCpf,
                numeroDoCartao, bandeira, funcaoDoCartao, anosDeValidade, limiteDeCredito,
                cep, unidadeFederativa, municipio, bairro, logradouro);
        cartoes.add(cartao);
        System.out.println("Cartão adicionado com sucesso!");
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
