databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-7") {
        createTable(tableName: "ramo") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "ramoPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "nombre_ramo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "idsubramo", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_ramo", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }
}