package gestorcartera

import groovy.util.logging.Slf4j
import wallet.*
import kit.Util

@Singleton
@Slf4j
class DataConfig {

    //mapa de datos para super usuario
    def defaultAsesorAdmin = [
            usuario   : [
                    username: 'pacman',
                    password: 'pass',
                    correo  : 'pacman_azul@hotmail.com',
                    nombre  : 'juan',
                    apellMa : 'sanchez',
                    apellPa : 'sanchez',
                    ciudad  : 'toluca',
                    rfc     : 'sasj870712p7',
                    colonia : 'nueva oxtotitla',
                    calle   : 'laguna de huapango',
                    cp      : '50100',
                    fechaNac: Util.toDate(12, 07, 1987),
                    noCasa  : '417',
                    tel     : 7222024401
            ],
            homoclave : 'sdasd123',
            tipoAsesor: Util.getAsesorTipo().get(0),
            isAdmin   : 1
    ]

    def defaultCliente = [
            usuario   : [
                    username: 'blacked',
                    password: 'pass',
                    correo  : 'aldodaniel@hotmail.com',
                    nombre  : 'aldo daniel',
                    apellMa : 'sanchez',
                    apellPa : 'bastida',
                    ciudad  : 'toluca',
                    rfc     : 'ssdafasdfsadf',
                    colonia : 'Parques Zoquiapan',
                    calle   : 'laguna de huapango',
                    cp      : '50100',
                    fechaNac: Util.toDate(29, 12, 1997),
                    noCasa  : '417',
                    tel     : 7291615267
            ],
            clave: 'asasda',
            isIntegral: 1
    ]

    //mapa de datos para un <code>Seguro</code> por default
    def defaultSeguro = [
            nombre     : "Seguros Axa",
            aseguradora: Util.getUtilitiesClassSeguro().getAseguradoras().get(0),
            tipo       : Util.getUtilitiesClassSeguro().getTipos().get(0),
            valorSeguro: 0,
            emisor     : 109321,
            sumaAsegurada: '15.00',
            renovacion : Util.toDate(29, 12, 1997),
            cobertura  : Util.getUtilitiesClassSeguro().getCoberturas().get(0),

    ]


    //,mapara de datos para un <code>Poliza</code> por default
    def defaultPoliza = [
            cliente         : Cliente.get(1),
            seguro          : Seguro.get(1),
            ramo            : Util.getUtilitiesClassPoliza().getRamos().get(0),
            status          : Util.getUtilitiesClassPoliza().getStatus().get(1),
            periodo         : Util.getUtilitiesClassPoliza().getPeriodos().get(2),
            primaTotal      : 231.toLong(),
            gastosExpedicion: 1243.toFloat(),
            financiamiento  : 12312.toFloat(),
            comisionCedida  : 123.toFloat(),
            numeroRemision  : 32,
            fechaDesde      : Util.toDate(11, 12, 2019),
            fechaExpedicion : Util.toDate(10, 10, 2019)
    ]


    def defaultAuto = [
            cliente: Cliente.get(1),
            seguro: Seguro.get(1),
            nombre: 'Ford Fiesta',
            model: 2019,
            tipo: Util.getUtilitiesClassAutomovil().getTipos().get(0),
            placas: 'ASD123',
            uso: Util.getUtilitiesClassAutomovil().getUsos().get(0),
            numSerie: 64879,
            numMotor: 4785411
    ]

    void init() {
        log.info('init configuration')
        adminRoot()
    }

    void adminRoot() {
        if (Asesor.list().isEmpty()) {
            def asesor = new Asesor(defaultAsesorAdmin).save()
            log.info("Ingresando usuario ROOT: " + asesor.toString())
        }

        if (Cliente.list().isEmpty()){
            def cliente = new Cliente(defaultCliente).save()
            log.info("Ingresando usuario ROOT: " + cliente.toString())
        }

        if (Seguro.list().isEmpty()) {
            def seguro = new Seguro(defaultSeguro).save()
            log.info("Ingresando Seguro: " + seguro.toString())
        }

        if (Poliza.list().isEmpty()) {
            def poliza = new Poliza(defaultPoliza).save()
            log.info("Ingresando Poliza: " + poliza.toString())
        }

        if (Automovil.list().isEmpty() && !Seguro.list().isEmpty() && !Cliente.list().isEmpty() ){
            def automovil = new Automovil(defaultAuto).save()
            log.info("Ingresando Automovil: " + automovil.toString())
        }

    }

}
