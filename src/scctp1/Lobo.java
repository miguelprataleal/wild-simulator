package scctp1;


import java.util.Random;



/**
 *
 * @author MiguelDiogo
 */
public class Lobo extends Animal{

    public Lobo() {
        /* energia de novo lobo sorteada de 0 a 30 */
        Random rand = new Random();
        energia = rand.nextInt(30);
    }

    public Lobo(Mundo mundo) {
        super(mundo);
        /* energia de novo lobo sorteada de 0 a 30 */
        Random rand = new Random();
        energia = rand.nextInt(30);
    }

    public Lobo(Mundo mundo, double energia) {
        super(mundo, energia);
    }
    
    

    public Lobo(Mundo mundo, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        Random rand = new Random();
        energia = rand.nextInt(30);
       
    }
    
    public Lobo(Mundo mundo, double energia, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        this.energia = energia;

    }
    
    


    /**
     * Lobo tenta reproduzir-se.
     * @throws AnimalReproduziuException 
     */
    @Override
    public void tentaReproduzir() throws AnimalReproduziuException{
        Random rand = new Random();
        /* sorteia numero de 0 a 99 (100 numeros), calhar os primeiros cinco equivale a probabilidade de 5% */
        if (rand.nextInt(100) < 5) {
            throw new AnimalReproduziuException();
        }



    }

    /**
     * Lobo come ovelha/ovelhas da sua casa. Se houver mais lobos, partilha-a(s) igualmente.
     */
    @Override
    public void come() {
        if (!mundo.getOvelhas(this).isEmpty()) {
            double energiaTotal = 0;
            int numLobosLocais = mundo.getLobos(this).size();
            for (Ovelha ovelha : mundo.getOvelhas(this)) {
                energiaTotal += 20;
                mundo.getOvelhas().remove(ovelha);
            }
            for (Lobo lobo : mundo.getLobos(this)) {
                lobo.setEnergia(lobo.getEnergia() + energiaTotal/numLobosLocais);
            } 
        } 
    }

}
