document.getElementById("defaultOpen").click();

var keys = ["correo", "fechaNac", "nombre", "apellMa", "apellPa", "ciudad", "rfc", "colonia", "calle", "cp", "tipo", "noCasa", "tel", "password", "username", "isIntegral"]


$(function () {
    $("form[name='form-cliente']").validate({
        onsubmit: false,
        rules: {
            username: {
                remote: ''
            },
            password: 'required',
            passwordConfirm: {
                equalTo: "#password"
            }
        },
        messages: {
            username: 'El usuario ya existe',
            password: 'La contraseña es requerida',
            passwordConfirm: 'Ingresa la misma contraseña'
        },
        submitHandler: function(form) {
            if(form.valid())
                return form.submit();
            
                return false;
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
            if (status == 'false') {
                location.reload()
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