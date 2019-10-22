package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity

import java.sql.Date

@GrailsCompileStatic
class Poliza implements GormEntity<Poliza>{

    long idPoliza
    long idSeguro
    long idCliente
    long idRamo
    long idStatus
    long primaTotal
    String clave
    float gastosExpedicion
    float financiamiento
    float comisionCedida
    String periodo
    int numeroRemision
    Date fecha_desde
    Date fecha_hasta

    static constraints = {
    }

}
