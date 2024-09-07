package com.bancodigital;

import com.cartao.Cartao;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Titular extends Identificacao implements Endereco {

    private String nome;
    private LocalDate dataDeNascimento;
    private String cep;
    private String unidadeFederativa;
    private String municipio;
    private String bairro;
    private String logradouro;
    private List<Cartao> cartoes;
    private List<Conta> contas;

    private static final List<Titular> listaDeClientes = new ArrayList<>();

    public Titular(String nome, LocalDate dataDeNascimento, int rg, String orgaoEmissorRg, String cpf,
                   String cep, String unidadeFederativa, String municipio, String bairro, String logradouro) {
        super(rg, orgaoEmissorRg, cpf);
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cep = cep;
        this.unidadeFederativa = unidadeFederativa;
        this.municipio = municipio;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.cartoes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public Titular() {
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF/CNPJ do cliente:");
        String cpf = scanner.nextLine();

        LocalDate dataDeNascimento = null;
        while (dataDeNascimento == null) {
            System.out.println("Digite a data de nascimento do cliente (dd/MM/yyyy):");
            String dataNascimentoStr = scanner.nextLine();
            try {
                dataDeNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        int rg = -1;
        while (rg <= 0) {
            System.out.println("Digite o RG do cliente:");
            try {
                rg = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("RG inválido. Tente novamente.");
            }
        }

        System.out.println("Digite o órgão emissor do RG:");
        String orgaoEmissorRg = scanner.nextLine();

        System.out.println("Digite o CEP do cliente:");
        String cep = scanner.nextLine();

        System.out.println("Digite a unidade federativa do cliente:");
        String unidadeFederativa = scanner.nextLine();

        System.out.println("Digite o município do cliente:");
        String municipio = scanner.nextLine();

        System.out.println("Digite o bairro do cliente:");
        String bairro = scanner.nextLine();

        System.out.println("Digite o logradouro do cliente:");
        String logradouro = scanner.nextLine();

        Titular clienteExistente = encontrarClientePorCpf(cpf);

        if (clienteExistente != null) {
            System.out.println("Cliente com CPF " + cpf + " já existe.");
            System.out.println("Deseja atualizar as informações desse cliente? (s/n):");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                clienteExistente.setNome(nome);
                clienteExistente.setDataDeNascimento(dataDeNascimento);
                clienteExistente.setCep(cep);
                clienteExistente.setUnidadeFederativa(unidadeFederativa);
                clienteExistente.setMunicipio(municipio);
                clienteExistente.setBairro(bairro);
                clienteExistente.setLogradouro(logradouro);
            }
        } else {
            Titular cliente = new Titular(nome, dataDeNascimento, rg, orgaoEmissorRg, cpf, cep, unidadeFederativa, municipio, bairro, logradouro);
            listaDeClientes.add(cliente);
        }
    }

    public static Titular encontrarClientePorCpf(String cpfCnpj) {
        for (Titular cliente : listaDeClientes) {
            if (cliente.getCpf().trim().equals(cpfCnpj.trim())) {
                return cliente;
            }
        }
        return null;
    }

    public void exibirInformacoesDadosPessoais() {
        if (nome == null) {
            System.out.println("Nome não disponível.");
        } else {
            System.out.println("Nome: " + nome);
        }

        if (dataDeNascimento == null) {
            System.out.println("Data de Nascimento não disponível.");
        } else {
            System.out.println("Data de Nascimento: " + formatarData(dataDeNascimento));
            System.out.println("Idade: " + calculaIdade());
        }

        System.out.println("CEP: " + (cep != null ? cep : "Não disponível"));
        System.out.println("Unidade Federativa: " + (unidadeFederativa != null ? unidadeFederativa : "Não disponível"));
        System.out.println("Município: " + (municipio != null ? municipio : "Não disponível"));
        System.out.println("Bairro: " + (bairro != null ? bairro : "Não disponível"));
        System.out.println("Logradouro: " + (logradouro != null ? logradouro : "Não disponível"));

        System.out.println("Agência: " + (Agencia.getAgencia() != null ? Agencia.getAgencia() : "Não disponível"));

        System.out.println("Contas: ");
        if (contas != null && !contas.isEmpty()) {
            for (Conta conta : contas) {
                System.out.println("Número da Conta: " + conta.getNumero());
            }
        } else {
            System.out.println("Nenhuma conta associada.");
        }
    }

    private String formatarData(LocalDate data) {
        if (data == null) {
            return "Data não disponível";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public int calculaIdade() {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataDeNascimento, hoje).getYears();
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Cartao> getCartoes() {  //
        return cartoes;
    }

    public void setCartao(Cartao cartao) {
        this.cartoes.add(cartao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String getCep() {
        return cep;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    @Override
    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    @Override
    public String getMunicipio() {
        return municipio;
    }

    @Override
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String getBairro() {
        return bairro;
    }

    @Override
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void atualizarDadosCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF/CNPJ do cliente que deseja atualizar:");
        String cpf = scanner.nextLine();

        Titular clienteParaAtualizar = encontrarClientePorCpf(cpf);

        if (clienteParaAtualizar != null) {
            while (true) {
                System.out.println("------------------------------");
                System.out.println("M - Menu");
                System.out.println("1 - Alterar o nome");
                System.out.println("2 - Alterar o cep");
                System.out.println("3 - Alterar o endereço");
                System.out.println("4 - Alterar a agência");
                System.out.println("5 - Alterar o número da conta");
                System.out.println("6 - Exibir os dados do cliente");
                System.out.println("------------------------------");
                System.out.println("7 - Retornar para o menu anterior");
                System.out.println("9 - Encerrar sessão");
                System.out.println("------------------------------");
                System.out.println("E - Escolha uma opção: ");

                int opcaoAltera = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.println("------------------------------");
                System.out.println();
                switch (opcaoAltera) {
                    case 1:
                        System.out.println("Informe o nome:");
                        String nomeAtualizado = scanner.nextLine();
                        clienteParaAtualizar.setNome(nomeAtualizado);
                        System.out.println("Nome atualizado para: " + nomeAtualizado);
                        break;

                    case 2:
                        System.out.println("Informe o cep:");
                        String cepAtualizado = scanner.nextLine();
                        clienteParaAtualizar.setCep(cepAtualizado);
                        System.out.println("CEP atualizado para: " + cepAtualizado);
                        break;

                    case 3:
                        System.out.println("Informe o logradouro:");
                        String logradouroAtualizado = scanner.nextLine();
                        clienteParaAtualizar.setLogradouro(logradouroAtualizado);
                        System.out.println("Logradouro atualizado para: " + logradouroAtualizado);
                        break;

                    case 4:
                        // Implementar lógica de alteração da agência
                        break;

                    case 5:
                        // Implementar lógica de alteração do número da conta
                        break;

                    case 6:
                        System.out.println("Dados do cliente:");
                        clienteParaAtualizar.exibirInformacoesDadosPessoais();
                        System.out.println(); // Adiciona uma linha em branco entre os detalhes dos clientes
                        break;

                    case 7:
                        System.out.println("Retornando para o menu anterior.");
                        return;

                    case 9:
                        System.out.println("Sessão encerrada.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        } else {
            System.out.println("Cliente com CPF/CNPJ " + cpf + " não encontrado.");
        }
    }

    public void pesquisarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF/CNPJ do cliente:");
        String numeroCpfCnpj = scanner.nextLine();
        System.out.println("-----------------------------");
        Titular cliente = encontrarClientePorCpf(numeroCpfCnpj);

        if (cliente != null) {
            cliente.exibirInformacoesDadosPessoais();
            System.out.println("-----------------------------");
        } else {
            System.out.println("Cliente com CPF/CNPJ " + numeroCpfCnpj + " não encontrado.");
        }
    }
}
