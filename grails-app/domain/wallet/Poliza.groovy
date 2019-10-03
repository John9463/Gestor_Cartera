package wallet

import grails.compiler.GrailsCompileStatic
import org.grails.datastore.gorm.GormEntity

import java.sql.Date

@GrailsCompileStatic
class Poliza implements GormEntity<Poliza>{

    Integer idPoliza
    Integer idCliente
    String numRemision
    String tipoDoc
    String ramo
    String subramo
    String aseguradora
    Date vigenciaDsd
    Date vigenciaHasta
    String periodo
    String grupo
    String empresa
    String sucursal
    Integer cis
    Float comCedida
    Float fnanto
    Float gtosExp
    Float primaTotal

    static constraints = {
    }

}
