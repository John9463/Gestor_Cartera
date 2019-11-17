package wallet

import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@ToString
class ReciboPago implements GormEntity<ReciboPago>{

    static belongsTo = [poliza: Poliza]

    String numRecibo
    float monto
    int numeroPeriodoPago
    Date fechaPago
    String statusPago

    static mapping = {
        version false
    }

}
