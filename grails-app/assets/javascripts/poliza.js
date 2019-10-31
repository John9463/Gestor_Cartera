
document.getElementById("defaultOpen").click();
document.title = "Gestor Cartera - Polizas"
var keys = ["numeroRemision"
,"idPoliza"
,"fechaDesde"
,"idSeguro"
,"financiamiento"
,"periodo"
,"idStatus"
,"idCliente"
,"comisionCedida"
,"primaTotal"
,"idRamo"
,"gastosExpedicion"
,"fechaHasta"
,"clave"]

var superid

function show(it){
     var tab = document.getElementById('add-mod')
     var form = document.getElementById('form-poliza')

     if(it == 'add'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Crear Poliza'
          form.action = '/poliza/save'
          tab.click()
          clean() 
     }

     if(it == 'mod'){
          tab.removeAttribute('hidden')
          tab.innerHTML = 'Editar Poliza'
          form.action = '/poliza/update'
          tab.click()
     }

}

function edit(id){

     let request = {
          method: 'POST',
          body : JSON.stringify({id: id})
     }

     fetch('/poliza/getPoliza',request)
     .then( Response => Response.json())
     .then( poliza => {
          for (let key in poliza){
               let input = $("[name='"+key+"']")
          
               if(key == 'fechaHasta' || key == 'fechaDesde'){
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

     fetch('/poliza/delete',request)
     .then( Response => Response.text() )
     .then( response => {
          if(response == 'true'){
               location.reload()
               alert("La poliza fue eliminada")
          }else
               alert("La poliza NO fue eliminada")

     }).catch((err) => alert("Problems in server" + err) );
     
}
