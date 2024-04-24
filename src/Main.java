import java.util.*;

public class Main {
    public static void criarTabuleiro(int num, List<Personagens> personagens, List<Comida> comidas, String[][] tabuleiro) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                boolean ocupado = false;
                for (Personagens personagem : personagens) {
                    if (i == personagem.getPosx() && j == personagem.getPosy()) {
                        tabuleiro[i][j] = "[ " + personagem.getType() + " ]";
                        ocupado = true;
                        break;
                    }
                }
                if (!ocupado) {
                    for (Comida comida : comidas) {
                        if (i == comida.getPosx() && j == comida.getPosy()) {
                            tabuleiro[i][j] = "[ " + comida.getType() + " ]";
                            ocupado = true;
                            break;
                        }
                    }
                }
                if (!ocupado) {
                    tabuleiro[i][j] = "[ . ]";
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Personagens> personagens = new ArrayList<>();
        List<Comida> comidas = new ArrayList<>();
        Scanner leitor = new Scanner(System.in);

        personagens.add(new Jogador("", 2, 4));

        String tabuleiro[][] = new String[8][8];

        System.out.println("Selecione o nível de dificuldade: ");
        System.out.println("Facil [1]");
        System.out.println("Medio [2]");
        System.out.println("Dificil [3]");
        System.out.print("Informe opcao: ");
        int nivel = leitor.nextInt();
        if (nivel == 1) {
            personagens.add(new Inimigo("", 3, 7));
            comidas.add(new Comida("", 5, 5));
        } else if (nivel == 2) {
            personagens.add(new Inimigo("", 3, 7));
            personagens.add(new Inimigo("", 6, 1));
            comidas.add(new Comida("", 5, 5));
            comidas.add(new Comida("", 7, 7));
        } else if (nivel == 3) {
            personagens.add(new Inimigo("", 3, 7));
            personagens.add(new Inimigo("", 6, 1));
            personagens.add(new Inimigo("", 7, 4));
            comidas.add(new Comida("", 5, 5));
            comidas.add(new Comida("", 7, 7));
            comidas.add(new Comida("", 0, 0));
        } else {
            System.out.println("Opção inválida!");
            System.exit(0);
        }

        criarTabuleiro(8, personagens, comidas, tabuleiro);

        int op;
        boolean todasComidasPegas;

        do {
            todasComidasPegas = true;
            for (Comida comida : comidas) {
                if (!(personagens.get(0).getPosx() == comida.getPosx() && personagens.get(0).getPosy() == comida.getPosy())) {
                    todasComidasPegas = false;
                    break;
                }
            }
            if (todasComidasPegas) {
                System.out.println("Parabéns! Você pegou todas as comidas. Você ganhou!");
                break;
            }

            System.out.println("\n##################################\n");
            System.out.println("[ 1 ] - Subir");
            System.out.println("[ 2 ] - Descer");
            System.out.println("[ 3 ] - Direita");
            System.out.println("[ 4 ] - Esquerda");
            System.out.println("[ 0 ] - Encerrar jogo");
            System.out.print("Informe opcao: ");
            op = leitor.nextInt();
            System.out.println("\n##################################\n");

            for (int i = 1; i < personagens.size(); i++) {
                if (personagens.get(0).getPosx() == personagens.get(i).getPosx() &&
                        personagens.get(0).getPosy() == personagens.get(i).getPosy()) {
                    System.out.println("### GAME OVER! ###");
                    op = 0;
                }
            }
            switch (op) {
                case 1:
                    personagens.get(0).setPosx(personagens.get(0).getPosx() - 1);
                    break;
                case 2:
                    personagens.get(0).setPosx(personagens.get(0).getPosx() + 1);
                    break;
                case 3:
                    personagens.get(0).setPosy(personagens.get(0).getPosy() + 1);
                    break;
                case 4:
                    personagens.get(0).setPosy(personagens.get(0).getPosy() - 1);
                    break;
                case 0:
                    System.out.println("Jogo encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            for (int i = 1; i < personagens.size(); i++) {
                personagens.get(i).perseguirJogador(personagens.get(0));
            }

            for (int i = 0; i < comidas.size(); i++) {
                Comida comida = comidas.get(i);
                if (personagens.get(0).getPosx() == comida.getPosx() && personagens.get(0).getPosy() == comida.getPosy()) {
                    comidas.remove(comida);
                    break;
                }
            }

            criarTabuleiro(8, personagens, comidas, tabuleiro);

        } while (op != 0);
    }
}