import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Jogo {

    // ATRIBUTOS
    private int idJogo;
    private double resultadoCerto;
    private double valorInf;
    private double valorSup;
    private List <Ouvinte> participantes;


    // ENCAPSULAMENTO

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public double getResultadoCerto() {
        return resultadoCerto;
    }

    public void setResultadoCerto(double resultadoCerto) {
        this.resultadoCerto = resultadoCerto;
    }

    public double getValorInf() {
        return valorInf;
    }

    public void setValorInf(double valorInf) {
        this.valorInf = valorInf;
    }

    public double getValorSup() {
        return valorSup;
    }

    public void setValorSup(double valorSup) {
        this.valorSup = valorSup;
    }

    public List<Ouvinte> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Ouvinte> participantes) {
        this.participantes = participantes;
    }


    // CONSTRUTORES

    public Jogo() {
        idJogo = 0;
        resultadoCerto = 0;
        valorInf = 0;
        valorSup = 0;
        participantes = new ArrayList<>();
    }

    public Jogo(int idJogo, double resultadoCerto, double valorInf, double valorSup) {
        this.idJogo = idJogo;
        this.resultadoCerto = resultadoCerto;
        this.valorInf = valorInf;
        this.valorSup = valorSup;
        participantes = new ArrayList<>();
    }

    public Jogo(int idJogo, double resultadoCerto, double valorInf, double valorSup, List<Ouvinte> participantes) {
        this.idJogo = idJogo;
        this.resultadoCerto = resultadoCerto;
        this.valorInf = valorInf;
        this.valorSup = valorSup;
        this.participantes = participantes;
    }



    //OVERRIDE


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###0.000");

        String detalheJogo = "ID Jogo: " + idJogo + "\tPeso exato: " + df.format(resultadoCerto) + "\nMargem Inf.: " + df.format(valorInf) + "\tMargem Sup.: " + df.format(valorSup) + "\n";

        if (this.getParticipantes().size()!= 0){
            for (int i = 0; i < this.getParticipantes().size(); i++) {
                detalheJogo += this.participantes;
            }

        } else{
            detalheJogo += "Jogo sem participantes!";
        }
        return detalheJogo;
    }
}
