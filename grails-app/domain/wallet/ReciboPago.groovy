package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity
import java.sql.Date

@GrailsCompileStatic
class ReciboPago implements GormEntity<ReciboPago>{

    Integer idRecibo
    Integer idPoliza
    Integer numRecibo
    String formaPago
    Integer numPago
    Float monto
    Date vigenciaDsd
    Date vigenciaHasta
    Date fechaPago
    String moneda
    String estado
    Float comision


    static constraints = {
    }

}
