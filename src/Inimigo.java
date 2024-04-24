import java.util.Random;

public class Inimigo extends Personagens{

    public Inimigo(String type, int posy, int posx) {
        super("\033[0;35mO\033[0m", posy, posx);
    }

    public void perseguirJogador(Personagens jogador){
        Random rand = new Random();
        int numero = rand.nextInt(2);

        if (numero == 1) {
            if (jogador.getPosx() > this.getPosx()) {
                if (getPosx() == 7 || getPosx() == 0) {
                    setPosx(getPosx());
                }
                setPosx(getPosx() + 1);
            }else{
                if (getPosx() == 7 || getPosx() == 0) {
                    setPosx(getPosx());
                }
                setPosx(getPosx() - 1);
            }
        }else{
            if (jogador.getPosy() > this.getPosy()) {
                if (getPosy() == 7 || getPosy() == 0) {
                    setPosy(getPosy());
                }
                setPosy(getPosy() + 1);
            }else{
                if (getPosy() == 7 || getPosy() == 0) {
                    setPosy(getPosy());
                }
                setPosy(getPosy() - 1);
            }
        }
    }
}
