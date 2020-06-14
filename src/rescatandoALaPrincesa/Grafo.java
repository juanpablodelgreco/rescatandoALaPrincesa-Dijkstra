package rescatandoALaPrincesa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
		private Integer[][] matriz;
		private Integer[] predecesores;
		private int nodoInicial;
		
		public Grafo(List<Arista> aristas, int cantidadNodos) {
			for(Arista a:aristas) {
				matriz[a.getDesde()][a.getHasta()] = a.getPeso();
				matriz[a.getHasta()][a.getDesde()] = a.getPeso();
			}	
		}
		
		public Integer[] dijkstra(int nodoInicial) {
			int nodoActual, distanciaAristaActual;
			Integer proximoNodo;
			Integer[] distancias = new Integer[matriz.length];
			this.nodoInicial = nodoInicial;
			predecesores = new Integer[matriz.length];
			distancias[nodoInicial] = 0;

			Set<Integer> noVisitados = new HashSet<Integer>();
			for (int i = 0; i < matriz.length; i++) {
				if (i != nodoInicial)
					noVisitados.add(i);
			}

			nodoActual = this.nodoInicial;
			while (!noVisitados.isEmpty()) {
				for (Integer adyacente : getAdyacentes(nodoActual)) {
					distanciaAristaActual = matriz[nodoActual][adyacente] + distancias[nodoActual];
					if(distancias[adyacente] == null || distancias[adyacente] > distanciaAristaActual) {
						distancias[adyacente] = distanciaAristaActual;
						predecesores[adyacente] = nodoActual;
					}
				}
				noVisitados.remove(nodoActual);
				proximoNodo = null;
				for(Integer noVisitado:noVisitados) {
					if(proximoNodo == null || distancias[proximoNodo] == null || distancias[noVisitado] != null && distancias[proximoNodo] > distancias[noVisitado])
						proximoNodo = noVisitado;
				}
				if(proximoNodo == null)
					return distancias;
				nodoActual = proximoNodo;
			}
			return distancias;
		}
		
		private List<Integer> getAdyacentes(int nodoActual) {
			List<Integer> adyacentes = new ArrayList<Integer>();
			for (int i = 0; i < matriz.length; i++) {
				if (matriz[nodoActual][i] != null)
					adyacentes.add(i);
			}
			return adyacentes;
		}
}
