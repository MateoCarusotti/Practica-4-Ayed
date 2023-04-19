package tp04.ejercicio3;
import tp02.ejercicio2.*;
import tp04_ag.*;
public class RecorridosAG {
	
	private void preOrden (ArbolGeneral<Integer> a, ListaGenerica<Integer> l, Integer n) {
		if(!a.esVacio()) {
			if ((a.getDato() % 2 != 0) && (a.getDato()>n)) {
				l.agregarFinal(a.getDato());
			}
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					this.preOrden(hijos.proximo(),l,n);
				}
			}
		}
	}
	
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		this.preOrden(a, l, n);
		return l;
	}
	
	
	private void inOrden (ArbolGeneral<Integer> a, ListaGenerica<Integer> l, Integer n) {
		if(!a.esVacio()) {
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					this.inOrden(hijos.proximo(),l,n);
				}
			}
			if ((a.getDato() % 2 != 0) && (a.getDato()>n)) {
				l.agregarFinal(a.getDato());
			}
		}
	}
	
	public ListaGenerica< Integer > numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		this.inOrden(a, l, n);
		return l;
	}
	
	private void postOrden (ArbolGeneral<Integer> a, ListaGenerica<Integer> l, Integer n) {
		if(!a.esVacio()) {
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					this.postOrden(hijos.proximo(),l,n);
				}
			}
			if ((a.getDato() % 2 != 0) && (a.getDato()>n)) {
				l.agregarFinal(a.getDato());
			}
		}
	} //que hacer
	
	
	
	
	
	
}
