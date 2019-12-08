<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="layout" content="theme">

<asset:stylesheet src="application.css"/>

</head>

<body>

<div id="data-list-clientes" class="tabcontent">

  <input type="text" id="filter-value" onkeyup="filterCliente()" placeholder="Buscar por clave.." title="Type in a name"/>
  <button class="btn btn-success" data-toggle="modal" data-target="#modal-cliente" onclick="show('add')"><i class="far fa-plus-square">Crear Cliente</i></button>
  <g:link controller="report" action="create" params="[domain: 'cliente']" download="clientes.xslx" class="btn btn-primary">Crear Reporte</g:link>
    <table id="table-clientes" class="table table-striped">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Apellido Paterno</th>
          <th>Email</th>
          <th>Clave</th>
          <th>Acciones</th>
        </tr>
      </thead>

      <g:each var="cliente" in="${ clientes }">
        <tbody>
          <tr>
            <td>${cliente.usuario.nombre}</td>
            <td>${cliente.usuario.apellPa}</td>
            <td>${cliente.usuario.correo}</td>
            <td>${cliente.clave}</td>
            <td>
              <button class="btn btn-warning" data-toggle="modal" data-target="#modal-cliente" onclick="edit(${cliente.id})"><i class="fas fa-edit">Editar</i></button>
              <button class="btn btn-danger" data-toggle="modal" data-target="#myModal" onclick="previusDelete(${cliente.id})"><i class="far fa-trash-alt">Borrar</i> </button>
            </td>
          </tr>
        </tbody>
      </g:each>

    </table>
</div>

<!-- The Modal SQL CREATE / UPDATE-->
  <div class="modal" id="modal-cliente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">

      <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title" id="title-cliente">Alta de Cliente</h4>
           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
           </button>
        </div>
      <!-- Modal Header-->

      <!-- Modal Body-->
      <div class="modal-body">

        <g:form controller="cliente" class="was-validated" name="form-cliente">
          <div class="form-group modal-body">

            <div class="row pt-4">
                <div class="col-4">
                  <label for="pwd">Nombre:</label>
                  <input type="text" class="form-control"  placeholder="juan" name="nombre" required>
                </div>

                <div class="col-4">
                    <label for="pwd">Apellido Paterno:</label>
                    <input type="text" class="form-control"  placeholder="vargas" name="apellPa" required>
                  </div>

                  <div class="col-4">
                    <label for="pwd">Apellido Materno:</label>
                    <input type="text" class="form-control"  placeholder="Ejemplo: contreras" name="apellMa" required>
                  </div>
                </div>
            </div>

            <div class="row pt-4">

              <div class="col-4">
                <label for="uname">Correo Electronico:</label>
                <input type="email" class="form-control"  placeholder="Ejemplo: example@mail.com" name="correo" maxlenght="5" required>
              </div>

              <div class="col-4">
                <label for="uname">Fecha De Nacimiento:</label>
                <input type="date" class="form-control"  placeholder="Ejemplo: 1020" name="fechaNac" required>
              </div>

              <div class="col-4">
                <label for="pwd">RFC:</label>
                <input type="text" class="form-control"  placeholder="Ejemplo: 147" name="rfc" required>
              </div>

            </div>
            
            <div class="row pt-4">

              <div class="col-4">
                <label for="pwd">Ciudad:</label>
                <input type="text" class="form-control"  placeholder="Ejemplo: Toluca" name="ciudad" required>
              </div>

              <div class="col-sm-4">
                <label for="pwd">Colonia:</label>
                <input type="text" class="form-control"  placeholder="Ejemplo: $15.50" name="colonia" required>
              </div>

              <div class="col-sm-4">
                <label for="pwd">Calle:</label>
                <input type="text" class="form-control"  placeholder="Ejemplo: Av. Dependencia" name="calle" required>
              </div>

            </div>
          
            <div class="row pt-4">

              <div class="col-4">
                <label for="pwd">No. Casa:</label>
                <input type="number" class="form-control"  placeholder="Ejemplo: 2000" name="noCasa" required>
              </div>

              <div class="col-sm-4">
                <label for="pwd">Codigo Postal:</label>
                <input type="number" class="form-control"  placeholder="Ejemplo: 50100" name="cp" required>
              </div>

              <div class="col-4">
                <label for="pwd">Telefono Celular:</label>
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
          
          <g:actionSubmit id="target-submit" class="btn btn-primary" value="Guardar" action="save" hidden="true" />
        
        </g:form>
      </div>
      <!-- Modal Body -->

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" onclick="save()">Confirmar</button>
      </div>
      <!-- Modal footer -->

      </div>
    </div>
  </div>
<!-- The Modal-->

<!-- The Modal DELETE -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Confirmacion Baja de Cliente</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <b>¿Estas seguro que deseas eliminar la Cliente?</b>
        <br>
        <span>Esta accion no puede deshacerse una vez ejecutada. </span>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="deleteCliente()">Confirmar</button>
      </div>

    </div>
  </div>
</div>
<!-- The Modal -->

  <asset:javascript src="cliente.js" />
</body>

</html>