package rescatandoALaPrincesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RescatePrincesa {
	private String path;
	private int cantNodos;
	private int cantAristas;
	private int cantDragones;
	private int posicionPrincesa;
	private int posicionPrincipe;
	private List<Integer> posicionDragones;
	private List<Arista> aristas;
	private Grafo grafo;
	
	public RescatePrincesa(String path) {
		this.path = path;
		posicionDragones = new ArrayList<Integer>();
		aristas = new ArrayList<Arista>();
		cargarDatos();
		grafo = new Grafo(aristas, this.cantNodos);
		solucion();
		System.out.println("Arhivo de salida generado con exito!");
	}
	
	public void solucion() {
		Integer[] largoCamino = grafo.dijkstra(this.posicionPrincesa);
		String respuesta = "";
		boolean interceptado = false;
		Integer largoPrincipe = largoCamino[this.posicionPrincipe];
		if (largoPrincipe == null)
			respuesta = "No hay camino";
		else {
			for (int posicionDragon : posicionDragones) {
				if (largoCamino[posicionDragon] != null && largoCamino[posicionDragon] <= largoPrincipe) {
					respuesta = "Interceptado";
					interceptado = true;
					break;
				}
			}
			if (!interceptado) {
				List<Integer> camino = grafo.getCamino(posicionPrincipe);
				for (int j = 0; j < camino.size() - 1; j++)
					respuesta += (camino.get(j) + 1) + " ";
				respuesta += camino.get(camino.size() - 1) + 1;
			}
		}
		grabarResultados(respuesta);
	}
	
	private void cargarDatos() {
		try {
			Scanner sc = new Scanner(new File(this.path+".in"));
			int i;
			Arista a;
			this.cantNodos = sc.nextInt();
			this.cantAristas = sc.nextInt();
			this.cantDragones = sc.nextInt();
			this.posicionPrincesa = (sc.nextInt()-1);
			this.posicionPrincipe = (sc.nextInt()-1);
			for(i=0; i<this.cantDragones; i++)
				posicionDragones.add(sc.nextInt()-1);
			for(i=0; i<this.cantAristas; i++) {
				a = new Arista(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void grabarResultados(String respuesta) {
		try {
			PrintWriter pw = new PrintWriter(new File(this.path+".out"));
			pw.println(respuesta);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
