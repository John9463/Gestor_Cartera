package gestorcartera

import caret.Cartera

class BootStrap {

    def init = { servletContext ->
        def cart = Cartera.get(1)

        cart.delete()
    }
    def destroy = {
    }
}
