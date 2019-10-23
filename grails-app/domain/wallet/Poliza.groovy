package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@GrailsCompileStatic
@ToString
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
    Date fechaDesde
    Date fechaHasta

    static constraints = {
    }

}
