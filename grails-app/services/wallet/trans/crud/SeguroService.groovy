package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Seguro

@Transactional
class SeguroService {

    boolean exist(int id) {
        Seguro.list().find { it.ident() == id }
    }

    def get(int id){
        Seguro.get(id)
    }

    def save(def params){
        if(params){

        }
    }

    def list(){
        Seguro.list()
    }

    Map getAseguradoras() {
        def seguros = Seguro.list()
        def aseguradoras = seguros.groupBy { it.aseguradora }.collect { new Aseguradora(it) }
        return [aseguradoras: aseguradoras]
    }

    private class Aseguradora {
        String name
        ArrayList<Seguro> seguros

        Aseguradora(def entry) {
            name = entry.key
            seguros = entry.value
        }
    }

}
