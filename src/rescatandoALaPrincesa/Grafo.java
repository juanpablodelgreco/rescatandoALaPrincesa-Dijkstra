package rescatandoALaPrincesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Grafo {
	private String path;
	private MatrizAdyacencia matriz;
	private int cantClaros;
	private int cantSenderos;
	private int cantDragones;
	private int claroPrincipe;
	private int claroPrincesa;
	private List <Integer>posDragones;
	private List <Integer> noSolucion;
	
	public Grafo(String path) {
		this.path = path;
		noSolucion = new ArrayList<Integer>();
		posDragones = new ArrayList<Integer> ();
	}
	
	public void cargarDatos() {
		try {
			Scanner sc = new Scanner(new File(this.path+".in"));
			int arista1, arista2;
			this.cantClaros = sc.nextInt();
			this.cantSenderos = sc.nextInt();
			this.cantDragones = sc.nextInt();
			matriz = new MatrizAdyacencia(this.cantClaros);
			this.claroPrincesa = sc.nextInt();
			this.claroPrincipe = sc.nextInt();
			for(int i=0; i<this.cantDragones; i++) 
				posDragones.add(sc.nextInt());
			for(int j = 0; j<this.cantSenderos; j++) {
				arista1 = sc.nextInt()-1;
				arista2 = sc.nextInt()-1;
					matriz.agregarPeso(arista1, arista2, sc.nextInt());
					matriz.agregarPeso(arista2, arista1, sc.nextInt());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public MatrizAdyacencia getMatriz() {
		return matriz;
	}

	public int getCantClaros() {
		return cantClaros;
	}

	public int getClaroPrincesa() {
		return claroPrincesa;
	}

	public Map<Integer, Integer> getDragones() {
		return dragones;
	}
	
	
}
