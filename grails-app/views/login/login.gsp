<!doctype html>
<html lang="en" class="no-js">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
      <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

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
                   <g:form controller="login" action="" method="post" name="login">
                           <div class="form-group">
                              <label for="exampleInputEmail1">Email o Usuario: </label>
                              <input name="user" class="form-control" id="user" aria-describedby="emailHelp" placeholder="Enter email">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Contraseña: </label>
                              <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                           </div>
                        
                           <div class="col-md-12 text-center ">
                               <!-- <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Iniciar Sesión</button> -->
                               <%-- <g:link class=" btn btn-block mybtn btn-primary tx-tfm" params="[user: 'title', password:]" controller="login" action="logIn"> Iniciar Sesion </g:link > --%>
                              <g:actionSubmit value="Iniciar Sesion" action="logIn"/>
                           </div>
                           <div class="form-group">
                              <p class="text-center">Don't have account? <a href="#" id="signup">Sign up here</a></p>
                           </div>
                        </g:form>
               <g:if test="${ error  == 'not-data'}">
                  <p class="text-danger"> Ingresa un Usuario y Contraseña para continuar</p>
               </g:if>
               <g:elseif test="${ error == 'not-user'}">
                  <p class="text-warning">Ingresa un usuario para continuar</p>
               </g:elseif>
               <g:elseif test="${ error == 'not-pass'}">
                  <p class="text-warning">Ingresa una contraseña para continuar</p>
               </g:elseif>
				</div>
			</div>
		
		</div>
      </div>

       <asset:javascript src="application.js"/>
       <asset:javascript src="login.js"/>

</body>
</html>