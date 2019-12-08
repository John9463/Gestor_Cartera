var superid

$('#form-automovil').validate({
    rules: {
        seguro: 'required',
        cliente: {
            required: true,
            remote: '/cliente/exist/' + $("input[name='cliente']").val()
        },
        vehiculo: "required",
        modelo: "required",
        tipos: "required",
        placas: {
            required: true,
            minlength: 2,
            maxlength: 8
        },
        uso: {
            required: true
        },
        numSerie: {
            required: true,
            minlength: 2,
            maxlength: 4
        },
        numMotor: {
            required: true,
            minlength: 2,
            maxlength: 4
        }
    },
    messages: {
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
        uso: {
            required: 'Ingresa un uso para el vehiculo'
        },
        numSerie: {
            required: 'Ingresa un numero de serie',
            minlength: 'Numero de serie demasiado corto',
            maxlength: 'Numero de serie no valido'
        },
        numMotor: {
            required: 'Ingresa un numero de motor',
            minlength: 'Numero de motor demasiado corto',
            maxlength: 'Numero de motor no valido'
        }
    }

})

function save() {

    let submit = document.getElementById('target-submit')

    submit.click();

}

function show(it) {
    let title = document.getElementById('title-auto')
    let form = document.getElementById('form-automovil')

    if (it == 'add') {
        title.innerText = 'Crear Automovil'
        form.action = '/automovil/save'
        clean()
    }

    if (it == 'mod') {
        title.innerText = 'Editar Automovil'
        form.action = '/automovil/update'
    }

}

function edit(id) {
    fetch('/automovil/get/' + id)
        .then(response => response.json())
        .then(automovil => {
            for (let key in automovil) {
                let input = $("[name='" + key + "']")
                input.val(automovil[key])
            }
            document.getElementById('id').value = id
            show('mod')
        }).catch((err) => alert("Problems in server" + err));

}

function clean() {
    const keys = ["cliente", "seguro", "nombre", "modelo", "tipo", "placas", "uso", "numSerie", "numMotor"]
    for (let key of keys) {
        let input = $("[name='" + key + "']")
        input.val('')
    }
}

function previusDelete(id) {
    superid = id
}

function deleteAutomovil() {
    fetch('/automovil/delete/' + superid)
        .then(Response => Response.text())
        .then(response => {
            if (response == 'false')
                location.reload()
        }).catch((err) => alert("Problems in server" + err));
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