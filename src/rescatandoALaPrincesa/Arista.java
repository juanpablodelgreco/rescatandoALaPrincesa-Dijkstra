package rescatandoALaPrincesa;

public class Arista {
	private int desde;
	private int hasta;
	private int peso;
	
	public Arista(int desde, int hasta, int peso) {
		this.desde = desde;
		this.hasta = hasta;
		this.peso = peso;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
}
