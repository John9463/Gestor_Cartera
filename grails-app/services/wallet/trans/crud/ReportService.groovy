package wallet.trans.crud

import builders.dsl.spreadsheet.builder.poi.PoiSpreadsheetBuilder
import reports.ReportsStylesheet
import wallet.Cliente

class ReportService {

    public String SHEET_NAME

    String fileName
    String sheetName

    def node
    def headers
    def data

    public static final String EXCEL_FILE_SUFIX = ".xlsx"
    public static final String EXCEL_FILE_PREFIX = "books"


    void exportExcelFromBooks(OutputStream outs, String type) {
        File file = File.createTempFile(EXCEL_FILE_PREFIX, EXCEL_FILE_SUFIX)

        selectTypeReport(type)

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
//                data.each { item ->
//                    row {
//                        item.properties.values().each {
//                            cell(it)
//                        }
//                    }
//                }
            }
        }
        file
    }

    def selectTypeReport(String type){
        switch (type){
            case 'cliente':
                sheetName = type
                fileName = type + '.xlsx'
                node = Cliente
                data = Cliente.list()
                headers =  Cliente.newInstance().properties.keySet()
                break

        }

    }

}
