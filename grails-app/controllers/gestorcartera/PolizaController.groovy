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
        def defaultModel = Util.getModelPoliza(seguroService.aseguradoras)

            if(polizas.isEmpty())
                render view: 'poliza', model: defaultModel
            else
                render view: 'poliza', model: [polizas: polizas] + defaultModel
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

    def get(int id) {
        respond polizaService.get(id)
    }

    def delete(int id) {
        respond polizaService.delete(id)
    }








}
