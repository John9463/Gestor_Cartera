package gestorcartera

import grails.artefact.Controller
import wallet.trans.crud.LoginService

class LoginController implements Controller{

    static allowedMethods = [
            login: 'POST',
            index: ['GET', 'POST'],
            logout: 'POST'
    ]

    LoginService loginService

    def index() {
        render view: 'login'
    }

    def login() {
        def usuario = loginService.getUserForLogin(params)

        if (usuario) {
            session['permissions'] = loginService.getPermissions(usuario)
            session['current-user'] = usuario.properties

            redirect controller: 'dashboard', action: 'index'
        }

        flash.message = "El usuario y/o la contraseña no son correctas,Sugerencia: Verifica tu ${ usuario.username ? 'Contraseña' : 'Usuario' }."

        chain(action: 'index')
    }

    def logout(){
        session.invalidate()
    }

}
