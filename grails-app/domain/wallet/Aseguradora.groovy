package wallet

import org.grails.datastore.gorm.GormEntity

class Aseguradora implements GormEntity<Aseguradora>{

    static hasMany = [seguros: Seguro]

    String nombre

    static constrains = {
        version false
    }

}
