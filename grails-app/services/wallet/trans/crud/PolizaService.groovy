package trans.crud

import grails.gorm.transactions.Transactional
import wallet.Poliza

@Transactional
class PolizaService {

    def save(def values){
        values << [idPoliza: Poliza.list().size() + 2]
        new Poliza( cleanKeys(values) ).save()
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
