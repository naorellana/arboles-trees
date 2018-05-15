/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiladores.arbol.models;

/**
 *
 * @author norellanac
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Nodo nodoRaiz= new Nodo(1); //raiz del nodoRaiz
        
        Nodo nodoIzq= new Nodo(2);//nodos/arbol de la izquiera
        Nodo nodoDer= new Nodo(3);//nodo/arbol de la derechanodoDer
        
        //añadiendo arbol/nodos izquierdo y derechoa la raiz
        nodoRaiz.setIzq(nodoIzq);
        nodoRaiz.setDer(nodoDer);
        
        //agregando sus nodos Izquierdos
        nodoIzq.setIzq(new Nodo(4));
        nodoIzq.setDer(new Nodo(5));
        //nodos para el 5
        nodoIzq.getDer().setIzq(new Nodo(10));
        
        //nodos para el 4
        nodoIzq.getIzq().setDer(new Nodo(9));
        nodoIzq.getIzq().setIzq(new Nodo(8));
        
        //agregando sus nodos
        nodoDer.setDer(new Nodo(7));
        nodoDer.setIzq(new Nodo(6));
        
        
        
        
        
        //clase arbol para recorridos
        Arbol arbol= new Arbol();//inicializando
        arbol.setRaiz(nodoRaiz);
        //****recorridos*********
        System.out.print("In");
        arbol.inorden(nodoRaiz);
        System.out.print("Pre");
        arbol.preorden(nodoRaiz);
        System.out.print("Pos");
        arbol.postorden(nodoRaiz);
        System.out.println("\nVer imagen en"+"\n http://2.bp.blogspot.com/-u7RcWPwWkzA/VzAXsc9GuUI/AAAAAAAAA5o/_OsRy2B3jjoWOnPTMyNqPoavIK269WMUwCK4B/s1600/preinon.jpg");
    
    }
    
}
