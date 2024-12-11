package com.example.kiosk.useCase.kioskProduct;

import com.example.kiosk.data.entity.KioskProductEntity;
import com.example.kiosk.data.repository.kiosk.KioskProductRepository;
import com.example.kiosk.model.kioskProduct.KioskProductModel;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class FetchKioskProductUseCase {
    private final KioskProductRepository kioskProductRepository;

    @Inject
    public FetchKioskProductUseCase(KioskProductRepository kioskProductRepository) {
        this.kioskProductRepository = kioskProductRepository;
    }

    public List<KioskProductModel> getAllProducts() {
        return kioskProductRepository.getMany()
                .stream()
                .map(KioskProductModel::fromEntity)
                .collect(Collectors.toList());
    }

    public KioskProductModel findById(long productId) {
        return kioskProductRepository.findById(productId)
                .map(KioskProductModel::fromEntity)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + productId));
    }
}
