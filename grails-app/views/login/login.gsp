<!doctype html>
<html lang="en" class="no-js">

<!------ Include the above in your HEAD tag ---------->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
      Gestor Cartera - Iniciar Sesiòn
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="login.css"/>

</head>

<body>
    <div class="container">
        <div class="row">
			<div class="col-md-5 mx-auto">
			<div id="first">
				<div class="myform form ">
					 <div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<h1>Bienvenidos a Gestor de Cartera | Iniciar Sesion</h1>
						 </div>
					</div>
               
                  <g:form controller="login" method="post" name="login">

                           <div class="form-group">
                              <label for="exampleInputEmail1">Email o Usuario: </label>
                              <input name="user" class="form-control" id="user" aria-describedby="emailHelp" placeholder="Enter email" required>
                           </div>

                           <div class="form-group">
                              <label for="exampleInputEmail1">Contraseña: </label>
                              <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Contraseña" required>
                           </div>
                        
                           <div class="col-md-12 text-center ">
                               <!-- <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Iniciar Sesión</button> -->
                               <%-- <g:link class=" btn btn-block mybtn btn-primary tx-tfm" params="[user: 'title', password:]" controller="login" action="logIn"> Iniciar Sesion </g:link > --%>
                              <g:actionSubmit value="Iniciar Sesion" action="check" />
                           </div>
                        
                           <div class="form-group">
                              <p class="text-center">Aun no tienes cuenta <a href="#" id="signup">¡Llamanos!</a></p>
                           </div>

                  </g:form>

                  <g:if test="${ flash.message }">
                     <p class="text-danger">${ flash.message }</p>
                  </g:if>
              
				</div>
			</div>
		</div>
      </div>


       <asset:javascript src="application.js"/>
       <asset:javascript src="login.js"/>
</body>
</html>