/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class PRUEBA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Se lee el parámetro
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el parámetro: ");
        String parametro = sc.nextLine();
        int numDigitos = parametro.length();// Se cuenta el número de dígitos para verificar que la logitud sea 10
        if (numDigitos == 10) {
            String[] arrayCadena = parametro.split("");//se define un arreglo donde se almacenan cada uno de los digitos
            String salida = "";
            // Se recorre cada ua de las posiciones y se reemplazan los valores dentro del mismo arreglo
            for (int i = 0; i < 10; i++) {
                if (arrayCadena[i].equals("0")) {
                    arrayCadena[i] = "S";
                } else if (arrayCadena[i].equals("1")) {
                    arrayCadena[i] = "U";
                } else if (arrayCadena[i].equals("2")) {
                    arrayCadena[i] = "T";
                } else if (arrayCadena[i].equals("3")) {
                    arrayCadena[i] = "P";
                } else if (arrayCadena[i].equals("4")) {
                    arrayCadena[i] = "A";
                } else if (arrayCadena[i].equals("5")) {
                    arrayCadena[i] = "G";
                } else if (arrayCadena[i].equals("6")) {
                    arrayCadena[i] = "M";
                } else if (arrayCadena[i].equals("7")) {
                    arrayCadena[i] = "E";
                } else if (arrayCadena[i].equals("8")) {
                    arrayCadena[i] = "L";
                } else if (arrayCadena[i].equals("9")) {
                    arrayCadena[i] = "C";
                } else {// si existe un valor no válido se genera una excepción
                    salida = "El parámetro debe ser numérico";
                    break;
                }
                salida = salida + arrayCadena[i];
            }
            System.out.println(salida);// se imprime la salida
        } else {
            System.out.println("La longitud del parámetro debe ser igual a 10");
        }

    }

}
