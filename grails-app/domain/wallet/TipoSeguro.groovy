package wallet

import org.grails.datastore.gorm.GormEntity

class TipoSeguro implements GormEntity<TipoSeguro>{

    long idTipoSeguro
    String nombre

}
