import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase Utiles, la cual posee metodos static para su uso libre en la clase App
 * 
 * @author franciscog
 */

public class Utiles {
    /**
     * Metodo que permite crear el archivo que almacenara la lista de numeros
     * 
     * @param lista         Recibe el arreglo de numeros
     * @param nombreArchivo Recibe el nombre del archivo con el cual se desea
     *                      guardar
     */
    public static void crearArchivo(ArrayList<Integer> lista, String nombreArchivo) {

        FileWriter fichero = null;
        PrintWriter pw;

        // El tryCatch es para prevenir algun error al momento de crear el archivo
        try {
            fichero = new FileWriter(nombreArchivo);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < lista.size(); i++) {
                Integer numero = lista.get(i);
                pw.println(numero);
            }

        } catch (Exception e) {
            System.out.println("Error al crear archivo de salida");

        } finally {
            try {
                // para asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar fichero");
            }
        }
    }

    /**
     * Metodo que permite, a partir de un archivo, cargar la lista de numeros
     * 
     * @param inFile String de entrada que posee el archivo a analizar.
     * @return Nos devolvera el ArrayList con la lista de numeros
     */
    public static ArrayList<Integer> leerArchivo(String inFile) {
        ArrayList<Integer> nuevaLista;
        nuevaLista = new ArrayList<>();
        File file = new File(inFile);

        FileReader fileR;
        BufferedReader file2 = null;

        // el tryCatch utilizado es para verificar que existe el archivo en el
        // directorio del programa
        try {
            fileR = new FileReader(file);
            file2 = new BufferedReader(fileR);

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo " + file.getName());
        }

        // este segmento es para prevenir el error NullPointerException
        try {
            String linea;
            while ((linea = file2.readLine()) != null) {
                nuevaLista.add(Integer.parseInt(linea));
            }
            file2.close();
        } catch (IOException e) {
            System.out.println("error");
        }

        return nuevaLista;
    }

    /**
     * Funcion que muestra archivo en consola
     * 
     * @param nombreArchivo nombre del archivo a mostrar
     */
    public static void mostrarArchivo(String nombreArchivo) {

        try {

            File archivo = new File(nombreArchivo);
            Scanner linea = new Scanner(archivo);
            while (linea.hasNextLine()) {
                String numero = linea.nextLine();
                System.out.println(numero);
            }
            linea.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo, asegurese que se encuentre en la misma ruta del programa");
        }
    }

    public static int buscarEnArchivo(String nombreArchivo, String elemento) {

        int posicion = -1;
        int pos = 0;

        try {

            File archivo = new File(nombreArchivo);
            Scanner linea = new Scanner(archivo);
            while (linea.hasNextLine()) {
                pos++;
                String auxlin = linea.nextLine();
                if (auxlin.equals(elemento)) {
                    posicion = pos;
                    break;
                }
            }
            linea.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo, asegurese que se encuentre en la misma ruta del programa");
        }
        return posicion;
    }
}