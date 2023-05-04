package repaso;
import tp02.ejercicio2.ListaGenerica;
import tp04_ag.*;
import tp02.ejercicio2.*;

public class RedDeAguaPotablev2 {
	private ArbolGeneral<Double> red;
	
	public double minimoCaudal(double caudal) {
		minimo min = new minimo();
		min.setDato(9999);
		if(!red.esVacio()) {
			minimoCaudal(caudal,red,min);
		}
		return min.getDato();
	}
	
	private void minimoCaudal(double caudal, ArbolGeneral<Double> aux , minimo min) {
		if(caudal< min.getDato()) {
			min.setDato(caudal);
		}
		if(aux.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Double>> hijos = aux.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				minimoCaudal(caudal / hijos.tamanio(),hijos.proximo(),min);
			}
		}
	}
	
	
}
