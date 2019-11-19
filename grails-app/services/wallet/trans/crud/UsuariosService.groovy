package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Usuario

@Transactional
class UsuariosService {

    boolean exist(int id){
        Usuario.exists(id)
    }

    Usuario get(def entry) {
        Usuario.find { username == entry.user && password == entry.password }
    }


}
