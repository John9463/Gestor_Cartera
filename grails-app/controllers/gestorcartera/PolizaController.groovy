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
        def defaultModel = Util.getModelPoliza(seguroService.aseguradoras)

        if (polizas.isEmpty())
            render view: 'poliza', model: defaultModel
        else
            render view: 'poliza', model: [polizas: polizas] + defaultModel + params
    }

    def save() {
        def poliza = polizaService.save(params)

        def actionValue = poliza ? 'ok' : 'nok'
        def messageValue = poliza ? 'Se guardo correctamente la Poliza' : 'No se pudo alamacenar la Poliza'

        chain action: 'index', model: [confirm: Util.responseConfirm(actionValue, messageValue, 'poliza').properties]
    }

    def update() {
        def poliza = polizaService.update(params)

        def actionValue = poliza ? 'OK' : 'NOK'
        def messageValue = poliza ? 'Se actualizo correctamente la Poliza' : 'No se pudo actualizar la Poliza'

        chain action: 'index', model: [confirm: Util.responseConfirm(actionValue, messageValue, 'poliza').properties]
    }

    def delete(int id) {
        polizaService.delete(id)
        def poliza = polizaService.exist(id)

        def actionValue = !poliza ? 'ok' : 'nok'
        def messageValue = !poliza ? 'Se elimino correctamente la Poliza' : 'No se pudo eliminar la Poliza'

        respond Util.responseConfirm(actionValue, messageValue, 'poliza')

    }

    def get(int id) {
        respond polizaService.get(id)
    }

}
