package gestorcartera

import wallet.trans.crud.ClientsService
import kit.Util

class ClienteController {
    static responseFormats = ['json']

    ClientsService clientsService

    def index() {
        def clientes = clientsService.list()
        def defaultModel = Util.getModelCliente()

        if (!clientes.isEmpty())
            defaultModel+=[clientes: clientes]

            render view: 'cliente', model: defaultModel
    }

    def save() {
        def cliente = clientsService.save(params)

        flash.target = cliente ? "Cliente Guardado" : "Cliente NO Guardado"
        flash.alert = cliente ? 'alert-success' : 'alert-warning'
        flash.message = cliente ? "Se guardo correctamente la informacion el Cliente" : "No se pudo guardar el Cliente"

        chain action: 'index'
    }

    def update() {
        def cliente = clientsService.update(params)

        flash.target = cliente ? "Cliente modificado" : "Cliente NO modificado"
        flash.alert = cliente ? 'alert-success' : 'alert-warning'
        flash.message = cliente ? "Se actualizo correctamente el Cliente" : "No se actualizo el cliente"

        chain action: 'index'
    }

    def get(int id) {
        respond clientsService.get(id)
    }

    def delete() {
        respond clientsService.delete(request.JSON.id)
    }

    def exist(int idCliente) {
        respond clientsService.exist(idCliente)
    }


}