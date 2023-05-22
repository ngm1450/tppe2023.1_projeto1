package org.unb.tppe.model.util;

import org.unb.tppe.model.entity.Publicacao;

import java.lang.reflect.Field;

public class CompletudeCamposUtil {

    // Utilizando reflection para evitar a desnecessária repetição dos campos

    public static boolean calcularCompletudeCamposOrExclusivo(Publicacao publicacao) {
        Field[] fields = Publicacao.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(publicacao);
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