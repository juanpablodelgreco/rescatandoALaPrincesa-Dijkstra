package rescatandoALaPrincesa;

import java.util.Arrays;

public class MatrizAdyacencia {
	private int[][] matriz;
	private int ordenMatriz;
	
	public MatrizAdyacencia(int ordenMatriz){
		this.ordenMatriz = ordenMatriz;
		matriz = new int[ordenMatriz][ordenMatriz];
		inicializarMatriz();
	}
	
	public void inicializarMatriz() {
		for(int i=0; i<this.ordenMatriz; i++) {
			for(int j=0; j<this.ordenMatriz; j++) {
				if(i==j) 
					matriz[i][j] = 0;
				else matriz[i][j] = 999;
			}
				
		}
	}

	public void agregarPeso(int i, int j, int peso) {
		this.matriz[i][j] = peso;
	}
	
	public int getPeso(int i, int j) {
		return this.matriz[i][j];
	}
	
	public int[][] getMatriz() {
		return matriz;
	}

	public int getOrdenMatriz() {
		return ordenMatriz;
	}
	
	public void mostrarMatriz() {
		for(int i=0; i<this.ordenMatriz; i++) {
			for(int j=0; j<this.ordenMatriz; j++)
				System.out.print(matriz[i][j]+"| ");
			System.out.println();
		}
	}
	
	@Override
	public String toString() {
		return "MatrizAdyacencia [matriz=" + Arrays.toString(matriz) + "]";
	}
}
