package wallet.trans.crud

import builders.dsl.spreadsheet.builder.poi.PoiSpreadsheetBuilder
import reports.ReportsStylesheet
import wallet.Cliente

class ReportService {

    String sheetName
    String fileName

    def domain
    def headers
    def data

    public static final String EXCEL_FILE_SUFIX = ".xlsx"
    public static final String EXCEL_FILE_PREFIX = "templates-domain"

    void exportExcelFromBooks(OutputStream outs, String domainClass) {
        File file = File.createTempFile(EXCEL_FILE_PREFIX, EXCEL_FILE_SUFIX)

        preparedTypeReport(domainClass)
        fileName = domainClass + EXCEL_FILE_SUFIX

        PoiSpreadsheetBuilder.create(outs).build {
            apply ReportsStylesheet
            sheet(sheetName) { s ->
                row {
                    headers.each { header ->
                        cell {
                            value header
                            style ReportsStylesheet.STYLE_HEADER
                        }
                    }
                }
//                data.each{ k, values ->
//                    values.each{ value ->
//                        cell( value )
//                    }
//                }
            }
        }
        file
    }

    def preparedTypeReport(String type) {
        switch (type){

            case 'cliente':
                sheetName = type
                domain = Cliente
                data = Cliente.list().collectEntries { [(it.hashCode()): it.properties.values() ] }
                headers = Cliente.newInstance().properties.keySet()
            break

            case 'asesor':
                sheetName = type
                domain = Cliente
                data = Cliente.list()
                headers = Cliente.newInstance().properties.keySet()
                break

            case 'automovil':
                sheetName = type
                domain = Cliente
                data = Cliente.list()
                headers = Cliente.newInstance().properties.keySet()
                break

            case 'seguro':
                sheetName = type
                domain = Cliente
                data = Cliente.list()
                headers = Cliente.newInstance().properties.keySet()
                break


            case 'poliza':
                sheetName = type
                domain = Cliente
                data = Cliente.list()
                headers =  Cliente.newInstance().properties.keySet()
                break
        }

    }

}
