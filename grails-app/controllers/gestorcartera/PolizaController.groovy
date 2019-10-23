package gestorcartera

import wallet.trans.crud.PolizaService

class PolizaController {
    static responseFormats = ['json']

    PolizaService polizaService

    def index(){
            def list = polizaService.list()
            if(list.isEmpty())
                render view: 'poliza'
            else
                render view: 'poliza', model:[polizas: list]
    }

    def save(){
        def poliza = polizaService.save(params)
        if( poliza )
            render poliza
        else
            redirect action: 'index'
    }


    def update(){
        render polizaService.update( params )
    }

    def getPoliza(){
        response << polizaService.get(request.JSON.id)
    }

    def delete(){
        response << polizaService.delete(request.JSsON.id)
    }








}
