package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.DescPoliza
import wallet.Poliza

@Transactional
class PolizaService {

    def save(def values){
        def newPoliza = new Poliza( cleanKeys(values) ).save()

        newPoliza
    }

    @Transactional(readOnly = true)
    def list(){
        Poliza.list()
    }

    private def cleanKeys(def values){
        values.remove('_action_save')
        values.remove('controller')
        values.remove('format')
        values.remove('action')
        values
    }

}
