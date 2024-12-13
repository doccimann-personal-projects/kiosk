package com.example.kiosk.data.local;

import com.example.kiosk.data.network.kiosk.entity.KioskProductEntity;

import java.math.BigInteger;
import java.util.List;

public class KioskProductStore {
    private KioskProductStore() {

    }

    public static List<KioskProductEntity> findAll() {
        return List.of(
                KioskProductEntity.create(1, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "클래식치즈버거", BigInteger.valueOf(4500L), "고소한 치즈와 촉촉한 패티가 조화를 이루는 버거"),
                KioskProductEntity.create(2, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "트윈치즈버거", BigInteger.valueOf(5000L), "치즈가 두 배로 풍성한 맛을 자랑하는 버거"),
                KioskProductEntity.create(3, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "크리스피치킨버거", BigInteger.valueOf(4000L), "바삭한 치킨과 신선한 야채가 어우러진 버거"),
                KioskProductEntity.create(4, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "베이컨더블버거", BigInteger.valueOf(5500L), "풍부한 베이컨과 치즈의 조화를 느낄 수 있는 버거"),
                KioskProductEntity.create(5, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "코리안불고기버거", BigInteger.valueOf(3500L), "달콤한 불고기 소스가 특징인 한국 스타일 버거"),
                KioskProductEntity.create(6, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "핫스파이스버거", BigInteger.valueOf(4800L), "매콤한 소스와 크리스피 치킨이 어우러진 버거"),
                KioskProductEntity.create(7, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "슈림프버거", BigInteger.valueOf(4200L), "탱글한 새우와 크리미 소스가 특징인 버거"),
                KioskProductEntity.create(8, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "햄더블치즈버거", BigInteger.valueOf(3200L), "햄과 치즈의 깔끔한 조화가 돋보이는 버거"),
                KioskProductEntity.create(9, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "어니언크런치버거", BigInteger.valueOf(4700L), "바삭한 어니언링과 소스가 어우러진 버거"),
                KioskProductEntity.create(10, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "그릴드스모크버거", BigInteger.valueOf(5000L), "그릴드 치킨과 스모크 향이 돋보이는 버거"),
                KioskProductEntity.create(11, "https://i.namu.wiki/i/rgsRmerotYndkqq4Oh3a5X9WElogC-q4jRe9Yh363SzIc21Cf2Y-plnGB-sCucyAZzEyhXT5fIOmECZtH3LGTg.webp", "메가치즈버거", BigInteger.valueOf(6000L), "치즈가 풍성하게 들어간 고소한 버거")
        );
    }
}
