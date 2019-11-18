package worker

import java.text.SimpleDateFormat

class Util {

    static def utilities = [

            poliza : [
                    periodos: ["trimestral", "cuatrimestral", "semestral", "anual"],
                    ramos   : ["ramo1", "ramo2", "ramo3", "ramo4"],
                    status  : ["status1", "status2", "status3", "status4"]
            ],

            cliente: [
                    tipos: ['tipoCliente1', 'tipoCliente2', 'tipoCliente3', 'tipoCliente4', 'tipoCliente5']
            ],

            asesor : [
                    tipos: ['tipoAsesor1', 'tipoAsesor2', 'tipoAsesor3', 'tipoAsesor4', 'tipoAsesor5']
            ],

            seguro : [
                    tipos       : ['tipoSeguro1', 'tipoSeguro2', 'tipoSeguro3', 'tipoSeguro4', 'tipoSeguro5'],
                    aseguradoras: ["aseguradora1", "aseguradora2", "aseguradora3", "asegurador4"],
                    coberturas  : ['cobetura1', 'cobertura2', 'cobertura3'],
            ]


    ]


    static Date toDate(String source) {
        new SimpleDateFormat('dd-MM-yyyy').parse(source)
    }

    static Date toDate(int day, int month, long year) {
        toDate("$day-$month-$year")
    }

    static Map getModelPoliza(ArrayList aseguradoras) {
        def classSeguro = getUtilitiesClassSeguro().getProperties()
        classSeguro.replace('aseguradoras', aseguradoras)
        getUtilitiesClassPoliza().getProperties() + classSeguro
    }

    static Map getModelCliente() {
        getUtilitiesClassCliente().getProperties()
    }

    static Map getModelSeguro() {
        getUtilitiesClassSeguro().getProperties()
    }

    static UtilitiesCliente getUtilitiesClassCliente() {
        new UtilitiesCliente(utilities.cliente)
    }

    static UtilitiesPoliza getUtilitiesClassPoliza() {
        new UtilitiesPoliza(utilities.poliza)
    }

    static UtilitiesSeguro getUtilitiesClassSeguro() {
        new UtilitiesSeguro(utilities.seguro)
    }

    static private class UtilitiesCliente {

        List<String> tipos

    }

    static private class UtilitiesPoliza {

        List<String> periodos
        List<String> ramos
        List<String> status

    }

    static private class UtilitiesSeguro {

        ArrayList<String> tipos
        ArrayList<String> aseguradoras
        ArrayList<String> coberturas

    }

}
