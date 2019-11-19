package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@ToString
@GrailsCompileStatic
class Automovil implements GormEntity<Automovil> {

    static belongsTo = [
            cliente: Cliente
    ]

    Seguro seguro
    String nombre
    int modelo
    String tipo
    String placas
    String uso
    long num_serie
    long num_motor

    static mapping = {
        version: false
    }
}
