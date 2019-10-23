<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<asset:stylesheet src="application.css"/>
<asset:stylesheet src="poliza.css"/>

</head>

<body>

<%-- <h2>Vertical Tabs</h2>
<p>Click on the buttons inside the tabbed menu:</p> --%>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Lista Poliza</button>
  <button id="add-mod" class="tablinks" onclick="openCity(event, 'Paris')" hidden>Crear Poliza</button>
</div>

<div id="London" class="tabcontent">
  <button onclick="show('add')"><i class="far fa-plus-square">Crear Poliza</i></button>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Clave Cliente</th>
        <th>Poliza</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <g:each var="poliza" in="${ polizas }">
    <tbody>
      <tr>
        <td>${poliza.clave}</td>
        <td>${poliza.idPoliza}</td>
        <td><button onclick="show('mod')"><i class="fas fa-edit">Editar</i></button> <button><i class="far fa-trash-alt">Borrar</i> </button> </td>
      </tr>
    </tbody>
    </g:each>
  </table>
</div>

<div id="Paris" class="tabcontent">
  <g:form controller="poliza" action="save" class="was-validated">

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
            <input type="date" class="form-control" id="pwd" placeholder="Ejemplo: 12/02/1997" name="periodo" required>
            <div class="valid-feedback">Correcto.</div>
            <div class="invalid-feedback">El campo es requerido.</div>
          </div>

        </div>
        <div class="row pt-4">
          <div class="col-6">
              <label for="uname">RAMO:</label>
              <select name="cars" height="30px" name="idRamo">
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
              <select name="idStatus">
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



  <asset:javascript src="application.js" />
  <asset:javascript src="poliza.js" />
</body>

</html>