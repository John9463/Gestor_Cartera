package gestorcartera

import wallet.trans.crud.AutomovilService

class AutomovilController {
    static responseFormats = ['json']

    AutomovilService automovilService

    def index() {
        def autos = automovilService.list()
        def model = automovilService.model()

        if (autos)
            model += [autos: autos]

        render view: 'automovil', model: model
    }

    def get(int id) {
        respond automovilService.get(id)
    }

    def save() {
        def auto = automovilService.save(params)

        flash.target = auto ? "Automovil Guardado" : "Automovil NO Guardado"
        flash.alert = auto ? 'alert-success' : 'alert-warning'
        flash.message = auto ? "Se guardo correctamente la informacion de el Automovil" : "No se pudo guardar el Automovil"

        chain action: 'index'
    }
}
