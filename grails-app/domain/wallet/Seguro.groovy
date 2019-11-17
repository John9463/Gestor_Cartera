package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@ToString
@GrailsCompileStatic
class Seguro implements GormEntity<Seguro>{

    String nombre
    String aseguradora
    String tipo
    float valorSeguro
    long emisor
    Date renovacion
    String cobertura
    String sumaAsegurada
    float primaNeta

    static mapping = {
        version: false
    }

}
