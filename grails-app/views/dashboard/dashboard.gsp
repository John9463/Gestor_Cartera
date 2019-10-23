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
        <a class="nav-link disabled" onclick="changeView('poliza')">Disabled</a>
      </li>
    </ul>
  </div>
</nav>



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
