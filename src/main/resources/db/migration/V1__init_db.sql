IF NOT EXISTS (SELECT *
               FROM sys.databases
               WHERE name = 'delbank')
    BEGIN
        CREATE DATABASE delbank;
    END
GO

USE delbank;
GO

IF NOT EXISTS (SELECT *
               FROM INFORMATION_SCHEMA.TABLES
               WHERE TABLE_NAME = 'bank_account')
    BEGIN
        CREATE TABLE bank_account
        (
            id              UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),   -- UUID gerado automaticamente
            branch          NVARCHAR(255) NOT NULL,                         -- Agência
            number          NVARCHAR(255) NOT NULL,                         -- Número da conta
            type            NVARCHAR(50)  NOT NULL,                         -- Tipo da conta
            holder_name     NVARCHAR(255) NOT NULL,                         -- Nome do titular
            holder_email    NVARCHAR(255) NOT NULL,                         -- E-mail do titular
            holder_document NVARCHAR(255) NOT NULL,                         -- Documento do titular
            holder_type     BIT           NOT NULL,                         -- Tipo de titular (booleano)
            created_at      DATETIME      NOT NULL       DEFAULT GETDATE(), -- Data de criação
            updated_at      DATETIME      NULL                              -- Data de atualização
        );
    END
GO

IF NOT EXISTS (SELECT *
               FROM INFORMATION_SCHEMA.TABLES
               WHERE TABLE_NAME = 'balances')
    BEGIN
        CREATE TABLE balances
        (
            id              UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
            bank_account_id NVARCHAR(255)  NOT NULL,
            amount          DECIMAL(18, 2) NOT NULL,
            amount_blocked  NVARCHAR(255)  NOT NULL,
            FOREIGN KEY (bank_account_id) REFERENCES bank_account(id)
        );
    END
GO
