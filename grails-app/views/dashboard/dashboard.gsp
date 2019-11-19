<!DOCTYPE html>
<html lang="en">

<head>
  <title>Gestor Cartera - Inicio</title>
  <asset:stylesheet src="application.css"/>
</head>


<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Cartera</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" onclick="changeView('poliza')">Polizas<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" onclick="changeView('cliente')">Clientes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" onclick="changeView('seguro')">Seguro</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" onclick="changeView('poliza')">Reportes</a>
      </li>
    </ul>
  </div>
</nav>

  <div class="alert alert-success" role="alert">
    <h4 class="alert-heading">Well done!</h4>
      <p>Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.</p>
      <hr>
    <p class="mb-0">status: ok.</p>
  </div>


  <button onclick="show()">show alert</button>

<iframe id="frame" src="/poliza" width="100%" height="90%"></iframe>



<asset:javascript src="application.js"/>
<script>
function changeView(view){
  console.log(view)
  var frame = document.getElementById('frame')
  frame.src = '/'+view+'/index'
}
</script>
</body>

</html>
