package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity


@GrailsCompileStatic
@ToString
class Cliente implements GormEntity<Cliente>{

    int idClient
    String correo
    Date fechaNac
    String nombre
    String apellMa
    String apellPa
    String ciudad
    String rfc
    String colonia
    String calle
    String cp
    String tipo
    String numeros
    long tel


    static constraints = {
    }




}
