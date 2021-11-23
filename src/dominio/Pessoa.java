package dominio;

public class Pessoa {
    private Integer codigo;
    private String nome;
    private String sexo;
    private Integer idade;
    private Double peso;
    private Integer altura;


    public Pessoa(Integer codigo, String nome, String sexo, Integer idade, Double peso, Integer altura) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public Pessoa() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }
}

