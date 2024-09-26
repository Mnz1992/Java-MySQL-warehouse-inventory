SELECT
     empleado.`ID_Empleado` AS empleado_ID_Empleado,
     empleado.`Nombre_E` AS empleado_Nombre_E,
     empleado.`Ap_pat` AS empleado_Ap_pat,
     empleado.`Ap_mat` AS empleado_Ap_mat,
     empleado.`Calle` AS empleado_Calle,
     empleado.`Colonia` AS empleado_Colonia,
     empleado.`CP` AS empleado_CP,
     empleado.`Ciudad` AS empleado_Ciudad,
     empleado.`Estado` AS empleado_Estado,
     empleado.`Numero_ext` AS empleado_Numero_ext,
     empleado.`Numero_int` AS empleado_Numero_int,
     docempleado.`DOC` AS docempleado_DOC,
     docempleado.`Tipo_Doc` AS docempleado_Tipo_Doc
FROM
     `empleado` empleado INNER JOIN `docempleado` docempleado ON empleado.`ID_Empleado` = docempleado.`ID_Empleado`
WHERE
     empleado.ID_Empleado = $P{curp} AND docempleado.Tipo_Doc=$P{tipo_doc}