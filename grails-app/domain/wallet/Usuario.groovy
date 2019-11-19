package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@ToString
@GrailsCompileStatic
class Usuario implements GormEntity<Usuario> {

    String username
    String password

    String correo
    String nombre
    String apellMa
    String apellPa
    String ciudad
    String rfc
    String colonia
    String calle
    String cp
    Date fechaNac
    String noCasa
    long tel

    static mapping = {
        version: false
    }

}
