package com.example.kiosk.data.local;

import com.example.kiosk.data.entity.KioskProductEntity;

import java.math.BigInteger;
import java.util.List;

public class KioskProductStore {
    private KioskProductStore() {

    }

    public static List<KioskProductEntity> findAll() {
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
