databaseChangeLog = {

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-1") {
        createTable(tableName: "asesor") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "asesorPK")
            }

            column(name: "usuario_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "homoclave", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "is_admin", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "tipo_asesor", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-2") {
        createTable(tableName: "asesor_clientes") {
            column(name: "cliente_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "asesor_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-3") {
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

            column(name: "placas", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "tipo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "num_motor", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "modelo", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "cliente_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "num_serie", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "seguro_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-4") {
        createTable(tableName: "cliente") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "clientePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "usuario_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "clave", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "is_integral", type: "BOOLEAN") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-5") {
        createTable(tableName: "cliente_asesores") {
            column(name: "asesor_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "cliente_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-6") {
        createTable(tableName: "poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "polizaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "ramo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "prima_total", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "comision_cedida", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "clave", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "gastos_expedicion", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "numero_remision", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "financiamiento", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "seguro_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "periodo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fecha_desde", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "status", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fecha_expedicion", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "cliente_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-7") {
        createTable(tableName: "recibo_pago") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "recibo_pagoPK")
            }

            column(name: "monto", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "num_recibo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "numero_periodo_pago", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "status_pago", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "poliza_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "fecha_pago", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-8") {
        createTable(tableName: "seguro") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "seguroPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "renovacion", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "tipo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "aseguradora", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "emisor", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "cobertura", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "valor_seguro", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "prima_neta", type: "FLOAT") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "suma_asegurada", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-9") {
        createTable(tableName: "usuario") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "usuarioPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "correo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fecha_nac", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "apell_ma", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "tel", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "calle", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "cp", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "colonia", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "rfc", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "apell_pa", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "no_casa", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "ciudad", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-10") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "cliente_asesores", constraintName: "FK12s4fu4usv2m94flrrh7sx973", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-11") {
        addForeignKeyConstraint(baseColumnNames: "asesor_id", baseTableName: "cliente_asesores", constraintName: "FK21d6t4m0jsv0ev1d27v8vulir", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "asesor", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-12") {
        addForeignKeyConstraint(baseColumnNames: "asesor_id", baseTableName: "asesor_clientes", constraintName: "FK542bia14bfvpcpi59xl1acv7s", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "asesor", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-13") {
        addForeignKeyConstraint(baseColumnNames: "seguro_id", baseTableName: "automovil", constraintName: "FK609qimn8e2ai31vtqxvke76f", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "seguro", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-14") {
        addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "asesor", constraintName: "FK62pqimnqcv394uf7v6h074051", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-15") {
        addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "cliente", constraintName: "FKc3u631ocxdrtm3ccpme0kjlmu", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-16") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "asesor_clientes", constraintName: "FKd2jtv9bmyvc5s2xcm77vsiot7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-17") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "poliza", constraintName: "FKd75jfgvv0488xpmc3mka4nxu5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-18") {
        addForeignKeyConstraint(baseColumnNames: "seguro_id", baseTableName: "poliza", constraintName: "FKed7blor7cnw1rfumbfq3hr372", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "seguro", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-19") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "automovil", constraintName: "FKoauc122vicryshn8j90xwas0s", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1574018807452-20") {
        addForeignKeyConstraint(baseColumnNames: "poliza_id", baseTableName: "recibo_pago", constraintName: "FKok2ekoe7aehvu3mfju6so62k", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "poliza", validate: "true")
    }
}
