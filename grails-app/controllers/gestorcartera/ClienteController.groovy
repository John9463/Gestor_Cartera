package gestorcartera

import wallet.trans.crud.ClienteService
import kit.Util

class ClienteController {
    static responseFormats = ['json']

    ClienteService clienteService

    def index() {
        def clientes = clienteService.list()
        def defaultModel = Util.getModelCliente()

        if (!clientes.isEmpty())
            defaultModel+=[clientes: clientes]

            render view: 'cliente', model: defaultModel
    }

    def save() {
        def cliente = clienteService.save(params)

        flash.target = cliente ? "Cliente Guardado" : "Cliente NO Guardado"
        flash.alert = cliente ? 'alert-success' : 'alert-warning'
        flash.message = cliente ? "Se guardo correctamente la informacion el Cliente" : "No se pudo guardar el Cliente"

        chain action: 'index'
    }

    def update() {
        def cliente = clienteService.update(params)

        flash.target = cliente ? "Cliente modificado" : "Cliente NO modificado"
        flash.alert = cliente ? 'alert-success' : 'alert-warning'
        flash.message = cliente ? "Se actualizo correctamente el Cliente" : "No se actualizo el Cliente"

        chain action: 'index'
    }

    def get(int id) {
        respond clienteService.get(id)
    }

    def delete() {
        respond clienteService.delete(request.JSON.id)
    }

    def exist(int cliente) {
        response << clienteService.exist(cliente)
    }


}