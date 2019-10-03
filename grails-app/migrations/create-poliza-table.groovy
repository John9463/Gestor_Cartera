databaseChangeLog = {

    changeSet(author: "aldo (generated)", id: "1570062978368-3") {
        createTable(tableName: "poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "polizaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_poliza", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "id_cliente", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "ramo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "prima_total", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "tipo_doc", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "grupo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "empresa", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "sucursal", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "gtos_exp", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "subramo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fnanto", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "com_cedida", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "periodo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "cis", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "num_remision", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "aseguradora", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "vigencia_hasta", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "vigencia_dsd", type: "date") {
                constraints(nullable: "false")
            }
        }
    }

}