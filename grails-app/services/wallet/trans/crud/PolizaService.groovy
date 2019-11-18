package wallet.trans.crud

import grails.gorm.transactions.Transactional
import groovy.json.JsonBuilder
import wallet.Cliente
import wallet.Poliza
import wallet.Seguro

import java.text.SimpleDateFormat

@Transactional
class PolizaService {

    @Transactional(readOnly = true)
    def list(){
        Poliza.list()
    }

    def save(def params){
        def poliza = new Poliza(params)
        poliza.save()
    }

    def update(def params){
        def poliza = Poliza.get(params)
        poliza.save(flush: true)
    }

    Poliza get(int id) {
        Poliza.get(id)
    }

    boolean delete(int id) {
        try{
            def del = Poliza.get(id)
            del.delete()
            true
        }catch(Exception ex){
            false
        }
    }

}
