document.getElementById("defaultOpen").click();

var superid

var keys = ["numeroRemision", "fechaDesde", "seguro", "financiamiento", "periodo", "status", "cliente", "comisionCedida", "primaTotal", "ramo", "gastosExpedicion", "fechaExpedicion", "clave"]



$(()=>{

    // $( "input:blank" ).css( "background-color", "#bbbbff" );

    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        console.log(arg)
        return arg !== value;
    }, "Value must not equal arg.");

    $("form[name='form-poliza']").validate({
        onsubmit: false,
        rules: {
            seguro: {
                'valueNotEquals': 'Seleccione un Seguro'
            },
            cliente: {
                required: true,
                remote: '/cliente/exist/'+$("input[name='cliente']").val()
            },
            periodo: "required",
            ramo: "required",
            status: "required",
            numeroRemision: {
                required: true,
                minlength: 2,
                maxlength: 4
            },
            comisionCedida: {
                required: true,
                minlength: 2,
                maxlength: 4
            },
            gastosExpedicion: {
                required: true,
                maxlength: 4
            }
        },
        messages: {
            seguro: {
                required: 'Seleccione un Seguro'
            },
            cliente: {
                required: 'Es necesario ingresar un cliente',
                remote: 'No existe ningun usuario con el id ingresado'
            },
            periodo: 'Seleccione un periodo de tiempo',
            ramo: 'Seleccione un ramo',
            status: 'Seleccione un status',
            numeroRemision: {
                required: 'El campo es requerido',
                minlength: "El campo no puede ser menor a 2",
                maxlength: "El campo no puede ser mayor de 5"
            },
            comisionCedida: {
                required: 'El campo es requerido',
                minlength: "El campo no puede ser menor a 2",
                maxlength: "El campo no puede ser mayor de 5"
            },
            gastosExpedicion: {
                required: 'El campo es requerido',
                maxlength: "El campo no puede ser mayor de 4"
            },
            fechaDesde:{

            },
            fechaExpedicion: {

            },
            financiamiento: {

            },
            pimaTotal:{
              
            }
        },
        submitHandler: function(form) {
            if(form.valid())
                form.submit();
        }
    })    

})

function show(it) {
    var tab = document.getElementById('add-mod')
    var form = document.getElementById('form-poliza')

    if (it == 'add') {
        tab.removeAttribute('hidden')
        tab.innerHTML = 'Crear Poliza'
        form.action = '/poliza/save'
        tab.click()
        clean()
    }

    if (it == 'mod') {
        tab.removeAttribute('hidden')
        tab.innerHTML = 'Editar Poliza'
        form.action = '/poliza/update'
        tab.click()
    }

}

function edit(id) {
    fetch('/poliza/get/' + id)
        .then(response => response.json())
        .then(poliza => {
            console.log(poliza)
            for (let key in poliza) {
                console.log(key)
                let input = $("[name='" + key + "']")

                if (key == 'fechaDesde' || key == 'fechaExpedicion') {
                    let d = poliza[key]
                    let date = d.substring(0, 10)
                    input.val(date)
                } else if (key === 'cliente') {
                    input.val(poliza.cliente.id)
                } else {
                    input.val(poliza[key])
                }
            }
            document.getElementById('id').value = id
            show('mod')
        }).catch((err) => alert("Problems in server" + err));

}

function clean() {
    for (let key in keys) {
        let input = $("[name='" + key + "']")
        input.val('')
    }
}

function previusDelete(id) {
    superid = id
}

function deletePoliza() {
    fetch('/poliza/delete/' + superid)
        .then(response => response.text())
        .then(confirm => {
            console.log(confirm)
            if (confirm.action == 'ok')
                location.reload()
            showAlert(confirm)
        }).catch((err) => alert("Problems trying delete Poliza : " + err));
}