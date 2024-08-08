import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agencia implements Endereco {
    private String numero;
    private String nome;
    private String cnpj;
    private List<Conta> contas;
    private String cep;
    private String unidadeFederativa;
    private String municipio;
    private String bairro;
    private String logradouro;

    private static final List<Agencia> listaDeAgencias = new ArrayList<>();

    public Agencia(String numero, String nome, String cnpj, String cep, String unidadeFederativa, String municipio, String bairro, String logradouro) {
        this.numero = numero;
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = new ArrayList<>();
        this.cep = cep;
        this.unidadeFederativa = unidadeFederativa;
        this.municipio = municipio;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public static Agencia cadastrarAgencia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número da agência:");
        String numero = scanner.nextLine();

        System.out.println("Digite o nome da agência:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CNPJ da agência:");
        String cnpj = scanner.nextLine();

        System.out.println("Digite o CEP da agência:");
        String cep = scanner.nextLine();

        System.out.println("Digite a unidade federativa da agência:");
        String unidadeFederativa = scanner.nextLine();

        System.out.println("Digite o município da agência:");
        String municipio = scanner.nextLine();

        System.out.println("Digite o bairro da agência:");
        String bairro = scanner.nextLine();

        System.out.println("Digite o logradouro da agência:");
        String logradouro = scanner.nextLine();

        Agencia agenciaExistente = encontrarAgenciaPorNumero(numero);

        if (agenciaExistente != null) {
            System.out.println("Agência com número " + numero + " já existe.");
            System.out.println("Deseja atualizar as informações dessa agência? (s/n):");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                agenciaExistente.setNome(nome);
                agenciaExistente.setCnpj(cnpj);
                agenciaExistente.setCep(cep);
                agenciaExistente.setUnidadeFederativa(unidadeFederativa);
                agenciaExistente.setMunicipio(municipio);
                agenciaExistente.setBairro(bairro);
                agenciaExistente.setLogradouro(logradouro);
                System.out.println("Agência atualizada com sucesso.");
            }
            return agenciaExistente;
        } else {
            Agencia novaAgencia = new Agencia(numero, nome, cnpj, cep, unidadeFederativa, municipio, bairro, logradouro);
            listaDeAgencias.add(novaAgencia);
            System.out.println("Agência cadastrada com sucesso.");
            return novaAgencia;
        }
    }

    public static Agencia encontrarAgenciaPorNumero(String numero) {
        for (Agencia agencia : listaDeAgencias) {
            if (agencia.getNumero().equals(numero)) {
                return agencia;
            }
        }
        return null;
    }

    public Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        return null; // Retorna null se não encontrar a conta
    }

    public static Agencia getAgencia() {
        // Método para retornar a última agência criada ou necessária
        return listaDeAgencias.isEmpty() ? null : listaDeAgencias.get(listaDeAgencias.size() - 1);
    }

    public String getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getCep() {
        return "";
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String getUnidadeFederativa() {
        return "";
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    @Override
    public String getMunicipio() {
        return "";
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String getBairro() {
        return "";
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String getLogradouro() {
        return "";
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void exibirInfo() {
        System.out.println("Número: " + numero);
        System.out.println("Nome: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("CEP: " + cep);
        System.out.println("Unidade Federativa: " + unidadeFederativa);
        System.out.println("Município: " + municipio);
        System.out.println("Bairro: " + bairro);
        System.out.println("Logradouro: " + logradouro);
    }

    @Override
    public String toString() {
        return "Agência: " + this.nome + " Número: " + this.numero;
    }
}
