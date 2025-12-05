package modul_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("======================================================");
        System.out.println("        SISTEM KARTU RENCANA STUDI (KRS)              ");
        System.out.println("======================================================");

        System.out.print("Masukkan NIM    : ");
        String nim = input.nextLine();
        System.out.print("Masukkan Nama   : ");
        String nama = input.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = input.nextLine();

        Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan, 0.0);
        KartuRencanaStudi krs = new KartuRencanaStudi(mhs, 10);

        boolean running = true;
        while (running) {
            // MODIFIKASI: Menu diperbarui dengan opsi baru
            System.out.println("\n================ MENU KRS ================");
            System.out.println("| 1. Tambah Mata Kuliah                |");
            System.out.println("| 2. Input Nilai Mata Kuliah           |");
            System.out.println("| 3. Hapus Mata Kuliah dari KRS        |");
            System.out.println("| 4. Tampilkan KRS                     |");
            System.out.println("| 5. Keluar                            |");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n---[TAMBAH MATA KULIAH]---");
                    System.out.print("Kode Mata Kuliah: ");
                    String kode = input.nextLine();
                    System.out.print("Nama Mata Kuliah: ");
                    String namaMK = input.nextLine();
                    System.out.print("Jumlah SKS      : ");
                    int sks = input.nextInt();
                    input.nextLine();

                    Matakuliah mk = new Matakuliah(kode, namaMK, sks);
                    krs.tambahMatakuliah(mk);
                    break;

                case 2:
                    System.out.println("\n---[INPUT NILAI]---");
                    System.out.print("Masukkan Kode Mata Kuliah: ");
                    String kodeCari = input.nextLine();

                    Matakuliah mkCari = krs.cariMatakuliah(kodeCari);
                    if (mkCari != null) {
                        System.out.print("Masukkan Nilai (0-100): ");
                        double nilai = input.nextDouble();
                        input.nextLine();
                        mkCari.setNilai(nilai);
                        System.out.println("-> Nilai berhasil diinput!");
                    } else {
                        System.out.println("-> Mata kuliah tidak ditemukan!");
                    }
                    break;

                // BARU: Case untuk menghapus mata kuliah
                case 3:
                    System.out.println("\n---[HAPUS MATA KULIAH]---");
                    System.out.print("Masukkan Kode Mata Kuliah yang akan dihapus: ");
                    String kodeHapus = input.nextLine();

                    if (krs.hapusMatakuliah(kodeHapus)) {
                        System.out.println("-> Mata kuliah dengan kode '" + kodeHapus + "' berhasil dihapus.");
                    } else {
                        System.out.println("-> Gagal: Mata kuliah dengan kode tersebut tidak ditemukan di KRS.");
                    }
                    break;

                // MODIFIKASI: Nomor case disesuaikan
                case 4:
                    krs.tampilkanKRS();
                    break;

                // MODIFIKASI: Nomor case disesuaikan
                case 5:
                    System.out.println("\nTerima kasih! Sampai jumpa lagi. 👋");
                    running = false;
                    break;

                default:
                    System.out.println("\nPilihan tidak valid!");
                    break;
            }
        }
        input.close();
    }
}