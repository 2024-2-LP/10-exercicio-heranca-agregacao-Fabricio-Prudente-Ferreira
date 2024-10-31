package school.sptech;

public class Desenvolvedor {
    protected String nome;
    protected Integer qtdHoras;
    protected Double valorHora;

    public Desenvolvedor(){}

    public Desenvolvedor(String nome, Integer qtdHoras, Double valorHora) {
        this.nome = nome;
        this.qtdHoras = qtdHoras;
        this.valorHora = valorHora;
    }

    public Double calcularSalario(){
        if(valorHora != null && qtdHoras != null){
            return valorHora * qtdHoras;
        }

        return 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Desenvolvedor{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", qtdHoras=").append(qtdHoras);
        sb.append(", valorHora=").append(valorHora);
        sb.append('}');
        return sb.toString();
    }
}
