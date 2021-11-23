package ui;

import dominio.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import servicos.Calculadora;

public class CalculadoraUI {
    private List<Pessoa> pessoas;
    private Scanner teclado;

    public CalculadoraUI() {
        this.teclado = new Scanner(System.in);
        this.pessoas = new ArrayList<>();
    }

    public void main() {
        int opcaoSelecionada;
        do {
            System.out.println("Selecione a opção desejada: ");
            System.out.println("1 - Inserir Pessoa: ");
            System.out.println("2 - Calcular IMC: ");
            System.out.println("3 - Calcular TGC: ");
            System.out.println("4 - Calcular peso ideal: ");
            System.out.println("5 - Listar todos: ");
            System.out.println("0 - Sair: ");
            opcaoSelecionada = teclado.nextInt();

            switch (opcaoSelecionada) {
                case 1:
                    this.inserirPessoa();
                    break;
                case 2:
                    Pessoa pessoaSelecionadaImc = this.listarPessoasParaSelecao();
                    this.calcularImc(pessoaSelecionadaImc);
                    break;
                case 3:
                    Pessoa pessoaSelecionadaTgc = this.listarPessoasParaSelecao();
                    this.calcularTgc(pessoaSelecionadaTgc);
                    break;
                case 4:
                    Pessoa pessoaSelecionadaPesoIdeal = this.listarPessoasParaSelecao();
                    this.calcularPesoIdeal(pessoaSelecionadaPesoIdeal);
                    break;
                case 5:
                    this.listarTudo();
            }
        } while (opcaoSelecionada != 0);
    }

    private void listarTudo() {
        pessoas.forEach(pessoa -> {
            System.out.println(pessoa.getCodigo() + "- " + pessoa.getNome());
            calcularImc(pessoa);
            calcularTgc(pessoa);
            calcularPesoIdeal(pessoa);
        });
    }

    private void calcularPesoIdeal(Pessoa pessoa) {
        double pesoIdeal = Calculadora.calcularPesoIdeal(pessoa);
        System.out.printf("Peso ideal de %s: %.2f \n", pessoa.getNome(), pesoIdeal);
    }

    private void calcularTgc(Pessoa pessoa) {
        double tgc = Calculadora.calcularTaxaGorduraCorporal(pessoa);
        System.out.printf("Tgc de %s: %.2f \n", pessoa.getNome(), tgc);
    }

    private void calcularImc(Pessoa pessoa) {
        double imc = Calculadora.calculaImc(pessoa);
        String situacao = verificaSituacao(imc, pessoa.getSexo());
        System.out.printf("Imc de %s: %.2f. Está %s\n", pessoa.getNome(), imc, situacao);
    }

    private String verificaSituacao(double imc, String sexo) {
        if ((sexo.equals("M") && imc < 20.7) || (sexo.equals("F") && imc < 19.1)) {
            return "Abaixo do Peso";
        } else if((sexo.equals("M") && imc >= 20.7 && imc <= 26.4) || (sexo.equals("F") && imc >= 19.1 && imc <= 25.8)) {
            return "Peso Ideal";
        } else {
            return "Obeso";
        }
    }

    private Pessoa listarPessoasParaSelecao() {
        pessoas.forEach(pessoa -> {
            System.out.println(pessoa.getCodigo() + "- " + pessoa.getNome());
        });
        int codigoPessoaSelecionada = teclado.nextInt();

        return pessoas.get(codigoPessoaSelecionada - 1);
    }

    private void inserirPessoa() {
        Pessoa pessoa =  new Pessoa();
        System.out.println("\nInsira o nome da pessoa: ");
        pessoa.setNome(teclado.next());
        System.out.println("Insira a idade da pessoa: ");
        pessoa.setIdade(teclado.nextInt());
        System.out.println("Insira o sexo da pessoa (M ou F): ");
        pessoa.setSexo(teclado.next());
        System.out.println("Insira o peso da pessoa: ");
        pessoa.setPeso(teclado.nextDouble());
        System.out.println("Insira a altura da pessoa em cm: ");
        pessoa.setAltura(teclado.nextInt());
        pessoa.setCodigo(pessoas.size()+1);

        pessoas.add(pessoa);
    }


}
