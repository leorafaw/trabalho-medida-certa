package servicos;

import dominio.Pessoa;

public class Calculadora {

    public static double calculaImc(Pessoa pessoa) {
        return pessoa.getPeso()/Math.pow(pessoa.getAltura().doubleValue()/100, 2);
    }

    public static double calcularPesoIdeal(Pessoa pessoa) {
        int k = pessoa.getSexo().equals("M") ? 4 : 2;
        return (pessoa.getAltura() - 100) - ((pessoa.getAltura().doubleValue() - 150)/k);
    }

    public static double calcularTaxaGorduraCorporal(Pessoa pessoa) {
        int s = pessoa.getSexo().equals("M") ? 1 : 0;
        return (1.2 * calculaImc(pessoa)) - (10.8 * s) + (0.23 * pessoa.getIdade()) - 5.4;
    }

}
