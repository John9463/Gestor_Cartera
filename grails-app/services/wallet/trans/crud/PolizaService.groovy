package wallet.trans.crud

import grails.gorm.transactions.Transactional
import groovy.json.JsonBuilder
import wallet.Poliza
import java.text.SimpleDateFormat

@Transactional
class PolizaService {

    @Transactional(readOnly = true)
    def list(){
        Poliza.list()
    }

    def save(def params){
        params << [idPoliza: 5]
        new Poliza(params).save()
    }

    def update(def params){
        def poliza = Poliza.get(params.id)

        poliza.idCliente = params.idCliente as long
        poliza.idSeguro = params.idSeguro as long
        poliza.idRamo = params.idRamo as long
        poliza.idStatus = params.idStatus as long
        poliza.primaTotal = params.primaTotal as long
        poliza.clave = params.clave
        poliza.gastosExpedicion = params.gastosExpedicion as float
        poliza.financiamiento = params.financiamiento as float
        poliza.comisionCedida = params.comisionCedida as float
        poliza.numeroRemision = params.numeroRemision as int
        poliza.periodo = params.periodo
        poliza.fechaDesde = new SimpleDateFormat('dd-MM-YYYY').parse(params.fechaDesde)
        poliza.fechaHasta = new SimpleDateFormat('dd-MM-YYYY').parse(params.fechaHasta)

        poliza.save(flush: true)
    }

    def get(int id){
        def poliza = Poliza.get(id)
        def out = new JsonBuilder(poliza.properties).toPrettyString()
    }

    def delete(int id){
        try{
            def del = Poliza.get(id)
            del.delete()
            true
        }catch(Exception ex){
            false
        }
    }

}
