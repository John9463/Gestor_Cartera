package gestorcartera

import wallet.trans.crud.ClientsService

class ClienteController {
    static responseFormats = ['json']

    ClientsService clientsService

    def index(){
        def list = clientsService.list()
        if(list.isEmpty())
            render view: 'cliente'
        else
            render view: 'cliente', model:[clientes: list]
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
        response << clientsService.get(request.JSON.id)
    }

    def delete(){
        response << clientsService.delete(request.JSON.id)
    }

}