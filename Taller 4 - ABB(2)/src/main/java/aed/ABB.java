package aed;

import java.util.ArrayList;
import java.util.List;

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
        if (raiz == null) return null;
        Nodo actual = raiz;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual.valor;
    }
    

    public T maximo(){
        if (raiz == null) return null;
        Nodo actual = raiz;
        while (actual.der != null) {
            actual = actual.der;
        }
        return actual.valor;
    }

    public void insertar(T elem) {
    if (raiz == null) {
        raiz = new Nodo(elem);
        cardinal = 1;
        altura = 1;
    } else {
        int nuevaAltura = insertarRecursivo(raiz, elem, 1);
        if (nuevaAltura > altura) {
            altura = nuevaAltura;
        }
    }
}
private int insertarRecursivo(Nodo actual, T elem, int alt) {
    int comparacion = elem.compareTo(actual.valor);
    if (comparacion == 0) {
        return alt;
    } else if (comparacion < 0) {
        if (actual.izq == null) {
            actual.izq = new Nodo(elem);
            actual.izq.padre = actual;
            cardinal++;
            return alt + 1;
        } else {
            return insertarRecursivo(actual.izq, elem, alt + 1);
        }
    } else {
        if (actual.der == null) {
            actual.der = new Nodo(elem);
            actual.der.padre = actual;
            cardinal++;
            return alt + 1;
        } else {
            return insertarRecursivo(actual.der, elem, alt + 1);
        }
    }
}
    public boolean pertenece(T elem) {
        Nodo actual = raiz;
        while (actual != null) {
            int cmp = elem.compareTo(actual.valor);
            if (cmp == 0) return true;
            actual = (cmp < 0) ? actual.izq : actual.der;
        }
        return false;
    }
public void eliminar(T elem) {
        Nodo nodo = buscarNodo(elem);
        if (nodo == null) return;
        cardinal--;
        if ( nodo.izq==null && nodo.der==null){
            reemplazarEnPadre(nodo, null);
        }
        else if ( nodo.izq!=null && nodo.der==null){
            reemplazarEnPadre(nodo, nodo.izq);
        }
        else if ( nodo.izq==null && nodo.der!=null){
            reemplazarEnPadre(nodo, nodo.der);
        }
        else {
            Nodo sucesor = minimoNodo(nodo.der);
            nodo.valor = sucesor.valor;
            eliminarNodo(sucesor);
        }
    }

    private Nodo buscarNodo(T elem) {
        Nodo actual = raiz;
        while (actual != null) {
            int cmp = elem.compareTo(actual.valor);
            if (cmp == 0) return actual;
            actual = (cmp < 0) ? actual.izq : actual.der;
        }
        return null;
    }

    private Nodo minimoNodo(Nodo nodo) {
        while (nodo.izq != null) {
            nodo= nodo.izq;
        }
        return nodo;
    }

    private void eliminarNodo(Nodo nodo) {
        if (nodo.izq == null && nodo.der == null) {
            reemplazarEnPadre(nodo, null);
        } else if (nodo.izq != null && nodo.der == null) {
            reemplazarEnPadre(nodo, nodo.izq);
        } else {
            reemplazarEnPadre(nodo, nodo.der);
        }
    }

    private void reemplazarEnPadre(Nodo nodo, Nodo nuevo) {
        if (nodo.padre ==null){
            raiz=nuevo;
        }
        else if (nodo == nodo.padre.izq) {
            nodo.padre.izq= nuevo ;
        }
        else{
            nodo.padre.der = nuevo;
        }
        if (nuevo != null) {
            nuevo.padre = nodo.padre;
        }
    }
       
   @Override
    public String toString() {
        List<String> elementos = new ArrayList<>();
        recorridoInOrder(raiz, elementos);
        return "{" + String.join(",", elementos) + "}";
    }

    private void recorridoInOrder(Nodo actual, List<String> lista) {
        if (actual == null) return;

        recorridoInOrder(actual.izq, lista);                  
        lista.add(actual.valor.toString());                  
        recorridoInOrder(actual.der, lista);                 
    }


   public class ABB_Iterador {
    private List<T> elementos;
    private int posicion;

    public ABB_Iterador() {
        elementos = new ArrayList<>();
        posicion = 0;
        recorridoInOrder(raiz); 
    }

    private void recorridoInOrder(Nodo actual) {
        if (actual == null) return;
        recorridoInOrder(actual.izq);
        elementos.add(actual.valor);
        recorridoInOrder(actual.der);
    }

    public boolean haySiguiente() {
        return posicion < elementos.size();
    }

    public T siguiente() {
        T valor = elementos.get(posicion);
        posicion++;
        return valor;
    }
}
    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
