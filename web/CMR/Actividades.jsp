<%-- 
    Document   : Actividades
    Created on : 22/11/2017, 06:05:19 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividades</title>
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../bootstrap/css/PerlfilActividades.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="Contenedor">
          <%@include file="../Segemento/menu.jspf" %>
            <section Id="Lista">
              <article Id="Columna">
                <div id="cuadro">
                    <div id="cabeza">Actividades</div>
                    <div id="cuerpo">
                        <form class="form-horizontal">
                            <div class="form-group">
                                 <label for="inputType" class="col-sm-2 control-label">Datos de actividades</label>
                                 <div class="styled-select slate col-sm-10">
                                 <input type="date" name="fecha" placeholder="Fecha">
                                 </div>
                            </div>
                            <div class="form-group">
                                <label for="inputCompa" class="col-sm-2 control-label">Id De Contacto</label>
                                <div class="styled-select slate col-sm-10" >
                                    <select>
                                        <option value="Selecionar">Selecionar</option>                                
                                    </select>                           
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputNombre" class="col-sm-2 control-label">Nombre de Contacto</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputNombre" placeholder="Nombre">
                                </div>                        
                            </div>
                            <div class="form-group">
                                <label for="inputCompa" class="col-sm-2 control-label">Asignado a</label>
                                <div class="styled-select slate col-sm-10" >
                                    <select>
                                        <option value="Selecionar">Selecionar</option>                                
                                    </select>                           
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputCompa" class="col-sm-2 control-label">Tipo De Actividad</label>
                                <div class="styled-select slate col-sm-10" >
                                    <select>
                                        <option value="Selecionar">Selecionar</option>                                
                                    </select>                           
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputCompa" class="col-sm-2 control-label">Estado de La Actividad</label>
                                <div class="styled-select slate col-sm-10" >
                                    <select>
                                        <option value="Selecionar">Selecionar</option>                                
                                    </select>                           
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputNombre" class="col-sm-2 control-label">Tema </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputNombre" placeholder="Nombre">
                                </div>                        
                            </div>
                            <div class="form-group">
                                <label for="inputNombre" class="col-sm-2 control-label">Notas </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputNombre" placeholder="Nombre">
                                </div>                        
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">   
                                    <button id="btnNuevo" type="submit" class="btn btn-default" >Nuevo</button>
                                    <button id="btnRegis" type="submit" class="btn btn-default" >Guardar</button>
                                    <button id="btnBorrar" type="submit" class="btn btn-default" >Modificar</button>
                                    <button id="btnModif" type="submit" class="btn btn-default" >Borrar</button>
                                    <button id="btnDatos" type="submit" class="btn btn-default" >Optener Datos</button>
                                </div>                        
                            </div>                    
                        </form>
                    </div>
                </div>
              </article>
          </section>
       </section>
    </body>
</html>
