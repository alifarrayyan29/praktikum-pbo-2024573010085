package modul_3.latihan;

import java.util.Scanner;

public class latihan5 {

    public static void analisisString(String teks) {
        System.out.println("\n--- ANALISIS DASAR ---");
        System.out.println("Teks asli: \"" + teks + "\"");
        System.out.println("Panjang string: " + teks.length());
        System.out.println("Karakter pertama: " + teks.charAt(0));
        System.out.println("Karakter terakhir: " + teks.charAt(teks.length() - 1));
        System.out.println("UPPERCASE: " + teks.toUpperCase());
        System.out.println("lowercase: " + teks.toLowerCase());

        // Menghitung jumlah kata
        System.out.println("Jumlah kata: " + hitungJumlahKata(teks));

        // Menghitung jumlah vokal
        System.out.println("Jumlah vokal: " + hitungVokal(teks));

        // [BARU] Menghitung jumlah konsonan
        System.out.println("Jumlah konsonan: " + hitungKonsonan(teks));
    }

    public static int hitungJumlahKata(String teks) {
        String[] kata = teks.trim().split("\\s+");
        return kata.length;
    }

    public static int hitungVokal(String teks) {
        String vokal = "aeiouAEIOU";
        int counter = 0;
        for (int i = 0; i < teks.length(); i++) {
            if (vokal.contains(String.valueOf(teks.charAt(i)))) {
                counter++;
            }
        }
        return counter;
    }

    // =======================================================
    // PENAMBAHAN METHOD BARU DI BAWAH INI
    // =======================================================

    /**
     * [BARU] Method untuk menghitung jumlah huruf konsonan.
     */
    public static int hitungKonsonan(String teks) {
        int jumlahHuruf = 0;
        // Pertama, hitung semua karakter yang merupakan huruf
        for (char ch : teks.toCharArray()) {
            if (Character.isLetter(ch)) {
                jumlahHuruf++;
            }
        }
        // Konsonan = Total Huruf - Total Vokal
        return jumlahHuruf - hitungVokal(teks);
    }

    /**
     * [BARU] Method untuk mengubah string menjadi format Judul (Title Case).
     * Setiap kata diawali huruf besar, sisanya huruf kecil.
     */
    public static String toTitleCase(String teks) {
        if (teks == null || teks.isEmpty()) {
            return "";
        }
        // Pecah kalimat menjadi kata-kata
        String[] kataArray = teks.split("\\s+");
        StringBuilder hasil = new StringBuilder();

        for (String kata : kataArray) {
            if (kata.length() > 0) {
                // Ambil huruf pertama, ubah jadi kapital
                char hurufPertama = Character.toUpperCase(kata.charAt(0));
                // Ambil sisa kata, ubah jadi huruf kecil
                String sisaKata = kata.substring(1).toLowerCase();
                // Gabungkan kembali dan tambahkan spasi
                hasil.append(hurufPertama).append(sisaKata).append(" ");
            }
        }
        // Hilangkan spasi ekstra di akhir
        return hasil.toString().trim();
    }

    // ... (method reverseString dan isPalindrome tetap sama) ...
    public static String reverseString(String teks) {
        StringBuilder reversed = new StringBuilder();
        for (int i = teks.length() - 1; i >= 0; i--) {
            reversed.append(teks.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String teks) {
        String clean = teks.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM MANIPULASI STRING ===");
        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine();

        // Analisis dasar (sekarang juga menampilkan jumlah konsonan)
        analisisString(kalimat);

        // [BARU] Menampilkan hasil konversi ke Title Case
        System.out.println("\nFormat Judul (Title Case): \"" + toTitleCase(kalimat) + "\"");

        // String terbalik
        System.out.println("String terbalik: \"" + reverseString(kalimat) + "\"");

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

        if (kalimat.toLowerCase().contains(cari.toLowerCase())) {
            int posisi = kalimat.toLowerCase().indexOf(cari.toLowerCase());
            System.out.println("Kata \"" + cari + "\" ditemukan dalam kalimat.");
            System.out.println("Posisi pertama: " + posisi);
        } else {
            System.out.println("Kata \"" + cari + "\" tidak ditemukan dalam kalimat.");
        }
    }
}