package gestorcartera

import wallet.trans.crud.SeguroService
import kit.Util

class SeguroController {

    static responseFormats = ['json']

    SeguroService seguroService

    def index() {
        def seguros = seguroService.list()
        def defaultModel = Util.getModelSeguro()

        if (seguros.isEmpty()) {
            render view: 'seguro', model: defaultModel
        } else {
            render view: 'seguro', model: [seguros: seguros] + [aseguradoras: Util.getUtilitiesClassSeguro().getAseguradoras()]
        }

    }

    def get(int id) {
        respond seguroService.get(request.JSON.id)
    }

    def save() {
        respond seguroService.save(params)
    }

    def update() {
        respond seguroService.update(params)
    }

    def delete() {
        respond seguroService.delete(request.JSON.id)
    }

    def exist(int idSeguro) {
        respond seguroService.exist(idSeguro)
    }

}