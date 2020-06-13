package rescatandoALaPrincesa;

import java.util.PriorityQueue;

public class Dijkstra {
	private PriorityQueue<Nodo> colaPrioridad;
	private Grafo grafo;
	private boolean[] visitados;
	
	public Dijkstra(String path) {
		grafo = new Grafo(path);
		this.visitados = new boolean[grafo.getCantClaros()];
	}
	
	public void resolucion() {
		Nodo n;
		colaPrioridad = new PriorityQueue<Nodo>();
		Nodo nodoInicial = new Nodo(grafo.getClaroPrincesa(), 0);
		colaPrioridad.add(nodoInicial);
		for(int i = 0 ; i<grafo.getCantClaros(); i++) {
			if(i != nodoInicial.getNumNodo())
				colaPrioridad.add(new Nodo(i, 999));
		}
		while(!colaPrioridad.isEmpty()) {
			n = colaPrioridad.poll();
		this.visitados[n.getNumNodo()] = true;
		for(int j=0; j<grafo.getCantClaros(); j++) {
			if(grafo.getMatriz()[n.getNumNodo()][j])
		}
	}
}

	@Override
	public String toString() {
		return "Dijkstra [colaPrioridad=" + colaPrioridad + "]";
	}
}