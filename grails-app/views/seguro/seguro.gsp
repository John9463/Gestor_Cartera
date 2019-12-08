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

<div class="tabcontent">
  <input type="text" id="filter-value" onkeyup="filter()" placeholder="Buscar por clave.." title="Type in a name">
  <button class="btn btn-success" data-toggle="modal" data-target="#modal-seguro" onclick="show('add')"><i class="far fa-plus-square">Crear Seguro</i></button>
  <g:link controller="report" action="create" params="[domain: 'seguro']" download="seguros.xslx" class="btn btn-primary">Reporte</g:link>
  
  <table id="table" class="table table-striped">
    <thead>
      <tr>
        <th>Seguro:</th>
        <th>Nombre</th>
        <th>Aseguradora</th>
        <th>Cobertura</th>
        <th>sumaAsegurada</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <g:each var="seguro" in="${ seguros }">

        <tbody>
          <tr>
            <td>${seguro.id}</td>
            <td>${seguro.nombre}</td>
            <td>${seguro.aseguradora}</td>
            <td>${seguro.cobertura}</td>
            <td>${seguro.sumaAsegurada}</td>
          <td>
            <button class="btn btn-warning" data-toggle="modal" data-target="#modal-seguro" onclick="edit(${seguro.id})"><i class="fas fa-edit">Editar</i></button>
            <button class="btn btn-danger" data-toggle="modal" data-target="#myModal" onclick="previusDelete(${seguro.id})"><i class="far fa-trash-alt">Borrar</i> </button> </td>
          </tr>
        </tbody>
  
    </g:each>
  </table>
</div>

<!-- The Modal SQL CREATE / UPDATE-->
  <div class="modal" id="modal-seguro" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">

        <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title" id="title-seguro">Alta de Seguro</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
          </div>
        <!-- Modal Header -->


        <!-- Modal Body -->
        <div class="modal-body">
            <g:form controller="seguro" action="save" class="was-validated" name="form-seguro">

                <div class="form-group">
                
                  <div class="row pt-4">

                    <div class="col-4">
                      <label for="uname">Nombre Seguro:</label>
                      <input type="text" class="form-control" placeholder="Ejemplo: miseguro" name="nombre" required>
                    </div>
                
                    <div class="col-4">
                        <label for="uname">Emisor:</label>
                        <input type="number" class="form-control"  placeholder="Ejemplo: 1547" name="emisor" required>
                    </div>

                    <div class="col-4">
                      <label for="uname">Valor Seguro:</label>
                      <input type="number" class="form-control"  placeholder="Ejemplo: 1547" name="valorSeguro" required>
                    </div>

                  </div>

                  <div class="row pt-4">
                    
                    <div class="col-4">
                      <label for="pwd">Tipo:</label><br>
                      <select name="tipo" required>
                            <option selected>Selecciona un Tipo</option>
                          <g:each var="tipo" in="${tipos}">
                            <option >${tipo}</option>
                          </g:each>
                      </select>
                    </div>  

                    <div class="col-4">
                      <label for="pwd">Cobertura:</label>
                      <select name="cobertura" required>
                          <option>Seleccione una cobertura</option>
                          <g:each var="cobertura" in="${coberturas}">
                            <option >${cobertura}</option>
                          </g:each>
                        </select>
                    </div>

                    <div class="col-4">
                      <label for="uname">Aseguradoras:</label>
                        <select name="aseguradora" required>
                              <option selected>Selecciona una Aseguradora</option>
                            <g:each var="aseguradora" in="${aseguradoras}">
                              <option>${aseguradora}</option>
                            </g:each>
                        </select>
                    </div>    

                  </div>    

                  <div class="row pt-4">

                    <div class="col-sm-4">
                      <label for="pwd">Renovacion:</label>
                      <input type="date" class="form-control"  placeholder="Ejemplo: 1547" name="renovacion" required>
                    </div>

                    <div class="col-sm-4">
                      <label for="pwd">Suma Asegurada:</label>
                      <input type="text " class="form-control"  placeholder="Ejemplo: $15.50" name="sumaAsegurada" required>
                    </div>

                    <div class="col-sm-4">
                      <label for="pwd">Prima Neta:</label>
                      <input type="number" class="form-control" placeholder="" name="primaNeta" required>
                    </div>

                  </div>
                
                </div>

                <input type="number" class="form-control" id="id" name="id" hidden>
                <button id="target-submit" type="submit" class="btn btn-primary" hidden>Guardar</button>
             
            </g:form>
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
          <button type="button" class="btn btn-success" onclick="save()">Confirmar</button>
        </div>
        <!-- Modal footer -->

      </div>
    </div>
  </div>
<!-- -->

<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Confirmacion Baja de Seguro</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <b>¿Estas seguro que deseas eliminar la seguro?</b>
        <br>
        <span>Esta accion no puede deshacerse una vez ejecutada. </span>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="deleteSeguro()">Confirmar</button>
      </div>

    </div>
  </div>
</div>
<!-- The Modal -->


  <asset:javascript src="application.js" />
  <asset:javascript src="seguro.js" />
</body>

</html>