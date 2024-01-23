
// 	Urun.java(model sınıf)
package com.example.feslegenmarket.model;

public class Urun{
    private Long id;
    private String ad;
    private double fiyat;
    private int stokAdedi;

    // Getter ve setter metotları

    // toString metodu
}



// UrunService.java(Servis sınıfı)

package com.example.feslegenmarket.service;

import com.example.feslegenmarket.model.Urun;

import java.util.List;

public interface UrunService {
    List<Urun> urunleriListele();
    Urun urunBul(Long id);
    void urunEkle(Urun urun);
    void urunSil(Long id);
}
