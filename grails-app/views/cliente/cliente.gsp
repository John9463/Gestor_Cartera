<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="layout" content="theme">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<asset:stylesheet src="application.css"/>

</head>

<body>

<%-- <h2>Vertical Tabs</h2>
<p>Click on the buttons inside the tabbed menu:</p> --%>

<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'London')" id="defaultOpen">Lista Clientes</button>
  <button id="add-mod" class="tablinks" onclick="openTab(event, 'Paris')" hidden>Crear Clientes</button>
</div>

<input type="text" id="filter-value" onkeyup="filter()" placeholder="Buscar por nombre.." title="Type in a name">

<div id="London" class="tabcontent">
  <button onclick="show('add')"><i class="far fa-plus-square">Crear Cliente</i></button>
    <table id="table" class="table table-striped">
      <thead>
        <tr>
          <th>Cliente</th>
          <th>Nombre</th>
          <th>Email</th>
          <th>Ciudad</th>
          <th>Acciones</th>
        </tr>
      </thead>

      <g:each var="cliente" in="${ clientes }">
        <tbody>
          <tr>
            <td>${cliente.id}</td>
            <td>${cliente.usuario.nombre}</td>
            <td>${cliente.usuario.correo}</td>
            <td>${cliente.usuario.ciudad}</td>
            <td><button onclick="edit(${cliente.id})"><i class="fas fa-edit">Editar</i></button> <button type="button" data-toggle="modal" data-target="#myModal" onclick="previusDelete(${cliente.id})"><i class="far fa-trash-alt">Borrar</i> </button> </td>
          </tr>
        </tbody>
      </g:each>

    </table>
</div>

<div id="Paris" class="tabcontent">
  <g:form controller="cliente" class="was-validated" name="form-cliente">
    <div class="form-group">

      <div class="row pt-4">
          <div class="col-4">
            <label for="pwd">NOMBRE:</label>
            <input type="text" class="form-control"  placeholder="Ejemplo: juan barreras" name="nombre" required>
          </div>

          <div class="col-4">
              <label for="pwd">APELLIDO PATERNO:</label>
              <input type="text" class="form-control"  placeholder="Ejemplo: vargas" name="apellPa" required>
            </div>

            <div class="col-4">
              <label for="pwd">APELLIDO MATERNO:</label>
              <input type="text" class="form-control"  placeholder="Ejemplo: contreras" name="apellMa" required>
            </div>
          </div>
      </div>

      <div class="row pt-4">

        <div class="col-4">
          <label for="uname">CORREO ELECTRONICO:</label>
          <input type="email" class="form-control"  placeholder="Ejemplo: example@mail.com" name="correo" maxlenght="5" required>
        </div>

        <div class="col-4">
          <label for="uname">FECHA DE NACIMIENTO:</label>
          <input type="date" class="form-control"  placeholder="Ejemplo: 1020" name="fechaNac" required>
        </div>

        <div class="col-4">
          <label for="pwd">RFC:</label>
          <input type="text" class="form-control"  placeholder="Ejemplo: 147" name="rfc" required>
        </div>

      </div>
      
      <div class="row pt-4">

        <div class="col-4">
          <label for="pwd">CIUDAD:</label>
          <input type="text" class="form-control"  placeholder="Ejemplo: Toluca" name="ciudad" required>
        </div>

        <div class="col-sm-4">
          <label for="pwd">COLONIA:</label>
          <input type="text" class="form-control"  placeholder="Ejemplo: $15.50" name="colonia" required>
        </div>

        <div class="col-sm-4">
          <label for="pwd">CALLE:</label>
          <input type="text" class="form-control"  placeholder="Ejemplo: Av. Dependencia" name="calle" required>
        </div>

      </div>
     
      <div class="row pt-4">

        <div class="col-4">
          <label for="pwd">NO. CASA:</label>
          <input type="number" class="form-control"  placeholder="Ejemplo: 2000" name="noCasa" required>
        </div>

        <div class="col-sm-4">
          <label for="pwd">CODIGO POSTAL:</label>
          <input type="number" class="form-control"  placeholder="Ejemplo: 50100" name="cp" required>
        </div>

        <div class="col-4">
          <label for="pwd">TELEFONO CELULAR:</label>
          <input type="number" class="form-control"  placeholder="Ejemplo: 7291586478" name="tel" required>
        </div>

      </div>
     
      <div class="row pt-4">

        <div class="col-5">
          <label for="pwd">Clave de Usuario:</label>
          <input type="text" class="form-control" name="clave" required />
        </div>

        <div class="col-5">
          <label for="pwd">Usuario integral:</label>
            <input type="checkbox" class="form-control"  placeholder="Ejemplo: 7291586478" name="isIntegral">
        </div>
        <%-- ID --%>
        <input type="number" class="form-control" id="id" name="id" hidden>

      </div>
    
      <div class="row pt-4">
            <div class="col-4">
              <label for="pwd">Username:</label>
              <input type="text" class="form-control"  placeholder="Ejemplo: 2000" name="username" required>
            </div>

            <div class="col-4">
              <label for="pwd">Password:</label>
              <input type="password" class="form-control" id="password" placeholder="Ejemplo: 7291586478" name="password" required>
            </div>

            <div class="col-4">
              <label for="pwd">Confirmacion Password:</label>
              <input type="password" class="form-control"  placeholder="Ejemplo: 7291586478" name="passwordConfirm" required>
            </div>
      <div>   

    </div>
    
    <g:actionSubmit class="btn btn-primary" value="Guardar" action="save" />
  
  </g:form>
</div>


<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Confirmacion Baja de Poliza</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <b>¿Estas seguro que deseas eliminar la poliza?</b>
        <br>
        <span>Esta accion no puede deshacerse una vez ejecutada. </span>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="deletePoliza()">Confirmar</button>
      </div>

    </div>
  </div>
</div>
<!-- The Modal -->

  <asset:javascript src="cliente.js" />
</body>

</html>