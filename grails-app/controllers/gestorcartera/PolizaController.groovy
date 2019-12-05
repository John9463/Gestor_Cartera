package gestorcartera


import wallet.trans.crud.PolizaService
import wallet.trans.crud.SeguroService
import kit.Util

class PolizaController {
    static responseFormats = ['json']

    PolizaService polizaService
    SeguroService seguroService

    def index() {
        def polizas = polizaService.list()
        def model = Util.getModelPoliza(seguroService.aseguradoras)

        if (polizas)
            model += [polizas: polizas]

        render view: 'poliza', model: model
    }

    def save() {
        def poliza = polizaService.save(params)

        flash.target = poliza ? "Poliza Guardada" : "Poliza NO Guardado"
        flash.alert = poliza ? 'alert-success' : 'alert-warning'
        flash.message = poliza ? "Se guardo correctamente la informacion de la Poliza" : "No se pudo guardar la Poliza"

        chain action: 'index'
    }

    def update() {
        def poliza = polizaService.update(params)

        flash.target = poliza ? "Poliza Actualizada" : "Poliza NO Actualizada"
        flash.alert = poliza ? 'alert-success' : 'alert-warning'
        flash.message = poliza ? "Se guardo correctamente la informacion de la Poliza" : "No se pudo guardar la Poliza"

        chain action: 'index'
    }

    def delete(int id) {
        response << polizaService.delete(id)
    }

    def get(int id) {
        respond polizaService.get(id)
    }

}
