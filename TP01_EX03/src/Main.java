import java.text.DecimalFormat;
import java.util.*;


public class Main {

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    static int idOuvinteTemp = 11;
    static int idJogoTemp = 1;
    static int idPalpiteTemp = 0;

    static int pontuacaoTemp = 5;

    static int idUserAddPalpite;

    static List<Ouvinte> ouvintes;
    static  List<Jogo> listaJogos;

    static List<Paltite> paltites;
    static  int listaOuvintesJogoTemp [] = new int[5];


    public static void main(String[] args) {
        ouvintes = new ArrayList<>();
        listaJogos = new ArrayList<>();
        paltites = new ArrayList<>();

        CriarMockups();

        int op = 1;
        while (op != 0) {
            System.out.println("1-Ver Ouvintes");
            System.out.println("2-Criar, editar ou eliminar ouvintes");
            System.out.println("3-Ver dados de um ouvinte");
            System.out.println("4-Ver ranking");
            System.out.println("5-Jogar");
            System.out.println("6-Ver Palpites");
            System.out.println("0-Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    VerOuvintes();
                    break;
                case 2:
                    CriarEdiarEliminar();
                    break;
                case 3:
                    VerDadosOuvinte();
                    break;
                case 4:
                    VerRanking();
                    break;
                case 5:
                    Jogar();
                    break;
                case 6:
                    VerPalpites();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        }

    }

    private static void VerPalpites() {
        DecimalFormat df = new DecimalFormat("#,###0.000");

        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < paltites.size(); i++) {
            System.out.println(paltites.get(i).toString() + "\tDif: " + df.format(paltites.get(i).getDifPalpite()));
        }
        System.out.println("--------------------------------------------------------------");
    }

    private static void CriarMockups() {
        ouvintes.add(new Ouvinte(1,"Joao",30,"91000000"));
        ouvintes.add(new Ouvinte(2,"Ana",26,"96000000"));
        ouvintes.add(new Ouvinte(3,"Maria",22,"93000000"));
        ouvintes.add(new Ouvinte(4,"Joana",25,"91111222"));
        ouvintes.add(new Ouvinte(5,"Pedro",31,"96111222"));
        ouvintes.add(new Ouvinte(6,"Ricardo",40,"93111222"));
        ouvintes.add(new Ouvinte(7,"Cidalia",19,"91222333"));
        ouvintes.add(new Ouvinte(8,"Marco",23,"96222333"));
        ouvintes.add(new Ouvinte(9,"Sofia",33,"93222333"));
        ouvintes.add(new Ouvinte(10,"Irina",40,"91444555"));



    }

