package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Automovil
import wallet.Seguro

@Transactional
class AutomovilService {

    def list() {
        Automovil.list()
    }

    def get(int id){
        Automovil.get(id)
    }

    def model(){
        [seguros: Seguro.list()]
    }
}
