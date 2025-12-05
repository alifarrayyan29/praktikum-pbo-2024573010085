package modul_5.praktikum2;

public class Mahasiswa {
    // Attributes (Fields) - Dibuat private (Encapsulation)
    private String npm;
    private String nama;
    private String jurusan;
    private double ipk;
    private int semester;
    private boolean isAktif;

    // Constructor
    public Mahasiswa(String npm, String nama, String jurusan) {
        this.npm = npm;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = 0.0; // Nilai default saat objek dibuat
        this.semester = 1; // Nilai default
        this.isAktif = true; // Nilai default
    }

    // == GETTER METHODS (Mengambil nilai) ==

    public String getNpm() {
        return npm;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public double getIpk() {
        return ipk;
    }

    public int getSemester() {
        return semester;
    }

    // Berbeda penamaan 'get' menjadi 'is' prefix
    // untuk tipe data boolean
    public boolean isAktif() {
        return isAktif;
    }

    // == SETTER METHODS (Mengubah nilai) ==

    // Note: npm sengaja tidak ada setter-nya
    // asumsi npm tidak boleh diubah setelah objek dibuat

    public void setNama(String nama) {
        // Validasi: nama tidak boleh kosong
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("ERROR: Nama tidak boleh kosong!");
            return;
        }

        // Validasi: nama hanya boleh huruf dan spasi
        // (Regex: [a-zA-Z .'] -> boleh huruf, spasi, titik, petik)
        if (!nama.matches("[a-zA-Z .']+")) {
            System.out.println("ERROR: Nama hanya boleh berisi huruf dan spasi!");
            return;
        }

        this.nama = nama.trim(); // Menghapus spasi di awal/akhir
        System.out.println("✓ Nama berhasil diubah menjadi: " + this.nama);
    }

    public void setJurusan(String jurusan) {
        if (jurusan == null || jurusan.trim().isEmpty()) {
            System.out.println("ERROR: Jurusan tidak boleh kosong!");
            return;
        }
        this.jurusan = jurusan.trim();
        System.out.println("✓ Jurusan berhasil diubah menjadi: " + this.jurusan);
    }

    public void setIpk(double ipk) {
        // Validasi: IPK harus dalam rentang 0.0 s.d 4.0
        if (ipk >= 0.0 && ipk <= 4.0) {
            this.ipk = ipk;
            // % .2f -> format 2 angka di belakang koma, %n -> newline
            System.out.printf("✓ IPK berhasil diubah menjadi: %.2f%n", ipk);
        } else {
            System.out.println("ERROR: IPK tidak valid. Harus antara 0.0 - 4.0!");
        }
        // Panggil method private jika IPK di bawah standar
        // peringatan();
    }

    public void setSemester(int semester) {
        // Validasi: Semester harus lebih besar dari 0
        if (semester > 0 && semester <= 14) { // Asumsi maks 14 semester
            this.semester = semester;
            System.out.println("✓ Semester berhasil diubah menjadi: " + this.semester);
        } else {
            System.out.println("ERROR: Semester tidak valid. Harus antara 1 - 14!");
        }
    }

    public void setAktif(boolean aktif) {
        this.isAktif = aktif;
        String status = this.isAktif ? "Aktif" : "Tidak Aktif";
        System.out.println("✓ Status berhasil diubah menjadi: " + status);
    }

    // == PRIVATE METHODS (Hanya bisa diakses di class ini) ==
    /*
    private void peringatan() {
        if (this.ipk < 2.0) {
            System.out.println("! Peringatan: IPK di bawah standar!");
        } else if (this.ipk >= 3.5) {
            System.out.println("✓ Excellent! IPK sangat baik!");
        }
    }
    */

    // == COMPUTED PROPERTY (Method yang bertindak sbg properti) ==
    public String getPredikat() {
        if (ipk >= 3.5) return "Cum Laude";
        else if (ipk >= 3.0) return "Sangat Memuaskan";
        else if (ipk >= 2.5) return "Memuaskan";
        else return "Cukup";
    }

    // == PUBLIC METHOD (Utility) ==
    public void tampilkanInfo() {
        // Menggunakan ternary operator untuk status
        String status = this.isAktif ? "Aktif" : "Tidak Aktif";

        System.out.println("========= DATA MAHASISWA =========");
        System.out.println("NPM       : " + this.npm);
        System.out.println("Nama      : " + this.nama);
        System.out.println("Jurusan   : " + this.jurusan);
        System.out.printf("IPK       : %.2f (%s)%n", this.ipk, getPredikat());
        System.out.println("Semester  : " + this.semester);
        System.out.println("Status    : " + status);
        System.out.println("==================================");
    }
}