<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Gestor Cartera"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>

<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Cartera - ${session.permissions.domain.endsWith('_admin') ? 'Admin' : session.permissions.domain }</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <g:each var="module" in="${ session.permissions.modules }">  
          <li class="active button">
            <a class="nav-link" href="/${module}/index">${module.capitalize()}<span class="sr-only">(current)</span></a>
          </li>
      </g:each>
          <li class="nav-item active">
            <a class="nav-link" onclick="logOut()">Cerrar Sesion</a>
          </li>
    </ul>
    
  </div>
</nav>

    <g:if test="${ flash.message  }">
   
      <div class="alert ${flash.alert} alert-dismissible fade show" role="alert">
        <strong>${flash.target}</strong> ${flash.message}.
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    </g:if>

<asset:javascript src="application.js"/>
<g:layoutBody/>
</body>
</html>
