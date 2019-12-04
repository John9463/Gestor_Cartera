package wallet.trans.crud

import wallet.Asesor
import wallet.Cliente
import wallet.Usuario

class LoginService {

    UsuariosService usuariosService

    def getUserForLogin(def bodyUser){
        def user = usuariosService.get(bodyUser)

        if( user ){
            return new UserLogin(
                    usuario: user,
                    permissions: getPermissions(user)
            )
        }
        user
    }

    Map getPermissions(Usuario user){
        if(usuariosService.existId(user.id)){

            def permissions = [modules: [], domain: '']
            Asesor asesor = Asesor.find{ usuario == user }
            Cliente cliente = Cliente.find{ usuario == user}

            if( asesor && cliente) // Esto no puede ocurrir
                throw NullPointerException("No puede existir el mismo usuario para Asesor y Cliente")
            else if( asesor ){
                permissions.modules = ['cliente','poliza']
                permissions.domain = 'asesor'

                if( asesor.isAdmin ){
                    permissions.modules += ['automovil', 'seguro', 'asesor']
                    permissions.domain+='_admin'
                }

            }else if( cliente ){
                permissions.modules = ['poliza','automovil']
                permissions.domain = 'cliente'
            }

            return permissions
        }
    }

    private class UserLogin{

        Usuario usuario
        Map permissions
    }


}
