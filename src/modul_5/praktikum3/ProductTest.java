package modul_5.praktikum3;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        System.out.println("SISTEM MANAJEMEN PRODUK");

        // Membuat produk dengan PIN awal "1234"
        Product laptop = new Product("Laptop ASUS", 8500000, 15, "1234");
        Product mouse = new Product("Mouse Logitech", 150000, 50, "1234");

        System.out.println("\n--- PRODUK BERHASIL DIBUAT ---");
        laptop.tampilkanInfo();
        mouse.tampilkanInfo();

        // TEST READ-ONLY PROPERTIES
        System.out.println("\n--- TEST READ-ONLY PROPERTIES ---");
        System.out.println("ProductID (read-only): " + laptop.getProductId());
        System.out.println("Created At (read-only): " + laptop.getCreatedAt());
        // laptop.productId = "P-002"; // ERROR jika uncomment
        // Properti ini TIDAK BISA diubah setelah objek dibuat

        // TEST READ-WRITE PROPERTIES
        System.out.println("\n--- TEST READ-WRITE PROPERTIES ---");

        // Test 1: Ubah harga tanpa PIN (akan gagal)
        System.out.println("\n1. Mencoba ubah harga dengan PIN salah:");
        laptop.setHargaBeli(9000000, "0000"); // PIN salah

        // Test 2: Ubah harga dengan PIN benar
        System.out.println("\n2. Ubah harga dengan PIN benar:");
        laptop.setHargaBeli(9000000, "1234"); // PIN benar

        // Test 3: Ubah nama
        System.out.println("\n3. Ubah nama produk:");
        laptop.setNama("Laptop ASUS ROG");

        // Test 4: Ubah stok
        System.out.println("\n4. Ubah stok:");
        laptop.setStok(20); // PIN tidak dibutuhkan untuk set stok

        // TEST WRITE-ONLY PROPERTY
        System.out.println("\n--- TEST WRITE-ONLY PROPERTY (PIN) ---");
        // System.out.println(laptop.pinAdmin); // ERROR jika uncomment
        // System.out.println(laptop.getPinAdmin()); // ERROR (tidak ada getter)
        System.out.println("Hanya bisa diubah dengan validasi PIN lama:");
        laptop.setPinAdmin("1234", "5678"); // Ubah PIN dari 1234 -> 5678
        // laptop.changeAdminPin("0000", "9999"); // Akan gagal

        // TEST COMPUTED PROPERTIES
        System.out.println("\n--- TEST COMPUTED PROPERTIES ---");
        System.out.printf("Total Nilai Laptop : Rp %,.0f%n", laptop.getTotalNilai());
        System.out.printf("Harga Jual Laptop  : Rp %,.0f%n", laptop.getHargaJual());
        System.out.printf("Total Nilai Mouse  : Rp %,.0f%n", mouse.getTotalNilai());
        System.out.println("Status Stok Mouse  : " + mouse.getStatusStok());

        // TEST BUSINESS METHODS
        System.out.println("\n--- TEST BUSINESS METHODS ---");

        System.out.println("\n1. Tambah stok laptop:");
        laptop.tambahStok(10, "5678"); // Pakai PIN baru

        System.out.println("\n2. Kurangi stok mouse (penjualan):");
        mouse.kurangiStok(4);

        System.out.println("\n3. Kurangi stok mouse lagi (akan menipis):");
        mouse.kurangiStok(45);

        System.out.println("\n4. Coba kurangi stok lebih dari tersedia:");
        mouse.kurangiStok(5); // sisa 1, dikurangi 5

        // TAMPILKAN INFO AKHIR
        System.out.println("\n--- INFORMASI PRODUK SETELAH UPDATE ---");
        laptop.tampilkanInfo();
        mouse.tampilkanInfo();

        // RINGKASAN ENCAPSULATION
        System.out.println("\n--- RINGKASAN ENCAPSULATION ---");
        System.out.println("---> PROPERTY READ-ONLY      :");
        System.out.println("     (hanya getter, di-set di constructor)");
        System.out.println("     Contoh: productId, createdAt      -> (✓)");
        System.out.println("     (Tidak bisa diubah)               -> (X)");

        System.out.println("\n---> PROPERTY READ-WRITE     :");
        System.out.println("     (ada getter dan setter)");
        System.out.println("     Contoh: nama, harga, stok         -> (✓)");
        System.out.println("     (setter dengan validasi)          -> (✓)");

        System.out.println("\n---> PROPERTY WRITE-ONLY     :");
        System.out.println("     (hanya setter, tidak ada getter)");
        System.out.println("     Contoh: pinAdmin                  -> (✓)");
        System.out.println("     (Tidak bisa dibaca)               -> (X)");

        System.out.println("\n---> PROPERTY COMPUTED       :");
        System.out.println("     (hanya getter, tidak ada field)");
        System.out.println("     Contoh: totalNilai, statusStok    -> (✓)");
        System.out.println("     (Dihitung otomatis)               -> (✓)");
    }
}