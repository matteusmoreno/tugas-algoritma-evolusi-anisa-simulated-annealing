
# 🔥 Optimasi Rute Pengiriman J&T di Surabaya dengan Metode Simulated Annealing

Proyek ini bertujuan untuk mengoptimalkan rute pengiriman kurir J&T di wilayah Surabaya menggunakan algoritma *Simulated Annealing*. Dengan pendekatan ini, rute terbaik dapat ditemukan dengan mempertimbangkan kemungkinan solusi yang kurang optimal untuk keluar dari *local optimum*.

## 🗺️ Daftar Lokasi

| Kode | Titik Lokasi         |
|------|----------------------|
| A    | Gudang Utama J&T     |
| B    | J&T Rungkut          |
| C    | J&T Tandes           |
| D    | J&T Kenjeran         |
| E    | J&T Dukuh Pakis      |
| F    | J&T Margomulyo       |

## 📏 Matriks Jarak Antar Lokasi (dalam KM)

|     | A  | B  | C  | D  | E  | F  |
|-----|----|----|----|----|----|----|
| A   | 0  | 8  | 12 | 10 | 6  | 14 |
| B   | 8  | 0  | 10 | 6  | 7  | 12 |
| C   | 12 | 10 | 0  | 14 | 9  | 5  |
| D   | 10 | 6  | 14 | 0  | 8  | 11 |
| E   | 6  | 7  | 9  | 8  | 0  | 10 |
| F   | 14 | 12 | 5  | 11 | 10 | 0  |

## 🔍 Langkah-Langkah Simulated Annealing

1. Mulai dengan rute awal secara acak (contoh: A → B → C → D → E → F → A).
2. Tentukan suhu awal (contoh: 100) dan *cooling rate* (contoh: 0.95).
3. Pada setiap iterasi:
   - Tukar dua titik secara acak.
   - Hitung jarak total dari rute baru.
   - Jika lebih pendek → diterima.
   - Jika lebih panjang → diterima dengan probabilitas: `P = e^(-Δ/T)`
4. Turunkan suhu: `T = T * coolingRate`
5. Ulangi hingga suhu cukup rendah atau iterasi habis.

## 💻 Cara Menjalankan

1. Pastikan Anda memiliki Java dan IDE (misal IntelliJ atau VS Code) terinstal.
2. Clone repositori ini:
   ```bash
   git clone https://github.com/username/proyek-simulated-annealing.git
   ```
3. Jalankan file `SimulatedAnnealing.java`.
4. Lihat output di terminal untuk rute terbaik dan jaraknya.

## 🧠 Contoh Output

```plaintext
Rute terbaik: A → B → C → F → E → D → A  
Jarak total: 51 km
```
