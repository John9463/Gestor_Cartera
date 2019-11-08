package gestorcartera

import wallet.Usuario
import wallet.trans.crud.UsuariosService

class LoginController {

    UsuariosService usuariosService

    def index(){
        render view:'login'
    }

    def logIn(){
        def usuario = usuariosService.get( params.user , params.password )

        if( usuario ){
            redirect controller: 'dashboard', action:'index'
        }else if( !params.user && params.password )
            render view:'login', model: [error:'not-user']
        else if( params.user && !params.password )
            render view:'login', model: [error:'not-pass']
        else
            render view:'login', model: [error:'not-data']
    }


}
