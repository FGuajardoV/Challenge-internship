import java.util.ArrayList;

public class Funciones {
    /**
     * Metodo que permite crear la lista de numeros aleatorios
     * 
     * @param cantidad recibe la cantidad de numeros a crear.
     * @return lista de numeros aleatorios.
     */
    public static ArrayList<Integer> crearListaRandom(Integer cantidad) {
        ArrayList<Integer> lista;
        lista = new ArrayList<>();
        for (Integer i = 1; i <= cantidad; i++) {
            Integer getRandomValue = (int) (Math.random() * (10000 - 1)) + 1;
            lista.add(getRandomValue);
        }

        return lista;
    }

    /**
     * Metodo que permite ordenar la lista de numeros
     * 
     * @param lista lista de numeros sin orden.
     * @return lista de numeros ordenada.
     */
    public static ArrayList<Integer> bubblesort(ArrayList<Integer> lista) {
        boolean orden = false;
        Integer temp;

        int[] auxLista = new int[lista.size()];
        ArrayList<Integer> listaFinal = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            auxLista[i] = lista.get(i);
        }

        while (!orden) {
            orden = true;
            for (int i = 0; i < lista.size() - 1; i++) {
                if (auxLista[i] > auxLista[i + 1]) {
                    temp = auxLista[i];
                    auxLista[i] = auxLista[i + 1];
                    auxLista[i + 1] = temp;
                    orden = false;
                }
            }
        }

        for (int i = 0; i < lista.size(); i++) {
            listaFinal.add(auxLista[i]);
        }

        return listaFinal;
    }

    /*
     * Codigo de quicksort java rescatado de
     * https://www.geeksforgeeks.org/quick-sort/
     */

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     */
    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*
     * The main function that implements QuickSort
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     */
    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Metodo que permite ordenar la lista de numeros
     * 
     * @param lista lista de numeros sin orden.
     * @return lista de numeros ordenada.
     */
    public static ArrayList<Integer> quickSortArray(ArrayList<Integer> lista) {

        int[] auxLista = new int[lista.size()];
        ArrayList<Integer> listaFinal = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            auxLista[i] = lista.get(i);
        }

        int n = auxLista.length;

        quickSort(auxLista, 0, n - 1);

        for (int i = 0; i < lista.size(); i++) {
            listaFinal.add(auxLista[i]);
        }

        return listaFinal;
    }
}
