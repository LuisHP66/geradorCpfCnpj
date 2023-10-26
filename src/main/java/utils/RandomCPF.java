package utils;

import java.util.Random;

public class RandomCPF {

    public RandomCPF() {
    }

    private String geradorCPF() {
        Random randomNum = new Random();
        int[] numeros = new int[9];

        for (int i = 0; i < 9; i++) {
            numeros[i] = randomNum.nextInt(10);
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * (10 - i);
        }

        int primeiroVerificador = (soma % 11);
        if (primeiroVerificador < 2) {
            primeiroVerificador = 0;
        } else {
            primeiroVerificador = 11 - primeiroVerificador;
        }

        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * (11 - i);
        }

        soma += primeiroVerificador * 2;
        int segundoVerificador = (soma % 11);
        if (segundoVerificador < 2) {
            segundoVerificador = 0;
        } else {
            segundoVerificador = 11 - segundoVerificador;
        }

        StringBuilder cpf = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            cpf.append(numeros[i]);
        }
        cpf.append(primeiroVerificador);
        cpf.append(segundoVerificador);
        String cpfString = cpf.toString();

        return cpfString;
    }

    public String generationCPF() {
        return geradorCPF();
    }
}
