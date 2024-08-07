import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    /**
     * Construtor para inicializar uma agência.
     *
     * @param numero O número da agência.
     * @param nome O nome da agência.
     */
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

    public Agencia() {
    }

    public static void cadastrarAgencia() {
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

        // Verifica se a agência já existe na lista
        Agencia agenciaExistente = encontrarAgenciaPorNumero(numero);

        if (agenciaExistente != null) {
            System.out.println("Agência com número " + numero + " já existe.");
            System.out.println("Deseja atualizar as informações dessa agência? (s/n):");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                // Atualiza as informações da agência existente
                agenciaExistente.setNome(nome);
                agenciaExistente.setCnpj(cnpj);
                agenciaExistente.setCep(cep);
                agenciaExistente.setUnidadeFederativa(unidadeFederativa);
                agenciaExistente.setMunicipio(municipio);
                agenciaExistente.setBairro(bairro);
                agenciaExistente.setLogradouro(logradouro);
            }
        } else {
            // Criação do objeto Agencia e adição na lista
            Agencia agencia = new Agencia(numero, nome, cnpj, cep, unidadeFederativa, municipio, bairro, logradouro);
            listaDeAgencias.add(agencia);
        }
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static Agencia encontrarAgenciaPorNumero(String numeroDaAgencia) {
        for (Agencia agencia : listaDeAgencias) {
            if (agencia.getNumero().equals(numeroDaAgencia)) {
                return agencia;
            }
        }
        return null;
    }

    public Optional<Conta> buscarConta(String numeroDaConta) {
        return contas.stream()
                .filter(conta -> conta.getNumero().equals(numeroDaConta))
                .findFirst();
    }

    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    /**
     * Adiciona uma conta à lista de contas da agência.
     *
     * @param conta A conta a ser adicionada.
     */
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    /**
     * Busca uma agência pelo número.
     *
     * @param numero O número da agência a ser buscada.
     * @return Um Optional contendo a agência, se encontrada; caso contrário, um Optional vazio.
     */
    public Optional<Agencia> buscarAgencia(String numero) {
        return listaDeAgencias.stream()
                .filter(agencia -> agencia.getNumero().equals(numero))
                .findFirst();
    }

    /**
     * Remove uma conta da lista de contas da agência.
     *
     * @param conta A conta a ser removida.
     */
    public void removerConta(Conta conta) {
        contas.remove(conta);
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
}
