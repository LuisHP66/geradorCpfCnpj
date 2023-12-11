package implementation;

import utils.*;

public interface GeradorCpfCnpj {

    static String gerar(TipoSelector tipo){
        return switch (tipo) {
            case CNPJ -> new RandomCNPJ().generationCnpj();
            case CPF -> new RandomCPF().generationCPF();
            case NAME -> new RandomName().generationName();
            case GTIN -> new RandomCodigoGtin().gerarGtin13();
            default -> throw new RuntimeException("Método não implementado");
        };
    }
}
