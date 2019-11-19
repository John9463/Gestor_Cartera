package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Asesor

@Transactional
class AsesorService {

    def list() {
        Asesor.list()
    }

    def get(int id){
        Asesor.get(id)
    }

    boolean exist(int id){
        Asesor.exists(id)
    }

    def save(def params){
        new Asesor(params).save()
    }

    def update(def params){
        def asesor = get(params.id)
        asesor.properties = params
        asesor.save()
    }

    def delete(int id){
        def asesor = Asesor.get(id).delete()

        exist(id)
    }
}
