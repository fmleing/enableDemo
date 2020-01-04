package com.enable.selectorDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class SomeBeanConfigurationSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes attributes =
                AnnotationAttributes.fromMap(
                        importingClassMetadata.getAnnotationAttributes
                                (EnableSomeBeansSelector.class.getName(), false));
        String criteria = attributes.getString("criteria");
        if (criteria.equals("default")) {
            return new String[]{"enableannot.selector.SomeBeanConfigurationDefault"};
        }else {
            return new String[]{"enableannot.selector.SomeBeanConfigurationType1"};
        }
    }
}

@Configuration
class SomeBeanConfigurationType1 {

    @Bean
    public String aBean() {
        return "Type1";
    }

}

@Configuration
class SomeBeanConfigurationDefault {

    @Bean
    public String aBean() {
        return "Default";
    }

}
