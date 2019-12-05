package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Cliente
import wallet.Usuario

@Transactional
class ClienteService {

    @Transactional(readOnly = true)
    def list() {
        Cliente.list()
    }

    def save(def params) {
        params.usuario = new Usuario(params)
        params.isIntegral = params.isIntegral == 'on' ? 1 : 0
        new Cliente(params).save()
    }

    def update(def params) {
        def cliente = Cliente.get(params.id)
        cliente.isIntegral == params.isIntegral
        cliente.clave = params.clave

        def usuario = new Usuario(params)
        usuario.id = cliente.usuario.id
        cliente.usuario = usuario
        usuario.save(flush: true)
        cliente.save(flush: true)
    }

    def get(int id) {
        def cliente = Cliente.get(id)
        def usuario = Usuario.get(cliente.usuario.id)
        cliente.getProperties() + usuario.getProperties()
    }

    def delete(int id) {
        def del = Cliente.get(id)
        del.delete()
    }

    boolean exist(int id) {
        Cliente.exists(id)
    }

}
