public class CPFValidator {
    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Calcular o primeiro dígito verificador
            int digito1 = calcularDigitoVerificador(cpf.substring(0, 9));
            // Calcular o segundo dígito verificador
            int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1);

            // Verificar se os dígitos calculados são iguais aos dígitos do CPF
            return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
        } catch (Exception e) {
            return false;
        }
    }

    private static int calcularDigitoVerificador(String cpf) {
        int soma = 0;
        int peso = cpf.length() + 1;

        for (int i = 0; i < cpf.length(); i++) {
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * peso--;
        }

        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}
