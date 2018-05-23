
package com.compiladores.arbol.controllers;


import com.compiladores.arbol.models.Arbol;
import com.compiladores.arbol.models.Conectar;
import com.compiladores.arbol.models.Nodo;
import com.compiladores.arbol.models.Usuarios;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//mapa desde formulario
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TreeController {
    //@Autowired	
    private JdbcTemplate jdbcTemplate;
    public TreeController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
  
        

@RequestMapping(value = "/pruebasAr", method= RequestMethod.GET)
public ModelAndView pruebasAr(HttpServletRequest request){
    Enumeration enumeration = request.getParameterNames();
    Map<String, Object> modelMap = new HashMap<>();
    while(enumeration.hasMoreElements()){
        String parameterName = (String) enumeration.nextElement();
        modelMap.put(parameterName, request.getParameter(parameterName));
    }
     String preOrden="", inOrden="", posOrden="";
    
    //procesando arbolito
     Nodo nodoRaiz= new Nodo(modelMap.get("Lv0Nodo1").toString()); //raiz del nodoRaiz
     
        Nodo nodoIzq= new Nodo(modelMap.get("Lv1Nodo1").toString());//nodos/arbol de la izquiera
        Nodo nodoDer= new Nodo(modelMap.get("Lv1Nodo2").toString());//nodo/arbol de la derechanodoDer
        
        //añadiendo arbol/nodos izquierdo y derechoa la raiz
        nodoRaiz.setIzq(nodoIzq);
        nodoRaiz.setDer(nodoDer);
        
        //agregando sus nodos Izquierdos
        nodoIzq.setIzq(new Nodo(modelMap.get("Lv2Nodo1").toString()));
        nodoIzq.setDer(new Nodo(modelMap.get("Lv2Nodo2").toString()));
        //nodos para el 5
        nodoIzq.getDer().setIzq(new Nodo(modelMap.get("Lv3Nodo3").toString()));
        
        //nodos para el 4
        nodoIzq.getIzq().setDer(new Nodo(modelMap.get("Lv3Nodo2").toString()));
        nodoIzq.getIzq().setIzq(new Nodo(modelMap.get("Lv3Nodo1").toString()));
        
        //agregando sus nodos
        nodoDer.setDer(new Nodo(modelMap.get("Lv2Nodo4").toString()));
        nodoDer.setIzq(new Nodo(modelMap.get("Lv2Nodo3").toString()));
        
        
        
        //clase arbol para recorridos
       Arbol arbol= new Arbol();//inicializando
        arbol.setRaiz(nodoRaiz);
        //obteniendo los recorridos
        
        inOrden=arbol.inorden(nodoRaiz);
        //System.out.print("IN: "  +orden);
        preOrden=arbol.preorden(nodoRaiz);
        //System.out.print("Pre: "  +orden);
        posOrden=arbol.postorden(nodoRaiz);     //*/
    //*************
    ModelAndView modelAndView = new ModelAndView("sample");
    modelAndView.addObject("parameters", modelMap);
    modelAndView.addObject("preOrden",preOrden );
    modelAndView.addObject("inOrden", inOrden);
    modelAndView.addObject("posOrden", posOrden);
    return modelAndView;
}

    
    
    @GetMapping("/pruebaArbol")
    public ModelAndView pruebaArbol( @RequestParam String s )
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("arbol_1");
        return mav;
    }
    
    
}
