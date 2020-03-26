package tprac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Negocio {
	private static Integer pos = 1;
	private static ArrayList<Integer> solucionFila;
	private static ArrayList<Integer> solucionColumna;
	private static ArrayList<Integer> solucionComposicion;
	private static Map<Integer, ArrayList<Integer>> mapSoluciones;

	// Function prints all combinations of numbers 1, 2, ...MAX_POINT
	// that sum up to n.
	// i is used in recursion keep track of index in arr[] where next
	// element is to be added. Initital value of i must be passed as 0.
	
	//busca todas las composiciones con cuatro numeros de un numero dado
	public static void buscarComposicion(int arr[], int n, int cantidadDigs) {
		int numero = n;
		if (n == 0 && cantidadDigs == 4) {
			almacenarComposicionCuatroDigitos(arr, cantidadDigs);
		} else if (n > 0) {
			for (int k = 1; k <= numero; k++) {
				arr[cantidadDigs] = k;
				// System.out.println("k= "+ k + " "+ arr[i]);
				buscarComposicion(arr, n - k, cantidadDigs + 1);
			}
		}
	}

	//genera un map con todas las composiciones de un numero dado
	public static void almacenarComposicionCuatroDigitos(int arr[], int m) {
		solucionComposicion = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			solucionComposicion.add(arr[i]);
		}
		mapSoluciones.put(pos++, solucionComposicion);
	}

	//genera las soluciones de las filas y las columnas a las que debe llegar el usuario
	public static ArrayList<ArrayList<Integer>> generarSoluciones() {
		pos = 0;
		mapSoluciones = new HashMap<Integer, ArrayList<Integer>>();
		
		Random Nrandom = new Random();
		Random Crandom1 = new Random();
		Random Crandom2 = new Random();

		int numRandom = Nrandom.nextInt((24 - 16) + 1) + 16;

		buscarComposicion(new int[100], numRandom, 0);

		int cr1 = Crandom1.nextInt((mapSoluciones.size() - 1) + 1) + 1;
		int cr2 = Crandom2.nextInt((mapSoluciones.size() - 1) + 1) + 1;

		ArrayList<ArrayList<Integer>> soluciones = new ArrayList<ArrayList<Integer>>();
		
		soluciones.add(mapSoluciones.get(cr1));
		solucionFila = soluciones.get(0);
		soluciones.add(mapSoluciones.get(cr2));
		solucionColumna = soluciones.get(1);
		return soluciones;
	}

	//suma los numeros de un arraylist y compara si el resultado es igual a la solucion de la fila/columna  i, segun corresponda
	public static boolean sumar(ArrayList<Integer> numsInputUsr, Integer i, String dir) {
		int suma = 0;
		boolean bool = true;
		Integer numSolucion = 0;

		if (numsInputUsr.size() == 4) {
			if (dir.equals("f")) {
				numSolucion = solucionFila.get(i - 1);
			} else if (dir.equals("c")) {
				numSolucion = solucionColumna.get(i - 1);
			}
			for (int j = 0; j < numsInputUsr.size(); j++) {
				suma += numsInputUsr.get(j);
				bool |= true;
				if (suma != numSolucion) {
					bool &= false;
				}
			}
		} else {
			bool &= false;
		}
		return bool;
	}
}
