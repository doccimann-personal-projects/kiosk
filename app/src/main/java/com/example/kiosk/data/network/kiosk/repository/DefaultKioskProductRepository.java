package com.example.kiosk.data.network.kiosk.repository;

import com.example.kiosk.data.network.kiosk.entity.KioskProductEntity;
import com.example.kiosk.data.local.KioskProductStore;

import java.util.List;
import java.util.Optional;

public class DefaultKioskProductRepository implements KioskProductRepository {
    @Override
    public List<KioskProductEntity> getMany() {
        return KioskProductStore.findAll();
    }

    @Override
    public Optional<KioskProductEntity> findById(long id) {
        return KioskProductStore.findAll()
                .stream().filter(entity -> entity.id() == id)
                .findFirst();
    }
}
