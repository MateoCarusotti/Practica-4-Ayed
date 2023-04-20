package tp03.ejercicio4;
import tp03.ejercicio1.*;
public class RedBinariaLlena {
	private ArbolBinario<Integer> arbol;

	
	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	
	private void maximoRetardo (int max, int cont,ArbolBinario<Integer> arbol) {
		if(!arbol.esVacio()){
			cont = cont + arbol.getDato();
			if(!arbol.esHoja()) {
				if(arbol.tieneHijoDerecho()) {
					this.maximoRetardo(max, cont,arbol.getHijoDerecho());
				}
				if(arbol.tieneHijoIzquierdo()) {
					this.maximoRetardo(max,cont, arbol.getHijoIzquierdo());
				}
			}else {
				if(cont>= max) {
					max = cont;
				}
			}
			cont = cont - arbol.getDato();
			
		}
		
	}
	
	public int retardoReenvio(){
		int max = -1;
		int cont = 0;
		maximoRetardo(max,cont,arbol);
		return max;
	}
}
