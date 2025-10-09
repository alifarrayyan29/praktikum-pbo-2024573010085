package modul_3;

import java.util.Scanner;

public class ArrayMethod {

    /**
     * Method untuk meminta input dari pengguna dan mengembalikan sebuah array integer.
     */
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

    /**
     * Method untuk menampilkan isi dari sebuah array integer.
     */
    public static void tampilkanArray(int[] array) {
        System.out.print("[");
        // Loop untuk mencetak semua elemen kecuali yang terakhir, dengan koma
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        // Cetak elemen terakhir tanpa koma
        if (array.length > 0) {
            System.out.print(array[array.length - 1]);
        }
        System.out.println("]");
    }

    /**
     * Method untuk mencari nilai maksimum dari sebuah array.
     */
    public static int cariMaksimum(int[] array) {
        int maks = array[0]; // Asumsikan elemen pertama adalah yang terbesar
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maks) {
                maks = array[i];
            }
        }
        return maks;
    }

    /**
     * Method untuk mencari nilai minimum dari sebuah array.
     */
    public static int cariMinimum(int[] array) {
        int min = array[0]; // Asumsikan elemen pertama adalah yang terkecil
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Method untuk menghitung rata-rata dari sebuah array.
     */
    public static double hitungRataRata(int[] array) {
        int total = 0;
        for (int nilai : array) {
            total += nilai;
        }
        // Cast ke double agar hasil pembagian tidak berupa integer
        return (double) total / array.length;
    }

    /**
     * Method untuk mengurutkan array menggunakan algoritma Bubble Sort.
     * Method ini membuat salinan array agar array asli tidak berubah.
     */
    public static int[] urutkanArray(int[] array) {
        int[] arrayBaru = array.clone(); // Membuat salinan array
        int n = arrayBaru.length;
        // Algoritma Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayBaru[j] > arrayBaru[j + 1]) {
                    // Tukar elemen
                    int temp = arrayBaru[j];
                    arrayBaru[j] = arrayBaru[j + 1];
                    arrayBaru[j + 1] = temp;
                }
            }
        }
        return arrayBaru;
    }

    public static void main(String[] args) {
        System.out.println("=== PROGRAM ANALISIS ARRAY ===");

        // Meminta pengguna memasukkan 5 angka
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
    }
}