package rescatandoALaPrincesa;

public class Nodo implements Comparable <Nodo>{
	private int numNodo;
	private int costo;
	private int predecesor;
	
	public Nodo(int numNodo, int costo) {
		this.numNodo = numNodo;
		this.costo = costo;
	}

	public int getCosto() {
		return costo;
	}
	
	public int getNumNodo() {
		return numNodo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void setPredecesor(int predecesor) {
		this.predecesor = predecesor;
	}
	
	@Override
	public int compareTo(Nodo n2) {
		return this.costo - n2.costo;
	}

	@Override
	public String toString() {
		return "[numNodo=" + (numNodo+1) + ", costo=" + costo + ", predecesor=" + (predecesor+1) + "]";
	}

	
	
}
