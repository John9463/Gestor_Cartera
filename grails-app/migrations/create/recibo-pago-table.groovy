databaseChangeLog = {
    changeSet(author: "aldo (generated)", id: "1571776146164-8") {
        createTable(tableName: "recibo_pago") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "recibo_pagoPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_poliza", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "monto", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "id_cliente", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "numero_periodo_pago", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "id_recibo", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "status_pago", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fecha_pago", type: "date") {
                constraints(nullable: "false")
            }
        }
    }
}