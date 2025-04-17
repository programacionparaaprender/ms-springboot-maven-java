CREATE TABLE users (
    id BIGINT IDENTITY(1,1) NOT NULL,
    nombre NVARCHAR(100) NOT NULL,
    email NVARCHAR(150) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    
    CONSTRAINT PK_users_id PRIMARY KEY (id),
    CONSTRAINT UQ_users_email UNIQUE (email)
);