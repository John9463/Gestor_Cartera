package gestorcartera

import wallet.trans.crud.ClientsService
import worker.Util

class ClienteController {
    static responseFormats = ['json']

    ClientsService clientsService

    def index(){
        def clientes = clientsService.list()
        if(clientes.isEmpty())
            render view: 'cliente', model: Util.getUtilitiesCliente()
        else
            render view: 'cliente', model: [clientes: clientes] + Util.getUtilitiesCliente()
    }

    def save(){
        def cliente = clientsService.save(params)
        if( cliente )
            render cliente
        else
            redirect action: 'index'
    }


    def update(){
        render clientsService.update( params )
    }

    def getCliente(){
        respond clientsService.get(request.JSON.id)
    }

    def delete(){
        response << clientsService.delete(request.JSON.id)
    }

    def exist(int idCliente) {
        respond clientsService.exist(idCliente)
    }

}