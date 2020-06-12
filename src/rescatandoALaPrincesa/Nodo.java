package rescatandoALaPrincesa;

public class Nodo {
	private int costo;
	private boolean hayDragon;
	
	public Nodo(int costo, boolean hayDragon) {
		this.costo = costo;
		this.hayDragon = hayDragon;
	}

	public int getCosto() {
		return costo;
	}

	public boolean isHayDragon() {
		return hayDragon;
	}
	
}
