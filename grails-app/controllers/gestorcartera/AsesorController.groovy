package gestorcartera

import wallet.trans.crud.AsesorService

class AsesorController {

    AsesorService asesorService

    def index() {
        def asesores = asesorService.list()
        def model = [:]

        if(asesores)
            model = [asesores: asesores]

        render view: 'asesor', model: model
    }

    def save(){
        def asesor = asesorService.save(params)

        def model = [:]

        model.message = asesor ? '' : ''
        model.action = asesor ? '' : ''

        chain action: 'index', model: model
    }

    def update(){
        def asesor = asesorService.update(params)

        model.message = asesor ? '' : ''
        model.action = asesor ? '' : ''

        chain action: 'index', model: model
    }

    def delete(int id){
        def asesor = asesorService.delete(id)

        model.message = asesor ? '' : ''
        model.action = asesor ? '' : ''

        chain action: 'index', model: model
    }


}
