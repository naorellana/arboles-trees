<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<script>
	$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 0; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div>    <div class="input-group" id="fila'+x+'">  <div class="input-group-prepend">    <span class="input-group-text" id="">Nvl'+x+'</span>  </div>  <input type="hidden" class="form-control" id="F_N'+x+'" value="'+x+'">  <input type="text" class="form-control" id="'+x+'celda1">   <input type="text" class="form-control" id="'+x+'celda2">   <input type="text" class="form-control" id="'+x+'celda3">   <input type="text" class="form-control" id="'+x+'celda4">   <input type="text" class="form-control" id="'+x+'celda5">   <input type="text" class="form-control" id="'+x+'celda6">   <input type="text" class="form-control" id="'+x+'celda7">   <input type="text" class="form-control" id="'+x+'celda8">   <input type="text" class="form-control" id="'+x+'celda9">   <input type="text" class="form-control" id="'+x+'celda10">   <input type="text" class="form-control" id="'+x+'celda11">   <input type="text" class="form-control" id="'+x+'celda12">   <input type="text" class="form-control" id="'+x+'celda13">   <input type="text" class="form-control" id="'+x+'celda14">   <input type="text" class="form-control" id="'+x+'celda15">   <input type="text" class="form-control" id="'+x+'celda16">   <!--input.form-control#celda$*16-->            <a href="#" class="remove_field btn btn-sm btn-danger">Borrar</a> </div></div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});
</script>

<div>
     <div class="input-group">
  <div class="col-12 primary text-center" >
    <div class="alert alert-dark" role="alert">
  Tabla Para Arbol Binario
</div>
  </div>
    </div>
    <form action="prueba">
        <div class="input_fields_wrap">
 
    
</div>
<button type="submit" class="btn btn-primary" id="x">enviar</button>
    </form>
    <button class="add_field_button btn btn-primary btn-lg btn-block">Agregar Fila</button>


  
</div>

<div id="tablaArbol" class="invisible">
    <div class="input-group" id="fila'+x+'">
  <div class="input-group-prepend">
    <span class="input-group-text" id="">Nvl'+x+'</span>
  </div>
  <input type="hidden" class="form-control" id="F_N'+x+'" value="'+x+'">
  <input type="text" class="form-control" id="'+x+'celda1">
   <input type="text" class="form-control" id="'+x+'celda2">
   <input type="text" class="form-control" id="'+x+'celda3">
   <input type="text" class="form-control" id="'+x+'celda4">
   <input type="text" class="form-control" id="'+x+'celda5">
   <input type="text" class="form-control" id="'+x+'celda6">
   <input type="text" class="form-control" id="'+x+'celda7">
   <input type="text" class="form-control" id="'+x+'celda8">
   <input type="text" class="form-control" id="'+x+'celda9">
   <input type="text" class="form-control" id="'+x+'celda10">
   <input type="text" class="form-control" id="'+x+'celda11">
   <input type="text" class="form-control" id="'+x+'celda12">
   <input type="text" class="form-control" id="'+x+'celda13">
   <input type="text" class="form-control" id="'+x+'celda14">
   <input type="text" class="form-control" id="'+x+'celda15">
   <input type="text" class="form-control" id="'+x+'celda16"> 
  <!--input.form-control#celda$*16-->
</div>


  

</div>

<jsp:include page="footer.jsp" />
