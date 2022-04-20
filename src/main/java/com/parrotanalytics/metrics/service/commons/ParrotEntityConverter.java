package com.parrotanalytics.metrics.service.commons;

import com.parrotanalytics.metrics.service.commons.constants.Entity;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ParrotEntityConverter implements AttributeConverter<Entity, String> {

  @Override
  public String convertToDatabaseColumn(Entity entity) {
    return entity.value();
  }

  @Override
  public Entity convertToEntityAttribute(String value) {
    return Entity.fromValue(value);
  }

}
