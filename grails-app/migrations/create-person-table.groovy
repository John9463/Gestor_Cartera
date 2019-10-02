databaseChangeLog = {

    changeSet(author: "aldo (generated)", id: "1570046318788-1") {
        createTable(tableName: "cartera") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "carteraPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "efectivo", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

}