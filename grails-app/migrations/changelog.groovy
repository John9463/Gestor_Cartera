databaseChangeLog = {

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-1") {
        createTable(tableName: "aseguradora") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "aseguradoraPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-2") {
        createTable(tableName: "asesor") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "asesorPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "usuario_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "asesor_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "homoclave", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "is_admin", type: "BOOLEAN") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-3") {
        createTable(tableName: "asesor_clientes") {
            column(name: "cliente_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "asesor_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-4") {
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

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-5") {
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

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-6") {
        createTable(tableName: "cliente_asesores") {
            column(name: "asesor_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "cliente_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-7") {
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
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-8") {
        createTable(tableName: "periodos") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "periodosPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "periodo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-9") {
        createTable(tableName: "poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "polizaPK")
            }

            column(name: "version", type: "BIGINT") {
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

            column(name: "periodo_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "fecha_expicion", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "fecha_desde", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "status_id", type: "BIGINT")

            column(name: "cliente_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-10") {
        createTable(tableName: "ramo") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "ramoPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "nramoombre_ramo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "poliza_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "idsub", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-11") {
        createTable(tableName: "recibo_pago") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "recibo_pagoPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
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

            column(name: "poliza_id", type: "BIGINT") {
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

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-12") {
        createTable(tableName: "seguro") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "seguroPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "rovacion", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "tipo_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "aseguradora_id", type: "BIGINT") {
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

            column(name: "suma_asegurada", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-13") {
        createTable(tableName: "status_poliza") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "status_polizaPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "poliza_id", type: "BIGINT")

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-14") {
        createTable(tableName: "tipo_asesor") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "tipo_asesorPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "tipo", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "usuario_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "rango", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-15") {
        createTable(tableName: "tipo_seguro") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "tipo_seguroPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "nombre", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-16") {
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

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-17") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "cliente_asesores", constraintName: "FK12s4fu4usv2m94flrrh7sx973", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-18") {
        addForeignKeyConstraint(baseColumnNames: "asesor_id", baseTableName: "cliente_asesores", constraintName: "FK21d6t4m0jsv0ev1d27v8vulir", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "asesor", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-19") {
        addForeignKeyConstraint(baseColumnNames: "periodo_id", baseTableName: "poliza", constraintName: "FK4o58lbka85x6riyihx3p8l94d", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "periodos", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-20") {
        addForeignKeyConstraint(baseColumnNames: "asesor_id", baseTableName: "asesor_clientes", constraintName: "FK542bia14bfvpcpi59xl1acv7s", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "asesor", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-21") {
        addForeignKeyConstraint(baseColumnNames: "seguro_id", baseTableName: "automovil", constraintName: "FK609qimn8e2ai31vtqxvke76f", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "seguro", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-22") {
        addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "asesor", constraintName: "FK62pqimnqcv394uf7v6h074051", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-23") {
        addForeignKeyConstraint(baseColumnNames: "status_id", baseTableName: "poliza", constraintName: "FKb0dx2619ih54sqcb5ildfbnyn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "status_poliza", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-24") {
        addForeignKeyConstraint(baseColumnNames: "asesor_id", baseTableName: "asesor", constraintName: "FKbgx9f3lwyrkg8sypa0u2x0qe1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tipo_asesor", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-25") {
        addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "cliente", constraintName: "FKc3u631ocxdrtm3ccpme0kjlmu", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-26") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "asesor_clientes", constraintName: "FKd2jtv9bmyvc5s2xcm77vsiot7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-27") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "poliza", constraintName: "FKd75jfgvv0488xpmc3mka4nxu5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-28") {
        addForeignKeyConstraint(baseColumnNames: "aseguradora_id", baseTableName: "seguro", constraintName: "FKdh916m5l20hgd8owpbswbjy2b", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "aseguradora", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-29") {
        addForeignKeyConstraint(baseColumnNames: "seguro_id", baseTableName: "poliza", constraintName: "FKed7blor7cnw1rfumbfq3hr372", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "seguro", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-30") {
        addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "tipo_asesor", constraintName: "FKfgof7qbe5cbagyamoe8ybgc8n", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "usuario", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-31") {
        addForeignKeyConstraint(baseColumnNames: "tipo_id", baseTableName: "seguro", constraintName: "FKhwrucaot13hrln28e3co7u27i", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tipo_seguro", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-32") {
        addForeignKeyConstraint(baseColumnNames: "poliza_id", baseTableName: "status_poliza", constraintName: "FKku6tnepbbd7rchuloxrhatagk", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "poliza", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-33") {
        addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "automovil", constraintName: "FKoauc122vicryshn8j90xwas0s", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cliente", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-34") {
        addForeignKeyConstraint(baseColumnNames: "poliza_id", baseTableName: "ramo", constraintName: "FKojmgdj3m3m86bs6o0x32ga7s1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "poliza", validate: "true")
    }

    changeSet(author: "aldodanielsanchezbastida (generated)", id: "1573245278933-35") {
        addForeignKeyConstraint(baseColumnNames: "poliza_id", baseTableName: "recibo_pago", constraintName: "FKok2ekoe7aehvu3mfju6so62k", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "poliza", validate: "true")
    }
}
