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
  <button class="tablinks" onclick="openTab(event, 'London')" id="defaultOpen">Lista Poliza</button>
  <button id="add-mod" class="tablinks" onclick="openTab(event, 'Paris')" hidden>Crear Poliza</button>
</div>

<input type="text" id="filter-value" onkeyup="filter()" placeholder="Buscar por clave.." title="Type in a name">

<div id="London" class="tabcontent">
  <button class="btn btn-success" onclick="show('add')"><i class="far fa-plus-square">Crear Poliza</i></button>
  <g:link controller="report" action="create" params="[domain: 'poliza']" download="polizas.xslx" class="btn btn-primary">Reporte</g:link>
  <table id="table" class="table table-striped">
    <thead>
      <tr>
        <th>Poliza</th>
        <th>Status</th>
        <th>Desde</th>
        <th>Hasta</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <g:each var="poliza" in="${ polizas }">

        <tbody>
          <tr>
            <td>${poliza.id}</td>
            <td>${poliza.status}</td>
            <td>${poliza.fechaDesde}</td>
            <td>${poliza.fechaExpedicion}</td>
            <td>
            <button class="btn btn-warning" onclick="edit(${poliza.id})"><i class="fas fa-edit">Editar</i></button>
            <button class="btn btn-danger" data-toggle="modal" data-target="#myModal" onclick="previusDelete(${poliza.id})"><i class="far fa-trash-alt">Borrar</i> </button> </td>
          </tr>
        </tbody>
  
    </g:each>
  </table>
</div>

<div id="Paris" class="tabcontent">
  <g:form controller="poliza" action="save" class="was-validated" name="form-poliza">
      <div class="form-group">

        <div class="row pt-4">
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
            <label for="uname">ID Cliente:</label>
            <input type="number" class="form-control" placeholder="Ejemplo: 15" name="cliente" id="cliente_id" required>
          </div>
        </div>

        <div class="row pt-4">

            <div class="col-4">
              <label for="pwd">Periodo:</label>
              <select height="30px" name="periodo" required>
                  <option selected>Seleccione un periodo</option>
                  <g:each var="periodo" in="${periodos}">
                      <option>${periodo}</option>
                  </g:each>
                </select>
            </div>

            <div class="col-4">
              <label for="uname">Ramo:</label>
              <select height="30px" name="ramo" required>
                <option selected>Seleccione un ramo</option>
                <g:each var="ramo" in="${ramos}">
                    <option>${ramo}</option>
                </g:each>
              </select>
            </div>

            <div class="col-4">
              <label for="uname">Status:</label>
              <select name="status" required>
                <option selected>Seleccione un status</option>
                <g:each var="st" in="${status}">
                    <option>${st}</option>
                </g:each>
              </select>
              </div>  
        </div>

        <div class="row pt-4">


          <div class="col-6">
            <label for="pwd">NO. Remision:</label>
            <input type="number" class="form-control"  placeholder="Ejemplo: 1547" minlength="2" maxlength="4" name="numeroRemision" required>
          </div>

          <div class="col-6">
            <label for="pwd">Comision Concedida:</label>
            <input type="number" class="form-control"  placeholder="Ejemplo: 147" name="comisionCedida" required>
          </div>

        </div>
     
        <div class="row pt-4">

          <div class="col-sm-4">
            <label for="pwd">Gastos de Expedicion:</label>
            <input type="number" class="form-control"  placeholder="Ejemplo: $15.50" name="gastosExpedicion" required>
          </div>

          <div class="col-sm-4">
            <label for="pwd">Desde:</label>
            <input type="date" class="form-control"  placeholder="Enter password" name="fechaDesde" required>
          </div>

          <div class="col-sm-4">
            <label for="pwd">Expedicion:</label>
            <input type="date" class="form-control"  placeholder="Enter password" name="fechaExpedicion" required>
          </div>

        </div>
     
        <div class="row pt-4">
            <div class="col-12">
              <label for="pwd">Financiamiento:</label>
              <input type="number" class="form-control"  placeholder="Ejemplo: $15.50" name="financiamiento" required>
            </div> 
        </div>

        <div class="row pt-4">
                <div class="col-6">
                <label for="pwd">Prima Total:</label>
                <input type="number" class="form-control"  placeholder="Ejemplo: $20.00" name="primaTotal" required>
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

  <asset:javascript src="poliza.js" />
</body>

</html>