package com.jpa.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {
 
    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return attribute == null ? null : java.sql.Date.valueOf(attribute);
    }
    @Override
    public LocalDate convertToEntityAttribute(Date dbDate) {
     
        return dbDate == null ? null : dbDate.toLocalDate();
    }
}