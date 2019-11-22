
document.getElementById("defaultOpen").click();

var superid

var keys = ["correo", "fechaNac", "nombre", "apellMa", "apellPa", "ciudad", "rfc", "colonia", "calle", "cp", "tipoAsesor", "noCasa", "tel", "password", "username", "isAdmin", "homoclave"]



$('#form-asesor').validate({
    rules:{
        seguro: 'required',
        cliente: {
             required: true,
            remote: '/cliente/exist/'+$("input[name='cliente']").val()
        },
        vehiculo: "required",
        modelo: "required",
        tipos: "required",
        placas: {
            required: true,
            minlength: 2,
            maxlength: 8
        },
        uso:{
             required: true
        },
        numSerie:{
             required: true,
             minlength: 2,
             maxlength: 4
        },
        numMotor:{
          required: true,
          minlength: 2,
          maxlength: 4
        }
    },
    messages:{
          seguro: 'required',
          cliente: {
               required: 'El campo cliente es obligatorio',
               remote: 'No existe ningun Cliente con este id'
          },
          vehiculo: "El vehiculo es campo requerido",
          modelo: "El modelo es campo requerido",
          tipos: "Selecciona un tipo",
          placas: {
               required: 'Las placas con requeridas',
               minlength: 'Faltan caracteres',
               maxlength: 'Placas no validas'
          },
          uso:{
               required: 'Ingresa un uso para el vehiculo'
          },
          numSerie:{
               required: 'Ingresa un numero de serie',
               minlength: 'Numero de serie demasiado corto',
               maxlength: 'Numero de serie no valido'
          },
          numMotor:{
               required: 'Ingresa un numero de motor',
               minlength: 'Numero de motor demasiado corto',
               maxlength: 'Numero de motor no valido'
          }
    }

})

function show(it){
     var tab = document.getElementById('add-mod')
     var form = document.getElementById('form-asesor')

     if(it == 'add'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Crear Asesor'
          form.action = '/asesor/save'
          tab.click()
          clean() 
     }

     if(it == 'mod'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Editar Asesor'
          form.action = '/asesor/update'
          tab.click()
     }

}

function edit(id){
     fetch('/asesor/get/'+id)
     .then( response => response.json())
     .then( asesor => {
               console.log(asesor)
          for (let key in asesor){
               let input = $("[name='"+key+"']")
               
               if (key == 'fechaNac') {
                    let d = asesor[key]
                    let date = d.substring(0, 10)
                    input.val(date)
                } else if (key === 'isAdmin') {
                    input.prop('checked', asesor[key] === '1');
                } else {
                    input.val(asesor[key])
                }
          }
          document.getElementById('id').value = id
          show('mod')
     }).catch((err) => alert("Problems in server" + err) );
     
}

function clean(){
     for (let key in keys){
          let input = $("[name='"+key+"']")
          input.val('')
     }
}

function previusDelete(id){
     superid = id
}

function deleteAsesor(){
     fetch('/asesor/delete/'+superid)
     .then( response => response.text() )
     .then( confirm => {
          if( confirm == 'true'){
               location.reload()
               alert("El Asesor fue eliminada")
          }else
               alert("La Asesor NO fue eliminada")

     }).catch((err) => alert("Problems in server" + err) );
     
}

function filter() {
     var input, filter, table, tr, td, i, txtValue;
     input = document.getElementById("filter-value");
     filter = input.value.toUpperCase();
     table = document.getElementById("asesor-table");
     tr = table.getElementsByTagName("tr");
     for (i = 0; i < tr.length; i++) {
       td = tr[i].getElementsByTagName("td")[1];
       if (td) {
         txtValue = td.textContent || td.innerText;
         if (txtValue.toUpperCase().indexOf(filter) > -1) {
           tr[i].style.display = "";
         } else {
           tr[i].style.display = "none";
         }
       }       
     }
   }


