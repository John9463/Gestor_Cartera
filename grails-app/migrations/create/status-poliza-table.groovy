databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-9") {
        createTable(tableName: "status_poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "status_polizaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_status", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }
}