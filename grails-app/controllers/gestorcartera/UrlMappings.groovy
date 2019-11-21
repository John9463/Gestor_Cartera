package gestorcartera

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'login', action: 'index')
        "/login/check"(controller: 'login',action: 'checkss')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }

}
