package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Usuario

@Transactional
class UsuariosService {

    Usuario get(String user, String pass) {
        Usuario.find { username == user && password == pass }
    }

}
