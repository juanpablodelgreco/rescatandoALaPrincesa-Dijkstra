package rescatandoALaPrincesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

	
	public Grafo(String path) {
		this.path = path;
		posDragones = new ArrayList<Integer> ();
		cargarDatos();
	}
	
	public void cargarDatos() {
		try {
			Scanner sc = new Scanner(new File("lote_de_pruebas/Input/"+this.path+".in"));
			int arista1, arista2, costo;

			this.cantClaros = sc.nextInt();
			this.cantSenderos = sc.nextInt();
			this.cantDragones = sc.nextInt();
			matriz = new MatrizAdyacencia(this.cantClaros);
			this.claroPrincesa = sc.nextInt()-1;
			this.claroPrincipe = sc.nextInt()-1;
			for(int i=0; i<this.cantDragones; i++) 
				posDragones.add(sc.nextInt());
			for(int j = 0; j<this.cantSenderos; j++) {
				arista1 = sc.nextInt()-1;
				arista2 = sc.nextInt()-1;
				costo = sc.nextInt();
					matriz.agregarPeso(arista1, arista2, costo);
					matriz.agregarPeso(arista2, arista1, costo);		
			}
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}
		
	}
	
	public MatrizAdyacencia getMatriz() {
		return matriz;
	}

	
	public boolean isDragon(int i) {
		for(Integer pd:posDragones)
				if(pd == i)
					return true;
		return false;
	}
	
	public int getCantClaros() {
		return cantClaros;
	}

	public int getClaroPrincesa() {
		return claroPrincesa;
	}

	public int getClaroPrincipe() {
		return claroPrincipe;
	}	
	
	
}
