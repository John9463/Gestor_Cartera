package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity
import java.sql.Date

@GrailsCompileStatic
class Seguro implements GormEntity<Seguro>{

    Integer idSeguro
    String tipoSeguro
    Float valorAsegurado
    Integer emisor
    Date vigenciaDsd
    Date vigenciaHasta
    Date renovacion
    String aseguradora
    String cobertura
    String tipoCovertura
    Float sumaAsegurada
    Float deducible
    Float primaNeta


    static constraints = {
    }

}
