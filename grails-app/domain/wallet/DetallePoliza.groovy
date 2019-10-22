package wallet

import org.grails.datastore.gorm.GormEntity

class DetallePoliza implements GormEntity<DetallePoliza>{

    long idDetalle
    long idPoliza
    String descripcion

}
