package utils;

import java.util.Random;

public class RandomCodigoGtin {

    private int calcularDigitoVerificador(String codigoParcial) {
        int soma = 0;
        for (int i = 0; i < codigoParcial.length(); i++) {
            int digito = Integer.parseInt(String.valueOf(codigoParcial.charAt(i)));
            soma += (i % 2 == 0) ? digito : digito * 3;
        }
        return (10 - (soma % 10)) % 10;
    }

    public String gerarGtin13() {
        Random random = new Random();
        long numeroAleatorio = random.nextLong() % 1000000000000L;
        String gtinParcial = String.format("%012d", Math.abs(numeroAleatorio));
        int digitoVerificador = calcularDigitoVerificador(gtinParcial);
        return gtinParcial + digitoVerificador;
    }
}