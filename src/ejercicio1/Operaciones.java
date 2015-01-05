/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author emiliano
 */
public interface Operaciones {
    /**
     Acepta como parámetros el número de individuos “buenos” 
    * que se van a seleccionar. 
    * Devuelve un array de objetos del tipo “Individuo”,con los individuos a cruzar.
    *   
     * @param numIndividuos
     * @return 
    */    
    public ArrayList<Individuo> seleccion(int numIndividuos);
  
    /**
    Acepta como parámetros a los dos individuos seleccionados en el método “Selección”, 
    * y genera aleatoriamente un punto de crossover. 
    * 
     * @param individuosCruza
     * @return 
    */    
    public ArrayList<Individuo> reproduccion(ArrayList<Individuo> individuosCruza);
    
    
    /**
     * Acepta como parámetros los dos individuos generados 
     * en el método de “Reproducción” (hijos).
     * Este método reemplaza dos individuos existentes en la población (que son los padres), 
     * por los nuevos individuos generados por el método “Reproducción”
     * @param individuosGenerados
     */
    public void remplazar(ArrayList<Individuo> individuosGenerados);
    
    /**
     * Este método devuelve un objeto del tipo “Individuo” 
     * que representa la mejor solución encontrada.
     * @return 
     */
    public Individuo evolve();
}
