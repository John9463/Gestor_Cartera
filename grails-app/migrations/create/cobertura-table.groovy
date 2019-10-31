databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-4") {
        createTable(tableName: "cobertura") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "coberturaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "tipo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_cobertura", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }
}