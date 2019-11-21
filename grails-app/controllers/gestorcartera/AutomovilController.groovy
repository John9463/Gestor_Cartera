package gestorcartera

import wallet.trans.crud.AutomovilService

class AutomovilController {
    static responseFormats = ['json']

    AutomovilService automovilService

    def index() {
        def autos = automovilService.list()
        def model = automovilService.model()

        if(autos)
            model+= [autos :autos]

        render view:'automovil', model: model
    }

    def get(int id){
        respond automovilService.get(id)
    }
}