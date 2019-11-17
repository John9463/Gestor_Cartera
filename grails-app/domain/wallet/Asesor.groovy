package wallet

class Asesor {

    static belongsTo= [ usuario:Usuario ]

    String homoclave

    String tipoAsesor

    boolean isAdmin

    static hasMany = [clientes: Cliente]

    static mapping = {
        version false
    }

}
