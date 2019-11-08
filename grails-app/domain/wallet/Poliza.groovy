package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@GrailsCompileStatic
@ToString
class Poliza implements GormEntity<Poliza>{

    static belongsTo = [cliente:Cliente]

    static hasOne = [
            ramo: Ramo
    ]

    static hasMany = [recibosPago: ReciboPago]

    StatusPoliza status

    Periodos periodo
    Seguro seguro
    long primaTotal
    String clave
    float gastosExpedicion
    float financiamiento
    float comisionCedida
    int numeroRemision
    Date fechaDesde
    Date fechaExpicion

    static constraints = {
    }

}
