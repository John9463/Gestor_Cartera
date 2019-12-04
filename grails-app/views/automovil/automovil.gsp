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
  <button class="tablinks" onclick="openTab(event, 'London')" id="defaultOpen">Lista Automoviles</button>
  <button id="add-mod" class="tablinks" onclick="openTab(event, 'Paris')" hidden>Crear Automoviles</button>
</div>

<input type="text" id="filter-value" onkeyup="filter()" placeholder="Buscar por nombre.." title="Type in a name">

<div id="London" class="tabcontent">
  <button class="btn btn-success" onclick="show('add')"><i class="far fa-plus-square">Crear Automovil</i></button>
  <button class="btn btn-primary">Reporte</button>
  <table id="autos-table" class="table table-striped">
    <thead>
      <tr>
        <th>Automovil</th>
        <th>Cliente</th>
        <th>Model</th>
        <th>Uso</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <g:each var="auto" in="${ autos }">
    <tbody>
      <tr>
        <td>${auto.id}</td>
        <td>${auto.cliente.id}</td>
        <td>${auto.modelo}</td>
        <td>${auto.uso}</td>
        <td>
        <button class="btn btn-warning" onclick="edit(${auto.id})"><i class="fas fa-edit">Editar</i></button> 
        <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#myModal" onclick="previusDelete(${auto.id})"><i class="far fa-trash-alt">Borrar</i> </button> </td>
      </tr>
    </tbody>
    </g:each>
  </table>
</div>

<div id="Paris" class="tabcontent">
  <g:form controller="automovil" action="save" class="was-validated" name="form-automovil">
      <div class="form-group">
        
        <div class="row pt-4">

          <div class="col-4">
            <label for="uname">ID Cliente:</label>
            <input type="number" class="form-control"  placeholder="50" name="cliente" maxlenght="5" required>
          </div>

          <div class="col-4">
            <label for="uname">Seguros:</label>
            <select name="seguro" required >
                <option selected>Seleccione un Seguro</option>
                <g:each var="aseguradora" in="${ aseguradoras }">
                    <optgroup label="${ aseguradora.name }">
                      <g:each var="seguro" in="${aseguradora.seguros}">
                          <option value="${seguro.id}">${seguro.nombre}</option>
                      </g:each>
                    </optgroup>
                </g:each>
            </select>
          </div>

          <div class="col-4">
            <label for="pwd">Vehiculo:</label>
            <input type="text" class="form-control"  placeholder="Ford" name="nombre" required>
          </div>

        </div>

        <div class="row pt-4">
            <div class="col-4">
              <label for="pwd">Modelo:</label>
              <input type="text" class="form-control"  placeholder="2015" name="modelo" required>
            </div>
  
            <div class="col-4">
              <label for="uname">Tipos:</label>
              <select name="tipo" required >
                  <option selected>Seleccione un tipo</option>
                  <g:each var="tipo" in="${ tipos }">
                    <option value="${tipo}">${seguro.nombre}</option>    
                  </g:each>
              </select>
            </div>
        </div>

        <div class="row pt-4">

          <div class="col-5">
            <label for="pwd">Placas:</label>
            <input type="text" class="form-control"  placeholder="AWF500S" name="placas" required>
          </div>

          <div class="col-5">
            <label for="pwd">Uso:</label>
            <input type="text" class="form-control"  placeholder="Trabajo" name="uso" required>
          </div>

        </div>
      
        <div class="row pt-4">

          <div class="col-sm-4">
            <label for="pwd">No. de Serie:</label>
            <input type="text" class="form-control"  placeholder="Ejemplo: $15.50" name="numSerie" required>
          </div>

          <div class="col-sm-4">
            <label for="pwd">No. Motor:</label>
            <input type="text" class="form-control"  placeholder="Ejemplo: Av. Dependencia" name="numMotor" required>
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
        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="deletePoliza()">Confirmar</button>
      </div>

    </div>
  </div>
</div>
<!-- The Modal -->

  <asset:javascript src="automovil.js" />
</body>

</html>