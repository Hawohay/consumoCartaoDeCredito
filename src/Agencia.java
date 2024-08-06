import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private String numero;
    private String nome;
    private List<Conta> contas;

    public Agencia(String numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.contas = new ArrayList<>();
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

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }
}
