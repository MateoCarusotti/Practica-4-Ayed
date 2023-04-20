package tp03.ejercicio5;
import tp03.ejercicio1.*;
import tp02.ejercicio3.*;
public class ProfundidadDeArbolBinario {
	private ArbolBinario <Integer> ar;
	
	public void setArbol(ArbolBinario<Integer> arbol) {
		this.ar = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		int nivel = 0;
		int cant = -1;
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
		ColaGeneric<ArbolBinario<Integer>> cola = new ColaGeneric<ArbolBinario<Integer>>();
		cola.encolar(ar);
		cola.encolar(null);
		while (!cola.esVacia() && nivel < p ) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				nivel++;
			}
		}
		if(nivel == p) { // REPITO CODIGO
			cant = 0;
			while(!cola.esVacia()) {
				arbol = cola.desencolar();
				if(arbol != null) {
					cant = cant + arbol.getDato();
					if(arbol.tieneHijoDerecho()) {
						cola.encolar(arbol.getHijoDerecho());
					}
					if(arbol.tieneHijoIzquierdo()) {
						cola.encolar(arbol.getHijoIzquierdo());
					}
				}else {
					if (!cola.esVacia()) {
						cola.encolar(null);
					}
				}
			}
		}
		return cant; //si retorna menos -1 significa que el nivel p no existia 
	}
}
