package worker

import java.text.SimpleDateFormat

class Util {

    static def utilities = [

            poliza      : [
                    periodos: ["trimestral", "cuatrimestral", "semestral", "anual"],
                    ramos   : ["Seguros", "Autos", "Gastos Médicos", "Daños"],
                    status  : ["Vigente", "Cancelada", "Vencida", "Sin renovar"]
            ],

            aseguradoras: ["Inbursa", "Axa", "Mapfre", "Ana", "Atlas"],

            asesor      : [
                    tipos: ['A', 'B', 'C', 'D']
            ],

            seguro      : [
                    tipos: ['Individual', 'Colectivo', 'Conyugal', 'Educa', 'paquete']
            ],

            coberturas  : ['Amplia', 'Limitada', 'Plus'],

    ]


    static Date toDate(String source){
        new SimpleDateFormat('dd-MM-yyyy').parse(source)
    }

    static Date toDate(int day, int month, long year) {
        toDate("$day-$month-$year")
    }

    static ArrayList<String> getAseguradoras() {
        utilities.aseguradoras as ArrayList<String>
    }

    static Map getUtilitiesPoliza() {
        getUtilitiesClassPoliza().properties
    }


    static UtilitiesPoliza getUtilitiesClassPoliza() {
        new UtilitiesPoliza(utilities.poliza)
    }

    static Map getUtilitiesSeguro() {
        getUtilitiesClassSeguro().properties
    }

    static ArrayList<String> getCoberturas() {
        utilities.coberturas as ArrayList<String>
    }

    static UtilitiesSeguro getUtilitiesClassSeguro() {
        new UtilitiesSeguro(utilities.seguro)
    }

    static private class UtilitiesPoliza {

        List<String> periodos
        List<String> ramos
        List<String> status

    }

    static private class UtilitiesSeguro {

        ArrayList<String> tipos

    }

}
