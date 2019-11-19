package wallet

import org.grails.datastore.gorm.GormEntity

class Asesor implements GormEntity<Asesor>{

    static belongsTo = [usuario: Usuario]

    String homoclave

    String tipoAsesor

    int isAdmin

    static hasMany = [clientes: Cliente]

    static mapping = {
        version false
    }

}
