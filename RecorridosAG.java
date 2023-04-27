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
	
	
	public ListaGenerica < Integer > numerosImparesMayoresQuePostOrden(ArbolGeneral < Integer > a, Integer n) {
        ListaGenerica < Integer > lista = new ListaEnlazadaGenerica < Integer > ();
        numerosImparesMayoresQuePostOrden(a, n, lista);
        return lista;
    }

    private void numerosImparesMayoresQuePostOrden(ArbolGeneral < Integer > a, Integer n, ListaGenerica < Integer > lista) {
        if (a.tieneHijos()) {
            ListaGenerica < ArbolGeneral < Integer >> lHijos = a.getHijos();
            lHijos.comenzar();
            while (!lHijos.fin()) {
                numerosImparesMayoresQuePostOrden(lHijos.proximo(), n, lista);
            }
        }
        int dato = a.getDato();
        if (dato > n && dato % 2 != 0) {
            lista.agregarFinal(dato);
        }
    }
	
	
	
	
}

