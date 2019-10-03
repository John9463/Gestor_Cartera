databaseChangeLog = {

    changeSet(author: "aldo (generated)", id: "1570062978368-1") {
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

            column(name: "id_cliente", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "fecha_nac", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "apell_ma", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "tipo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "clave", type: "INT") {
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

            column(name: "numero", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "ciudad", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

}