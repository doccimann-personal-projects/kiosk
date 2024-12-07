package com.example.kiosk.data.repository.kiosk;

import com.example.kiosk.data.entity.KioskProductEntity;

import java.util.List;

public interface KioskProductRepository {
    List<KioskProductEntity> getMany();
}
