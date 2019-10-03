package gestorcartera

import wallet.Poliza
import wallet.trans.crud.PolizaService

class PolizaController {

    PolizaService polizaService

    def index(){
        render view:'poliza'
    }

    def save(){
       render new Poliza(cleanKeys(params)).save()
    }

    def cleanKeys(def values){
        values.remove('_action_save')
        values.remove('controller')
        values.remove('format')
        values.remove('action')
        values
    }





}
