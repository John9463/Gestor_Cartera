databaseChangeLog = {

    changeSet(author: "aldo (generated)", id: "1570062978368-5") {
        createTable(tableName: "seguro") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "seguroPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "renovacion", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "deducible", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "id_seguro", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "tipo_seguro", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "aseguradora", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "emisor", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "cobertura", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "tipo_covertura", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "vigencia_hasta", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "vigencia_dsd", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "prima_neta", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "valor_asegurado", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "suma_asegurada", type: "FLOAT") {
                constraints(nullable: "false")
            }
        }
    }

}