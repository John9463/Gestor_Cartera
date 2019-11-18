package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@GrailsCompileStatic
@ToString
class Poliza implements GormEntity<Poliza>{

    static hasMany = [recibosPago: ReciboPago]

    Cliente cliente
    Seguro seguro
    String ramo
    String clave
    String status
    String periodo
    long primaTotal
    float gastosExpedicion
    float financiamiento
    float comisionCedida
    int numeroRemision
    Date fechaDesde
    Date fechaExpedicion

    static mapping = {
        version: false
    }

}
