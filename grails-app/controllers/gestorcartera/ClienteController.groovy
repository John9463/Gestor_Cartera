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
        if (chainModel)
            defaultModel+=chainModel

            render view: 'cliente', model: defaultModel
    }

    def save() {
        def cliente = clientsService.save(params)
        def model = [complete: true, message: 'El cliente NO fue guardado']

        if (cliente)
            model.message = 'El cliente fue guardado Exitosamente'

            chain action: 'index', model: model
    }

    def update() {
        def cliente = clientsService.update(params)
        def model = [show: true, message: 'El cliente NO fue guardado']

        flash.header = "hola mundo"
        flash.alert = cliente ? 'alert-success' : 'alert-warning'
        flash.message = "respuesta de lo que sucedio"
        flash.show = true


        forward controller: 'dashboard', action: 'index', model: model
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