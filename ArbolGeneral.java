package tp04_ag;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class ArbolGeneral<T> {

		private T dato;

		private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

		public T getDato() {
			return dato;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}

		public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
			if (hijos==null)
				this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
			else
				this.hijos = hijos;
		}

		public ArbolGeneral(T dato) {
			this.dato = dato;
		}

		public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
			this(dato);
			if (hijos==null)
				this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
			else
				this.hijos = hijos;
		}

		public ListaGenerica<ArbolGeneral<T>> getHijos() {
			return this.hijos;
		}

		public void agregarHijo(ArbolGeneral<T> unHijo) {

			this.getHijos().agregarFinal(unHijo);
		}

		public boolean esHoja() {

			return !this.tieneHijos();
		}
		
		public boolean tieneHijos() {
			return !this.hijos.esVacia();
		}
		
		public boolean esVacio() {

			return this.dato == null && !this.tieneHijos();
		}

		

		public void eliminarHijo(ArbolGeneral<T> hijo) {
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				if (hijos.incluye(hijo)) 
					hijos.eliminar(hijo);
			}
		}
		
		public ListaEnlazadaGenerica<T> preOrden() {
			return null;
		}
		
		public Integer altura() {
			int cant = 0;
			ArbolGeneral<T> aux = new ArbolGeneral<T>(null);
			ColaGeneric<ArbolGeneral<T>> cola = new ColaGeneric<ArbolGeneral<T>>();
			ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
			cola.encolar(this);
			cola.encolar(null);
			while((!cola.esVacia())) {
				aux = cola.desencolar();
				if(aux != null) {
					if(aux.tieneHijos()) {
						hijos = aux.getHijos();
						hijos.comenzar();
						while(!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}
					}
				}else if(!cola.esVacia()) {
					cant++;
					cola.encolar(null);
				}
			}
			return cant;
		}

		public Integer nivel(T dato) {
			// falta implementar
			return -1;
		}

		public Integer ancho() {
			int max = -1;
			int cant = 0;
			ArbolGeneral<T> aux = new ArbolGeneral<T>(null);
			ColaGeneric<ArbolGeneral<T>> cola = new ColaGeneric<ArbolGeneral<T>>();
			ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
			if(!this.tieneHijos()) {
				cant++;
			}
			cola.encolar(this);
			cola.encolar(null);
			while((!cola.esVacia())) {
				aux = cola.desencolar();
				if(aux != null) {
					if(aux.tieneHijos()) {
						hijos = aux.getHijos();
						hijos.comenzar();
						while(!hijos.fin()) {
							cola.encolar(hijos.proximo());
							cant++;
						}
					}
				}else if(!cola.esVacia()) {
					if(cant > max) {
						max = cant;
					}
					cant = 0;
					cola.encolar(null);
				}
			}
			return max;
		}
		
		
		public Boolean esAncestro(T a, T b) {
			if(!this.esVacio()) {
				if(this != a) {
					if(this.tieneHijos()) {
						ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
						hijos = this.getHijos();
						hijos.comenzar();
						while(!hijos.fin()) {
							hijos.proximo().esAncestro(a, b);
						}
					}	
				}
			}else {
				return false;
			}
			
		}
		
}
