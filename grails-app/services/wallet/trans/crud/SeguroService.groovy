package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Seguro
import wallet.TipoSeguro

@Transactional
class SeguroService {

    def get(int id){
        Seguro.get(id)
    }

    def save(def params){
        if(params){

        }
    }

    def list(){
        TipoSeguro.list()
    }

}
