package modul_3;

import java.util.Scanner;

public class StringDasar {

    /**
     * Method untuk menampilkan analisis dasar dari sebuah string.
     * Method ini juga memanggil method hitungJumlahKata dan hitungVokal.
     */
    public static void analisisString(String teks) {
        System.out.println("\n--- ANALISIS DASAR ---");
        System.out.println("Teks asli: \"" + teks + "\"");
        System.out.println("Panjang string: " + teks.length());
        System.out.println("Karakter pertama: " + teks.charAt(0));
        System.out.println("Karakter terakhir: " + teks.charAt(teks.length() - 1));
        System.out.println("UPPERCASE: " + teks.toUpperCase());
        System.out.println("lowercase: " + teks.toLowerCase());

        // Menghitung jumlah kata
        int jumlahKata = hitungJumlahKata(teks);
        System.out.println("Jumlah kata: " + jumlahKata);

        // Menghitung jumlah vokal
        int jumlahVokal = hitungVokal(teks);
        System.out.println("Jumlah vokal: " + jumlahVokal);
    }

    /**
     * Method untuk menghitung jumlah kata dalam sebuah string.
     */
    public static int hitungJumlahKata(String teks) {
        // trim() untuk hapus spasi di awal/akhir, split() untuk memecah berdasarkan spasi
        String[] kata = teks.trim().split("\\s+");
        return kata.length;
    }

    /**
     * Method untuk menghitung jumlah huruf vokal dalam sebuah string.
     */
    public static int hitungVokal(String teks) {
        String vokal = "aeiouAEIOU";
        int counter = 0;
        for (int i = 0; i < teks.length(); i++) {
            // Cek apakah karakter saat ini ada di dalam string vokal
            if (vokal.contains(String.valueOf(teks.charAt(i)))) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Method untuk membalik urutan karakter dalam sebuah string.
     */
    public static String reverseString(String teks) {
        StringBuilder reversed = new StringBuilder();
        for (int i = teks.length() - 1; i >= 0; i--) {
            reversed.append(teks.charAt(i));
        }
        return reversed.toString();
    }

    /**
     * Method untuk mengecek apakah sebuah string adalah palindrom.
     * Palindrom: dibaca sama dari depan maupun belakang (setelah mengabaikan spasi dan simbol).
     */
    public static boolean isPalindrome(String teks) {
        // 1. Bersihkan string dari spasi, simbol, dan ubah ke huruf kecil
        String clean = teks.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // 2. Buat versi terbalik dari string yang sudah bersih
        String reversed = new StringBuilder(clean).reverse().toString();
        // 3. Bandingkan keduanya
        return clean.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM MANIPULASI STRING ===");
        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine();

        // Analisis dasar
        analisisString(kalimat);

        // String terbalik
        System.out.println("\nString terbalik: \"" + reverseString(kalimat) + "\"");

        // Cek Palindrom
        if (isPalindrome(kalimat)) {
            System.out.println("String ini adalah palindrom.");
        } else {
            System.out.println("String ini bukan palindrom.");
        }

        // Pencarian substring
        System.out.println("\nMasukkan kata yang ingin dicari:");
        System.out.print("> ");
        String cari = input.nextLine();

        // Cek apakah kata 'cari' ada di dalam 'kalimat' (abaikan huruf besar/kecil)
        if (kalimat.toLowerCase().contains(cari.toLowerCase())) {
            // Cari posisi (indeks) pertama kali kata itu muncul
            int posisi = kalimat.toLowerCase().indexOf(cari.toLowerCase());
            System.out.println("Kata \"" + cari + "\" ditemukan dalam kalimat.");
            System.out.println("Posisi pertama: " + posisi);
        } else {
            System.out.println("Kata \"" + cari + "\" tidak ditemukan dalam kalimat.");
        }
    }
}