package gestorcartera

import wallet.Poliza
import wallet.trans.crud.PolizaService

class PolizaController {

    PolizaService polizaService

    def index(){
        render view:'poliza'
    }

    def save(){
        if ( polizaService.save( params ))
            render "<h1>La poliza fue guardada exitosamente</h1>"
        else
            redirect view: 'poliza', model: []
    }







}
