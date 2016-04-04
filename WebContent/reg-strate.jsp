

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/rouge"
		user="root"
		password="mysql"
		var="miConexion"
/>

<sql:query var="sql1"
		sql="select * from tb_ubigeo"
		dataSource="${miConexion}"
/>

	<div id="canvas" style="margin: 0px; left: auto; height: 100px; background-color: rgb(255, 255, 255);" > 
	 <div id="page-wrapper">
	   <div id="header" style="display: block; background-image: none;" > 
	     <div style="margin: 0px auto; width: 1364px; height: 268px; position: relative; background-image: none; background-color: rgb(228, 50, 72);"> 
	       <div id="asset-1447878960359" style="left: 61.98px; top: 13.85px; width: 300.18px; height: auto; position: absolute; z-index: 372;" >
	         <div id="asset-1447878960359-neo-asset-inner" style="border: 10px solid rgba(255, 250, 250, 0.568627); border-image: none; padding-top: 10px; padding-right: 0px; padding-left: 0px; position: relative; opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);" spellcheck="false">
	           <div style="text-align: center; line-height: 1.4;">
	            <span style="color: rgb(255, 255, 255); letter-spacing: 1px; font-family: Carme, sans-serif; font-size: 72px;">ROUGE</span>
	           </div>
	         </div>
	       </div>
	       <div id="asset-1447884260158" style="left: 1246.5px; top:209px; width: 41px; height: 41px; position: absolute; z-index: 380;">
	         <div style="border-color: rgb(51, 51, 51); opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);">
	           <a target="_blank"><img width="36" height="36" class="link-icon" style="width: 36px; height: 36px;" alt="Find us on Facebook" src="img/neo-soc-icon-w-64-facebook.png" /></a>
	         </div>
	       </div>
	       <div id="asset-1447884292229" style="left: 1295.5px; top: 209px; width: 42px; height: 42px; position: absolute; z-index: 381;">
	         <div style="border-color: rgb(51, 51, 51); opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);">
	           <a target="_blank"><img width="37" height="37" class="link-icon" style="width: 37px; height: 37px;" alt="Find us on Twitter" src="./img/neo-soc-icon-w-64-twitter-2.png" /></a>
	         </div>
	       </div>
  	     <div id="menu">
  	   
  	     </div>
	       <div style="left: 750px; top: 209px; width: 150px; height: auto; position: absolute; z-index: 395;">
	        <div>
	         <p style="text-align: center;"><span style="color: rgb(235, 240, 242); font-family: sans-serif; font-size: 14px;"><a style="color: rgb(235, 240, 242);" href="iniciar-sesi-n.html">INICIAR SESI&Oacute;N</a></span></p>
	        </div>
	       </div>
	       <div style="left: 900px; top: 209px; width: 170px; height: auto; position: absolute; z-index: 395;">
	        <div style="border-color: rgb(87, 87, 87); position: relative; opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);" spellcheck="false">
	         <p style="text-align: center;"><span style="color:rgb(235, 240, 242); font-family: sans-serif; font-size: 14px;"><a style="color:rgb(235,240,242);" href="registra-tu-negocio.html">PUBLICA TU NEGOCIO</a></span></p>
	        </div>
	       </div>
	   </div> 
	 </div> 
	 <div id="content"> 
	   <div style="margin: 0px auto; width: 1366px; height: 700px; position: relative;">  
      <div style="position: absolute; opacity: 1; width: 1366px; height: 700px; background-image: url(img/img_registro.jpg); background-repeat: repeat; background-size: cover;">
	      
	         <!-- Colocar aqui iframes o cuadros de rouge -->
            
            <div style="left: auto; top:auto; width: 1000px; height: auto; position: relative; z-index: 393; background-color: #EFEFEF; opacity:0.9; font-family: Calibri; box-shadow: 3px 3px 5px gray; border-radius: 10px; margin-left:auto; margin-right: auto;" >
            
              <div id="Titulo" style="position: relative; opacity: 1;" spellcheck="false">
                <h2 style="text-align: center;">
                  <span style="">REGISTRATE EN ROUGE</span>
                </h2>
              </div>

              <div spellcheck="false">
                <p style="text-align: center;">
                  <span style="color: rgb(81, 209, 21);">Ingresa tu opinión acerca de los centros de belleza de tu preferencia<br>Encuentra los mejores y más económicos para ti.&nbsp;</span>
                </p>
              </div>

              <div style="">
             
                <style>
                  form {
                   margin:auto;
                   width:60%;
                  }
                  input{
                   margin-bottom:10px; 
                   display:inline-block;
                  } 
                </style>

                <form action="ServletUsuario" method="post">
                	<input type="hidden" name="metodo"  value="registrar">
                <table>
                  <tr>
                    <td>
                      <label for="name">Nombre y Apellidos:</label> 
                      <br> 
                      <input id="name" required="" type="text" name="txtNombre">  
                      <br> 
                    </td>
                    <td>
                      <label for="usuario">Usuario (10 caracteres máximo):</label> 
                      <br> 
                      <input id="usuario" required="" type="text" name="txtCodus"> 
                      <br>
                    </td> 
                    <td>
                      Sexo:<select name="cboSexo">       
                      	 <option value="0">(...)</option>               
                         <option value="1">Masculino</option>
                         <option value="2">Femenino</option>
                         <option value="3">Prefiero no Decirlo</option>
                       </select>
                    </td>
                  <tr>
                    <td>
                      <br> 
                      <label for="e-mai">Correo Electrónico:</label> 
                      <br> 
                      <input id="e-mail" required="" type="email" name="txtEmail"> 
                      <br> 
                    </td>                      
                    <td colspan="2">                      
                      <br> 
                      <label for="confirm-e-mai"> Confirmar Correo Electrónico:</label> 
                      <br> 
                      <input id="confirm-e-mail" required="" type="email" name="txtConfirmEmail"> 
                      <br> 
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <br> 
                      <label for="password">Contraseña:</label> 
                      <br> 
                      <input id="password" required="" type="password" name="txtPassword"> 
                      <br> 
                    </td>
                    <td colspan="2">
                      <br> 
                      <label for="re-password">Confirmar Contraseña:</label> 
                      <br> 
                      <input id="re-password" required="" type="password" name="txtConfirmPassword"> 
                      <br> 
                    </td>
                  </tr>
                  <tr>
                    <td>                      
                      <br> 
                      <label for="pais"> Distrito:</label> 
                      <br> 
                      <select name="cboDistrito" style="width:120px">
                      	<c:forEach var="fila1" items="${sql1.rows}">
                      		<option value="<c:out value="${fila1.cod_ubigeo}"/>">
                      		<c:out value="${fila1.descripcion}"/>
                      		</option>
                      	</c:forEach>	
                      </select> 
                      
                      <br> 
                    </td>                  
                    <td colspan="2">                      
                      <br> 
                      <label for="pais">Fecha de Nacimiento:</label> 
                      <br> 
                      <input id="fecnac" required="" type="text" name="txtFecha"> 
                      <br> 
                    </td>                  
                  </tr>
                  <tr>
                    <td>
                      <br> 
                      Servicios que buscas normalmente:
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <input type="checkbox" name="chbServicio" value="1"> 
                      <span>Peluquería</span> 
                      <br> 
                      <input type="checkbox" name="chbServicio" value="2"> 
                      <span>Spa</span> 
                      <br> 
                      <input type="checkbox" name="chbServicio" value="3"> 
                      <span>Manicure y/o Pedicure</span> 
                      <br> 
                      <input type="checkbox" name="chbServicio" value="4"> 
                      <span>Depilación</span> 
                      <br>
                    </td>
                    <td colspan="2">
                      <input type="checkbox" name="chbServicio" value="5"> 
                      <span>Sauna</span> 
                      <br> 
                      <input type="checkbox" name="chbServicio" value="6"> 
                      <span>Masajes</span> 
                      <br> 
                      <input type="checkbox" name="chbServicio" value="7"> 
                      <span>Tratamiento de la piel</span> 
                      <br> 
                      <input type="checkbox" name="chbServicio" value="8"> 
                      <span>Tratamiento de cabello</span> 
                      <br> 
                    </td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: center">
                      <br>
                      <input id="publish" type="submit" value="Registrarse">
                    </td>
                  </tr>
                </table>
                </form>          
              </div>
            </div>

	       
	     </div>
	   </div> 
	 </div> 

  	<div id="footer" style="display: block; background-image: none;" data-is-full-body-width="false"> 
  	 <div style="margin: 0px auto; width: 1364px; height: 225px; position: relative; background-image: none; background-color: rgb(243, 55, 78);"> 
  	  <div style="left: 1043.7px; top: 21.2px; width: 300px; height: 37px; position: absolute; z-index: 373;" >
  	   <div style="border-color: rgb(87, 87, 87); position: relative; opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);" spellcheck="false">
  	    <p style="text-align: center;"><span style="color: rgb(255, 255, 255); letter-spacing: 2px; font-size: 18px;">S&iacute;guenos en:</span></p>
  	   </div>
  	  </div>
  	  <div  style="left: 1125.61px; top: 76.1px; width: 67px; height: 67px; position: absolute; z-index: 374;" >
  	   <div style="border-color: rgb(51, 51, 51); opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);">
  	    <a target="_blank"><img width="65" height="65" class="link-icon" style="width: 65px; height: 65px;" alt="Find us on Facebook" src="img/neo-soc-icon-b-64-facebook.png" /></a>
  	   </div>
  	  </div>
  	  <div style="left: 1199.61px; top: 76.1px; width: 67px; height: 67px; position: absolute; z-index: 376;">
  	   <div style="border-color: rgb(51, 51, 51); opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);">
  	    <a target="_blank"><img width="65" height="65" class="link-icon" style="width: 65px; height: 65px;" alt="Find us on Twitter" src="img/neo-soc-icon-b-64-twitter-2.png" /></a>
  	   </div>
  	  </div>
  	  <div style="left: 42px; top: 53px; width: 174px; height: 102px; position: absolute; z-index: 372;" >
  	   <div style="border: 9px solid rgba(255, 250, 250, 0.568627); border-image: none; padding-top: 10px; padding-right: 0px; padding-left: 0px; position: relative; opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);" spellcheck="false">
  	    <h1 style="text-align: center;"><span style="color: rgb(245, 245, 245);"><sup><span style="letter-spacing: 2px; font-family: Carme, sans-serif; font-size: 36px;">ROUGE</span></sup></span></h1>
  	   </div>
  	  </div>
  	  <div style="left: 265.6px; top: 10.11px; width: 5px; height: 194px; position: absolute; z-index: 378;">
  	   <div style="border-color: rgb(51, 51, 51); opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgb(238, 238, 238);"></div>
  	  </div>
  	  <div style="left: 335.59px; top: 21.09px; width: 200px; height: auto; position: absolute; z-index: 382;" >
  	   <div id="footer"  style="border-color: rgb(87, 87, 87); position: relative; opacity: 1; background-image: none; background-color: rgba(255, 255, 255, 0);" spellcheck="false">
  	    <p><span style="color: rgb(255, 255, 255); font-family: Arial, Helvetica, sans-serif;"><strong>Para Visitantes:</strong></span></p> 
  	    <ul> 
  	     <li><span style="color: rgb(255, 255, 255); font-family: Arial, Helvetica, sans-serif; font-size: 16px;"><a style="color: rgb(255, 255, 255);" href="con-cenos.html" target="_self" data-link-type="website">Con&oacute;cenos</a></span></li> <br>
  	     <li><span style="color: rgb(255, 255, 255); font-family: Arial, Helvetica, sans-serif; font-size: 16px;"><a style="color: rgb(255, 255, 255);" href="objetivos.html" target="_self" data-link-type="website">Nuestros Objetivos</a></span></li> 
  	    </ul>
  	   </div>
  	  </div>
  	  <div style="left: 541.61px; top: 21.09px; width: 220px; height: auto; position: absolute; z-index: 382;" >
  	   <div style="border-color: rgb(87, 87, 87); position: relative; opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);" spellcheck="false">
  	    <p><span style="font-family: Arial, Helvetica, sans-serif;"><strong><span style="color: rgb(255, 255, 255);">Para Empresas:</span></strong></span></p> 
  	    <ul> 
  	     <li><span style="color: rgb(255, 255, 255); font-family: Arial, Helvetica, sans-serif; font-size: 16px;"><a style="color: rgb(255, 255, 255);" href="registra-tu-negocio.html" target="_self" data-link-type="website">Publica tu empresa aqu&iacute;</a></span></li>
  	    </ul>
  	   </div>
  	  </div>
  	  <div style="left: 1089.81px; top: 155.42px; width: 207px; height: auto; position: absolute; z-index: 383;" >
  	   <div style="border-color: rgb(87, 87, 87); position: relative; opacity: 1; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.498039); background-image: none; background-color: rgba(255, 255, 255, 0);" spellcheck="false">
  	    <p><span style="color: rgb(51, 50, 50); font-family: &quot;Alegreya Sans&quot;, sans-serif; font-size: 12px;"><span></span>&copy;2016 Rouge(c).Todos los derechos reservados.</span></p>
  	   </div>
  	  </div>
  	 </div> 
  	</div> 
  </div>
	 <div id="bottom-area" style="width: 1362px; height: 0px;"></div> 
 </div>       
</body>
</html>