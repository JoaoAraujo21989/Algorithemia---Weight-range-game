import java.text.DecimalFormat;

public class Paltite {
    // ATRIBUTOS
    private int idPalpite;
    private int idOuvinte;

    private String nomeOuvinte;
    private int idJogo;
    private double palpiteOuvinte;
    private int pontuacao;

    private  double difPalpite;

    // ENCAPSULAMENTO

    public int getIdPalpite() {
        return idPalpite;
    }

    public void setIdPalpite(int idPalpite) {
        this.idPalpite = idPalpite;
    }

    public int getIdOuvinte() {
        return idOuvinte;
    }

    public void setIdOuvinte(int idOuvinte) {
        this.idOuvinte = idOuvinte;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public double getPalpiteOuvinte() {
        return palpiteOuvinte;
    }

    public void setPalpiteOuvinte(double palpiteOuvinte) {
        this.palpiteOuvinte = palpiteOuvinte;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNomeOuvinte() {
        return nomeOuvinte;
    }

    public void setNomeOuvinte(String nomeOuvinte) {
        this.nomeOuvinte = nomeOuvinte;
    }

    public double getDifPalpite() {
        return difPalpite;
    }

    public void setDifPalpite(double difPalpite) {
        this.difPalpite = difPalpite;
    }

    // CONSTRUTORES

    public Paltite() {
        idPalpite = 0;
        idOuvinte = 0;
        nomeOuvinte = "";
        idJogo = 0;
        palpiteOuvinte = 0;
        pontuacao = 0;
        difPalpite = 0;
    }

    public Paltite(int idPalpite, int idOuvinte, String nomeOuvinte, int idJogo, double palpiteOuvinte, int pontuacao, double difPalpite) {
        this.idPalpite = idPalpite;
        this.idOuvinte = idOuvinte;
        this.nomeOuvinte = nomeOuvinte;
        this.idJogo = idJogo;
        this.palpiteOuvinte = palpiteOuvinte;
        this.pontuacao = pontuacao;
        this.difPalpite = difPalpite;
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

        return "ID: " + idPalpite + "\tNome: " + nomeOuvinte + "\tID Jogo: " + idJogo + "\tPalpite: " + df.format(palpiteOuvinte)  + "\tPontuacao: " + pontuacao;
    }


}
