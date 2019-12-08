var superid
$(() => {

    // $( "input:blank" ).css( "background-color", "#bbbbff" );

    $.validator.addMethod("valueNotEquals", function(value, element, arg) {
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
                remote: '/cliente/exist/' + $("input[name='cliente']").val()
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
            fechaDesde: {

            },
            fechaExpedicion: {

            },
            financiamiento: {

            },
            pimaTotal: {

            }
        },
        submitHandler: function(form) {
            if (form.valid())
                form.submit();
        }
    })

})

function save() {

    let submit = document.getElementById('target-submit')

    submit.click();

}

function show(it) {
    let title = document.getElementById('title-poliza')
    let form = document.getElementById('form-poliza')

    if (it == 'add') {

        title.innerTest = 'Alta de Poliza'
        form.action = '/poliza/save'

        clean()
    }

    if (it == 'mod') {
        title.innerText = 'Modificacion de Poliza'
        form.action = '/poliza/update'
    }

}

function edit(id) {
    fetch('/poliza/get/' + id)
        .then(response => response.json())
        .then(poliza => {
            for (let key in poliza) {
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
    const keys = ["numeroRemision", "fechaDesde", "seguro", "financiamiento", "periodo", "status", "cliente", "comisionCedida", "primaTotal", "ramo", "gastosExpedicion", "fechaExpedicion", "clave"]

    for (let key of keys) {
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
            if (confirm == 'false')
                location.reload()

        }).catch((err) => alert("Problems trying delete Poliza : " + err));
}