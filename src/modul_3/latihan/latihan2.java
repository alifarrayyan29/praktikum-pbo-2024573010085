package modul_3.latihan;

import java.util.Scanner;
import java.util.Arrays;

public class latihan2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Langkah 1: Deklarasi array
        String[] namaSiswa = {"Alice", "Bob", "Charlie"};
        String[] mataPelajaran = {"Matematika", "Bahasa Ind", "IPA", "IPS"};
        int[][] nilaiSiswa = new int[namaSiswa.length][mataPelajaran.length];

        // Langkah 2: Input nilai
        System.out.println("=== INPUT NILAI SISWA ===");
        for (int i = 0; i < namaSiswa.length; i++) {
            System.out.println("Input nilai untuk " + namaSiswa[i] + ":");
            for (int j = 0; j < mataPelajaran.length; j++) {
                System.out.print(mataPelajaran[j] + ": ");
                nilaiSiswa[i][j] = input.nextInt();
            }
            System.out.println();
        }

        // Langkah 3: Menampilkan data, menghitung rata-rata per siswa, dan mencari nilai tertinggi per siswa
        System.out.println("\n=== TABEL NILAI SISWA ===");

        // Header Tabel
        System.out.printf("%-12s", "Nama");
        for (String mapel : mataPelajaran) {
            System.out.printf("%-12s", mapel);
        }
        System.out.println("Rata-rata");

        // Array untuk menyimpan info nilai tertinggi setiap siswa
        String[] infoNilaiTertinggi = new String[namaSiswa.length];

        // Isi Tabel
        for (int i = 0; i < namaSiswa.length; i++) {
            System.out.printf("%-12s", namaSiswa[i]);

            int total = 0;
            int nilaiTertinggiSiswa = nilaiSiswa[i][0]; // Asumsikan nilai pertama tertinggi
            String mapelTertinggi = mataPelajaran[0];   // Asumsikan mapel pertama tertinggi

            for (int j = 0; j < mataPelajaran.length; j++) {
                System.out.printf("%-12d", nilaiSiswa[i][j]);

                // [PERBAIKAN] Menggunakan += untuk menjumlahkan nilai
                total += nilaiSiswa[i][j];

                // [FITUR 1] Mencari nilai dan mapel tertinggi untuk siswa ini
                if (nilaiSiswa[i][j] > nilaiTertinggiSiswa) {
                    nilaiTertinggiSiswa = nilaiSiswa[i][j];
                    mapelTertinggi = mataPelajaran[j];
                }
            }

            double rataRata = (double) total / mataPelajaran.length;
            System.out.printf("%.2f\n", rataRata);

            // Menyimpan hasil fitur 1 ke dalam array
            infoNilaiTertinggi[i] = String.format("Nilai tertinggi %s: %d (pada mata pelajaran %s)", namaSiswa[i], nilaiTertinggiSiswa, mapelTertinggi);
        }

        // Menampilkan hasil Fitur 1
        System.out.println("\n--- NILAI TERTINGGI PER SISWA ---");
        for (String info : infoNilaiTertinggi) {
            System.out.println(info);
        }

        // [FITUR 2] Menghitung dan menampilkan rata-rata nilai untuk setiap mata pelajaran
        System.out.println("\n--- RATA-RATA NILAI PER MATA PELAJARAN ---");
        for (int j = 0; j < mataPelajaran.length; j++) { // Loop luar iterasi per MATA PELAJARAN (kolom)
            double totalPerMapel = 0;
            for (int i = 0; i < namaSiswa.length; i++) { // Loop dalam iterasi per SISWA (baris)
                totalPerMapel += nilaiSiswa[i][j];
            }
            double rataRataMapel = totalPerMapel / namaSiswa.length;
            System.out.printf("%-12s: %.2f\n", mataPelajaran[j], rataRataMapel);
        }
    }
}