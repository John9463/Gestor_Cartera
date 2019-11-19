document.getElementById("defaultOpen").click();

var superid

var keys = ["numeroRemision", "fechaDesde", "seguro", "financiamiento", "periodo", "status", "cliente", "comisionCedida", "primaTotal", "ramo", "gastosExpedicion", "fechaExpedicion", "clave"]

$('#form-poliza-source').validate({
    rules: {
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
        comisionCedida: {
            required: true,
            minlength: 2,
            maxlength: 4
        },
        gastosExpedicion: {
            required: true,
            minlength: 2,
            maxlength: 4
        }
    },
    messages: {
        seguro: {
            required: 'Es necesario ingresar un usuario existente'
        },
        cliente: {
            required: 'Es necesario ingresar un cliente'
        },
        periodo: 'Seleccione un periodo de tiempo',
        ramo: 'Seleccione un ramo',
        status: 'Seleccione un status',
        numeroRemision: {
            required: 'Campo es requerido',
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