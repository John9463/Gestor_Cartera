package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@GrailsCompileStatic
@ToString
class Cliente implements GormEntity<Cliente> {

    static hasMany = [
            polizas : Poliza,
            asesores: Asesor
    ]

    static belongsTo = [usuario: Usuario]

    String clave

    int isIntegral

    static mapping = {
        version: false
    }

}
