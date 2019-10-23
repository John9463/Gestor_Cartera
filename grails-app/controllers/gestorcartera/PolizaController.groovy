package gestorcartera

import trans.crud.PolizaService
import wallet.Poliza

class PolizaController {

    PolizaService polizaService

    def index(){
            def list = Poliza.list()
            if(list.isEmpty())
                render view: 'poliza'
            else
                render view: 'poliza', model:[polizas: list]
    }

    def save(){
        params << [idPoliza: 5]
        def poliza = new Poliza(params).save()
        if( poliza ){
            render poliza.toString()
        }else{
            redirect action: 'index'
        }
    }







}
