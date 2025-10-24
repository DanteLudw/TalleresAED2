package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> {
    private Nodo raiz ;
    private int cardinal;
    private int altura;
    
    private class Nodo {
        T valor;
        Nodo padre;
        Nodo izq;
        Nodo der;
        Nodo (T v){
            valor= v ;
            padre= null;
            izq=null;
            der=null;
        }
    }

    public ABB () {
        raiz = null;
        cardinal = 0;
        altura = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T maximo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void insertar(T elem){
        if (raiz==null){
            raiz.valor = elem ;
            altura=1;
        }
        int alturaPrima=0;
        funcionAux(raiz, elem, alturaPrima);
        if (alturaPrima > altura){
            altura=alturaPrima;
        }
    }

    private funcionAux( Nodo raiz, T elem, int: altura) ->Nodo nuevo, alturaPrima{
        Nodo nuevo;
        alturaPrima=altura+1;
        if (elem>raiz.valor){
            if (raiz.der==null){
                raiz.der=Nuevo;
            }
            else{
                funcionAux(raiz.der,elem,alturaPrima);
            }
        }
        else {
            if (raiz.izq==null){
                raiz.izq=Nuevo;
            }
            else{
                funcionAux(raiz.izq,elem,alturaPrima);
            }
        }
    }
    public boolean pertenece(T elem){
        if (raiz==null ) {
            return false;
        }

    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ABB_Iterador {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
