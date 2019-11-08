package gestorcartera

import groovy.util.logging.Slf4j
import wallet.Usuario

import java.text.SimpleDateFormat

@Singleton
@Slf4j
class DataConfig {

    def superUser = [
            username: 'pacman',
            password: 'pass',
            correo: 'pacman_azul@hotmail.com',
            nombre: 'juan',
            apellMa: 'sanchez',
            apellPa: 'sanchez',
            ciudad: 'toluca',
            rfc: 'sasj870712p7',
            colonia: 'nueva oxtotitla',
            calle: 'laguna de huapango',
            cp: '50100',
            fechaNac: new SimpleDateFormat('dd/MM/YYYY').parse('12/07/1987'),
            noCasa: '417',
            tel: 7222024401
    ]

    void init(){
        log.info('init configuration')
        adminRoot()
    }

    void adminRoot(){
        if(Usuario.list().isEmpty()){
            def root = new Usuario(superUser)
            root.save()
            log.info("Ingresando usuario ROOT: "+ root.toString())
        }

    }

}
