databaseChangeLog = {

    changeSet(author: "aldo (generated)", id: "1571776146164-5") {
        createTable(tableName: "detalle_poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "detalle_polizaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_poliza", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "descripcion", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_detalle", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

}
