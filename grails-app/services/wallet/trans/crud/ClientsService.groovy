package wallet.trans.crud

import grails.gorm.transactions.Transactional
import groovy.json.JsonBuilder
import wallet.Cliente
import worker.Util

@Transactional
class ClientsService{

    @Transactional(readOnly = true)
    def list(){
        Cliente.list()
    }

    def save(def params){
        params << [idClient: 5]
        new Cliente(params).save()
    }

    def update(def params){
        def cliente = Cliente.get(params.id)

        cliente.correo = params.correo
        cliente.fechaNac = Util.toDate(params.fechaNac)
        cliente.nombre = params.nombre
        cliente.apellMa = params.apellMa
        cliente.apellPa = params.apellPa
        cliente.ciudad = params.ciudad
        cliente.rfc = params.rfc
        cliente.colonia = params.colonia
        cliente.calle = params.calle
        cliente.cp = params.cp
        cliente.tipo = params.tipo
        cliente.numeros = params.numeros
        cliente.tel = params.tel as long

        cliente.save(flush: true)
    }

    def get(int id){
        Cliente.get(id)
    }

    def delete(int id){
        try{
            def del = Cliente.get(id)
            del.delete()
            true
        }catch(Exception ex){
            false
        }
    }

    boolean exist(int id) {
        Cliente.list().find { it.ident() == id }
    }

}
