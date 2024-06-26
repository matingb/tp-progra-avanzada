package main.Grafos;

import java.util.ArrayList;
import java.util.Collections;

public class ColoreoWelshPowell extends ColoreoOrdenDeterminado {

	public static int[] colorear(int[][] m) {
		
		ArrayList<Integer> listaNodosOrdenDescendente = ordenoPorGradoDescendente(m); // Llama al metodo que ordena los nodos segun su grado de forma descendente
		
		return ColoreoSecuencial.colorear(m, listaNodosOrdenDescendente); // Utiliza la funcion de coloreo con el ordenamiento obtenido
	}
	
	private static ArrayList<Integer> ordenoPorGradoDescendente (int[][] m){
		
		ArrayList <Integer> listaGradosNodos = calcularGradoNodos(m);
		
		// Lista que a su vez contendra 1 lista para cada grado
		ArrayList<ArrayList<Integer>> listaDeListasPorGrado = new ArrayList<>();
		
		// Asignar a cada lista los nodos correspondientes
		int maximo = Collections.max(listaGradosNodos);
		for (int gradoNodo : listaGradosNodos) {
			if (listaGradosNodos.contains(maximo)) {
				ArrayList<Integer> listaGradoMaxActual = new ArrayList <>(); // Lista que contra los nodos con el mismo grado
				for (int gradoActual = 0; gradoActual < listaGradosNodos.size(); gradoActual++) {
					if (listaGradosNodos.get(gradoActual) == maximo) {
						listaGradoMaxActual.add(gradoActual); // Agrego a la lista el nodo que tiene el grado maximo
					}
				}
				listaDeListasPorGrado.add(listaGradoMaxActual); // Agrego la nueva lista a la lista que contiene a todas las listas
			}
			maximo--; // Reduzco el grado maximo
		}
		
		return obtenerListadoFinalNodos(listaDeListasPorGrado, m.length);
	}
	
}
