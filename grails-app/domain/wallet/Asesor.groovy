package wallet

class Asesor {

    static belongsTo= [ usuario:Usuario ]

    String homoclave

    TipoAsesor asesor

    boolean isAdmin

    static hasMany = [clientes: Cliente]

}
