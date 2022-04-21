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
            Integer getRandomValue = (int) (Math.random() * (100 - 1)) + 1;
            lista.add(getRandomValue);
        }

        return lista;
    }

    public static ArrayList<Integer> bubblesort(ArrayList<Integer> lista) {
        boolean orden = false;
        Integer temp;
        int[] auxLista = new int[lista.size()];
        for (int j = 0; j < lista.size() - 1; j++) {
            auxLista[j] = lista.get(j);
        }
        while (!orden) {
            orden = true;
            for (int i = 0; i < lista.size() - 1; i++) {
                if (lista.get(i) > lista.get(i+1)) {
                    temp = lista.get(i); 
                }
            }
        }

        return lista;
    }
}
