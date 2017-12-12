
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="../bootstrap/css/PerfilCliente.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="../Segemento/menu.jspf" %>
     <section id="Contenedor">        
         <section Id="Lista">
                <article Id="Columna1">
                <!--INICIO DE CUADRO 1-->
                     <div id="cuadro">
                          <div id="cabeza">Clientes</div>
                           <div id="cuerpo">
                               <from class="form-horizontal">
                                   <div class="form-group">
                                       <label for="inputUserId" class="col-sm-2 control-label">Id Cliente</label>
                                       <div class="col-sm-10">
                                           <input type="text" class="form-control" id="inputUserId" placeholder="Id Cliente">
                                       </div>             
                                   </div>
                                   <div class="form-group">
                                       <label for="inputName" class="col-sm-2 control-label">Nombres</label>
                                       <div class="col-sm-10">
                                           <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                       </div>
                                   </div>
                                   <div class="form-group">
                                       <label for="inputName" class="col-sm-2 control-label">Apellidos</label>
                                       <div class="col-sm-10">
                                           <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                       </div>
                                   </div>
                                   <div class="form-group">
                                       <label for="inputType" class="col-sm-2 control-label">Tipo de Cliente</label>
                                       <div class="styled-select slate col-sm-10" >
                                           <select>
                                               <option value="Selecionar">Corredor</option>
                                               <option value="Administardor">Individual</option>
                                               <option value="Operador">Compañia</option>  
                                           </select>
                                       </div>
                                    </div>
                               </from>
                           </div>     

                      </div>
             <!--INICIO DE CUADRO2-->
               <div id="cuadro">
               <div id="cabeza">Direccion de Casa</div>
               <div id="cuerpo">
                   <from class="form-horizontal">
                       <div class="form-group">
                           <label for="inputName" class="col-sm-2 control-label">Calle</label>
                           <div class="col-sm-10">
                               <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                           </div>
                       </div>
                       <div class="form-group">
                           <label for="inputName" class="col-sm-2 control-label">Ciudad</label>
                           <div class="col-sm-10">
                               <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                           </div>
                       </div>
                       <div class="form-group">
                           <label for="inputType" class="col-sm-2 control-label">Pais/Region</label>
                           <div class="styled-select slate col-sm-10" >
                               <select>
                                   <option value="Selecionar">Afganistan</option>
                                   <option value="Administardor">Albania</option>
                                   <option value="Operador">American Samoa</option>
                                   <option value="Operador">Andorra</option>
                                   <option value="Operador">Angola</option>
                                   <option value="Operador">Anguilla</option>
                                   <option value="Operador">Antarctica</option>
                                   <option value="Operador">Antigua</option>
                                   <option value="Operador">Argentina</option>
                                   <option value="Operador">Armenia</option>
                                   <option value="Operador">Aruba</option>
                                   <option value="Operador">Ascension</option>
                                   <option value="Operador">Australia</option>
                                   <option value="Operador">Australian External Territories</option>
                                   <option value="Operador">Austria</option>
                                   <option value="Operador">Azerbaijan</option>
                                   <option value="Operador">Bahamas</option>
                                   <option value="Operador">Baharain</option>
                                   <option value="Operador">Bangladesh</option>
                                   <option value="Operador">Barbados</option>
                                   <option value="Operador">Barbuda</option>
                                   <option value="Operador">Belarus</option>
                                   <option value="Operador">Belgium</option>
                                   <option value="Operador">Belize</option>
                                   <option value="Operador">Benin</option>
                                   <option value="Operador">Bermuda</option>
                                   <option value="Operador">Bhutan</option>
                                   <option value="Operador">Bolivia</option>
                                   <option value="Operador">Bosnia&Herzegovina</option>
                                   <option value="Operador">Botswana</option>
                                   <option value="Operador">Brazil</option>
                                   <option value="Operador">British Virgin islands</option>
                                   <option value="Operador">Brunei Darussalam</option>
                                   <option value="Operador">Bulgaria</option>
                                   <option value="Operador">Burkina Faso</option>
                                   <option value="Operador">Burundi</option>
                                   <option value="Operador">Cambodia</option>
                                   <option value="Operador">Cameroon</option>
                               </select>
                           </div>
                       </div>
                           <div class="form-group">
                           <label for="inputType" class="col-sm-2 control-label">Estado/ Provincia</label>
                           <div class="styled-select slate col-sm-10" >
                               <select>
                                   <option value="Selecionar"> </option>
                               </select>
                           </div>
                           </div>

                           <div class="form-group">
                           <label for="inputName" class="col-sm-2 control-label">Codigo Postal</label>
                           <div class="col-sm-10">
                               <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                           </div>
                           </div>                    
                   </from>                
               </div>
             </div>
                <!--INICIO DE CUADRO-->
                   <div id="cuadro">
                       <div id="cabeza">Ciudad De Trabajo</div>
                       <div id="cuerpo">
                           <from class="form-horizontal">
                               <div class="form-group">
                                   <label for="inputName" class="col-sm-2 control-label">Calle</label>
                                   <div class="col-sm-10">
                                       <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label for="inputName" class="col-sm-2 control-label">Ciudad</label>
                                   <div class="col-sm-10">
                                       <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label for="inputType" class="col-sm-2 control-label">Pais/Region</label>
                                   <div class="styled-select slate col-sm-10" >
                                       <select>
                                           <option value="Selecionar">Afganistan</option>
                                           <option value="Administardor">Albania</option>
                                           <option value="Operador">American Samoa</option>
                                           <option value="Operador">Andorra</option>
                                           <option value="Operador">Angola</option>
                                           <option value="Operador">Anguilla</option>
                                           <option value="Operador">Antarctica</option>
                                           <option value="Operador">Antigua</option>
                                           <option value="Operador">Argentina</option>
                                           <option value="Operador">Armenia</option>
                                           <option value="Operador">Aruba</option>
                                           <option value="Operador">Ascension</option>
                                           <option value="Operador">Australia</option>
                                           <option value="Operador">Australian External Territories</option>
                                           <option value="Operador">Austria</option>
                                           <option value="Operador">Azerbaijan</option>
                                           <option value="Operador">Bahamas</option>
                                           <option value="Operador">Baharain</option>
                                           <option value="Operador">Bangladesh</option>
                                           <option value="Operador">Barbados</option>
                                           <option value="Operador">Barbuda</option>
                                           <option value="Operador">Belarus</option>
                                           <option value="Operador">Belgium</option>
                                           <option value="Operador">Belize</option>
                                           <option value="Operador">Benin</option>
                                           <option value="Operador">Bermuda</option>
                                           <option value="Operador">Bhutan</option>
                                           <option value="Operador">Bolivia</option>
                                           <option value="Operador">Bosnia&Herzegovina</option>
                                           <option value="Operador">Botswana</option>
                                           <option value="Operador">Brazil</option>
                                           <option value="Operador">British Virgin islands</option>
                                           <option value="Operador">Brunei Darussalam</option>
                                           <option value="Operador">Bulgaria</option>
                                           <option value="Operador">Burkina Faso</option>
                                           <option value="Operador">Burundi</option>
                                           <option value="Operador">Cambodia</option>
                                           <option value="Operador">Cameroon</option>
                                       </select>
                                   </div>
                               </div>
                                   <div class="form-group">
                                   <label for="inputType" class="col-sm-2 control-label">Estado/ Provincia</label>
                                   <div class="styled-select slate col-sm-10" >
                                       <select>
                                           <option value="Selecionar"> </option>
                                       </select>
                                   </div>
                                   </div>

                                   <div class="form-group">
                                   <label for="inputName" class="col-sm-2 control-label">Codigo Postal</label>
                                   <div class="col-sm-10">
                                       <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                   </div>
                                   </div>                    
                           </from>                
                       </div>            
                   </div>
                </article>
          </section>
         <!--INICIO DE CUADR0 SEGUNSA COLUMNA-->
         <section Id="Lista2">
             <!--primer cuadro -->
                <article id="Columna2">
                    <div id="cuadro">
                              <div id="cabeza">identificar información</div>
                               <div id="cuerpo">
                                   <from class="form-horizontal">

                                       <div class="form-group">
                                           <label for="inputName" class="col-sm-2 control-label">Nro ID´s</label>
                                           <div class="col-sm-10">
                                               <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">Fecha de caducidad de ID´s</label>
                                           <div class="styled-select slate col-sm-10">
                                               <input type="date" name="fecha" placeholder="Fecha">

                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">ID´s emitido por el pais</label>
                                           <div class="styled-select slate col-sm-10" >
                                               <select>
                                                    <option value="Selecionar">Afganistan</option>
                                                    <option value="Administardor">Albania</option>
                                                    <option value="Operador">American Samoa</option>
                                                    <option value="Operador">Andorra</option>
                                                    <option value="Operador">Angola</option>
                                                    <option value="Operador">Anguilla</option>
                                                    <option value="Operador">Antarctica</option>
                                                    <option value="Operador">Antigua</option>
                                                    <option value="Operador">Argentina</option>
                                               </select>
                                           </div>
                                        </div>
                                   </from>
                               </div>     
                    </div>
                </article>
             <!--segundo cuadro-->
                <article>              
                    <div id="cuadro">
                             <div id="cabeza">Informacion de contacto</div>
                              <div id="cuerpo">
                                  <from class="form-horizontal">
                                      <div class="form-group">
                                          <label for="inputUserId" class="col-sm-2 control-label">Nro de telefono</label>
                                          <div class="col-sm-10">
                                              <input type="text" class="form-control" id="inputUserId" placeholder="Id Cliente">
                                          </div>             
                                      </div>
                                      <div class="form-group">
                                          <label for="inputName" class="col-sm-2 control-label">Nro de Celular</label>
                                          <div class="col-sm-10">
                                              <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="inputName" class="col-sm-2 control-label">Nro de Fax</label>
                                          <div class="col-sm-10">
                                              <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="inputType" class="col-sm-2 control-label">Correo</label>
                                          <div class="col-sm-10">
                                              <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                          </div>
                                       </div>
                                  </from>
                              </div> 
                    </div>
                </article>
              <!--tercer cuadro-->
                <artcle>
                    <div id="cuadro">
                              <div id="cabeza">Otra Informacion</div>
                               <div id="cuerpo">
                                   <from class="form-horizontal">
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">Area de interes</label>
                                           <div class="styled-select slate col-sm-10">
                                               <select>
                                                   <option value="Selecionar"> </option>
                                                   <option value="11/12/13">material basico</option>
                                                   <option value="Selecionar">Ciclo del consumidor</option>
                                                   <option value="Selecionar">Ciudad real</option>
                                               </select>

                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">Cliente Oficial</label>
                                           <div class="styled-select slate col-sm-10" >
                                               <select>
                                                    <option value="Selecionar"> </option>
                                                    <option value="Selecionar">Material basico</option>
                                                    <option value="Selecionar">ciclo del consumidor</option>
                                                    <option value="Selecionar">Servicio Final</option>                                                                                                   
                                               </select>
                                           </div>
                                        </div>
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">Directores</label>
                                           <div class="styled-select slate col-sm-10" >
                                               <select>
                                                    <option value="Selecionar"> </option>
                                                    <option value="Selecionar">Juan</option>
                                                    <option value="Selecionar">Hector</option>
                                                    <option value="Selecionar">Manuel</option> 
                                                    <option value="Selecionar">Cayo</option> 
                                               </select>
                                           </div>
                                        </div>
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">Secretario</label>
                                           <div class="styled-select slate col-sm-10" >
                                               <select>
                                                    <option value="Selecionar"> </option>
                                                    <option value="Selecionar">Carlos</option>
                                                    <option value="Selecionar">Paola</option>
                                                    <option value="Selecionar">Angela</option> 
                                                    <option value="Selecionar">Micheal</option> 
                                               </select>
                                           </div>
                                        </div>
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">Categorizacion</label>
                                           <div class="styled-select slate col-sm-10" >
                                               <select>
                                                    <option value="Selecionar"> </option>
                                                    <option value="Selecionar">Riesgo Minimo</option>
                                                    <option value="Selecionar">Riesgo Mediano</option>
                                                    <option value="Selecionar">Riesgo Normal</option>                                                     
                                               </select>
                                           </div>
                                        </div>
                                       <div class="form-group">
                                           <label for="inputType" class="col-sm-2 control-label">Propietario beneficiado</label>
                                           <div class="styled-select slate col-sm-10" >
                                               <select>
                                                    <option value="Selecionar"> </option>
                                                    <option value="Selecionar">Juan</option>
                                                    <option value="Selecionar">Hector</option>
                                                    <option value="Selecionar">Manuel</option> 
                                                    <option value="Selecionar">Cayo</option>                                                     
                                               </select>
                                           </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputName" class="col-sm-2 control-label">Dinero Comprometido</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="inputName" placeholder="Nombre">
                                            </div>
                                        </div>
                                   </from>
                               </div>     
                    </div>
                </artcle>
         </section>
     </section>
    </body>
</html>
