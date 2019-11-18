package gestorcartera

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/login/login")
        "/poliza/get/$id"(controller: poliza, action: 'get')
        "/poliza/delete/$id"(controller: poliza, action: 'delete')
        "/cliente/get/$id"(controller: cliente, action: 'get')
        "/seguro/check/$id"(controller: 'seguro', action: 'exist')
        "/cliente/check/$id"(controller: 'cliente', action: 'exist')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
