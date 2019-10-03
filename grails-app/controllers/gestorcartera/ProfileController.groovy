package gestorcartera

class ProfileController{

    def index(){
        render view:'profile.gsp'
    }

    def save(){
        println params

        index()
    }

}