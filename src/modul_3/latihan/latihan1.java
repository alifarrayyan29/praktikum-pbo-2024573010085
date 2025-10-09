package modul_3.latihan;
import java.util.Arrays;

public class latihan1 {
    public static void main(String[] args) {
        // 1. Membuat array untuk menyimpan nilai ujian 10 siswa
        int[] nilaiUjian = {85, 92, 78, 65, 88, 95, 74, 81, 98, 70};

        // Inisialisasi variabel yang dibutuhkan
        double totalNilai = 0;
        int nilaiTertinggi = nilaiUjian[0]; // Asumsikan nilai pertama adalah yang tertinggi
        int nilaiTerendah = nilaiUjian[0];  // Asumsikan nilai pertama adalah yang terendah

        // Loop untuk menghitung total sekaligus mencari nilai tertinggi dan terendah
        for (int nilai : nilaiUjian) {
            // Menambahkan setiap nilai ke total
            totalNilai += nilai;

            // Memeriksa apakah nilai saat ini lebih tinggi dari nilai tertinggi yang tersimpan
            if (nilai > nilaiTertinggi) {
                nilaiTertinggi = nilai;
            }

            // Memeriksa apakah nilai saat ini lebih rendah dari nilai terendah yang tersimpan
            if (nilai < nilaiTerendah) {
                nilaiTerendah = nilai;
            }
        }

        // 2. Menghitung rata-rata nilai
        double rataRata = totalNilai / nilaiUjian.length;

        // 3. Menampilkan semua hasil
        System.out.println("Daftar Nilai Ujian: " + Arrays.toString(nilaiUjian));
        System.out.println("==========================================");
        System.out.printf("Rata-rata Nilai: %.2f\n", rataRata);
        System.out.println("Nilai Tertinggi: " + nilaiTertinggi);
        System.out.println("Nilai Terendah : " + nilaiTerendah);
    }
}