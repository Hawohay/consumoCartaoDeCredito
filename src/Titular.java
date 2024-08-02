import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Titular extends Identificacao implements Endereco {
    private String nome;
    private LocalDate dataDeNascimento;

    private String cep;
    private String unidadeFederativa;
    private String municipio;
    private String bairro;
    private String logradouro;

    public Titular(String nome, LocalDate dataDeNascimento, int rg, String orgaoEmissorRg, String cpf, int digitoVerificadorCpf,
                   String cep, String unidadeFederativa, String municipio, String bairro, String logradouro) {
        super(rg, orgaoEmissorRg, cpf, digitoVerificadorCpf);
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cep = cep;
        this.unidadeFederativa = unidadeFederativa;
        this.municipio = municipio;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public Titular() {
        // Construtor padrão
    }

    public void exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + formatarData(getDataDeNascimento()));
        System.out.println("Idade: " + calculaIdade());
        System.out.println("CEP: " + getCep());
        System.out.println("Unidade Federativa: " + getUnidadeFederativa());
        System.out.println("Município: " + getMunicipio());
        System.out.println("Bairro: " + getBairro());
        System.out.println("Logradouro: " + getLogradouro());
    }

    private String formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public int calculaIdade() {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataDeNascimento, hoje).getYears();
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
}
