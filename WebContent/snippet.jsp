<!DOCTYPE html>
<html>
<head>
  <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
  <style>body{margin:0px;padding:0px;border:0px;font-family:Lato;}</style>
  <link href=".\css\rouge-estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
   <style>
     input#cell,
     input#establecimiento{font-size:16px; width:260px;}
     div.background { display:inline-block;height:576px;width:1364px;color:rgba(255, 255, 255, 0);background:rgba(255, 255, 255, 0);transition-property: color, background,border;transition-duration:1s;transition-timing-funtion:linear;  transition-delay:0s; }
     #cell,
     #establecimiento,
     .lugar,
     .spa{display:inline-block;font-size: 20px; margin:30px 38px 30px; color:#000000;}
     .lugar{margin-left: 230px;}
     div.background:hover,
     div.background:focus{background:rgba(148, 40, 40, 0.83); color:#000000;}
     p{  margin:150px 20px 0px 190px;font-size: 26px;  line-height: 40px;  max-width:100%;  text-align:justify;    }
     span{  font-size:39px; }
     input#cell,
     input#establecimiento {  border:1px solid #757590;}
     input#search{ font-family:  Arial; background-color: #fff;  color:   #757575;border-radius: 2px; cursor:pointer;  width:130px;  height:43px;margin-top:20px;  margin-left:613px;  font-size:20px;  border: solid #757580 1px;  letter-spacing: 0px; padding: 5px 10px 5px 10px;transition-property: color, background,border;transition-duration:0.5s;transition-timing-funtion:linear;  transition-delay:0s;}
     input#search:hover,
     input#search:focus{border: solid #000000; color:#FFF; background: #000000}
   </style>
   <div class="background"> 
    <div id="presentation-text"> 
     <p><span>Bienvenido a ROUGE</span><br>Buscas un servicio de Salon y/o Spa?, aqu&iacute; encontrar&aacute;s recomendaciones de personas como t&uacute;.<br> Puedes empezar ingresando la localidad o el nombre del establecimiento.</p> 
    </div> 
    <form action="./resultados.html" target="_parent"> 
     <div id="normal-text"> 
      <label class="lugar" for="cell">Lugar</label> 
      <input type="text" name="Lugar" placeholder="" id="cell"> 
      <label class="spa" for="establecimiento">Sal&oacute;n o Spa</label> 
      <input type="text" name="Nombre" value="" placeholder="" id="establecimiento"><br> 
      <input id="search" type="submit" value="Buscar"> 
     </div> 
    </form> 
   </div>
</body>
</html>