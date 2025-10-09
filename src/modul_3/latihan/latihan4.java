package modul_3.latihan;

import java.util.Scanner;

public class latihan4 {

    // ... (method-method yang sudah ada: inputArray, tampilkanArray, cariMaksimum, cariMinimum, hitungRataRata, urutkanArray) ...
    public static int[] inputArray(int ukuran) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[ukuran];
        System.out.println("Masukkan " + ukuran + " angka:");
        for (int i = 0; i < ukuran; i++) {
            System.out.print("Angka ke-" + (i + 1) + ": ");
            array[i] = input.nextInt();
        }
        return array;
    }
    public static void tampilkanArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        if (array.length > 0) {
            System.out.print(array[array.length - 1]);
        }
        System.out.println("]");
    }
    public static int cariMaksimum(int[] array) {
        int maks = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maks) {
                maks = array[i];
            }
        }
        return maks;
    }
    public static int cariMinimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    public static double hitungRataRata(int[] array) {
        int total = 0;
        for (int nilai : array) {
            total += nilai;
        }
        return (double) total / array.length;
    }
    public static int[] urutkanArray(int[] array) {
        int[] arrayBaru = array.clone();
        int n = arrayBaru.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayBaru[j] > arrayBaru[j + 1]) {
                    int temp = arrayBaru[j];
                    arrayBaru[j] = arrayBaru[j + 1];
                    arrayBaru[j + 1] = temp;
                }
            }
        }
        return arrayBaru;
    }

    // =======================================================
    // PENAMBAHAN METHOD BARU DI BAWAH INI
    // =======================================================

    /**
     * [BARU] Method untuk mencari nilai tertentu dalam array (Linear Search).
     * Mengembalikan indeks dari elemen jika ditemukan, atau -1 jika tidak.
     */
    public static int cariNilai(int[] array, int nilaiYangDicari) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == nilaiYangDicari) {
                return i; // Mengembalikan indeks jika nilai ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika nilai tidak ditemukan setelah loop selesai
    }

    /**
     * [BARU] Method untuk menghitung median dari array yang SUDAH diurutkan.
     */
    public static double hitungMedian(int[] arrayUrut) {
        int n = arrayUrut.length;
        if (n % 2 != 0) {
            // Jika jumlah elemen ganjil, median adalah nilai tengah
            return arrayUrut[n / 2];
        } else {
            // Jika jumlah elemen genap, median adalah rata-rata dari dua nilai tengah
            int tengah1 = arrayUrut[(n / 2) - 1];
            int tengah2 = arrayUrut[n / 2];
            return (double) (tengah1 + tengah2) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM ANALISIS ARRAY ===");

        int[] data = inputArray(5);

        System.out.println("\n=== HASIL ANALISIS ===");
        System.out.print("Data Asli      : ");
        tampilkanArray(data);

        System.out.println("Nilai Maksimum : " + cariMaksimum(data));
        System.out.println("Nilai Minimum  : " + cariMinimum(data));
        System.out.printf("Rata-rata      : %.2f\n", hitungRataRata(data));

        // Mengurutkan array
        int[] dataUrut = urutkanArray(data);
        System.out.print("Array setelah diurutkan: ");
        tampilkanArray(dataUrut);

        // [BARU] Menghitung dan menampilkan median dari data yang sudah diurutkan
        System.out.printf("Median         : %.2f\n", hitungMedian(dataUrut));

        // [BARU] Proses pencarian nilai
        System.out.println("\n=== PENCARIAN NILAI ===");
        System.out.print("Masukkan nilai yang ingin Anda cari: ");
        int nilaiCari = input.nextInt();

        int indeksHasil = cariNilai(data, nilaiCari);

        if (indeksHasil != -1) {
            System.out.println("Nilai " + nilaiCari + " ditemukan pada indeks ke-" + indeksHasil);
        } else {
            System.out.println("Nilai " + nilaiCari + " tidak ditemukan dalam array.");
        }
    }
}