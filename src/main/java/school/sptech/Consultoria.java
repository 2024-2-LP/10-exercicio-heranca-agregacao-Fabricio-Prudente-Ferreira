package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(){
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedor != null && desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            contratar(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double salarioTotal = 0.0;

        for(Desenvolvedor desenvolvedor : desenvolvedores){
            salarioTotal += desenvolvedor.calcularSalario();
        }

        return salarioTotal;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdDevMobile = 0;

        for(Desenvolvedor desenvolvedor : desenvolvedores){
            if(desenvolvedor instanceof DesenvolvedorMobile){
                qtdDevMobile++;
            }
        }

        return qtdDevMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        if(salario != null){
            List<Desenvolvedor> devs = new ArrayList<>();

            for(Desenvolvedor desenvolvedor : desenvolvedores){
                if(desenvolvedor.calcularSalario() >= salario){
                    devs.add(desenvolvedor);
                }
            }

            return devs;
        }

        return null;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(!desenvolvedores.isEmpty()){
            Desenvolvedor devMenorSalario = desenvolvedores.get(0);

            for(Desenvolvedor desenvolvedor : desenvolvedores){
                if(desenvolvedor.calcularSalario() < devMenorSalario.calcularSalario()){
                    devMenorSalario = desenvolvedor;
                }
            }

            return devMenorSalario;
        }

        return null;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        if(tecnologia != null && !tecnologia.isBlank()){
            List<Desenvolvedor> devs = new ArrayList<>();

            for(Desenvolvedor dev : desenvolvedores){
                if (
                        (dev instanceof DesenvolvedorWeb && (
                            ((DesenvolvedorWeb) dev).getBackend().equalsIgnoreCase(tecnologia) ||
                            ((DesenvolvedorWeb) dev).getFrontend().equalsIgnoreCase(tecnologia) ||
                            ((DesenvolvedorWeb) dev).getSgbd().equalsIgnoreCase(tecnologia)
                        ))

                        ||

                        (dev instanceof DesenvolvedorMobile && (
                            ((DesenvolvedorMobile) dev).getPlataforma().equalsIgnoreCase(tecnologia) ||
                            ((DesenvolvedorMobile) dev).getLinguagem().equalsIgnoreCase(tecnologia)
                        ))
                ){
                    devs.add(dev);
                }
            }

            return devs;
        }

        return null;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        List<Desenvolvedor> devs = buscarPorTecnologia(tecnologia);

        Double totalSalario = 0.0;

        for(Desenvolvedor dev : devs){
            totalSalario += dev.calcularSalario();
        }

        return totalSalario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
