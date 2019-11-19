package gestorcartera

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/login/login")
        "/$controller/$action/$id"(controller: controller, action: action)
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
