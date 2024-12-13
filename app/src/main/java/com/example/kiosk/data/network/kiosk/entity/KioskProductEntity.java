package com.example.kiosk.data.network.kiosk.entity;

import android.os.Parcelable;

import com.example.kiosk.data.network.common.Entity;
import com.google.auto.value.AutoValue;

import java.math.BigInteger;

@AutoValue
public abstract class KioskProductEntity extends Entity implements Parcelable {
    public abstract String imageUrl();

    public abstract String name();

    public abstract BigInteger price();

    public abstract String description();

    public static KioskProductEntity create(long id, String imageUrl, String name, BigInteger price, String description) {
        return new AutoValue_KioskProductEntity(id, imageUrl, name, price, description);
    }
}
