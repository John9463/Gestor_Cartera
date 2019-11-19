package gestorcartera

import grails.artefact.Controller
import wallet.trans.crud.LoginService
import wallet.trans.crud.UsuariosService

class LoginController implements Controller{

    UsuariosService usuariosService
    LoginService loginService

    def index() {
        render view: 'login'
    }

    def logIn() {
        def usuario = usuariosService.get(params)

        if (usuario) {
            session['permissions'] = loginService.getPermissions(usuario)
            session['current-user'] = usuario.properties

            redirect controller: 'dashboard', action: 'index'
        } else if (!params.user && params.password)
            render view: 'login', model: [error: 'not-user']
        else if (params.user && !params.password)
            render view: 'login', model: [error: 'not-pass']
        else
            render view: 'login', model: [error: 'not-data']
    }


}
