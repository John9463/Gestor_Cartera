package wallet

import org.grails.datastore.gorm.GormEntity

class TipoSeguro implements GormEntity<TipoSeguro>{

    static belongTo = [ seguro: Seguro ]

    String nombre

}
