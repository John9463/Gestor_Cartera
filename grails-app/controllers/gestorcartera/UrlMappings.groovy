package gestorcartera

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/login/login")
        "/seguro/check/$idPoliza"(controller: 'seguro', action: 'exist')
        "/cliente/check/$idCliente"(controller: 'cliente', action: 'exist')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
