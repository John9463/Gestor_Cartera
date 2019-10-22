databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-3") {
        createTable(tableName: "cliente") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "clientePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "correo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fecha_nac", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "apell_ma", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "tipo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "tel", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "calle", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "cp", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "colonia", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "rfc", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "apell_pa", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "numeros", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_client", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "ciudad", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }
}