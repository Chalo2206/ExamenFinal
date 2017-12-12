<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros</title>
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../bootstrap/css/Cuadros.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="Contenedor">
        <%@include file="../Segemento/menu.jspf" %>
        <div id="cuadro">
            <div id="cabeza">Registración</div>
            <div id="cuerpo">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputUserId" class="col-sm-2 control-label">User ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserId" placeholder="User ID">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputName" class="col-sm-2 control-label">Nombre</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputType" class="col-sm-2 control-label">Tipo de Usuario</label>
                        <div class="styled-select slate col-sm-10" >
                            <select>
                                <option value="Selecionar">Selecionar</option>
                                <option value="Administardor">Administardor</option>
                                <option value="Operador">Operador</option>
                                <option value="Libre">Libre</option>
                                <option value="Oficina">Oficina</option>
                            </select>
                        </div>
                    </div>   
                    <div class="form-group">
                        <label for="inputPass" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputPass" placeholder="Password">
                        </div>
                    </div> 
                    <div class="form-group">
                        <label for="inputTele" class="col-sm-2 control-label">Nro Celular</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputTele" placeholder="Nro Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail" placeholder="Example@example.com">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">   
                            <button id="btnNuevo" type="submit" class="btn btn-default" >Nuevo</button>
                            <button id="btnRegis" type="submit" class="btn btn-default" >Registrar</button>
                            <button id="btnBorrar" type="submit" class="btn btn-default" >Borrar</button>
                            <button id="btnModif" type="submit" class="btn btn-default" >Modificar</button>
                            <button id="btnDatos" type="submit" class="btn btn-default" >Datos</button>
                            <a href="/CRM/ServlertRegistro" class="btn btn-primary">Datos</a>
                        </div>                        
                    </div>                    
                </form>
            </div>
        </div>
     </section>        
   </body>
</html>
