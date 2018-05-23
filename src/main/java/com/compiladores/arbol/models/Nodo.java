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
public class Nodo // Clase Nodo
{ 
    private String dato;
    private Nodo izq;   //Atributos del nodo
    private Nodo der;

    public Nodo(String dato)
    {
        this.dato = dato;
        izq = null;
        der = null;
    }

    public Nodo getIzq()
    {
            return izq;
    }

    public void setIzq(Nodo izq)
    {
            this.izq = izq;
    }

    public Nodo getDer()
    {
            return der;
    }

    public void setDer(Nodo der)
    {
            this.der = der;
    }

    public String getDato()
    {
        return dato;
    }

    public void setDato(String dato)
    {
            this.dato = dato;
    }
}
