/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Prueba4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Se instancian los objetos Scanner
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        // Se leen los valores de entrada, se verifican si son correctos y se hace el llamado al método escribirMes
        //  para generar la salida
        System.out.println("Ingrese el número del mes: ");
        int mes = sc1.nextInt();
        if (mes <= 12 && mes >= 1) {
            System.out.println("Ingrese la inicial del día de la semana: L-M-X-J-V-S-D");
            String diaSemana = sc2.nextLine();
            diaSemana = diaSemana.toUpperCase();// se dejan las letras en mayúsculas
            if (diaSemana.equals("L") || diaSemana.equals("M") || diaSemana.equals("X") || diaSemana.equals("J") || diaSemana.equals("V") || diaSemana.equals("S") || diaSemana.equals("D")) {
                escribirMes(mes, diaSemana);
            } else {
                System.out.println("Valor no válido: ");
            }
        }
        else{
            System.out.println("Valor no válido: ");
        }

    }
//El método escribirMes recibe los valores y empieza a concatenar el día del més con el dia de la 
    //semana correspondiente y finalmente el resultado se guarda en un archivo .txt
    public static void escribirMes(int mes, String diaSemana) {
        FileWriter archivo = null;// atributo que genera el archivo
        PrintWriter escribe = null;// atributo que escriba la salida en el archivo
        String ruta="";//ruta de almacenamiento del archivo
        String calendario = "";
        // se defina el número de días de cada mes y se guarda en un atributo
        int diaMesMax = 31;
        if (mes == 2) {
            diaMesMax = 29;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            diaMesMax = 30;
        }
        // se guarda las iniciales de los días de la semana en un arregle de 7 posiciones
        String[] semana = new String[7];
        semana[0] = "L";
        semana[1] = "M";
        semana[2] = "X";
        semana[3] = "J";
        semana[4] = "V";
        semana[5] = "S";
        semana[6] = "D";

        //Se compara el valor del día de la semana y se compara con cada uno de los valores del arreglo
        // cuando sea igual se guarda este valor en el atributo diaInicio
        int diaInicio = 0;
        for (int i = 0; i <= semana.length; i++) {
            if (semana[i].equals(diaSemana)) {
                diaInicio = i;
                break;
            }
        }
        //Se crea un atributo llamado día actual con el índice de la posición del arreglo que inicia desde el valor 
        //  guardado en diaInicio, luego se establece un for donde se van concatenando los días del mes a los días de la semana
        //  y donde el valor de diaActual se reinicia cuendo sea igual a 7 el refultado final queda guardado en el atributo
        //  calendario
        int diaActual = diaInicio;
        for (int i = 1; i <= diaMesMax; i++) {
            if (diaActual == 7) {
                diaActual = 0;
            }
            calendario = calendario + i + semana[diaActual];
            //System.out.println( i+semana[diaActual]);
            diaActual++;
        }
        // Se escribe el archivo con el valor contenido en el atributo calendario
        try {
            ruta = "c:/mes" + mes + ".txt";//se define la ruta del archivo
            archivo = new FileWriter(ruta);// se genera el archivo
            // Se escribe la información de calendario en el archivo
            escribe = new PrintWriter(archivo);
            escribe.println(calendario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        System.out.println("se ha guardado el archivo "+ruta);
        }
    }

}
