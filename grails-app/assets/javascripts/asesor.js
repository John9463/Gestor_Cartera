var superid

$('#form-asesor').validate({
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

    let submit = document.getElementById('taget-submit')

    submit.click();

}

function show(it) {
    var title = document.getElementById('title-asesor')
    var form = document.getElementById('form-asesor')

    if (it == 'add') {

        title.innerHTML = 'Alta de Asesor'
        form.action = '/asesor/save'

        clean()
    }

    if (it == 'mod') {

        title.innerHTML = 'Modificacion de Asesor'
        form.action = '/asesor/update'

    }

}

function edit(id) {
    fetch('/asesor/get/' + id)
        .then(response => response.json())
        .then(asesor => {
            console.log(asesor)
            for (let key in asesor) {
                let input = $("[name='" + key + "']")

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
        }).catch((err) => alert("Problems in server" + err));

}

function clean() {
    const keys = ["correo", "fechaNac", "nombre", "apellMa", "apellPa", "ciudad", "rfc", "colonia", "calle", "cp", "tipoAsesor", "noCasa", "tel", "password", "username", "isAdmin", "homoclave"]

    for (let key of keys) {
        let input = $("[name='" + key + "']")
        input.val('')
    }
}

function previusDelete(id) {
    superid = id
}

function deleteAsesor() {
    fetch('/asesor/delete/' + superid)
        .then(response => response.text())
        .then(confirm => {
            if (confirm == 'false')
                location.reload()
        }).catch((err) => alert("Problems in server" + err));
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