package com.example.util;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

    public class BeanUtil{
        
        public static void copyNonNullProperties(Object source, Object target, String... ignoreProperties) {
            Set<String> ignoreSet = new HashSet<>(Arrays.asList(ignoreProperties));
            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(source.getClass()); // Aqui, a função getPropertyDescriptors da classe BeanUtils é usada para obter um array de PropertyDescriptor do objeto source. Cada PropertyDescriptor contém informações sobre uma propriedade (como nome, método getter e setter) do objeto.

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
                    Object value = propertyDescriptor.getReadMethod().invoke(source); // Aqui, o método getReadMethod() retorna o método getter da propriedade, e invoke(source) é utilizado para invocar esse método e obter o valor da propriedade no objeto source.

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