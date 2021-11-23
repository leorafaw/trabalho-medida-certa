package servicos;

import static org.junit.jupiter.api.Assertions.*;

import dominio.Pessoa;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    public void testaCalculoImc() {
        Pessoa pessoa = new Pessoa(1, "Leonardo", "M", 20, 87.00, 179);

        double retorno = Calculadora.calculaImc(pessoa);

        assertEquals(retorno, 27.15, 0.01);
    }

    @Test
    public void testaCalculoTgc() {
        Pessoa pessoa = new Pessoa(1, "Leonardo", "M", 20, 87.00, 179);

        double retorno = Calculadora.calcularTaxaGorduraCorporal(pessoa);

        assertEquals(retorno, 20.98, 0.01);
    }

    @Test
    public void testaCalculoPesoIdeal() {
        Pessoa pessoa = new Pessoa(1, "Leonardo", "M", 20, 87.00, 179);

        double retorno = Calculadora.calcularPesoIdeal(pessoa);

        assertEquals(retorno, 71.75, 0.01);
    }
}