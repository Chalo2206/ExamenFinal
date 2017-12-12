<%-- 
    Document   : Empleado
    Created on : 22/11/2017, 06:03:06 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="../bootstrap/css/PerfilEmpleado.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="../Segemento/menu.jspf" %>
        <div id="cuadro">
            <div id="cabeza">Empleado</div>
            <div id="cuerpo">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputNombre" class="col-sm-2 control-label">Id Personal</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputNombre" placeholder="Nombre">
                        </div>                        
                    </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Nombre de Personal</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Genero</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Estado</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNombre" class="col-sm-2 control-label">DOB</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputNombre" placeholder=" ___/___/___">
                        </div>                        
                    </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Nombre del Padre</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>                
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Nombre de la Madre</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Direccion de los Parientes</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Direccion Temporal</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Correo</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Numero de Telefono</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Numero de Contacto</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Departamento</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                         <label for="inputType" class="col-sm-2 control-label">Fecha de Inscripcion</label>
                         <div class="styled-select slate col-sm-10">
                              <input type="date" name="fecha" placeholder="Fecha">
                         </div>
                     </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Años de Experiencia</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Calificacion</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCompa" class="col-sm-2 control-label">Designacion</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>                                
                            </select>                           
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputTelf" class="col-sm-2 control-label">Salario</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTelf" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">   
                            <button id="btnNuevo" type="submit" class="btn btn-default" >Nuevo</button>
                            <button id="btnRegis" type="submit" class="btn btn-default" >Guardar</button>
                            <button id="btnBorrar" type="submit" class="btn btn-default" >Eliminar</button>
                            <button id="btnModif" type="submit" class="btn btn-default" >Modificar</button>
                            <button id="btnDatos" type="submit" class="btn btn-default" >Optener Datos</button>
                        </div>                        
                    </div>                    
                </form>
            </div>
        </div>
    </body>
</html>
