package com.example.kiosk.data.repository.kiosk;

import com.example.kiosk.data.entity.KioskProductEntity;

import java.util.List;
import java.util.Optional;

public interface KioskProductRepository {
    List<KioskProductEntity> getMany();

    Optional<KioskProductEntity> findById(long id);
}
