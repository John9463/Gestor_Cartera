package gestorcartera

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import wallet.trans.crud.ReportService

import static org.springframework.http.HttpStatus.OK

class ReportController implements GrailsConfigurationAware{

    ReportService reportService

    String xlsxMimeType
    String encoding

    @Override
    void setConfiguration(Config co) {  // <1>
        xlsxMimeType = co.getProperty('grails.mime.types.xlsxMimeType',
                String,
                'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')
        encoding = co.getProperty('grails.converters.encoding', String, 'UTF-8')
    }

    def create(String domain) {
        response.status = OK.value() // <2>
        response.setHeader "Content-disposition", "attachment; filename=${reportService.fileName}" // <3>
        response.contentType = "${xlsxMimeType};charset=${encoding}" // <4>
        OutputStream outs = response.outputStream
        reportService.exportExcelFromBooks(outs, domain) // <5>
        outs.flush()
        outs.close()
    }

}
