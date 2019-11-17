package wallet

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@ToString
@GrailsCompileStatic
class Cliente implements GormEntity<Cliente>{

    static hasMany = [
            polizas: Poliza,
            asesores: Asesor
    ]

    static  belongsTo = [ usuario: Usuario ]

    String clave

    boolean isIntegral

    static mapping = {
        version: false
    }

}
