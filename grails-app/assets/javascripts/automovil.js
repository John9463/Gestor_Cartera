
document.getElementById("defaultOpen").click();

var superid

var keys = ["numeroRemision"
,"fechaDesde"
,"seguro"
,"financiamiento"
,"periodo"
,"status"
,"cliente"
,"comisionCedida"
,"primaTotal"
,"ramo"
,"gastosExpedicion"
,"fechaExpedicion"
,"clave"
]


$('#form-poliza-source').validate({
    rules:{
        seguro: 'required',
        cliente: {
            required: true
        },
        periodo: "required",
        ramo: "required",
        status: "required",
        numeroRemision: {
            required: true,
            minlength: 2,
            maxlength: 4
        },
        comisionCedida:{
             required: true,
             minlength: 2,
             maxlength: 4
        },
        gastosExpedicion:{
             required: true,
             minlength: 2,
             maxlength: 4
        }
    },
    messages:{
        seguro:{
            required: 'Es necesario ingresar un usuario existente'
        },
        cliente: {
            required: 'Es necesario ingresar un cliente'
        },
        periodo: 'Seleccione un periodo de tiempo',
        ramo: 'Seleccione un ramo',
        status: 'Seleccione un status',
        numeroRemision: {
            required:'Campo es requerido',
            minlength: "El campo no es valido",
            maxlength: 'el campo es mayor a los permitidos'
        },
        comisionCedida: {
            required: 'Campo es requerido',
            minlength: 'El campo no es valido',
            maxlength: 'El campo es mayor a los permitidos'
        },
        gastosExpedicion: {
            required: 'Campo es requerido',
            minlength: 'El campo no es valido',
            maxlength: 'El campo es mayor a los permitidos'
        }
    }

})

function show(it){
     var tab = document.getElementById('add-mod')
     var form = document.getElementById('form-seguro')

     if(it == 'add'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Crear Seguro'
          form.action = '/seguro/save'
          tab.click()
          clean() 
     }

     if(it == 'mod'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Editar Seguro'
          form.action = '/seguro/update'
          tab.click()
     }

}

function edit(id){
     fetch('/automovil/get/'+id)
     .then( response => response.json())
     .then( automovil => {
               console.log(automovil)

          // for (let key in automovil){
          //      let input = $("[name='"+key+"']")

          // }
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

function deleteAutomovil(){
     fetch('/automovil/delete/'+superid)
     .then( Response => Response.text() )
     .then( response => {
          if(response == 'true'){
               location.reload()
               alert("La seguro fue eliminada")
          }else
               alert("La seguro NO fue eliminada")

     }).catch((err) => alert("Problems in server" + err) );
     
}

function filter() {
     var input, filter, table, tr, td, i, txtValue;
     input = document.getElementById("filter-value");
     filter = input.value.toUpperCase();
     table = document.getElementById("autos-table");
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


