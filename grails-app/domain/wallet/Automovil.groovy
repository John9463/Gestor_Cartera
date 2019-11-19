package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@ToString
@GrailsCompileStatic
class Automovil implements GormEntity<Automovil> {

    Cliente cliente
    Seguro seguro
    String nombre
    int modelo
    String tipo
    String placas
    String uso
    long numSerie
    long numMotor

    static mapping = {
        version: false
    }
}
