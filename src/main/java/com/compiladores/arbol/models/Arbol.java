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
public class Arbol  // CLASE ARBOL
{
    private Nodo raiz;

    public Arbol()
    {
        raiz = null;       
    }
  
    public boolean vacioArbol(Nodo a)//Metodo para saber si el arbol esta completamente vacio
    {
        return (a == null);           
    }

    public Nodo getRaiz() //procedimiento para obtener la raiz
    {
        return raiz;
    }

    public void setRaiz(Nodo raiz) // Agregar Raiz a el Arbol
    {
        this.raiz = raiz;
    } 

    public Nodo getIzqArbol(Nodo a)//retorna el arbol izquierdo
    {
        if(a.getIzq() == null)
        {
            return null;
        }
        else
        {
            return a.getIzq();
        }
    }

    public Nodo getDerArbol(Nodo a)//retorna el arbol derecho
    {
        if(a.getDer() == null)
        {
            return null;
        }
        else
        {
            return a.getDer();
        }
    } 

    public String adicionarNodo(Nodo a, Nodo n)//Agrega un nodo al arbol Ordenado
    {
        if(vacioArbol(a))
        {
            raiz = n;
            return "Elemento insertado correctamente.";
        }
        else
        {
            if(a.getDato() != n.getDato())
            {
                if(n.getDato() < a.getDato())
                {
                    if (getIzqArbol(a) == null)
                    {
                        a.setIzq(n);
                        return "Elemento insertado correctamente.";
                    }
                    else
                    {
                        return adicionarNodo(getIzqArbol(a), n);
                    }
                }
                else if(n.getDato() > a.getDato())
                {
                    if (getDerArbol(a) == null)
                    {
                        a.setDer(n);
                        return "Elemento insertado correctamente.";
                    }
                    else
                    {
                        return adicionarNodo(getDerArbol(a), n);
                    }
                }
            }   
            else
            {
                return "No se puede agregar el Elemento.";               
            }           
        }
        return "";
    } 

    public void preorden(Nodo a) //realiza el recorrido en preorden de un arbol
    {   
        if(!vacioArbol(a))
        {
            System.out.print(a.getDato()+ " ");
            preorden(getIzqArbol(a));
            preorden(getDerArbol(a));
        }
        
    }

    public void inorden(Nodo a) //realiza el recorrido en inorden de un arbol
    {
        if(!vacioArbol(a))
        {
            inorden(getIzqArbol(a));
            System.out.print(a.getDato()+ " ");
            inorden(getDerArbol(a));
        }           
    }

    public void postorden(Nodo a)//realiza el recorrido en postorden de un arbol
    {
        if(!vacioArbol(a))
        {
            postorden(getIzqArbol(a));
            postorden(getDerArbol(a));
            System.out.print(a.getDato()+ " ");
        }
    }

    public Nodo buscarNodo(Nodo a, int dato)//retorna un nodo el cual contiene un dato que se busca, si no lo encuentra retorna null
    {
        if(a != null)
        {
           if(a.getDato() == dato)
           {
                return a;
           }

           else
           {
                if(dato > a.getDato())
                {
                    return buscarNodo(a.getDer(), dato);
                }
                else
                {
                    return buscarNodo(a.getIzq(), dato);
                }
            }
        }
        else
        {
            return null;
        }
    }


    public boolean soloRaiz(Nodo nodo){ // METODO ELIMINAR NODO DEL ARBOL
        if(nodo.getDer()==null && nodo.getIzq()==null ){
            nodo=null;
            return true;
        }
        return false;
    }
    public Nodo EliminarNodo(Nodo nodo, int dato)
    {
        if(soloRaiz(nodo))
        {
            return null;
        }
      
        if (nodo == null){
            System.out.println("No se encuentra el nodo.");
        }
        else if (dato < nodo.getDato()){
            Nodo izq;
            izq = EliminarNodo(nodo.getIzq(), dato);
            nodo.setIzq(izq);
        }
        else if (dato > nodo.getDato()){
            Nodo der;
            der = EliminarNodo(nodo.getDer(), dato);
            nodo.setDer(der);
        }       
        else{
            Nodo eliminar;
            eliminar = nodo;
          
            if(eliminar.getIzq() == null)
            {
                nodo = eliminar.getDer();               
            }
            else if (eliminar.getDer() == null)
            {
                nodo = eliminar.getIzq();
            }
            else
            {
                eliminar = reemplazar(eliminar);
            }
            eliminar = null;
        }
        return nodo;
    }
  
    public Nodo reemplazar(Nodo nodo)
    {
        Nodo N1, N2;
        N2 = nodo;
        N1 = nodo.getIzq();
      
        while(N1.getDer() != null)
        {
            N2 = N1;
            N1 = N1.getDer();
        }
      
        nodo.setDato(N1.getDato());
      
        if(N2 == nodo)
        {
            N2.setIzq(N1.getIzq());
        }
        else
        {
            N2.setDer(N1.getIzq());
        }
      
        return N1;
    }
    public void cargar() // METODO CARGAR ARBOL
    {
        adicionarNodo(raiz, new Nodo (10));
        adicionarNodo(raiz, new Nodo (11));
        adicionarNodo(raiz, new Nodo (15));
        adicionarNodo(raiz, new Nodo (12));
        adicionarNodo(raiz, new Nodo (16));
        adicionarNodo(raiz, new Nodo (9));
        adicionarNodo(raiz, new Nodo (3));
        adicionarNodo(raiz, new Nodo (2));
        adicionarNodo(raiz, new Nodo (5));
    }
} // Fin Clase ARBOL


