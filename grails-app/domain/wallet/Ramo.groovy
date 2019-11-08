package wallet

import org.grails.datastore.gorm.GormEntity

class Ramo implements GormEntity<Ramo>{

    long idsub
    String nramoombreRamo

    static belongsTo = [poliza: Poliza]

}
