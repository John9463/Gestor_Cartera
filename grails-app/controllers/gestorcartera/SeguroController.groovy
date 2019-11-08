package gestorcartera

import wallet.trans.crud.SeguroService

class SeguroController {

    SeguroService seguroService

    def index() {
        def seguros = seguroService.list()

        if(seguros.isEmpty()){
            render view: 'seguro'
        }else{
            render view: 'seguro', model:[seguros: seguros]
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

}