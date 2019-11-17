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
  <button class="tablinks" onclick="openTab(event, 'London')" id="defaultOpen">Lista Seguro</button>
  <button id="add-mod" class="tablinks" onclick="openTab(event, 'Paris')" hidden>Crear Seguro</button>
</div>

<input type="text" id="filter-value" onkeyup="filter()" placeholder="Buscar por clave.." title="Type in a name">

<div id="London" class="tabcontent">
  <button onclick="show('add')"><i class="far fa-plus-square">Crear Seguro</i></button>
  <table id="seguro-table" class="table table-striped">
    <thead>
      <tr>
        <th>Id Seguro:</th>
        <th>Nombre</th>
        <th>Aseguradora</th>
        <th>Cobertura</th>
        <th>sumaAsegurada</th>
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
            <td><button onclick="edit(${seguro.id})"><i class="fas fa-edit">Editar</i></button> <button type="button" data-toggle="modal" data-target="#myModal" onclick="previusDelete(${seguro.id})"><i class="far fa-trash-alt">Borrar</i> </button> </td>
          </tr>
        </tbody>
  
    </g:each>
  </table>
</div>

<div id="Paris" class="tabcontent">
  <g:form controller="seguro" action="save" class="was-validated" name="form-seguro">

      <div class="form-group">
        <div class="row pt-4">

          <div class="col-4">
            <label for="uname">ID SEGURO:</label>
            <input type="number" class="form-control" id="uname" placeholder="Ejemplo: 1520" name="idSeguro" maxlenght="5" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-4">
            <label for="uname">ID CLIENTE:</label>
            <input type="number" class="form-control" id="uname" placeholder="Ejemplo: 1020" name="idCliente" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-4">
            <label for="pwd">PERIODO:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: 12/02/1997" name="periodo" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        </div>
        <div class="row pt-4">
          <div class="col-6">
              <label for="uname">RAMO:</label>
              <select height="30px" name="idRamo" required>
                <option value="5">Volvo</option>
                <option value="6">Saab</option>
                <option value="7">Fiat</option>
                <option value="8">Audi</option>
              </select>
              <div class="valid-feedback">Correcto.</div>
              <div class="invalid-feedback">El campo es requerido.</div>
            </div>

            <div class="col-6">
              <label for="uname">STATUS:</label>
              <select name="idStatus" required>
                <option value="0">Volvo</option>
                <option value="1">Saab</option>
                <option value="2">Fiat</option>
                <option value="3">Audi</option>
              </select>
              <div class="valid-feedback">Correcto.</div>
              <div class="invalid-feedback">El campo es requerido.</div>
            </div>
          </div>
      </div>


      
        <div class="row pt-4">

          <div class="col-6">
            <label for="pwd">NUMERO DE REMISION:</label>
            <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: 1547" name="numeroRemision" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-6">
            <label for="pwd">COMISION CONCEDIDA:</label>
            <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: 147" name="comisionCedida" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        </div>
     

      
     
        <div class="row pt-4">

          <div class="col-sm-4">
            <label for="pwd">GASTOS DE EXPEDICION:</label>
            <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: $15.50" name="gastosExpedicion" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-sm-4">
            <label for="pwd">DESDE:</label>
            <input type="date" class="form-control" id="pwd" placeholder="Enter password" name="fechaDesde" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

          <div class="col-sm-4">
            <label for="pwd">HASTA:</label>
            <input type="date" class="form-control" id="pwd" placeholder="Enter password" name="fechaHasta" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        </div>
     
      <div class="row pt-4">

          <div class="col-12">
            <label for="pwd">FINANCIAMIENTO:</label>
            <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: $15.50" name="financiamiento" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        <input type="number" class="form-control" id="id" name="id" hidden>

        </div>

        <div class="row pt-4">
        <div class="col-6">
        <label for="pwd">PRIMA TOTAL:</label>
        <input type="number" class="form-control" id="pwd" placeholder="Ejemplo: $20.00" name="primaTotal" required>
        <div class="valid-feedback">Correcto.</div>
        <div class="invalid-feedback">El campo es requerido.</div>
        </div>

        <div class="col-6">
        <label for="pwd">CLAVE CLIENTE:</label>
        <input type="text" class="form-control" id="pwd" placeholder="Ejemplo: USR4325" name="clave" required>
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
  <asset:javascript src="seguro.js" />
</body>

</html>