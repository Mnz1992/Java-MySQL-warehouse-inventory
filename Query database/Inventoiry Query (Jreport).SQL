SELECT IdPRODUCTO,
       NProducto,
       I_STOCK,
       ENTRADA,
       DEVOLUCION,
       PERDIDA,
       SALIDA,
       (COALESCE(I_STOCK,0)+COALESCE(ENTRADA,0)+COALESCE(DEVOLUCION,0)-COALESCE(PERDIDA,0)-COALESCE(SALIDA,0)) AS TOTAL_STOCK
     
FROM
(SELECT prod.Cod_barras_p as IdPRODUCTO,
        prod.Nombre_prod as NProducto,
        
 (SELECT COALESCE(SUM(inv.`Stock_ini`),0)
 FROM 
inventario inv  
where prod.Cod_barras_p=inv.Cod_barras_p)AS I_STOCK,      
       
(SELECT COALESCE(SUM(factura.`Stock_Entrada`),0)
 FROM 
factura_entrada_cuerpo factura  join factura_entrada face
on factura.Folio=face.Folio
where prod.Cod_barras_p=factura.Cod_barras_p and face.Fecha_Entrada between $P{fecha1} and $P{fecha2})AS ENTRADA,

(SELECT COALESCE(SUM(dev.`Cantidad_Devuelta`),0)
 FROM 
devolucion dev  
where prod.Cod_barras_p=dev.Cod_barras_p and dev.Fecha_Devolucion between $P{fecha1} and $P{fecha2})AS DEVOLUCION,

(SELECT COALESCE(SUM(per.`Cantidad_Perdida`),0)
 FROM 
perdida per  
where prod.Cod_barras_p=per.Cod_barras_p and per.Fecha_Perdida between $P{fecha1} and $P{fecha2})AS PERDIDA,

(SELECT COALESCE(sum(salida.Stock_Salida),0) 
FROM 
vale_cuerpo_salida salida join vale_salida vs
on salida.ID_Salida=vs.ID_Salida
 where prod.Cod_barras_p=salida.Cod_barras_p and vs.Fecha_Salida between $P{fecha1} and $P{fecha2})AS SALIDA
from producto prod)QA