package com.example.kiosk.data.entity;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.math.BigInteger;

@AutoValue
public abstract class KioskProductEntity extends Entity implements Parcelable {
    public abstract String imageUrl();

    public abstract String name();

    public abstract BigInteger price();

    public static KioskProductEntity create(int id, String imageUrl, String name, BigInteger price) {
        return new AutoValue_KioskProductEntity(id, imageUrl, name, price);
    }
}
