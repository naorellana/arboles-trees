
package com.compiladores.arbol.controllers;


import com.compiladores.arbol.models.Conectar;
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
public class HomeController {
    //@Autowired	
    private JdbcTemplate jdbcTemplate;
    public HomeController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    @GetMapping("/inicio")
	public String init(HttpServletRequest req) {
                String sql="select * from usuarios order by id desc";
                List datos=this.jdbcTemplate.queryForList(sql);
		req.setAttribute("datos",datos);
		//req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
        
        
    @GetMapping("/arbol")
    public ModelAndView home()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("arbol_1");
        return mav;
    }
    

@RequestMapping(value = "/sample", method= RequestMethod.GET)
public ModelAndView sample(HttpServletRequest request){
    Enumeration enumeration = request.getParameterNames();
    Map<String, Object> modelMap = new HashMap<>();
    while(enumeration.hasMoreElements()){
        String parameterName = (String) enumeration.nextElement();
        modelMap.put(parameterName, request.getParameter(parameterName));
    }
    ModelAndView modelAndView = new ModelAndView("sample");
    modelAndView.addObject("parameters", modelMap);
    return modelAndView;
}

    
    
    @GetMapping("/prueba")
    public ModelAndView prueba()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("arbol_1");
        return mav;
    }
    
    @GetMapping("/tabla")
    public ModelAndView tabla()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("tabla_1");
        return mav;
    }
    @GetMapping("/new")
	public String neww(HttpServletRequest req) {
                //String sql="select * from usuarios order by id desc";
                //List usuarios=this.jdbcTemplate.queryForList(sql);
		//req.setAttribute("usuarios",usuarios);
		req.setAttribute("action", "save");
		return "add";
	}
    
    @GetMapping("save")
	public void guardar( @ModelAttribute Usuarios usuarios, BindingResult bindingResult, HttpServletResponse resp) throws IOException{
		jdbcTemplate.update
        (
        "insert into usuarios (id,nombre,correo,telefono ) values (?,?,?,?)",
         usuarios.getId(), usuarios.getNombre(),usuarios.getCorreo(),usuarios.getTelefono()
        ); 
		//req.setAttribute("books", springService.findAllBooks());
		//req.setAttribute("mode", "BOOK_VIEW");
		resp.sendRedirect("/");
	} 
        
       @GetMapping("edit")
	public String edit(@RequestParam int id, HttpServletRequest req) {
            String sql = "SELECT * FROM usuarios WHERE id='" + id+"'";
            List usuarios=this.jdbcTemplate.queryForList(sql);
		req.setAttribute("usuarios", usuarios.get(0));//obtiene un array con un registro en la posicion 0
                req.setAttribute("action", "update");
		return "add";
	} 
        
        @GetMapping("/delete")
	public void delete(@RequestParam long id, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.jdbcTemplate.update(
                    "delete from usuarios "
                + "where "
                + "id=? ",
        id);
        resp.sendRedirect("/");
    }
        
        @GetMapping("/update")
	public void update( @ModelAttribute Usuarios u,  HttpServletResponse resp) throws IOException{
		jdbcTemplate.update(
                    "update usuarios "
                + "set nombre=?,"
                + " correo=?,"
                + "telefono=? "
                + "where "
                + "id=? ",
         u.getNombre(),u.getCorreo(),u.getTelefono(),u.getId());
		resp.sendRedirect("/");
	} 
    
}
