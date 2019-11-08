package wallet

import org.grails.datastore.gorm.GormEntity

class Automovil implements GormEntity<Automovil>{

    static belongsTo = [
            cliente:Cliente,
            seguro:Seguro
    ]

    String nombre
    int modelo
    String tipo
    String placas
    String uso
    long num_serie
    long num_motor

}
