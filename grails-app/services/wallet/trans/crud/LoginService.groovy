package wallet.trans.crud

import wallet.Asesor
import wallet.Cliente
import wallet.Usuario

class LoginService {

    Map getPermissions(Usuario user){
        if(Usuario.exists(user.id)){

            def permissions = [modules: [], domain: '']
            Asesor asesor = Asesor.find{ usuario == user }
            Cliente cliente = Cliente.find{ usuario == user}

            if( asesor && cliente) // Esto no puede ocurrir
                throw NullPointerException("No puede existir el mismo usuario para Asesor y Cliente")
            else if( asesor ){
                permissions.modules = ['cliente','poliza']
                permissions.domain = 'asesor'

                if( asesor.isAdmin ){
                    permissions.modules+= ['automovil','seguro','asesor','reporte']
                    permissions.domain+='_admin'
                }

            }else if( cliente ){
            }else if( cliente ){
                permissions.modules = ['poliza','automovil']
                permissions.domain = 'cliente'
            }else
                throw NullPointerException("El usuario ${usuario.nombre} NO PUEDE existir en la tabla Asesor y Cliente")

            return permissions
        }
    }

}
