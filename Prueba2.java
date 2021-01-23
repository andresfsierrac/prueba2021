/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

/**
 *
 * @author Administrador
 */
public class Prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // se define el atributo booleano para indicar si se han encontrado los valores que satisfacen las ecuaciones
        boolean valoresEncontrados = false;
        // se construyentres ciclos for donde el valor máximo de a debe ser 333, de b es 666 y de c es 999
        // ya que estos pueden ser los máximos valores que se podrían tomar para satisfacer las ecuaciones y mientras
        // valoresEncontrados sea false se recorrerán los ciclos
        for (int a = 1; a < 333 && !valoresEncontrados; a++) {
            for (int b = 1; b < 666 && !valoresEncontrados; b++) {
                for (int c = 1; c < 999 && !valoresEncontrados; c++) {
                    if (a + b + c == 1000) { // se verifica si a+b+c=100
                        if (a * a + b * b == c * c) { //se verifica si a^2+b^2=c^2
                            System.out.println("a= " + a + ", b= " + b + ", c=" + c);
                            valoresEncontrados = true; 
                        }
                    }
                }
            }
        }
    }
}
