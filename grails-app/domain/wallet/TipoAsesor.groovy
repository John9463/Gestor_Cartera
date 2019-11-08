package wallet

class TipoAsesor {

    static belongsTo = [usuario:Usuario]

    //identificador de nivel: A, B , C ,D
    String tipo
    //tipos de clientes a gestionar [A:['empresas pequeñas',''],B:['empresas medianas'],c:['empresas grandes','conglomerados']]
    String rango

}
