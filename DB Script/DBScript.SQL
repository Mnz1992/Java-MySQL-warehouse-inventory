CREATE  SCHEMA STRELOK;
USE STRELOK;

CREATE TABLE Proveedor( 
ID_Proveedor CHAR(13) NOT NULL,
Nombre_prov VARCHAR(30) NOT NULL,
Empresa_prov VARCHAR(30) NOT NULL,
Telefono CHAR(10) NOT NULL,
CONSTRAINT PK_Proveedor PRIMARY KEY(ID_Proveedor)
);

CREATE TABLE Producto(
Cod_barras_p CHAR(4) NOT NULL,
Nombre_prod VARCHAR(40) NOT NULL,
Precio FLOAT NOT NULL,
Categoria VARCHAR(35) NOT NULL,
Unidades VARCHAR(13) NOT NULL,
Tipo_unidad VARCHAR(10) NOT NULL,
CONSTRAINT PK_Producto PRIMARY KEY(Cod_barras_p)
);

CREATE TABLE Empleado(
ID_Empleado CHAR(18) NOT NULL,
Nombre_E VARCHAR(30) NOT NULL,
Ap_pat VARCHAR(30) NOT NULL,
Ap_mat VARCHAR(30) NOT NULL,
Calle VARCHAR(45) NOT NULL,
Numero_int INT NOT NULL,
Numero_ext VARCHAR(10),
Colonia VARCHAR(30) NOT NULL,
CP CHAR(5) NOT NULL,
Ciudad VARCHAR(30) NOT NULL,
Estado VARCHAR(30)NOT NULL,
CONSTRAINT PK_Empleado PRIMARY KEY (ID_Empleado)
);


CREATE TABLE Inventario(
FolioI VARCHAR(45) NOT NULL,
Cod_barras_p CHAR(4) NOT NULL,
Stock_ini INT NOT NULL,
ID_Empleado CHAR(18) NOT NULL,
CONSTRAINT PK_Inventario PRIMARY KEY (Cod_barras_p,FolioI)
); 


CREATE TABLE Factura_Entrada(
Folio VARCHAR(45) NOT NULL,
Fecha_Entrada DATE NOT NULL,
ID_Proveedor CHAR(13) NOT NULL,
ID_Empleado CHAR(18) NOT NULL,
CONSTRAINT PK_Folio PRIMARY KEY (Folio)
);


CREATE TABLE Vale_Salida(
ID_Salida VARCHAR(21) NOT NULL,
Fecha_Salida DATE NOT NULL,
ID_Empleado CHAR(18) NOT NULL,
CONSTRAINT PK_Vale_Salida PRIMARY KEY (ID_Salida)
);



CREATE TABLE Perdida(
Folio_Perdida VARCHAR(21) NOT NULL,
Cantidad_Perdida INT NOT NULL,
Fecha_Perdida DATE NOT NULL,
Cod_barras_p CHAR(4) NOT NULL,
ID_Empleado CHAR(18) NOT NULL,
CONSTRAINT PK_Perdida PRIMARY KEY (Folio_Perdida)
);



CREATE TABLE Devolucion(
Folio_Devolucion VARCHAR(21) NOT NULL,
Cantidad_Devuelta INT NOT NULL,
Fecha_Devolucion DATE NOT NULL,
Cod_barras_p CHAR(4) NOT NULL,
ID_Empleado CHAR(18) NOT NULL,
CONSTRAINT PK_Devolucion PRIMARY KEY (Folio_Devolucion)
);

CREATE TABLE DocEmpleado(
DOC BLOB NOT NULL,
Tipo_Doc CHAR(4) NOT NULL,
ID_Empleado CHAR(18) NOT NULL,
CONSTRAINT PK_DocEmpleado PRIMARY KEY (ID_Empleado,Tipo_Doc),
CONSTRAINT FK_Empleado_doc FOREIGN KEY (ID_Empleado) REFERENCES Empleado (ID_Empleado)
ON DELETE CASCADE
);

CREATE TABLE Telefono(
Tipo_Tel VARCHAR(20) NOT NULL,
Numero_Tel CHAR(10) NOT NULL,
ID_EmpleadoT CHAR(18) NOT NULL,
CONSTRAINT PK_Telefono PRIMARY KEY (Tipo_Tel, ID_EmpleadoT),
CONSTRAINT FK_Tel_Empleado FOREIGN KEY (ID_EmpleadoT) REFERENCES Empleado (ID_Empleado)
ON DELETE CASCADE
);

CREATE TABLE Vale_Cuerpo_Salida(
Stock_Salida INT NOT NULL,
ID_Salida VARCHAR(21) NOT NULL,
Cod_barras_p CHAR(4) NOT NULL,
CONSTRAINT ID_salida PRIMARY KEY (ID_Salida, Cod_barras_p),
CONSTRAINT FK_ID_Salida FOREIGN KEY (ID_Salida) REFERENCES Vale_Salida (ID_Salida)
ON DELETE CASCADE
);

CREATE TABLE Factura_Entrada_Cuerpo(
Folio VARCHAR(45) NOT NULL,
Stock_Entrada INT NOT NULL,
Cod_barras_p CHAR(4) NOT NULL,
CONSTRAINT PK_Folio PRIMARY KEY (Folio, Cod_barras_p),
CONSTRAINT FK_Folio FOREIGN KEY (Folio) REFERENCES Factura_Entrada (Folio)
ON DELETE CASCADE
);
