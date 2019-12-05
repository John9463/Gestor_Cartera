package gestorcartera

import grails.artefact.Controller
import wallet.trans.crud.LoginService

class LoginController implements Controller{

    LoginService loginService

    def index() {
        render view: 'login'
    }

    //Verifica la existencia y otorga los permisos requeridos
    def check() {
        if(request.method == 'POST'){
            def usuario = loginService.getUserForLogin(params)

            if (usuario) {
                session['permissions'] = usuario.permissions
                session['current-user'] = usuario.properties

                redirect controller: usuario.permissions.modules[0], action: 'index'
            }else{
                flash.message = "El usuario y/o la contraseña no son correctas,Sugerencia: Verifica tu ${ usuario?.username ? 'Contraseña' : 'Usuario' }."

                chain(action: 'index')
            }
        }else
            redirect action: 'index'
    }

    def logout(){
        session.invalidate()
    }

}
