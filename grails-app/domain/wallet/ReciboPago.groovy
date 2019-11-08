package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity
import java.sql.Date

@GrailsCompileStatic
class ReciboPago implements GormEntity<ReciboPago>{

    static belongsTo = [poliza: Poliza]

    String numRecibo
    float monto
    int numeroPeriodoPago
    Date fechaPago
    String status_pago

    static constraints = {
    }

}
