document.getElementById("defaultOpen").click();

var keys = ["correo", "fechaNac", "nombre", "apellMa", "apellPa", "ciudad", "rfc", "colonia", "calle", "cp", "tipo", "noCasa", "tel", "password", "username", "isIntegral"]


$(function() {
    $("form[name='form-cliente']").validate({
        rules: {

            correo: {
                required: "Es requerido ingresar un correo electronico",
                email: "El formato del correo no es aceptado"
            },
            fechaNac: {
                required: "Es requerido la fecha de nacimiento"
            },
            nombre: {
                required: "Ingresa un nombre"
            },
            cp: {
                required: true,
                minlength: 5

            },
            noCasa: {
                minlength: 5
            },
            tel: {
                minlength: 7,
                maxlength: 10
            },
            username: {
                remote: ''
            },
            password: {

            },
            passwordConfirm: {

            }

        },
        messages: {


        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});


function show(it) {
    var tab = document.getElementById('add-mod')
    var form = document.getElementById('form-cliente')

    if (it == 'add') {
        tab.removeAttribute('hidden')
        tab.innerHTML = 'Crear Cliente'
        form.action = '/cliente/save'
        tab.click()
        clean()
    }

    if (it == 'mod') {
        tab.removeAttribute('hidden')
        tab.innerHTML = 'Editar cliente'
        form.action = '/cliente/update'
        tab.click()
    }

}



function edit(id) {
    fetch('/cliente/get/' + id)
        .then(response => response.json())
        .then(cliente => {
            for (let key in cliente) {
                let input = $("[name='" + key + "']")

                if (key == 'fechaNac') {
                    let d = cliente[key]
                    let date = d.substring(0, 10)
                    input.val(date)
                } else if (key == 'isIntegral') {
                    input.prop('checked', cliente[key] === 'true');
                } else {
                    input.val(cliente[key])
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
    fetch('/cliente/delete/' + superid)
        .then(response => response.text())
        .then(status => {
            if (status == 'true') {
                location.reload()
                alert("La poliza fue eliminada")
            } else
                alert("La poliza NO fue eliminada")

        }).catch((err) => alert("Problems in server" + err));

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