package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Seguro

@Transactional
class SeguroService {

    boolean delete(int id) {
        def seguro = Seguro.get(id)
        seguro.delete()
    }

    boolean exist(int id) {
        Seguro.exists(id)
    }

    def get(int id) {
        Seguro.get(id)
    }

    def save(def params) {
        new Seguro(params).save()
    }

    def update(def params){
        def seguro = get(params.id.toInteger())
        seguro.properties = params
        seguro.save()
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
