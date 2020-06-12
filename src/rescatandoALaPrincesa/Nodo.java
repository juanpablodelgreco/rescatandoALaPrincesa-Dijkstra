package rescatandoALaPrincesa;

public class Nodo implements Comparable <Nodo>{
	private int id;
	private int costo;
	private boolean visitado;
	private int previo;
	private boolean hayDragon;
	
	public Nodo(int id, int costo) {
		this.id = id;
		this.costo = costo;
	}

	public int getCosto() {
		return costo;
	}

	public boolean isHayDragon() {
		return hayDragon;
	}

	@Override
	public int compareTo(Nodo n2) {
		return Integer.compare(this.costo, n2.costo);
	}
	
}
