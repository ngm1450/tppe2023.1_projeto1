package org.unb.tppe.model.util;

import org.unb.tppe.model.entity.Publicacao;

import java.lang.reflect.Field;
import java.util.List;

// Utilizando reflection para evitar a desnecessária repetição dos campos

public class CompletudeRegistrosUtil {

    public static boolean calcularCompletudeRegistrosMultiCampos(Publicacao publicacao) {
        Field[] fields = Publicacao.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(publicacao);
                if (value == null) {
                    return false;
                }
                // Casting para lidar com os arrays da extrato_fiocruz.json
                if (value instanceof List<?> listValue) {
                    for (Object item : listValue) {
                        if (!isCompleto(item)) {
                            return false;
                        }
                    }
                } else if (!isCompleto(value)) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private static boolean isCompleto(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value != null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
