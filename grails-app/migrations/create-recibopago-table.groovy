databaseChangeLog = {

    changeSet(author: "aldo (generated)", id: "1570062978368-4") {
        createTable(tableName: "recibo_pago") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "recibo_pagoPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "id_poliza", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "monto", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "comision", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "num_recibo", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "estado", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "forma_pago", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "vigencia_hasta", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "id_recibo", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "moneda", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fecha_pago", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "vigencia_dsd", type: "date") {
                constraints(nullable: "false")
            }

            column(name: "num_pago", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

}