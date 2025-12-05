package modul_4;

public class Mahasiswa {
    // Atribut/Field (private untuk encapsulation)
    private String nama;
    private String nim;
    private String jurusan;

    // Constructor dengan parameter
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        // variabel ipk diterima oleh constructor, tapi tidak digunakan di dalam kode
    }

    // Getter methods
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
     }
}