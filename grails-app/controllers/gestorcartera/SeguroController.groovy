package gestorcartera

import wallet.trans.crud.SeguroService
import worker.Util

class SeguroController {

    SeguroService seguroService

    def index() {
        def seguros = seguroService.list()
        def defaultModel = Util.getModelSeguro()

        if(seguros.isEmpty()){
            render view: 'seguro', model:
        }else{
            render view: 'seguro', model: [seguros: seguros] + [aseguradoras: Util.getUtilitiesClassSeguro().getAseguradoras()]
        }

    }

    def getSeguro(){
        response << seguroService.get(request.JSON.id)
    }

    def save(){
        response << seguroService.save(params)
    }

    def update(){
        response << seguroService.update(params)
    }

    def delete(){
        response << seguroService.delete(request.JSON.id)
    }

    def exist(int idSeguro) {
        respond seguroService.exist(idSeguro)
    }

}