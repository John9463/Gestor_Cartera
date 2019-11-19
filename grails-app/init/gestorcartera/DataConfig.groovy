package gestorcartera

import groovy.util.logging.Slf4j
import wallet.Cliente
import wallet.Poliza
import wallet.Seguro
import wallet.Usuario
import worker.Util

@Singleton
@Slf4j
class DataConfig {

    //mapa de datos para super usuario
    def superUser = [
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
            clave     : 'dsfdsf',
            isIntegral: false
    ]

    //mapa de datos para un <code>Seguro</code> por default
    def defaultSeguro = [
            nombre       : "Seguros Axa",
            aseguradora  : Util.getUtilitiesClassSeguro().getAseguradoras().get(0),
            tipo         : Util.getUtilitiesClassSeguro().getTipos().get(0),
            valorSeguro  : 0,
            emisor       : 109321,
            renovacion   : Util.toDate(29, 12, 1997),
            cobertura    : Util.getUtilitiesClassSeguro().getCoberturas().get(0),
            sumaAsegurada: 'dasdasd',
            primaNeta    : 12000
    ]


    //,mapara de datos para un <code>Poliza</code> por default
    def defaultPoliza = [
            cliente         : Cliente.get(1),
            seguro          : Seguro.get(1),
            ramo            : Util.getUtilitiesClassPoliza().getRamos().get(0),
            clave           : 'Dwas93Sde',
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


    void init(){
        log.info('init configuration')
        adminRoot()
    }

    void adminRoot(){
        if (Usuario.list().isEmpty()) {
            def root = new Cliente(superUser).save()
            log.info("Ingresando usuario ROOT: " + root.toString())
        }

        if (Seguro.list().isEmpty()) {
            def seguro = new Seguro(defaultSeguro).save()
            log.info("Ingresando Seguro: " + seguro.toString())
        }

        if (Poliza.list().isEmpty()) {
            def poliza = new Poliza(defaultPoliza).save()
            log.info("Ingresando Poliza: " + poliza.toString())
        }

    }

}
