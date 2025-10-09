package modul_3;

import java.util.Scanner;

public class TextProcessing {

    /**
     * Method utama untuk memproses dan menganalisis data mahasiswa.
     * Mencari nama terpanjang, terpendek, dan mengurutkan nama.
     */
    public static void prosesDataMahasiswa(String data) {
        // Memisahkan data string menjadi array nama
        String[] dataMahasiswa = data.split(";");
        System.out.println("\n================ ANALISIS DATA ===============");
        System.out.println("Jumlah mahasiswa: " + dataMahasiswa.length);

        // Mencari nama terpanjang dan terpendek
        String namaTerpanjang = dataMahasiswa[0];
        String namaTerpendek = dataMahasiswa[0];
        for (int i = 1; i < dataMahasiswa.length; i++) {
            if (dataMahasiswa[i].length() > namaTerpanjang.length()) {
                namaTerpanjang = dataMahasiswa[i];
            }
            if (dataMahasiswa[i].length() < namaTerpendek.length()) {
                namaTerpendek = dataMahasiswa[i];
            }
        }
        System.out.println("Nama terpanjang: " + namaTerpanjang + " (" + namaTerpanjang.length() + " karakter)");
        System.out.println("Nama terpendek : " + namaTerpendek + " (" + namaTerpendek.length() + " karakter)");

        // Mengurutkan nama mahasiswa secara alfabetis (Bubble Sort)
        for (int i = 0; i < dataMahasiswa.length - 1; i++) {
            for (int j = 0; j < dataMahasiswa.length - i - 1; j++) {
                // compareTo() digunakan untuk membandingkan string
                if (dataMahasiswa[j].compareTo(dataMahasiswa[j + 1]) > 0) {
                    String temp = dataMahasiswa[j];
                    dataMahasiswa[j] = dataMahasiswa[j + 1];
                    dataMahasiswa[j + 1] = temp;
                }
            }
        }

        System.out.println("\nUrutan nama mahasiswa (sesuai abjad):");
        for (int i = 0; i < dataMahasiswa.length; i++) {
            System.out.println((i + 1) + ". " + dataMahasiswa[i]);
        }
    }

    /**
     * Method untuk menampilkan hasil format nama dan username.
     */
    public static void formatNama(String[] nama) {
        System.out.println("\n============== FORMAT NAMA & USERNAME =============");
        for (String namaLengkap : nama) {
            String namaFormatted = formatTitleCase(namaLengkap);
            String username = buatUsername(namaFormatted);
            System.out.println("Nama Lengkap: " + namaFormatted);
            System.out.println("Username    : " + username);
            System.out.println("---");
        }
    }

    /**
     * Method untuk mengubah format teks menjadi Title Case (Setiap Kata Diawali Huruf Besar).
     */
    public static String formatTitleCase(String teks) {
        if (teks == null || teks.isEmpty()) {
            return "";
        }
        String[] kata = teks.split("\\s+");
        StringBuilder hasil = new StringBuilder();
        for (String k : kata) {
            if (k.length() > 0) {
                hasil.append(Character.toUpperCase(k.charAt(0)))
                        .append(k.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return hasil.toString().trim();
    }

    /**
     * Method untuk membuat username dari nama lengkap.
     * Format: namadepan + hurufpertamanamakedua (jika ada).
     */
    public static String buatUsername(String nama) {
        String[] kata = nama.toLowerCase().split("\\s+");
        if (kata.length == 0) {
            return "";
        }
        StringBuilder username = new StringBuilder(kata[0]);
        if (kata.length > 1) {
            username.append(kata[1].charAt(0));
        }
        return username.toString();
    }

    /**
     * Method untuk membuat password sederhana dari nama.
     * Format: nama dibalik tanpa huruf vokal dan spasi.
     */
    public static String buatPassword(String nama) {
        String reversedName = new StringBuilder(nama).reverse().toString();
        // Regex (?i) membuatnya case-insensitive
        return reversedName.replaceAll("(?i)[aeiou\\s]", "");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM PENGOLAHAN DATA TEKS ===");
        System.out.println("Masukkan nama-nama mahasiswa (pisahkan dengan titik koma ';'):");
        System.out.print("> ");
        String dataInput = input.nextLine();

        // Proses data utama
        prosesDataMahasiswa(dataInput);

        // Format nama
        String[] database = dataInput.split(";");
        formatNama(database);
    }
}