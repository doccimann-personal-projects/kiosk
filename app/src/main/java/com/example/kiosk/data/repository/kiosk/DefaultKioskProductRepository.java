package com.example.kiosk.data.repository.kiosk;

import android.os.Parcel;

import androidx.annotation.NonNull;

import com.example.kiosk.data.entity.KioskProductEntity;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class DefaultKioskProductRepository implements KioskProductRepository {
    @Override
    public List<KioskProductEntity> getMany() {
        return List.of(
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L)),
                KioskProductEntity.create(1, "https://picsum.photos/200", "가난소불고기버거", BigInteger.valueOf(3000L))
        );
    }
}
