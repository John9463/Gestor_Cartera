package gestorcartera

import wallet.trans.crud.ClientsService
import kit.Util

class ClienteController {
    static responseFormats = ['json']

    ClientsService clientsService

    def index() {
        def clientes = clientsService.list()
        def defaultModel = Util.getModelCliente()

        if (clientes.isEmpty())
            render view: 'cliente', model: defaultModel
        else
            render view: 'cliente', model: [clientes: clientes] + defaultModel
    }

    def save() {
        def cliente = clientsService.save(params)
        if (cliente)
            render cliente
        else
            redirect action: 'index'
    }


    def update() {
        render clientsService.update(params)
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