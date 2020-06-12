package rescatandoALaPrincesa;

import java.util.PriorityQueue;

public class Dijkstra {
	private PriorityQueue<Nodo> colaPrioridad;
	private Grafo grafo;
	private boolean[] visitados;
	
	public Dijkstra(Grafo grafo) {
		this.grafo = grafo;
		this.visitados = new boolean[grafo.getCantClaros()];
	}
	
	public void resolucion() {
		colaPrioridad = new PriorityQueue<Nodo>();
		Nodo nodoInicial = new Nodo(grafo.getClaroPrincesa(), 0);
		colaPrioridad.add(nodoInicial);
		while(!colaPrioridad.isEmpty()) {
			colaPrioridad.poll();
		}
	}
	
}