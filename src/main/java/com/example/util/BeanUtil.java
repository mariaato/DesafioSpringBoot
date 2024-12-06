package com.example.util;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

    public class BeanUtil{
        
        public static void copyNonNullProperties(Object source, Object target, String... ignoreProperties) {
            Set<String> ignoreSet = new HashSet<>(Arrays.asList(ignoreProperties));
            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(source.getClass());

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String propertyName = propertyDescriptor.getName();
                try {
                    // Verifica se a propriedade deve ser ignorada
                    if (ignoreSet.contains(propertyName)) {
                        continue;
                    }

                    // Verifica se há método de escrita (setter)
                    if (propertyDescriptor.getWriteMethod() == null) {
                        continue; // Ignora propriedades sem setter
                    }

                    // Obtém o valor do campo no objeto fonte
                    Object value = propertyDescriptor.getReadMethod().invoke(source);

                    // Copia apenas se o valor não for nulo
                    if (value != null) {
                        propertyDescriptor.getWriteMethod().invoke(target, value);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao copiar propriedades", e);
                }
            }
        }

}