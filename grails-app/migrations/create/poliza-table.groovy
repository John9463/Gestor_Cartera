databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-6") {
        createTable(tableName: "poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "polizaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_poliza", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "periodo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_cliente", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_seguro", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "prima_total", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "comision_cedida", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "clave", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_ramo", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "gastos_expedicion", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "financiamiento", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "numero_remision", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "fecha_hasta", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "id_status", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "fecha_desde", type: "date") {
                constraints(nullable: "false")
            }
        }
    }
}