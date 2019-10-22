package wallet

import org.grails.datastore.gorm.GormEntity

class Ramo implements GormEntity<Ramo>{

    long idRamo
    long idsubramo
    String nombreRamo

}