    private static void VerOuvintes() {
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < ouvintes.size(); i++) {
            System.out.println(ouvintes.get(i).toString());
        }
        System.out.println("--------------------------------------------------------------");

    }

    private static void Jogar() {
        Scanner in = new Scanner(System.in);

        CriarJogo();


        RegistarPalpites();


        ClassificarPalpites();




    }

    private static void ClassificarPalpites() {
            pontuacaoTemp = 5;
        DecimalFormat df = new DecimalFormat("#,###0.000");


        System.out.println("===================================");
            System.out.println("=== Sorteio N " + (idJogoTemp) + " ===");
            System.out.println("=== Resultados ===");

        for (int i = 0; i < paltites.size(); i++) {
            if (paltites.get(i).getIdJogo() == idJogoTemp){
                //System.out.println(paltites.get(i).toString() + "\tDif: " + df.format(paltites.get(i).getDifPalpite()) );
                paltites.sort(Comparator.comparing(Paltite::getDifPalpite));
            }
        }
        for (int i = 0; i < paltites.size(); i++) {
            if (paltites.get(i).getIdJogo() == idJogoTemp){
                paltites.get(i).setPontuacao(pontuacaoTemp);
                for (int j = 0; j < ouvintes.size(); j++) {
                    if (ouvintes.get(j).getIdOuvinte()== paltites.get(i).getIdOuvinte()){
                        ouvintes.get(j).setPontuacaoFinal(ouvintes.get(j).getPontuacaoFinal()+pontuacaoTemp);
                        ouvintes.get(j).setnJogos(ouvintes.get(j).getnJogos()+1);
                    }
                }
                pontuacaoTemp--;
                System.out.println(paltites.get(i).toString() + "\tDif: " + df.format(paltites.get(i).getDifPalpite()) );

            }
            /*
            for (int j = 0; j < ouvintes.size(); j++) {
                if (ouvintes.get(j).getIdOuvinte()== paltites.get(i).getIdOuvinte()){
                    ouvintes.get(j).setPontuacaoFinal(ouvintes.get(j).getPontuacaoFinal()+pontuacaoTemp);
                }
            }
            */
        }
        //pontuacaoTemp--;


            System.out.println("===================================");
            idJogoTemp++;
            idPalpiteTemp++;
    }

    private static void RegistarPalpites() {

        Scanner in = new Scanner(System.in);
        double palpite;
        double diferencaPalpiteResultado;
        DecimalFormat df = new DecimalFormat("#,###0.000");


        for (int i = 0; i < listaJogos.size(); i++) {
            int j = idJogoTemp;
            while(j == listaJogos.get(i).getIdJogo()){
                for (int k = 0; k < listaJogos.get(i).getParticipantes().size(); k++) {
                    System.out.println("Qual o palpite do(a) " + listaJogos.get(i).getParticipantes().get(k).getNome() + "?");
                    //palpite = in.nextDouble();
                    palpite = rnd.nextDouble(listaJogos.get(i).getValorInf(), listaJogos.get(i).getValorSup()) ;        //TESTAR
                    System.out.println(df.format(palpite));
                    if (palpite<listaJogos.get(i).getResultadoCerto()){
                        diferencaPalpiteResultado = (listaJogos.get(i).getResultadoCerto() - palpite);
                    } else {
                        diferencaPalpiteResultado = (palpite - listaJogos.get(i).getResultadoCerto());
                    }

                    idPalpiteTemp++;
                    paltites.add(new Paltite(idPalpiteTemp, listaJogos.get(i).getParticipantes().get(k).getIdOuvinte(), listaJogos.get(i).getParticipantes().get(k).getNome(), listaJogos.get(i).getIdJogo(), palpite, 0, diferencaPalpiteResultado));
                    //System.out.println(idPalpiteTemp);
                    idUserAddPalpite = listaJogos.get(i).getParticipantes().get(k).getIdOuvinte();
                }
                for (int l=0; l < ouvintes.size(); l++) {
                    if (idUserAddPalpite == ouvintes.get(l).getIdOuvinte()){
                        ouvintes.get(l).getPaltites().add(paltites.get(paltites.size()-1));
                    }
                }
                break;
            }
        }
    }

    private static void CriarJogo() {
        Random rnd = new Random();
        DecimalFormat df = new DecimalFormat("#,###0.000");

        double resultadoCertoTemp;
        resultadoCertoTemp = rnd.nextDouble(1.000,10.000);
        double resultadoInfTemp = resultadoCertoTemp - 0.75;
        double resultadoSupTemp = resultadoCertoTemp + 0.75;



        listaJogos.add(new Jogo(idJogoTemp,resultadoCertoTemp,resultadoInfTemp,resultadoSupTemp));

        //Sortear ouvintes

        for (int i = 0; i < 5; i++) {
            listaOuvintesJogoTemp[i]= rnd.nextInt(0, ouvintes.size());
            for (int j = 0; j < i; j++)
                if (listaOuvintesJogoTemp[i]==listaOuvintesJogoTemp[j]){
                    i--;
                    break;
                }
            }
        for (int i = 0; i < listaJogos.size(); i++) {
            if (idJogoTemp == listaJogos.get(i).getIdJogo()){
                System.out.println("===================== JOGO " + idJogoTemp + " =====================");
                System.out.println("=Peso Min: " + df.format(resultadoInfTemp)  + " ==Peso Exato: " + df.format(resultadoCertoTemp)  + " =Peso Max: " + df.format(resultadoSupTemp));
                System.out.println("==================== Jogadores ===================");
                for (int j = 0; j < listaOuvintesJogoTemp.length; j++) {
                    listaJogos.get(i).getParticipantes().add(ouvintes.get(listaOuvintesJogoTemp[j]));
                    //Ver Lista Jogos
                    System.out.println(listaJogos.get(i).getParticipantes().get(j));
                }
                System.out.println("=======================================================");
            }
        }
    }

    private static void VerRanking() {

        System.out.println("=================== RANKING FINAL =============================");
        Collections.sort(ouvintes, Collections.reverseOrder());
        for (int i = 0; i < ouvintes.size(); i++) {
            System.out.println("ID Ouv: " + ouvintes.get(i).getIdOuvinte() + "\tNome: " + ouvintes.get(i).getNome() + "\t\tJogos: " + ouvintes.get(i).getnJogos() + "\t\tPontos Final: " + ouvintes.get(i).getPontuacaoFinal());
        }
        System.out.println("--------------------------------------------------------------");

    }

    private static void VerDadosOuvinte() {
        in = new Scanner(System.in);
        int  idOuvinteVer;

        System.out.println("Qual o ID do ouvinte?");
        idOuvinteVer = in.nextInt();

        System.out.println("--------------------------------------------------------------");
        if (idOuvinteVer>0 && idOuvinteVer < idOuvinteTemp){
            for (int i = 0; i < ouvintes.size(); i++) {
                if(idOuvinteVer == ouvintes.get(i).getIdOuvinte()){
                        System.out.println(ouvintes.get(i).toString());
                }
            }
        } else {
            System.out.println("Ouvinte invalido!");
        }
        System.out.println("--------------------------------------------------------------");
    }

    private static void CriarEdiarEliminar() {

        int op = 1;
        while (op != 0) {
            System.out.println("1-Ciar Ouvinte");
            System.out.println("2-Editar ouvinte");
            System.out.println("3-Eliminar ouvinte");
            System.out.println("0-Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    CriarOuvinte();
                    break;
                case 2:
                    EditarOuvinte();
                    break;
                case 3:
                    EliminarOuvinte();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
    }
}

    private static void EliminarOuvinte() {
        in = new Scanner(System.in);
        int idOuvinteEliminar;


        if (ouvintes.size() == 0) {
            System.out.println("Não existem ouvintes!!!");
        } else {
            do {
                System.out.println("Qual o ID do ouvinte a eliminar?");
                VerOuvintes();
                idOuvinteEliminar = in.nextInt();
            }
            while (idOuvinteEliminar<0 || idOuvinteEliminar > idOuvinteTemp-1);
            for (int i = 0; i < ouvintes.size(); i++) {
                if (idOuvinteEliminar == ouvintes.get(i).getIdOuvinte()) {
                    ouvintes.remove(i);
                    System.out.println("Ouvinte removido com sucesso!");
                    return;
                }
            }
            System.out.println("Ouvinte nao exixtente!");
        }
    }

    private static void EditarOuvinte() {
        in = new Scanner(System.in);
        int idOuvinteEditar;
        String nomeEditar;
        int idadeEditar;
        String contatoEditar;


        if (ouvintes.size() == 0) {
            System.out.println("Não existem ouvintes!!!");
        } else {
            do {
                System.out.println("Qual o ID do ouvinte a eliminar?");
                VerOuvintes();
                idOuvinteEditar = in.nextInt();
            }
            while (idOuvinteEditar<0 || idOuvinteEditar > idOuvinteTemp-1);
            in = new Scanner(System.in);
            System.out.println("Qual o novo nome?");
            nomeEditar = in.nextLine();
            in = new Scanner(System.in);
            System.out.println("Qual a idade do ouvinte?");
            idadeEditar = in.nextInt();
            in = new Scanner(System.in);
            System.out.println("Qual o contato do ouvinte?");
            contatoEditar = in.nextLine();
            for (int i = 0; i < ouvintes.size(); i++) {
                if (idOuvinteEditar == ouvintes.get(i).getIdOuvinte()) {
                    ouvintes.get(i).setNome(nomeEditar);
                    ouvintes.get(i).setIdade(idadeEditar);
                    ouvintes.get(i).setContato(contatoEditar);
                    System.out.println("Ouvinte editado com sucesso!");
                    return;
                }
            }
            System.out.println("Ouvinte nao exixtente!");
        }

    }

    private static void CriarOuvinte() {
        in = new Scanner(System.in);
        String nomeCriar;
        int idadeCriar;
        String contatoCriar;

        System.out.println("Qual o nome do novo ouvinte?");
        nomeCriar = in.nextLine();

        in = new Scanner(System.in);
        System.out.println("Qual a idade do " + nomeCriar + "?");
        idadeCriar = in.nextInt();

        in = new Scanner(System.in);
        System.out.println("Qual o contato do " + nomeCriar + "?");
        contatoCriar = in.nextLine();

        ouvintes.add(new Ouvinte(idOuvinteTemp,nomeCriar,idadeCriar,contatoCriar));
        System.out.println("Ouvinte criado com sucesso!!");
        idOuvinteTemp++;

    }


    }