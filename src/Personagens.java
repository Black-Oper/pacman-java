public class Personagens {
    String type;
    int posx;
    int posy;

    public Personagens(String type, int posy, int posx){
        this.type = type;
        this.posy = posy;
        this.posx = posx;
    }

    public String getType(){
        return this.type;
    }

    public int getPosx(){
        return this.posx;
    }

    public int getPosy(){
        return this.posy;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setPosx(int posx){
        this.posx = posx;
    }

    public void setPosy(int posy){
        this.posy = posy;
    }

    public void perseguirJogador(Personagens personagens) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'perseguirJogador'");
    }
}
