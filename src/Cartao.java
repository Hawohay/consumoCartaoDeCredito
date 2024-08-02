import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cartao extends Titular {
    private String numeroDoCartao;
    private int digitoVerificador;
    private String bandeira;
    private String funcaoDoCartao;
    private int cvv;
    private LocalDate dataDeValidade;
    private double limiteDeCredito;

    public Cartao(String nome, LocalDate dataDeNascimento, int rg, String orgaoEmissorRg, String cpf, int digitoVerificadorCpf,
                  String numeroDoCartao, int digitoVerificador, String bandeira, String funcaoDoCartao, int cvv, int anosDeValidade, double limiteDeCredito,
                  String cep, String unidadeFederativa, String municipio, String bairro, String logradouro) {
        super(nome, dataDeNascimento, rg, orgaoEmissorRg, cpf, digitoVerificadorCpf, cep, unidadeFederativa, municipio, bairro, logradouro);
        this.numeroDoCartao = numeroDoCartao;
        this.digitoVerificador = digitoVerificador;
        this.bandeira = bandeira;
        this.funcaoDoCartao = funcaoDoCartao;
        this.cvv = cvv;
        this.dataDeValidade = calculaDataValidade(anosDeValidade);
        this.limiteDeCredito = limiteDeCredito;
    }

    private LocalDate calculaDataValidade(int anosDeValidade) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.plusYears(anosDeValidade);
    }

    private String formatarDataValidade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDeValidade.format(formatter);
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Número do Cartão: " + numeroDoCartao);
        System.out.println("Dígito Verificador: " + digitoVerificador);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("Função do Cartão: " + funcaoDoCartao);
        System.out.println("CVV: " + cvv);
        System.out.println("Data de Validade: " + formatarDataValidade());
        System.out.println("Limite de Crédito: " + limiteDeCredito);
    }
}
