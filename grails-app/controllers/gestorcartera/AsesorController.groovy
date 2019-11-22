package gestorcartera

import wallet.trans.crud.AsesorService

class AsesorController {

    static responseFormats = ['json']

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

        flash.target = asesor ? "Asesor Guardado" : "Asesor NO Guardado"
        flash.alert = asesor ? 'alert-success' : 'alert-warning'
        flash.message = asesor ? "Se guardo correctamente la informacion de el Asesor" : "No se pudo guardar el Asesor"

        chain action: 'index'
    }

    def update(){
        def asesor = asesorService.update(params)

        flash.target = asesor ? "Asesor modificado" : "Asesor NO modificado"
        flash.alert = asesor ? 'alert-success' : 'alert-warning'
        flash.message = asesor ? "Se actualizo correctamente de el Asesor" : "No se actualizo el Asesor"

        chain action: 'index'
    }

    def delete(int id){
        def asesor = asesorService.delete(id)

        model.message = asesor ? '' : ''
        model.action = asesor ? '' : ''

        chain action: 'index', model: model
    }

    def get(int id){
        respond asesorService.get(id)
    }

}
