
public class Identificacao {

    private int rg;
    private String orgaoEmissorRg;
    private String cpf;


    public Identificacao(int rg, String orgaoEmissorRg, String cpf) {
        this.rg = rg;
        this.orgaoEmissorRg = orgaoEmissorRg;
        this.cpf = cpf;
    }

    public Identificacao() {

    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissorRg() {
        return orgaoEmissorRg;
    }

    public void setOrgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
