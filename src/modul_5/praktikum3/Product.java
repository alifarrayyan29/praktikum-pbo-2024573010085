package modul_5.praktikum3;

import java.util.Scanner; // Meskipun tidak terpakai di sini, ada di gambar
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    // === BAGIAN DATA (PROPERTIES / FIELDS) ===

    // Counter statis untuk ID unik
    private static int productCounter = 0;

    // --- Properti Read-Only ---
    // (hanya getter, di-set 1x di constructor)
    private final String productId;
    private final String createdAt;

    // --- Properti Read-Write ---
    // (ada getter dan setter)
    private String nama;
    private double hargaBeli;
    private int stok;

    // --- Properti Write-Only ---
    // (hanya setter, tidak ada getter)
    private String pinAdmin;

    // === BAGIAN METHOD (PERILAKU) ===

    // --- Constructor ---
    public Product(String nama, double hargaBeli, int stok, String pinAdmin) {
        this.productId = this.generateProductId(); // Panggil private method
        this.createdAt = this.getCurrentTimestamp(); // Panggil private method

        this.nama = nama;
        this.hargaBeli = hargaBeli;
        this.stok = stok;
        this.pinAdmin = pinAdmin;

        productCounter++; // Naikkan counter setiap objek dibuat
    }

    // --- Getters (READ-ONLY properties) ---
    public String getProductId() {
        return this.productId;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    // --- Getters (READ-WRITE properties) ---
    public String getNama() {
        return this.nama;
    }

    public double getHargaBeli() {
        return this.hargaBeli;
    }

    public int getStok() {
        return this.stok;
    }

    // --- Setters (READ-WRITE properties) ---
    // (setter dengan validasi PIN)
    public void setHargaBeli(double hargaBeli, String pin) {
        if (!validasiPin(pin)) {
            System.out.println("ERROR: PIN salah! Harga tidak diubah.");
            return;
        }
        if (hargaBeli <= 0) {
            System.out.println("ERROR: Harga beli harus positif.");
            return;
        }
        this.hargaBeli = hargaBeli;
        System.out.println("✓ Harga beli berhasil diubah.");
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("ERROR: Nama tidak boleh kosong.");
            return;
        }
        this.nama = nama;
        System.out.println("✓ Nama berhasil diubah.");
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("ERROR: Stok tidak boleh negatif.");
            return;
        }
        this.stok = stok;
        System.out.println("✓ Stok berhasil diubah.");
    }

    // --- Setter (WRITE-ONLY property) ---
    public void setPinAdmin(String pinLama, String pinBaru) {
        if (!validasiPin(pinLama)) {
            System.out.println("ERROR: PIN lama salah! Gagal ubah PIN.");
            return;
        }
        if (pinBaru == null || pinBaru.length() < 4) {
            System.out.println("ERROR: PIN baru minimal harus 4 digit.");
            return;
        }
        this.pinAdmin = pinBaru;
        System.out.println("✓ PIN Admin berhasil diubah.");
    }

    // --- Getters (COMPUTED properties) ---
    // (Nilainya dihitung, bukan disimpan)
    public double getHargaJual() {
        // Asumsi margin profit 20%
        return this.hargaBeli * 1.20;
    }

    public double getTotalNilai() {
        // Nilai total = harga beli * stok
        return this.hargaBeli * this.stok;
    }

    public String getStatusStok() {
        if (this.stok == 0) return "Habis";
        if (this.stok < 10) return "Hampir Habis";
        return "Tersedia";
    }

    // --- Business Methods (Aksi) ---
    public void tambahStok(int jumlah, String pin) {
        if (!validasiPin(pin)) {
            System.out.println("ERROR: PIN salah! Stok tidak ditambah.");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("ERROR: Jumlah tambah stok harus positif.");
            return;
        }
        this.stok += jumlah;
        System.out.println("✓ Stok berhasil ditambah. Stok baru: " + this.stok);
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("ERROR: Jumlah kurang stok harus positif.");
            return;
        }
        if (jumlah > this.stok) {
            System.out.println("ERROR: Stok tidak mencukupi (sisa " + this.stok + ").");
            return;
        }
        this.stok -= jumlah;
        System.out.println("✓ Stok berhasil dikurangi (penjualan). Stok baru: " + this.stok);
    }

    // --- Private Utility Methods ---
    // (Hanya bisa dipakai di dalam class ini)
    private boolean validasiPin(String pin) {
        return pin != null && pin.equals(this.pinAdmin);
    }

    private String generateProductId() {
        // Format: P-2025-001
        return "P-" + new SimpleDateFormat("yyyy").format(new Date()) + "-" + String.format("%03d", productCounter + 1);
    }

    private String getCurrentTimestamp() {
        // Format: 2025-10-28 17:30:00
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    // Method khusus untuk ganti PIN jika lupa (butuh 'Super PIN')
    public void changeAdminPin(String pinLama, String pinBaru, String pinSuperAdmin) {
        if (pinSuperAdmin.equals("MASTERKEY_123")) {
            this.pinAdmin = pinBaru;
            System.out.println("✓ OVERRIDE: PIN Admin diubah paksa oleh Super Admin.");
            return;
        }
        // Jika super pin salah, gunakan logika normal
        setPinAdmin(pinLama, pinBaru);
    }

    // --- Public Utility Method ---
    public void tampilkanInfo() {
        System.out.println("--- INFORMASI PRODUK [" + this.productId + "] ---");
        System.out.println("Nama       : " + this.getNama());
        System.out.printf("Harga Beli : Rp %,.0f%n", this.getHargaBeli());
        System.out.printf("Harga Jual : Rp %,.0f%n", this.getHargaJual()); // computed
        System.out.println("Stok       : " + this.getStok() + " (" + this.getStatusStok() + ")"); // computed
        System.out.printf("Total Nilai: Rp %,.0f%n", this.getTotalNilai()); // computed
        System.out.println("Dibuat pada: " + this.getCreatedAt());
        System.out.println("-------------------------------------");
    }
}
