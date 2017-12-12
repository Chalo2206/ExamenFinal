<%-- 
    Document   : index
    Created on : 21/11/2017, 10:02:47 PM
    Author     : Chalo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema CRM</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="cuadro">
            <div id="cabeza">Login</div>
            <div id="cuerpo">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">User ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" placeholder="User ID">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>                
                        <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">   
                            <button id="btnEntrar" type="submit" class="btn btn-success pull-right" >Entrar</button> 
                        </div>                        
                    </div>
                </form>
            </div>
        </div>        
    </body>
</html>
