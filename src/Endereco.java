public interface Endereco {
    String getCep();
    void setCep(String cep);

    String getUnidadeFederativa();
    void setUnidadeFederativa(String unidadeFederativa);

    String getMunicipio();
    void setMunicipio(String municipio);

    String getBairro();
    void setBairro(String bairro);

    String getLogradouro();
    void setLogradouro(String logradouro);
}
