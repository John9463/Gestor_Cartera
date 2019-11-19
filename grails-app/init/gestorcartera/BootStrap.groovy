package gestorcartera

class BootStrap {

    def init = { servletContext ->

        DataConfig.instance.init()

    }
    def destroy = {
    }
}
