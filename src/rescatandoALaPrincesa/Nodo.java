package rescatandoALaPrincesa;

public class Nodo implements Comparable <Nodo>{
	private int numNodo;
	private int costo;
	private int predecesor;
	private boolean visitado;
	
	public Nodo(int numNodo, int costo) {
		this.numNodo = numNodo;
		this.costo = costo;
		this.visitado = false;
	}

	public int getCosto() {
		return costo;
	}
	
	public int getNumNodo() {
		return numNodo;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	@Override
	public int compareTo(Nodo n2) {
		return this.costo - n2.costo;
	}
}
