package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity

@GrailsCompileStatic
class DescPoliza implements GormEntity<DescPoliza>{

    Integer idDescProducto
    Integer idProducto
    String descripcion

    static constraints = {
    }

}
