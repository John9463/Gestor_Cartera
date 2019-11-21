package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Automovil
import wallet.Cliente
import wallet.Seguro

@Transactional
class AutomovilService {

    SeguroService seguroService

    def list() {
        Automovil.list()
    }

    def save(def params){
        new Automovil(params).save()
    }

    def get(int id){
        Automovil.get(id)
    }

    def model(){
        [seguros: Seguro.list(), aseguradoras: seguroService.getAseguradoras()]
    }
}
