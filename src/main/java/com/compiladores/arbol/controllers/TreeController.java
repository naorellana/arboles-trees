
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
    //procesando arbolito
     Nodo nodoRaiz= new Nodo("1"); //raiz del nodoRaiz
        
        Nodo nodoIzq= new Nodo("2");//nodos/arbol de la izquiera
        Nodo nodoDer= new Nodo("3");//nodo/arbol de la derechanodoDer
        
        //añadiendo arbol/nodos izquierdo y derechoa la raiz
        nodoRaiz.setIzq(nodoIzq);
        nodoRaiz.setDer(nodoDer);
        
        //agregando sus nodos Izquierdos
        nodoIzq.setIzq(new Nodo("4"));
        nodoIzq.setDer(new Nodo("5"));
        //nodos para el 5
        nodoIzq.getDer().setIzq(new Nodo("10"));
        
        //nodos para el 4
        nodoIzq.getIzq().setDer(new Nodo("9"));
        nodoIzq.getIzq().setIzq(new Nodo("8"));
        
        //agregando sus nodos
        nodoDer.setDer(new Nodo("7"));
        nodoDer.setIzq(new Nodo("6"));
        
        
        
        
        
        //clase arbol para recorridos
        Arbol arbol= new Arbol();//inicializando
        arbol.setRaiz(nodoRaiz);
    //*************
    ModelAndView modelAndView = new ModelAndView("sample");
    modelAndView.addObject("parameters", modelMap);
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
