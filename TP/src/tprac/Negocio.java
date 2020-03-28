package tprac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Negocio {
	private static Integer claveNumero = 1;
	private static ArrayList<Integer> solucionFila;
	private static ArrayList<Integer> solucionColumna;
	private static ArrayList<Integer> solucionComposicion;
	private static Map<Integer, ArrayList<Integer>> grupoSoluciones;

	//busca todas las composiciones con cuatro numeros de un numero dado
	public static void buscarComposicion(int arreglo[], int numeroComponer, int cantidadDigitos) {
		int numero = numeroComponer;
		if (numeroComponer == 0 && cantidadDigitos == 4) {
			almacenarComposicionCuatroDigitos(arreglo, cantidadDigitos);
		} else if (numeroComponer > 0) {
			for (int i = 1; i <= numero; i++) {
				arreglo[cantidadDigitos] = i;
				buscarComposicion(arreglo, numeroComponer - i, cantidadDigitos + 1);
			}
		}
	}

	//genera un map con todas las composiciones de un numero dado
	public static void almacenarComposicionCuatroDigitos(int arreglo[], int composicion) {
		solucionComposicion = new ArrayList<Integer>();
		for (int i = 0; i < composicion; i++) {
			solucionComposicion.add(arreglo[i]);
		}
		grupoSoluciones.put(claveNumero++, solucionComposicion);
	}

	//genera las soluciones de las filas y las columnas a las que debe llegar el usuario
	public static ArrayList<ArrayList<Integer>> generarSolucionesFilasYColumnas() {
		claveNumero = 0;
		grupoSoluciones = new HashMap<Integer, ArrayList<Integer>>();
		
		Random numeroRandom = new Random();
		Random numeroComposicionRandom1 = new Random();
		Random numeroComposicionRandom2 = new Random();

		int numeroComponer = numeroRandom.nextInt((24 - 16) + 1) + 16;

		buscarComposicion(new int[100], numeroComponer, 0);

		int composicion1 = numeroComposicionRandom1.nextInt((grupoSoluciones.size() - 1) + 1) + 1;
		int composicion2 = numeroComposicionRandom2.nextInt((grupoSoluciones.size() - 1) + 1) + 1;

		ArrayList<ArrayList<Integer>> grupoComposiciones = new ArrayList<ArrayList<Integer>>();
		
		grupoComposiciones.add(grupoSoluciones.get(composicion1));
		solucionFila = grupoComposiciones.get(0);
		grupoComposiciones.add(grupoSoluciones.get(composicion2));
		solucionColumna = grupoComposiciones.get(1);
		return grupoComposiciones;
	}

	//suma los numeros de un arraylist y compara si el resultado es igual a la solucion de la fila/columna  i, segun corresponda
	public static boolean sumarNumerosGrupo(ArrayList<Integer> numsInputUsr, Integer numFilaColumna, String direccion) {
		int suma = 0;
		Integer numSolucion = 0;
		boolean sumaIgualSolucion = true;

		if (numsInputUsr.size() == 4) {
			if (direccion.equals("f")) {
				numSolucion = solucionFila.get(numFilaColumna - 1);
			} else if (direccion.equals("c")) {
				numSolucion = solucionColumna.get(numFilaColumna - 1);
			}
			for (int i = 0; i < numsInputUsr.size(); i++) {
				suma += numsInputUsr.get(i);
				sumaIgualSolucion |= true;
				if (suma != numSolucion) {
					sumaIgualSolucion &= false;
				}
			}
		} else {
			sumaIgualSolucion &= false;
		}
		return sumaIgualSolucion;
	}
}
