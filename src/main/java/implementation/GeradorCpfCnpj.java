package implementation;

import utils.RandomName;
import utils.TipoSelector;
import utils.RandomCNPJ;
import utils.RandomCPF;

public interface GeradorCpfCnpj {

    static String gerar(TipoSelector tipo){
        return switch (tipo) {
            case CNPJ -> new RandomCNPJ().generationCnpj();
            case CPF -> new RandomCPF().generationCPF();
            case NAME -> new RandomName().generationName();
            default -> throw new RuntimeException("Metodo não implementado");
        };
    }
}
