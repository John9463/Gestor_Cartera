package wallet

import org.grails.datastore.gorm.GormEntity

class Automovil implements GormEntity<Automovil>{

    long idAuto
    String nombre
    int idClient
    int idSeguro
    int modelo
    String tipo
    String placas
    String uso
    long num_serie
    long num_motos

}
