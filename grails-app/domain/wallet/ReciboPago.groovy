package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity
import java.sql.Date

@GrailsCompileStatic
class ReciboPago implements GormEntity<ReciboPago>{

    long idRecibo
    long idCliente
    long idPoliza
    float monto
    int numeroPeriodoPago
    Date fechaPago
    String status_pago

    static constraints = {
    }

}
