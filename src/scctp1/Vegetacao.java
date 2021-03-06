package scctp1;

import java.util.Random;



/**
 *
 * @author MiguelDiogo
 */
public class Vegetacao extends SerVivo{
    private int crescimento;
    
    public Vegetacao() {
        crescimento = 1;
        energia = 4;
    }
    
    public Vegetacao(boolean jaDesenvolvida) {
        if (jaDesenvolvida) 
            crescimento = 30;
        else {
            Random rand = new Random();
            crescimento = rand.nextInt(31);
        }
        energia = 4;
    }

    public int getCrescimento() {
        return crescimento;
    }

    public void setCrescimento(int crescimento) {
        this.crescimento = crescimento;
    }
    
    
    public void cresce() {
        crescimento++;
    }
    
    public boolean isReady() {
        return (crescimento >= 30);
    }
    

    public void morre() {
        crescimento = 1;
    }
    

 
}
