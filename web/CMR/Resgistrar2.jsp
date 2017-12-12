<%-- 
    Document   : Resgistrar2
    Created on : 07-dic-2017, 17:16:09
    Author     : UserPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Record De Usuarios Registrados</title>
        <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/bootstrap/css/PerfilRegistrar2.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="Contenedor">
            <div id="cuadro">
                <div id="cabeza">Registrar Usuarios 2</div>
                <div id="cuerpo">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputType" class="col-sm-2 control-label">Tipos De Usuario</label>
                            <div class="styled-select slate col-sm-10" >
                                <select>
                                    <option value="Selecionar">Administrador</option>
                                    <option value="Selecionar">Operador</option>
                                </select>
                            </div>
                        </div> 
                        <!---
                        Diseño de Tabla
                        --->                       
                        <table id="tabla" class="table">
                            <thead>
                            <th>Tipo de Usuario</th>
                            <th>Id de Usuario</th>
                            <th>Contraseña</th>
                            <th>Nombre</th>
                            <th>Nro de Contacto</th>
                            <th>Correo</th>
                            <th>Fecha De Inscripcion</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td>
                                            ${user.usertype}                                            
                                        </td>
                                        <td>
                                            ${user.userID}                                            
                                        </td>
                                        <td>
                                            ${user.password}
                                        </td>
                                        <td>
                                            ${user.name}                                            
                                        </td>
                                        <td>
                                            ${user.contactNo}                                            
                                        </td>
                                        <td>
                                            ${user.email}                                           
                                        </td>
                                        <td>
                                            ${user.dateofjoining}
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </section> 
    </body>
</html>
