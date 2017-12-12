<%-- 
    Document   : contactos
    Created on : 22/11/2017, 12:17:26 PM
    Author     : Chalo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contactos</title>
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../bootstrap/css/Cuadros.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../Segemento/menu.jspf" %>
        <div id="cuadro">
            <div id="cabeza">Contactos</div>
            <div id="cuerpo">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputNombre" class="col-sm-2 control-label">Nombre</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputNombre" placeholder="Nombre">
                        </div>                        
                    </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Nro Celular</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Compañia</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>   
                    <div class="form-group">
                        <label for="inputPostal" class="col-sm-2 control-label">Codigo Postal</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputPostal" placeholder="Codigo Postal">                            
                        </div>
                    </div> 
                    <div class="form-group">
                        <label for="inputCiudad" class="col-sm-2 control-label">Ciudad</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputCiudad" placeholder="Ciudad">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPais" class="col-sm-2 control-label">Pais</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="inputEstado" class="col-sm-2 control-label">Estado</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="inputTitulo" class="col-sm-2 control-label">Título</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="inputPapel" class="col-sm-2 control-label">Papel</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">   
                            <button id="btnNuevo" type="submit" class="btn btn-default" >Nuevo</button>
                            <button id="btnRegis" type="submit" class="btn btn-default" >Registrar</button>
                            <button id="btnBorrar" type="submit" class="btn btn-default" >Borrar</button>
                            <button id="btnModif" type="submit" class="btn btn-default" >Modificar</button>
                            <button id="btnDatos" type="submit" class="btn btn-default" >Datos</button>
                        </div>                        
                    </div>                    
                </form>
            </div>
        </div>        
    </body>
</html>
