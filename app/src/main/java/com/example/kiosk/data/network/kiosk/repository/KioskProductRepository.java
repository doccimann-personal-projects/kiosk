package com.example.kiosk.data.network.kiosk.repository;

import com.example.kiosk.data.network.kiosk.entity.KioskProductEntity;

import java.util.List;
import java.util.Optional;

public interface KioskProductRepository {
    List<KioskProductEntity> getMany();

    Optional<KioskProductEntity> findById(long id);
}
