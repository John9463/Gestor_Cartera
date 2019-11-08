package gestorcartera

import wallet.Cliente

import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->

        DataConfig.instance.init()

    }
    def destroy = {
    }
}
