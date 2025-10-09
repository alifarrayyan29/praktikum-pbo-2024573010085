package modul_3;

public class ArraySatuDimensi {
    public static void main(String[] args) {

        // Langkah 1: Deklarasi dan inisialisasi array
        int[] nilai = {85, 90, 78, 92, 88};
        String[] nama = {"Alice", "Bob", "Charlie", "Diana", "Eva"};

        // Langkah 2: Menampilkan panjang array
        System.out.println("Jumlah siswa: " + nilai.length);

        // Langkah 3: Mengakses elemen array
        System.out.println("Nama siswa pertama: " + nama[0]);
        System.out.println("Nilai siswa pertama: " + nilai[0]);

        // Langkah 4: Menampilkan semua data menggunakan loop
        System.out.println("\nData semua siswa:");
        for (int i = 0; i < nama.length; i++) {
            System.out.println((i + 1) + ". " + nama[i] + " - Nilai: " + nilai[i]);
        }

        // Langkah 5: MODIFIKASI - Mencari nilai tertinggi dan terendah
        // Inisialisasi variabel tertinggi dan terendah dengan nilai elemen pertama
        int nilaiTertinggi = nilai[0];
        int nilaiTerendah = nilai[0];

        // Loop untuk membandingkan setiap nilai dalam array
        for (int i = 1; i < nilai.length; i++) {
            // Jika nilai saat ini lebih besar dari nilaiTertinggi, update nilaiTertinggi
            if (nilai[i] > nilaiTertinggi) {
                nilaiTertinggi = nilai[i];
            }
            // Jika nilai saat ini lebih kecil dari nilaiTerendah, update nilaiTerendah
            if (nilai[i] < nilaiTerendah) {
                nilaiTerendah = nilai[i];
            }
        }

        // Menampilkan hasil nilai tertinggi dan terendah
        System.out.println("\n--- Analisis Nilai ---");
        System.out.println("Nilai Tertinggi: " + nilaiTertinggi);
        System.out.println("Nilai Terendah: " + nilaiTerendah);
    }
}