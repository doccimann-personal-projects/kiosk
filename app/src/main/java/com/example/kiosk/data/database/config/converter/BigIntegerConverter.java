package com.example.kiosk.data.database.config.converter;

import androidx.room.TypeConverter;

import java.math.BigInteger;

public class BigIntegerConverter {
    @TypeConverter
    public static String fromBigInteger(BigInteger value) {
        return value == null ? null : value.toString(); // BigInteger를 String으로 변환
    }

    @TypeConverter
    public static BigInteger toBigInteger(String value) {
        return value == null ? null : new BigInteger(value); // String을 BigInteger로 변환
    }
}
