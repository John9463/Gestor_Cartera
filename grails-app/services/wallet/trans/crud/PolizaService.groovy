package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Poliza

@Transactional
class PolizaService {

    boolean exist(int id) {
        Poliza.exists(id)
    }

    @Transactional(readOnly = true)
    def list() {
        Poliza.list()
    }

    def save(def params) {
        new Poliza(params).save(flush: true)
    }

    def update(def params) {
        def poliza = get(params.id.toInteger())
        poliza.properties = params
        poliza.save(flush: true)
    }

    Poliza get(int id) {
        Poliza.get(id)
    }

    boolean delete(int id) {
        def del = Poliza.get(id)
        del.delete()
    }

}
