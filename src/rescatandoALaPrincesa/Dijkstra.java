package rescatandoALaPrincesa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
	private PriorityQueue<Nodo> vs;
	private Grafo grafo;
	private Map<Integer,Nodo> s = new HashMap<Integer,Nodo>();
	
	public Dijkstra(String path) {
		grafo = new Grafo(path);
	}
	
	public void resolucion() {
		Nodo w;
		vs = new PriorityQueue<Nodo>();
		Nodo nodoInicial = new Nodo(grafo.getClaroPrincesa(), 0);
		vs.add(nodoInicial);
		for(int i = 0 ; i<grafo.getCantClaros(); i++) {
			if(i != nodoInicial.getNumNodo())
				vs.add(new Nodo(i, 999));
		}
		
		while (!vs.isEmpty()) {
			w = vs.poll();
			s.put(w.getNumNodo(), w);
			for (Nodo nv : vs) {
				if (!s.containsKey(nv.getNumNodo()) && nv.getCosto() > (w.getCosto() + grafo.getMatriz().getPeso(w.getNumNodo(),  nv.getNumNodo()))) {
					nv.setCosto(w.getCosto() + grafo.getMatriz().getPeso(w.getNumNodo(), nv.getNumNodo()));
					nv.setPredecesor(w.getNumNodo());
				}
				System.out.println(vs.size());
			
			}
		}
}

	@Override
	public String toString() {
		return s+" ";
	}
	
}