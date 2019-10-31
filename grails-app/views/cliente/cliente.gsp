<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
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

<div id="London" class="tabcontent">
  <button onclick="show('add')"><i class="far fa-plus-square">Crear Cliente</i></button>
  <table class="table table-striped">
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
        <td>${cliente.nombre}</td>
        <td>${cliente.correo}</td>
        <td>${cliente.ciudad}</td>
        <td><button onclick="edit(${cliente.id})"><i class="fas fa-edit">Editar</i></button> <button type="button" data-toggle="modal" data-target="#myModal" onclick="previusDelete(${cliente.id})"><i class="far fa-trash-alt">Borrar</i> </button> </td>
      </tr>
    </tbody>
    </g:each>
  </table>
</div>

<div id="Paris" class="tabcontent">
  <g:form controller="cliente" action="save" class="was-validated" name="form-cliente">

      <div class="form-group">
        <div class="row pt-4">

          <div class="col-4">
            <label for="uname">CORREO ELECTRONICO:</label>
            <input type="email" class="form-control" id="uname" placeholder="Ejemplo: example@mail.com" name="correo" maxlenght="5" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-4">
            <label for="uname">FECHA DE NACIMIENTO:</label>
            <input type="date" class="form-control" id="uname" placeholder="Ejemplo: 1020" name="fechaNac" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-4">
            <label for="pwd">NOMBRE:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: juan barreras" name="nombre" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        </div>
        <div class="row pt-4">
          <div class="col-6">
              <label for="pwd">APELLIDO PATERNO:</label>
              <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: vargas" name="apellPa" required>
              <div class="valid-feedback">Correcto.</div>
              <div class="invalid-feedback">El campo es requerido.</div>
            </div>

            <div class="col-6">
              <label for="pwd">APELLIDO MATERNO:</label>
              <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: contreras" name="apellMa" required>
              <div class="valid-feedback">Correcto.</div>
              <div class="invalid-feedback">El campo es requerido.</div>
            </div>
          </div>
      </div>


      
        <div class="row pt-4">

          <div class="col-6">
            <label for="pwd">CIUDAD:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: Toluca" name="ciudad" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-6">
            <label for="pwd">RFC:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: 147" name="rfc" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        </div>
     

      
     
        <div class="row pt-4">

          <div class="col-sm-4">
            <label for="pwd">COLONIA:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: $15.50" name="colonia" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-sm-4">
            <label for="pwd">CALLE:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: Av. Dependencia" name="calle" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-sm-4">
            <label for="pwd">CODIGO POSTAL:</label>
            <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: 50100" name="cp" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        </div>
     
      <div class="row pt-4">

          <div class="col-12">
            <label for="pwd">TIPO:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: afore" name="tipo" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        <input type="number" class="form-control" id="id" name="id" hidden>

        </div>

<div class="row pt-4">
        <div class="col-6">
        <label for="pwd">NUMEROS:</label>
        <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: 2000" name="numeros" required>
        <div class="valid-feedback">Correcto.</div>
        <div class="invalid-feedback">El campo es requerido.</div>
        </div>

        <div class="col-6">
        <label for="pwd">TELEFONO CELULAR:</label>
        <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: 7291586478" name="tel" required>
        <div class="valid-feedback">Correcto.</div>
        <div class="invalid-feedback">El campo es requerido.</div>
        </div>
   
      <div class="col-12 pt-4">

      
    <button type="submit" class="btn btn-primary">Guardar</button>
     </div>
      </div>
      </div>
</g:form>




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


  <asset:javascript src="application.js" />
  <asset:javascript src="cliente.js" />
</body>

</html>