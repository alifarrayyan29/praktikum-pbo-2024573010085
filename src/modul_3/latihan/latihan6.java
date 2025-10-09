package modul_3.latihan;

import java.util.Scanner;

public class latihan6 {

    public static void prosesDataMahasiswa(String data) {
        String[] dataMahasiswa = data.split(";");
        System.out.println("\n================ ANALISIS DATA ===============");
        System.out.println("Jumlah mahasiswa: " + dataMahasiswa.length);

        // ... (kode di dalam method ini tetap sama) ...
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

        for (int i = 0; i < dataMahasiswa.length - 1; i++) {
            for (int j = 0; j < dataMahasiswa.length - i - 1; j++) {
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

    public static void formatNama(String[] nama) {
        System.out.println("\n============== FORMAT NAMA, USERNAME & EMAIL =============");
        for (String namaLengkap : nama) {
            String namaFormatted = formatTitleCase(namaLengkap.trim()); // trim() untuk hapus spasi berlebih
            String username = buatUsername(namaFormatted);
            // [BARU] Panggil method untuk membuat email
            String email = buatEmail(namaFormatted);

            System.out.println("Nama Lengkap: " + namaFormatted);
            System.out.println("Username    : " + username);
            System.out.println("Email       : " + email); // Tampilkan email
            System.out.println("---");
        }
    }

    public static String formatTitleCase(String teks) {
        // ... (kode di dalam method ini tetap sama) ...
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

    public static String buatUsername(String nama) {
        // ... (kode di dalam method ini tetap sama) ...
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

    public static String buatPassword(String nama) {
        // ... (kode di dalam method ini tetap sama, meskipun tidak dipanggil di main) ...
        String reversedName = new StringBuilder(nama).reverse().toString();
        return reversedName.replaceAll("(?i)[aeiou\\s]", "");
    }

    // =======================================================
    // PENAMBAHAN METHOD BARU DI BAWAH INI
    // =======================================================

    /**
     * [BARU] Method untuk menghasilkan alamat email dari nama.
     * Menggunakan username yang sudah dibuat dan menambahkan domain.
     */
    public static String buatEmail(String nama) {
        String username = buatUsername(nama);
        return username + "@mahasiswa.campus.id";
    }

    /**
     * [BARU] Method untuk memvalidasi format nama.
     * Nama dianggap valid jika hanya mengandung huruf dan spasi.
     */
    public static boolean isNamaValid(String nama) {
        // Regex: ^[a-zA-Z\s]+$
        // Artinya: String harus terdiri dari awal (^) sampai akhir ($)
        // hanya oleh karakter huruf (a-z, A-Z) dan spasi (\s).
        return nama.trim().matches("^[a-zA-Z\\s]+$");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM PENGOLAHAN DATA TEKS ===");
        System.out.println("Masukkan nama-nama mahasiswa (pisahkan dengan titik koma ';'):");
        System.out.print("> ");
        String dataInput = input.nextLine();

        // Memisahkan data input menjadi array
        String[] database = dataInput.split(";");

        // [BARU] Proses validasi input sebelum diproses lebih lanjut
        boolean semuaNamaValid = true;
        for (String nama : database) {
            if (!isNamaValid(nama)) {
                System.out.println("\n[ERROR] Input tidak valid!");
                System.out.println("Nama \"" + nama.trim() + "\" mengandung karakter selain huruf dan spasi.");
                semuaNamaValid = false;
                break; // Hentikan pengecekan jika satu nama sudah tidak valid
            }
        }

        // [BARU] Hanya jalankan proses jika semua nama valid
        if (semuaNamaValid) {
            // Proses data utama
            prosesDataMahasiswa(dataInput);

            // Format nama
            formatNama(database);
        }
    }
}
