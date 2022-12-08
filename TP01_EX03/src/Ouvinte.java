import java.util.ArrayList;
import java.util.List;

public class Ouvinte implements Comparable<Ouvinte>{

    // ATRIBUTOS
    private int idOuvinte;
    private String nome;
    private int idade;
    private String contato;
    private int pontuacaoFinal;
    private int nJogos;

    private List<Paltite> paltites;


    // ENCAPSULAMENTO
    public int getIdOuvinte() {
        return idOuvinte;
    }

    public void setIdOuvinte(int idOuvinte) {
        this.idOuvinte = idOuvinte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getPontuacaoFinal() {return pontuacaoFinal;}

    public void setPontuacaoFinal(int pontuacaoFinal) {this.pontuacaoFinal = pontuacaoFinal;}

    public int getnJogos() {return nJogos;}

    public void setnJogos(int nJogos) {this.nJogos = nJogos;}

    public List<Paltite> getPaltites() {return paltites;}

    public void setPaltites(List<Paltite> paltites) {this.paltites = paltites;}



    // CONSTRUTORES

    public Ouvinte() {
        idOuvinte = 0;
        nome = "";
        idade = 0;
        contato = "";
        pontuacaoFinal = 0;
        nJogos = 0;
        paltites = new ArrayList<>();
    }

    public Ouvinte(int idOuvinte, String nome, int idade, String contato, int pontuacaoFinal, int nJogos) {
        this.idOuvinte = idOuvinte;
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.pontuacaoFinal = pontuacaoFinal;
        this.nJogos = nJogos;
        this.paltites = new ArrayList<>();

    }

    public Ouvinte(int idOuvinte, String nome, int idade, String contato) {
        this.idOuvinte = idOuvinte;
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.paltites = new ArrayList<>();

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
        return "ID: " + idOuvinte + "\tNome: " + nome + "\tIdade: " + idade + "\tContato: " + contato;
    }



    @Override
    public int compareTo(Ouvinte outroOuvinte) {
            if (this.getPontuacaoFinal() < outroOuvinte.getPontuacaoFinal() && this.getnJogos() < outroOuvinte.getnJogos()) {
                return -1;
            }
            if (this.getPontuacaoFinal() > getPontuacaoFinal() && this.getnJogos() > outroOuvinte.getnJogos()) {
                return 1;
            }
             return  0;
    }



}

