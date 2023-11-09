package br.facens.registerevent.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getName();
    }

    @Override
    public Category convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        for (Category category : Category.values()) {
            if (name.equals(category.getName())) {
                return category;
            }
        }

        throw new IllegalArgumentException("Unknown name: " + name);
    }
}
