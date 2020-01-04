package com.enable.registrarDemo;

import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SomeBeanConfigurationRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //获取EnableSomeBeansSelector注解的所有属性的value
        AnnotationAttributes attributes =
                AnnotationAttributes.fromMap(
                        importingClassMetadata.getAnnotationAttributes
                                (EnableSomeBeansSelector.class.getName(), false));
        //获取criteria属性的value
        String criteria = attributes.getString("criteria");
        if (criteria.equals("default")) {
            this.registerConfigurationDefault(registry);
        }else {
            this.registerConfigurationTypeA(registry);
        }
    }

    private void registerConfigurationDefault(BeanDefinitionRegistry registry) {
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(SomeBeanConfigurationDefault.class);
        definition.setRole(2);
        registry.registerBeanDefinition(SomeBeanConfigurationDefault.class.getName(), definition);
    }

    private void registerConfigurationTypeA(BeanDefinitionRegistry registry) {
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(SomeBeanConfigurationTypeA.class);
        definition.setRole(2);
        registry.registerBeanDefinition(SomeBeanConfigurationTypeA.class.getName(), definition);
    }

}

class SomeBeanConfigurationTypeA {


}

class SomeBeanConfigurationDefault {


}