package rescatandoALaPrincesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
	private PriorityQueue<Nodo> vs;
	private Grafo grafo;
	private Map<Integer,Nodo> s = new HashMap<Integer,Nodo>();
	private List<Integer> precesores = new ArrayList<Integer>();
	private String path;
	
	public Dijkstra(String path) {
		this.path = path;
		grafo = new Grafo(path);
	}
	
	public void resolucion() {
		int costoNuevo;
		Nodo w;
		vs = new PriorityQueue<Nodo>();
		Nodo nodoInicial = new Nodo(grafo.getClaroPrincesa(), 0);
		nodoInicial.setPredecesor(grafo.getClaroPrincesa());
		vs.add(nodoInicial);
		for (int i = 0; i < grafo.getCantClaros(); i++) {
			if (i != nodoInicial.getNumNodo())
				vs.add(new Nodo(i, 999));
		}
//		System.out.println("Primera->" + vs);
		while (!vs.isEmpty()) {
//			System.out.println("-------------");
			w = vs.peek();
			s.put(w.getNumNodo(), w);
			for (Nodo nv : vs) {
				costoNuevo = (w.getCosto() + grafo.getMatriz().getPeso(w.getNumNodo(), nv.getNumNodo()));
				if (!s.containsKey(nv.getNumNodo()) && nv.getCosto() > costoNuevo) {
					nv.setCosto(w.getCosto() + grafo.getMatriz().getPeso(w.getNumNodo(), nv.getNumNodo()));
					nv.setPredecesor(w.getNumNodo());
				}
			}
			vs.poll();
//			System.out.println(vs);
		}
		guardarPrecesores();
		guardarResultado();
		//System.out.println(precesores);
	}
	
	
	private int isCaminoPosible() {
		for(int p:precesores) {
			if(grafo.isDragon(p))
				return -1;
		}
		if(precesores.size() == 1)
			return -2;
		return 0;
	}
	
	private void guardarResultado() {
		try {
			int posible;
			String estado=" ";
			PrintWriter pw = new PrintWriter(new File(path+".out"));
			posible = isCaminoPosible();
			if(posible == -1)
				estado = "Interceptado";
			else if(posible == -2)
				estado = "No hay camino posible";
			if(posible == -1 || posible == -2) {
				pw.print(estado);
			}else {
				for(Integer p:precesores)
					pw.print(p+" ");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void guardarPrecesores() {
		int nodoInicio = 0, prece;
		while(s.containsKey(nodoInicio) == true) {
			precesores.add(s.get(nodoInicio).getNumNodo()+1);
			prece = s.get(nodoInicio).getPredecesor();
			s.remove(nodoInicio);
			nodoInicio = prece;
		}
			
	}
	
	@Override
	public String toString() {
		return "Dijkstra [vs=" + vs + ", s=" + s + "]";
	}
	
}