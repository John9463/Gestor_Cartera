package wallet

import org.grails.datastore.gorm.GormEntity

class Seguro implements GormEntity<Seguro>{

    static belongsTo = [
            aseguradora: Aseguradora
    ]

    TipoSeguro tipo
    float valorSeguro
    long emisor
    Date rovacion
    String cobertura
    String sumaAsegurada
    float primaNeta

}
