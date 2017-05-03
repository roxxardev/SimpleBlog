package com.pollub.utils;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Eryk on 2017-05-03.
 */
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return Timestamp.valueOf(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return dbData.toLocalDateTime();
    }
}
