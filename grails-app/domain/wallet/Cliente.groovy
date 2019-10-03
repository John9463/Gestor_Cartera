package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity

import java.sql.Date

@GrailsCompileStatic
class Cliente implements GormEntity<Cliente>{

    Integer idCliente
    Integer clave
    String tipo
    String nombre
    String apellPa
    String apellMa
    String rfc
    Date fechaNac
    Long tel
    String correo
    String calle
    String numero
    String colonia
    String ciudad
    String cp

    static constraints = {
    }




}
