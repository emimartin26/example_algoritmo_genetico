/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import static java.lang.Math.pow;
import java.util.Random;

/**
 *
 * @author emiliano
 */
public class Individuo {

    private int[] cromosoma;
    private double fitness;
    private int numGenes;
    private int minGen;
    private int maxGen;

    public Individuo(int numGenes, int minGen, int maxGen) {
        this.numGenes = numGenes;
        this.minGen = minGen;
        this.maxGen = maxGen;
        this.cromosoma = new int[numGenes];
        this.createCromosoma();
    }

    public Individuo() {
    }

    public void setInitialCromosoma() {
        this.cromosoma = new int[numGenes];
    }

    // arranca de 0 hasta numgenes -1
    public void createCromosoma() {
        for (int i = 0; i < numGenes; i++) {
            this.cromosoma[i] = this.createGen();
        }
    }

    public int createGen() {
        Random rnd = new Random();
        int numAleatorio = rnd.nextInt(maxGen - minGen + 1) + minGen;
        return numAleatorio;
    }

    public int[] getCromosoma() {
        return cromosoma;
    }

    public void setCromosoma(int[] cromosoma) {
        this.cromosoma = cromosoma;
    }

    public double getFitness() {
        double pozo1 = 0;
        double pozo2 = 1;
        for (int i = 1; i < (this.cromosoma.length + 1); i++) {
            int pepe = i - 1;
            if (this.cromosoma[pepe] == 0) {
                pozo1 = pozo1 + i;
            } else {
                pozo2 = pozo2 * i;
            }
        }
        if (pozo1 == 36) {
            pozo1 = 36.95;
        }
        if (pozo2 == 360) {
            pozo2 = 360.95;
        }
        double fitness = Math.abs((1 / (pozo1 - 36))) + Math.abs((1 / (pozo2 - 360)));

        return fitness;
    }

    public double getFitness2() {
        double A = 0.0;
        double B = 0.0;
        double C = 0.0;
        double D = 0.0;
        int j = 5;
        for (int i = 0; i < (6); i++) {
            A = A + (this.cromosoma[i] * pow(2, j));
            j = j - 1;
        }
        j = 5;
        for (int i = 6; i < (12); i++) {
            A = A + (this.cromosoma[i] * pow(2, j));
            j = j - 1;
        }
        j = 5;
        for (int i = 12; i < (18); i++) {
            A = A + (this.cromosoma[i] * pow(2, j));
            j = j - 1;
        }
        j = 5;
        for (int i = 18; i < (24); i++) {
            A = A + (this.cromosoma[i] * pow(2, j));
            j = j - 1;
        }

        double fitness = pow((A - B), 2) + (C - D) - pow((A - 30), 3) - pow((C - 40), 3);
        return fitness;
    }

    public double getPozo1() {
        double pozo1 = 0;
        for (int i = 1; i < (this.cromosoma.length + 1); i++) {
            int pepe = i - 1;
            if (this.cromosoma[pepe] == 0) {
                pozo1 = pozo1 + i;
            }
        }
        return pozo1;
    }

    public double getPozo2() {
        double pozo2 = 1;
        for (int i = 1; i < (this.cromosoma.length + 1); i++) {
            int pepe = i - 1;
            if (this.cromosoma[pepe] == 1) {
                pozo2 = pozo2 * i;
            }
        }
        return pozo2;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getNumGenes() {
        return numGenes;
    }

    public void setNumGenes(int numGenes) {
        this.numGenes = numGenes;
    }

    public int getMinGen() {
        return minGen;
    }

    public void setMinGen(int minGen) {
        this.minGen = minGen;
    }

    public int getMaxGen() {
        return maxGen;
    }

    public void setMaxGen(int maxGen) {
        this.maxGen = maxGen;
    }

    public void mutacion() {
        int puntoCruza;
        Random rnd = new Random();
        double prob = 0.01;
        double sorteo = Math.random();
        if (prob <= sorteo) {
            //rnd.nextInt(maxGen - minGen + 1) + minGen;
            puntoCruza = rnd.nextInt(5 - 0 + 1) + 0;
        } else {
            puntoCruza = rnd.nextInt(9 - 5 + 1) + 5;
        }
        //System.out.println(puntoCruza);
        if (this.cromosoma[puntoCruza] == 0) {
            this.cromosoma[puntoCruza] = 1;
        } else {
            this.cromosoma[puntoCruza] = 0;
        }

    }

    @Override
    public String toString() {
        String acumulador = "";
        String cadena;
        for (int i = 0; i < numGenes; i++) {
            acumulador = acumulador + this.cromosoma[i];
        }
        return acumulador;
    }

}
