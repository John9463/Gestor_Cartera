package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Seguro

@Transactional
class SeguroService {

    boolean exist(int id) {
        Seguro.exists(id)
    }

    def get(int id) {
        Seguro.get(id)
    }

    def save(def params) {
        if (params) {

        }
    }

    def list() {
        Seguro.list()
    }

    ArrayList<Aseguradora> getAseguradoras() {
        list().groupBy { it.aseguradora }.collect { new Aseguradora(it) }
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
