package gestorcartera

import wallet.trans.crud.SeguroService
import kit.Util

class SeguroController {

    static responseFormats = ['json']

    SeguroService seguroService

    def index() {
        def seguros = seguroService.list()
        def model = Util.getModelSeguro()

        if (seguros)
            model += [seguros: seguros]

        render view: 'seguro', model: model
    }

    def get(int id) {
        respond seguroService.get(id)
    }

    def save() {
        def cliente = seguroService.save(params)

        flash.target = cliente ? "Seguro Guardado" : "Seguro NO Guardado"
        flash.alert = cliente ? 'alert-success' : 'alert-warning'
        flash.message = cliente ? "Se guardo correctamente la informacion de el Seguro" : "No se pudo guardar el Seguro"

        chain action: 'index'
    }

    def update() {
        def cliente = seguroService.update(params)

        flash.target = cliente ? "Seguro Actualizado" : "Seguro NO Actualizado"
        flash.alert = cliente ? 'alert-success' : 'alert-warning'
        flash.message = cliente ? "Se actualizo correctamente la informacion de el Seguro" : "No se pudo actualizarel Seguro"

        chain action: 'index'
    }

    def delete(int id) {
        response << seguroService.delete(id)
    }

    def exist(int idSeguro) {
        respond seguroService.exist(idSeguro)
    }

}