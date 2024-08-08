import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Cartao extends Titular {

    private String numeroDoCartao;
    private String bandeira;
    private String funcaoDoCartao;
    private int cvv;
    private LocalDate dataDeValidade;
    private double limiteDeCredito;

    // Construtor atualizado
    public Cartao(String nome, LocalDate dataDeNascimento, int rg, String orgaoEmissorRg, String cpf,
                  String bandeira, String funcaoDoCartao, int anosDeValidade, double limiteDeCredito,
                  String cep, String unidadeFederativa, String municipio, String bairro, String logradouro,
                  List<Cartao> cartoesExistentes) {
        super(nome, dataDeNascimento, rg, orgaoEmissorRg, cpf, cep, unidadeFederativa, municipio, bairro, logradouro);
        this.numeroDoCartao = GeradorCartao.gerarNumeroCartaoValido(cartoesExistentes);
        this.bandeira = bandeira;
        this.funcaoDoCartao = funcaoDoCartao;
        this.cvv = GeradorCartao.gerarCVV(cartoesExistentes);
        this.dataDeValidade = LocalDate.now().plusYears(anosDeValidade);
        this.limiteDeCredito = limiteDeCredito;
    }

    // Construtor adicional (se necessário)
    public Cartao(String numeroDoCartao, String bandeira, String funcaoDoCartao, LocalDate dataDeValidade, double limiteDeCredito, int cvv) {
        this.numeroDoCartao = numeroDoCartao;
        this.bandeira = bandeira;
        this.funcaoDoCartao = funcaoDoCartao;
        this.dataDeValidade = dataDeValidade;
        this.limiteDeCredito = limiteDeCredito;
        this.cvv = cvv;
    }

    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Número do Cartão: " + numeroDoCartao);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("Função do Cartão: " + funcaoDoCartao);
        System.out.println("CVV: " + cvv);
        System.out.println("Data de Validade: " + dataDeValidade.format(DateTimeFormatter.ofPattern("MM/yy")));
        System.out.println("Limite de Crédito: " + limiteDeCredito);
        System.out.println("Endereço: " + getLogradouro() + ", " + getBairro() + ", " + getMunicipio() + " - " + getUnidadeFederativa() + ", CEP: " + getCep());
    }

    // Getters e Setters
    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getFuncaoDoCartao() {
        return funcaoDoCartao;
    }

    public void setFuncaoDoCartao(String funcaoDoCartao) {
        this.funcaoDoCartao = funcaoDoCartao;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }
}
