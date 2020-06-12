package rescatandoALaPrincesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rescate {
	private MatrizAdyacencia matriz;
	private int cantClaros;
	private int cantSenderos;
	private int cantDragones;
	private String path;

	public Rescate(String path) {
		this.path = path;
	}

	public void cargarDatos() {
		try {
			Scanner sc = new Scanner(new File(this.path+".in"));
			this.cantClaros = sc.nextInt();
			this.cantSenderos = sc.nextInt();
			this.cantDragones = sc.nextInt();
			matriz = new MatrizAdyacencia(this.cantClaros);
			matriz.agregarPeso(sc.nextInt(), sc.nextInt(), 50);
			matriz.agregarPeso(sc.nextInt(), sc.nextInt(), 60);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
