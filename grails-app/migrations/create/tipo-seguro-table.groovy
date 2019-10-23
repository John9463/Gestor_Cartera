databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-10") {
        createTable(tableName: "tipo_seguro") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "tipo_seguroPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_tipo_seguro", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }
}
