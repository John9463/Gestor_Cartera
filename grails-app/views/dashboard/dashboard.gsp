<html lang="en">

<head>
  <title>Gestor Cartera - Inicio</title>
  <meta name="" content="">
  <asset:stylesheet src="application.css"/>
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
            <a class="nav-link" onclick="changeView('${module}')">${module.capitalize()}<span class="sr-only">(current)</span></a>
          </li>
      </g:each>
          <li class="nav-item active">
            <a class="nav-link" onclick="logOut()">Cerrar Sesion</a>
          </li>
    </ul>
    
  </div>
</nav>

<g:if test="${ flash.show  }">
   
    <div class="alert ${flash.alert}" role="alert">
      <h4 class="alert-heading">${flash.header}</h4>
        <p>${flash.message}</p>
        <hr>
      <p class="mb-0">status: ok.</p>
    </div>

</g:if>

  

<iframe id="frame" src="/poliza" width="100%" height="90%"></iframe>



<asset:javascript src="application.js"/>
<script>

function changeView(view){
  var frame = document.getElementById('frame')
  frame.src = '/'+view+'/index'
}

function logOut(){
  console.log('log out')
  fetch('/login/logout').
  then(response => window.location.href = "/" )
}
</script>
</body>

</html>
