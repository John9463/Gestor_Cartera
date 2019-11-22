package wallet.trans.crud

import grails.gorm.transactions.Transactional
import wallet.Asesor
import wallet.Cliente
import wallet.Usuario

@Transactional
class AsesorService {

    def list() {
        Asesor.list()
    }

    def get(int id){
        def asesor = Asesor.get(id)
        def usuario = Usuario.get(asesor.usuario.id)
        asesor.getProperties() + usuario.getProperties()
    }

    boolean exist(int id){
        Asesor.exists(id)
    }

    def save(def params){
        params.isAdmin = params.isAdmin == 'on' ? 1 : 0
        params.usuario = new Usuario(params)
        new Asesor(params).save()
    }

    def update(def params){
        def asesor = Asesor.get(params.id)
        params.isAdmin =  params.isAdmin == 'on' ? 1 : 0
        asesor.properties = params

        def usuario = new Usuario(params)
        asesor.usuario = usuario

        usuario.save(flush: true)
        asesor.save(flush: true)
    }

    def delete(int id){
        def asesor = Asesor.get(id).delete()

        exist(id)
    }
}
