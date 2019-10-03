package gestorcartera

import wallet.trans.crud.ClientsService

class LoginController {

    ClientsService clientsService

    def index(){
        render view:'login'
    }

    def logIn(){
        if( params.user && params.password){
            redirect controller: 'dashboard', action:'index'
        }else if( !params.user && params.password )
            render view:'login', model: [error:'not-user']
        else if( params.user && !params.password )
            render view:'login', model: [error:'not-pass']
        else
            render view:'login', model: [error:'not-data']
    }


}
