package aed;

public class ABB<T extends Comparable<T>> {
    private Nodo raiz;
    private int cardinal;


    private class Nodo {
        T valor;
        Nodo padre;
        Nodo izq;
        Nodo der;
        Nodo ( T valor){
            this.valor=valor;
            this.padre=null;
            this.izq=null;
            this.der=null;
        }
    }

    public class HandleABB {
        private Nodo nodo;
        private HandleABB(Nodo nodo) {
            this.nodo = nodo;
        }

        public T valor() {
            return nodo.valor;
        }

        public void eliminar() {
            eliminarNodo(nodo);
        }
    }
    private Nodo insertarRec(Nodo actual, Nodo nuevo, Nodo padre) {
        if (actual == null) {
            nuevo.padre = padre;
            return nuevo;
        }
        if (nuevo.valor.compareTo(actual.valor) < 0) {
            actual.izq = insertarRec(actual.izq, nuevo, actual);
        } else {
            actual.der = insertarRec(actual.der, nuevo, actual);
        }
        return actual;
    }

    private void eliminarNodo(Nodo nodo) {
        raiz = eliminarRec(raiz, nodo.valor);
        cardinal--;
    }

    private Nodo eliminarRec(Nodo actual, T valor) {
        if (actual == null) return null;

        int cmp = valor.compareTo(actual.valor);
        if (cmp < 0) {
            actual.izq = eliminarRec(actual.izq, valor);
        } else if (cmp > 0) {
            actual.der = eliminarRec(actual.der, valor);
        } else {
            if (actual.izq == null) return actual.der;
            if (actual.der == null) return actual.izq;

            Nodo sucesor = encontrarMin(actual.der);
            actual.valor = sucesor.valor;
            actual.der = eliminarRec(actual.der, sucesor.valor);
        }
        return actual;
    }

    
    public int tamaño() {
        return cardinal;
    }

    public boolean estaVacio() {
        return cardinal == 0;
    }

    public ABB() {
        raiz=null;
        cardinal=0;
    }

    public T minimo(){
        return encontrarMin(raiz).valor;
    }
    private Nodo encontrarMin(Nodo nodo) {
        while (nodo.izq != null) nodo = nodo.izq;
        return nodo;
    }


    public HandleABB insertar(T elem){
        throw new UnsupportedOperationException("No implementado aún");
    }

    public boolean pertenece(T elem){
        throw new UnsupportedOperationException("No implementado aún");
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementado aún");
    }

    @Override
    public String toString(){
        throw new UnsupportedOperationException("No implementado aún");
    }

    public class ABB_Iterador {
        /* ¡COMPLETAR! */
    }

    public ABB_Iterador iterador() {
        throw new UnsupportedOperationException("No implementado aún");
    }

}
