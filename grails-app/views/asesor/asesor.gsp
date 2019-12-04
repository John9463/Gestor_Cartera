<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="layout" content="theme">
<asset:stylesheet src="application.css"/>

</head>

<body>

<%-- <h2>Vertical Tabs</h2>
<p>Click on the buttons inside the tabbed menu:</p> --%>

<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'London')" id="defaultOpen">Lista Asesor</button>
  <button id="add-mod" class="tablinks" onclick="openTab(event, 'Paris')" hidden>Crear Asesor</button>
</div>

<input type="text" id="filter-value" onkeyup="filter()" placeholder="Buscar por nombre.." title="Type in a name">

<div id="London" class="tabcontent">
  <button class="btn btn-success" onclick="show('add')"><i class="far fa-plus-square">Crear Asesor</i></button>
  <button class="btn btn-primary" href="/#">Reporte</button>
  <table id="table" class="table table-striped">
    <thead>
      <tr>
        <th>Asesor id</th>
        <th>Homoclave</th>
        <th>Tipo</th>
        <th>Admin</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <g:each var="asesor" in="${ asesores }">
    <tbody>
      <tr>
        <td>${asesor.id}</td>
        <td>${asesor.homoclave}</td>
        <td>${asesor.tipoAsesor}</td>
        <td>${asesor.isAdmin}</td>
        <td>
        <button class="btn btn-danger" onclick="edit('${asesor.id}')"><i class="fas fa-edit">Editar</i></button>
         <button class="btn btn-warning" data-toggle="modal" data-target="#myModal" onclick="previusDelete('${asesor.id}')"><i class="far fa-trash-alt">Borrar</i> </button> </td>
      </tr>
    </tbody>
    </g:each>
  </table>
</div>

<div id="Paris" class="tabcontent">
  <g:form controller="Asesor" action="save" class="was-validated" name="form-asesor">
    <div class="form-group">
      
        <div class="row pt-4">

            <div class="col-4">
              <label for="pwd">Nombre:</label>
              <input type="text" class="form-control"  placeholder="Ejemplo: juan barreras" name="nombre" required>
            </div>

            <div class="col-4">
              <label for="pwd">Apellido Paterno:</label>
              <input type="text" class="form-control"  placeholder="Ejemplo: vargas" name="apellPa" required>
            </div>

            <div class="col-4">
              <label for="pwd">Apellido Materno:</label>
              <input type="text" class="form-control"  placeholder="Ejemplo: contreras" name="apellMa" required>
            </div>

        </div>
      
        <div class="row pt-4">

          <div class="col-4">
            <label for="pwd">Ciudad:</label>
            <input type="text" class="form-control"  placeholder="Ejemplo: Toluca" name="ciudad" required>
          </div>

          <div class="col-4">
            <label for="pwd">RFC:</label>
            <input type="text" class="form-control"  placeholder="Ejemplo: 147" name="rfc" required>
          </div>

          <div class="col-4">
            <label for="pwd">Homoclave:</label>
            <input type="text" class="form-control" name="homoclave" required>
          </div>

        </div>
     
        <div class="row pt-4">

          <div class="col-sm-4">
            <label for="pwd">Colonia:</label>
            <input type="text" class="form-control"  placeholder="Ejemplo: $15.50" name="colonia" required>
          </div>

          <div class="col-sm-4">
            <label for="pwd">Calle:</label>
            <input type="text" class="form-control"  placeholder="Ejemplo: Av. Dependencia" name="calle" required>
          </div>

          <div class="col-sm-4">
            <label for="pwd">Codigo Postal:</label>
            <input type="number" class="form-control"  placeholder="Ejemplo: 50100" name="cp" required>
          </div>

        </div>
     
            
        <div class="row pt-4">

          <div class="col-4">
            <label for="uname">Fecha de nacimiento:</label>
            <input type="date" class="form-control"  placeholder="Ejemplo: 1020" name="fechaNac" required>
          </div>

          <div class="col-4">
            <label for="pwd">Tipo:</label><br>
            <select name="tipoAsesor">
                <option>Seleccione un tipo</option>
              <g:each var="tipo" in="${tipos}">
                <option>${tipo}</option>
              </g:each>
            </select>
          </div>

          <div class="col-3">
              <label for="pwd">Administrador:</label><br>
              <input type="checkbox" class="form-control" name="isAdmin">
          </div>


        </div>

        <div class="row pt-2">
            <div class="col-4">
                <label for="pwd">NO. Casa:</label>
                <input type="number" class="form-control"  placeholder="Ejemplo: 2000" name="noCasa" required>
            </div>

            <div class="col-4">
                <label for="pwd">Telefono Celular:</label>
                <input type="number" class="form-control"  placeholder="Ejemplo: 7291586478" name="tel" required>
            </div>

        </div>
    
        <div class="row pt-4">
            
            <div class="col-4">
              <label for="uname">Correo Electronico:</label>
              <input type="email" class="form-control"  placeholder="Ejemplo: example@mail.com" name="correo" maxlenght="5" required>
            </div>

            <div class="col-4">
                <label for="pwd">Username:</label>
                <input type="text" class="form-control"  placeholder="Ejemplo: 2000" name="username" required>
            </div>

            <div class="col-4">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control"  placeholder="Ejemplo: 7291586478" name="password" required>
            </div>

            <div class="col-4">
              <label for="pwd">Confirmacion Password:</label>
                  <input type="password" class="form-control"  placeholder="Ejemplo: 7291586478" name="passwordConfirm" required>
            </div>

        </div>
      

          <input type="number" class="form-control" id="id" name="id" hidden>
          <button type="submit" class="btn btn-primary">Guardar</button>
    </div>
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
        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="deleteAsesor()">Confirmar</button>
      </div>

    </div>
  </div>
</div>
<!-- The Modal -->

  <asset:javascript src="asesor.js" />
</body>

</html>