databaseChangeLog = {

    changeSet(author: "aldo (generated)", id: "1570062978368-2") {
        createTable(tableName: "desc_poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "desc_polizaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "descripcion", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_producto", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "id_desc_producto", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }


}