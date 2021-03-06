package scctp1;


import java.util.Random;



/**
 *
 * @author MiguelDiogo
 */
public abstract class Animal extends SerVivo {
    protected Mundo mundo;
    protected PontoToroidal2D coordenada;
    
    public Animal() {
        Random rand = new Random();
        /* sorteia coordX e coordY de 0 a 50 (inclusive) */
        coordenada = new PontoToroidal2D(rand.nextInt(51), rand.nextInt(51));
        energia = rand.nextInt(8);                  // sorteia energia de 0 a 7 (inclusive);
    }
    
    public Animal(Mundo mundo) {
        Random rand = new Random();
        /* sorteia coordX e coordY de 0 a 50 (inclusive) */
        coordenada = new PontoToroidal2D(rand.nextInt(51), rand.nextInt(51));
        energia = rand.nextInt(8);                  // sorteia energia de 0 a 7 (inclusive);
        this.mundo = mundo;
    }
    
    public Animal(Mundo mundo, double energia) {
        Random rand = new Random();
        /* sorteia coordX e coordY de 0 a 50 (inclusive) */
        coordenada = new PontoToroidal2D(rand.nextInt(51), rand.nextInt(51));
        this.energia = energia;
        this.mundo = mundo;
    }

    public Animal(Mundo mundo, int coordX, int coordY) {
        /* sorteia coordX e coordY de 0 a 50 (inclusive) */
        coordenada = new PontoToroidal2D(coordX, coordY);
        this.mundo = mundo;
        
    }

    
    public PontoToroidal2D getCoordenadas() {
        return coordenada;
    }
    

    public void setCoordenadas(PontoToroidal2D coordenadas) {
        this.coordenada = coordenadas;
    }

    
    public void setMundo (Mundo mundo) {
        this.mundo = mundo;
    }
    
    
    /**
     * Movimenta animal aleatoriamente para uma casa vizinha.
     * @throws scctp1.AnimalMorreuException
     * @throws scctp1.AnimalReproduziuException
     * @see PontoToroidal2D
     */
    public void move() throws AnimalMorreuException, AnimalReproduziuException {
        Random rand = new Random();
        /* escolhe a casa vizinha a visitar */
        if (energia > 0) {
            int dX, dY;
            do {
                dX = rand.nextInt((1 - (-1)) + 1) + (-1);       // move-se zero ou uma casa na horizontal
                dY = rand.nextInt((1 - (-1)) + 1) + (-1);       // move-se zero ou uma casa na horizontal
            }
            while (dX == 0 && dY == 0);

            //System.out.println(dX + " " + dY);
            //System.out.print("movi de " + coordenada.getCoordX() + " " + coordenada.getCoordY());
            coordenada.adiciona(mundo, dX, dY);   // move animal
            //System.out.println(" para " + coordenada.getCoordX() + " " + coordenada.getCoordY());


            energia--;
        }
        if (energia <= 0) {
            throw new AnimalMorreuException();
        }
        else {
            try{
                tentaReproduzir();
            }
            catch (AnimalReproduziuException e) {
                throw e;
            }

        }
        
    }
    
    /**
     * Animal come.
     */
    public abstract void come();
    
    /**
     * Animal tenta reproduzir-se.
     * @throws scctp1.AnimalReproduziuException
     */
    public abstract void tentaReproduzir() throws AnimalReproduziuException;

    
    
}
