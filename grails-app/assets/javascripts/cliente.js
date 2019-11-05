document.getElementById("defaultOpen").click();

var keys = ["idClient"
,"correo"
,"fechaNac"
,"nombre"
,"apellMa"
,"apellPa"
,"ciudad"
,"rfc"
,"colonia"
,"calle"
,"cp"
,"tipo"
,"numeros"
,"tel"]

function show(it){
     var tab = document.getElementById('add-mod')
     var form = document.getElementById('form-cliente')

     if(it == 'add'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Crear Cliente'
          form.action = '/cliente/save'
          tab.click()
          clean() 
     }

     if(it == 'mod'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Editar cliente'
          form.action = '/cliente/update'
          tab.click()
     }

}



function edit(id){

     let request = {
          method: 'POST',
          body : JSON.stringify({id: id})
     }

     fetch('/cliente/getCliente',request)
     .then( Response => Response.json())
     .then( poliza => {
          for (let key in poliza){
               let input = $("[name='"+key+"']")
          
               if(key == 'fechaNac'){
                    let d = poliza[key]
                    let date = d.substring(0,10)
                    input.val(date)
               }else{
                    input.val(poliza[key])
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

function deletePoliza(){
     let request = {
          method: 'POST',
          body : JSON.stringify({id: superid})
     }

     fetch('/cliente/delete',request)
     .then( Response => Response.text() )
     .then( response => {
          if(response == 'true'){
               location.reload()
               alert("La poliza fue eliminada")
          }else
               alert("La poliza NO fue eliminada")

     }).catch((err) => alert("Problems in server" + err) );
     
}


function filter() {
     var input, filter, table, tr, td, i, txtValue;
     input = document.getElementById("filter-value");
     filter = input.value.toUpperCase();
     table = document.getElementById("clientes-table");
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
