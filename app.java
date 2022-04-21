import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class app {
    /**
     * Funcion main encargada de manejar las interacciones
     * 
     * @param args sin parametros adicionales
     */
    public static void main(String[] args) {

        boolean salir = false;
        int opcion;
        System.out.println("\n=================================\nBienvenido!");
        while (!salir) {
            System.out.println("\nOpciones\n-----------------------\n1 - Generar nuevo archivo\n"
                    + "2 - Leer archivo\n3 - Ordenar archivo\n4 - Buscar numero en archivo\n5 - Salir");
            Scanner sn = new Scanner(System.in);
            try {
                System.out.print("Seleccionar una opcion: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        Scanner sn2 = new Scanner(System.in);
                        System.out.print("-----\nCuantos numeros desea generar?: ");
                        Integer cantidad = sn2.nextInt();

                        ArrayList<Integer> listaNumeros = Funciones.crearListaRandom(cantidad);

                        Scanner snAux = new Scanner(System.in);
                        System.out.print("Nombre del archivo a guardar (valor por defecto 'listaRandom.txt'): ");
                        String nombreArchivo = snAux.nextLine() + ".txt";
                        if (nombreArchivo.equals(".txt")) {nombreArchivo = "listaRandom.txt";}

                        Utiles.crearArchivo(listaNumeros, nombreArchivo);
                        System.out.println("\nEl archivo se guardo como '" + nombreArchivo + "'\n-----");

                        break;
                    case 2:
                        Scanner sn3 = new Scanner(System.in);
                        System.out.print("Nombre del archivo: ");
                        String archivoObjetivo = sn3.nextLine();

                        System.out.println("\n-----");
                        Utiles.mostrarArchivo(archivoObjetivo);
                        System.out.println("-----");

                        break;
                    case 3:
                        Scanner sn4 = new Scanner(System.in);
                        System.out.print("Nombre del archivo a ordenar: ");
                        String archivoLista = sn4.nextLine();

                        ArrayList<Integer> listaArchivo = Utiles.leerArchivo(archivoLista);
                        ArrayList<Integer> listaOrdenada = Funciones.bubblesort(listaArchivo);
                        //ArrayList<Integer> listaOrdenada = Funciones.quickSortArray(listaArchivo);
                        Utiles.crearArchivo(listaOrdenada, "[ORDENADO]" + archivoLista);
                        System.out.println("\nEl archivo se guardo como '" + "[ORDENADO]" + archivoLista + "'\n-----");

                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }

    }
}