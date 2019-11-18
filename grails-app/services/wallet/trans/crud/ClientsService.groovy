package wallet.trans.crud

import grails.gorm.transactions.Transactional
import groovy.json.JsonBuilder
import wallet.Cliente
import wallet.Usuario
import worker.Util

@Transactional
class ClientsService{

    @Transactional(readOnly = true)
    def list(){
        Cliente.list()
    }

    def save(def params){
        params.isIntegral = params.isIntegral == 'on'
        params.usuario = new Usuario(params)
        new Cliente(params).save()
    }

    def update(def params){
        def cliente = Cliente.get(params.id)
        cliente.isIntegral == params.isIntegral == 'on'
        cliente.clave = params.clave

        def usuario = new Usuario(params)
        usuario.id = cliente.usuario.id
        cliente.usuario = usuario
        usuario.save(flush: true)
        cliente.save(flush: true)
    }

    def get(int id){
        def cliente = Cliente.get(id)
        def usuario = Usuario.get(cliente.usuario.id)
        cliente.getProperties() + usuario.getProperties()
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
