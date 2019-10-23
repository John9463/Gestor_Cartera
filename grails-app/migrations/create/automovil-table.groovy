databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-2") {
        createTable(tableName: "automovil") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "automovilPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "uso", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_seguro", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "placas", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "tipo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "num_motos", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "modelo", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "id_client", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "num_serie", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_auto", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }
}