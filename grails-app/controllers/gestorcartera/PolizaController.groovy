package gestorcartera

import trans.crud.PolizaService
import wallet.Poliza

class PolizaController {

    PolizaService polizaService

    def index(){
//        def polizas = polizaService?.list()
//        if(!polizas.isEmpty())
//            render view:'poliza', model:[polizas: polizas]
//        else
            render view: 'poliza'
    }

    def save(){
        def poliza = new Poliza(params).save()
        if( poliza ){
            render poliza.toString()
        }else{
            redirect action: 'index'
        }
    }







}
