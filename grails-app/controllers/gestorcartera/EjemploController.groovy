package gestorcartera

class EjemploController {

    def index() {

        def nombre = 'Aldo Daniel'
        def val = true

        render(view:'VistaDeEjemplo.gsp', model: [name: nombre, verda: val])
     }
}
