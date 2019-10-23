package worker

import java.text.SimpleDateFormat

class Util {

    static Date toDate(String source){
        new SimpleDateFormat('dd-MM-yyyy').parse(source)
    }

}
