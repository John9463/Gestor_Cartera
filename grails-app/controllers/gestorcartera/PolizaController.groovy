package gestorcartera

import wallet.trans.crud.PolizaService
import wallet.trans.crud.SeguroService
import worker.Util

class PolizaController {
    static responseFormats = ['json']

    PolizaService polizaService
    SeguroService seguroService

    def index(){
            def polizas = polizaService.list()

            if(polizas.isEmpty())
                render view: 'poliza', model: Util.getUtilitiesPoliza() + seguroService.getAseguradoras()
            else
                render view: 'poliza', model: [polizas: polizas] + Util.getUtilitiesPoliza() + seguroService.getAseguradoras()
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
        respond polizaService.get(request.JSON.id)
    }

    def delete(){
        respond polizaService.delete(request.JSON.id)
    }








}
