package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.DescPoliza
import wallet.Poliza

@Transactional
class PolizaService {

    def save(def values){


    }

    def list(){
        DescPoliza.list()
    }

    def cleanKeys(def values){
        values.remove('_action_save')
        values.remove('controller')
        values.remove('format')
        values.remove('action')
        values
    }

}
