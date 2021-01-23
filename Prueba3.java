/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Administrador
 */
public class Prueba3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Se crea el atributo cadenaUrl con el valor de la url del mètodo createPayload
        String cadenaUrl = "https://securetransfer.redsis.com/rest/forms/v1/teamGoAny/payload";
        // Se crea el atributo createPayload que hace el llamado al mètodo conexionRest quien realiza la peticiòn 
        //      al mètodo createPayload de la api REST pasando como parametros la url, el tipo de peticion
        //      y almacena la respuesta.
        String createPayload = conexionRest(cadenaUrl, "GET","");
        System.out.println("createPayload " + createPayload);
        //Se crea el atributo nombreApellido que establece el formato para enviar los paràmetros 
        //      nombre y apellido al mètodo submitPayload  
        String nombreApellido = "{ \"nombre\" : \"ingresoRedsis\", \"apellido\" : \"Qwerty0909$\"}";
        //Se crea el arreglo partirCreatePayload que parte el atributo createPayload y guarda las 
        //      partes en una casilla del arreglo   
        String[] partirCreatePayload = createPayload.split(",\"submitFormLink\":");
        // se almacena en cadenaUrl el enlace para hacer el llamado al mètodo submitPayload, depurando 
        //      los caracteres " y }
        cadenaUrl = partirCreatePayload[1].replaceAll("[\"}]", "");
        // Se crea el atributo submitPayload que hace el llamado al mètodo conexionRest quien realiza la peticiòn 
        //      al mètodo submitPayload de la api REST pasando como parametros la url, el tipo de peticion
        //      y la cadena con el JSON de los paràmetros nombre y apellido y almacena la respuesta.
        String submitPayload = conexionRest(cadenaUrl, "POST", nombreApellido);
        System.out.println("submitPayload: "+submitPayload);
    }

    //El mtodo conexionRest es quien hace las peticiones a la api Rest y de acuerdo al tipo de 
    //  petición y a los paràmetros enviados retorna una respuesta en un String o genera una excepciòn 
    public static String conexionRest(String cadenaUrl, String peticion, String jsonParametros) {
        try {
            //Se define el objeto URL que trael la url de la peticiòn
            URL url = new URL(cadenaUrl);//URL
            // Se establece la conexion con la api
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            // Se establece el header con el formato
            conexion.setRequestProperty("Accept", "application/json");
            // Se indica el tipo de peticiòn
            conexion.setRequestMethod(peticion);
            // Si la petición es de tipo POST se hace el llamado al mètodo setDoOutput(true),
            // luego se envía el atributo jsonParametros con los parámetros de petición al método en tipo byte
            if (peticion.equals("POST")){
                conexion.setDoOutput(true);
	        //conexion.setDoInput(true);
                OutputStream enviaJson = conexion.getOutputStream();
                enviaJson.write(jsonParametros.getBytes("UTF-8"));
                enviaJson.close();
            }
			// Si hay un error genera la excepción
            if (conexion.getResponseCode() != 200) {
                throw new RuntimeException("HTTP Error código : " + conexion.getResponseCode());
            }
            //Se obtiene una respuesta y se almacena temporalmente en la variable aux  y el resultado final se
            //concatena en el atributo resultado 
            InputStreamReader recibe = new InputStreamReader(conexion.getInputStream());
            BufferedReader lee = new BufferedReader(recibe);
            StringBuffer resultado = new StringBuffer();
            String aux;
            while ((aux = lee.readLine()) != null) {
                resultado.append(aux);
            }
            //Se guarda la respuesta del resultado en un string llamado salida que retoena la respuesta al método main
            String salida=resultado.toString();
            conexion.disconnect();
            return salida;
        } catch (Exception e) {//Ratorna la excepción si ocurre un error
            System.out.println("Excepción en: " + e);
            return "";
        }

    }

}
