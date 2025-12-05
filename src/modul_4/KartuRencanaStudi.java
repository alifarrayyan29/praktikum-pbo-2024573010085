package modul_4;

public class KartuRencanaStudi {
    private Mahasiswa mahasiswa;
    private Matakuliah[] daftarMatakuliah;
    private int jumlahMatkul;
    private int maxMatkul;
    private final int maxSKS = 24; // BARU: Batas maksimal SKS yang bisa diambil

    public KartuRencanaStudi(Mahasiswa mahasiswa, int maxMatkul) {
        this.mahasiswa = mahasiswa;
        this.maxMatkul = maxMatkul;
        this.daftarMatakuliah = new Matakuliah[maxMatkul];
        this.jumlahMatkul = 0;
    }

    // MODIFIKASI: Menambahkan validasi SKS sebelum menambah mata kuliah
    public boolean tambahMatakuliah(Matakuliah matkul) {
        if (jumlahMatkul >= maxMatkul) {
            System.out.println("-> Gagal: KRS sudah penuh! Maksimal " + maxMatkul + " mata kuliah.");
            return false;
        }

        if (hitungTotalSKS() + matkul.getSks() > maxSKS) {
            System.out.println("-> Gagal: Total SKS akan melebihi batas maksimal (" + maxSKS + " SKS).");
            return false;
        }

        daftarMatakuliah[jumlahMatkul] = matkul;
        jumlahMatkul++;
        System.out.println("-> Sukses: Mata Kuliah '" + matkul.getNama() + "' berhasil ditambahkan.");
        return true;
    }

    // BARU: Method untuk menghapus mata kuliah dari KRS
    public boolean hapusMatakuliah(String kode) {
        int indexHapus = -1;
        // 1. Cari indeks dari mata kuliah yang akan dihapus
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                indexHapus = i;
                break;
            }
        }

        // 2. Jika tidak ditemukan, kembalikan false
        if (indexHapus == -1) {
            return false;
        }

        // 3. Geser semua elemen setelahnya ke kiri untuk menimpa data yang dihapus
        for (int i = indexHapus; i < jumlahMatkul - 1; i++) {
            daftarMatakuliah[i] = daftarMatakuliah[i + 1];
        }

        // 4. Kurangi jumlah matkul dan atur elemen terakhir menjadi null
        jumlahMatkul--;
        daftarMatakuliah[jumlahMatkul] = null;
        return true;
    }

    public int hitungTotalSKS() {
        int totalSKS = 0;
        for (int i = 0; i < jumlahMatkul; i++) {
            totalSKS += daftarMatakuliah[i].getSks();
        }
        return totalSKS;
    }

    public double hitungIPK() {
        if (jumlahMatkul == 0) return 0.0;

        double totalBobot = 0.0;
        int totalSKS = hitungTotalSKS();
        for (int i = 0; i < jumlahMatkul; i++) {
            Matakuliah mk = daftarMatakuliah[i];
            totalBobot += mk.getBobotNilai() * mk.getSks();
        }

        return totalSKS > 0 ? totalBobot / totalSKS : 0.0;
    }

    // BARU: Method untuk mencari mata kuliah dengan nilai terbaik
    public Matakuliah getNilaiTerbaik() {
        if (jumlahMatkul == 0) return null;

        Matakuliah terbaik = daftarMatakuliah[0];
        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() > terbaik.getNilai()) {
                terbaik = daftarMatakuliah[i];
            }
        }
        return terbaik;
    }

    // BARU: Method untuk mencari mata kuliah dengan nilai terburuk
    public Matakuliah getNilaiTerburuk() {
        if (jumlahMatkul == 0) return null;

        Matakuliah terburuk = daftarMatakuliah[0];
        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() < terburuk.getNilai()) {
                terburuk = daftarMatakuliah[i];
            }
        }
        return terburuk;
    }

    // MODIFIKASI: Tampilan KRS diperbarui dengan info tambahan
    public void tampilkanKRS() {
        System.out.println("==========================================================================");
        System.out.println("                         KARTU RENCANA STUDI (KRS)                        ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("NIM      : " + mahasiswa.getNim());
        System.out.println("Nama     : " + mahasiswa.getNama());
        System.out.println("Jurusan  : " + mahasiswa.getJurusan());
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-12s %-30s %-7s %s\n", "Kode", "Mata Kuliah", "SKS", "Nilai");
        System.out.println("--------------------------------------------------------------------------");

        if (jumlahMatkul == 0) {
            System.out.println("                  Belum ada mata kuliah yang diambil.                   ");
        } else {
            for (int i = 0; i < jumlahMatkul; i++) {
                // Menggunakan format yang sedikit diubah agar lebih rapi
                Matakuliah mk = daftarMatakuliah[i];
                System.out.printf("%-12s %-30s %-7d %.2f (%s)\n",
                        mk.getKode(), mk.getNama(), mk.getSks(), mk.getNilai(), mk.getNilaiHuruf());
            }
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total SKS    : " + hitungTotalSKS() + " / " + maxSKS);
        System.out.printf("IP Semester  : %.2f\n", hitungIPK());

        Matakuliah terbaik = getNilaiTerbaik();
        Matakuliah terburuk = getNilaiTerburuk();

        if (terbaik != null) {
            System.out.printf("Nilai Terbaik: %.2f (%s - %s)\n", terbaik.getNilai(), terbaik.getKode(), terbaik.getNama());
            System.out.printf("Nilai Terburuk: %.2f (%s - %s)\n", terburuk.getNilai(), terburuk.getKode(), terburuk.getNama());
        }
        System.out.println("==========================================================================\n");
    }

    public Matakuliah cariMatakuliah(String kode) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                return daftarMatakuliah[i];
            }
        }
        return null;
    }
}