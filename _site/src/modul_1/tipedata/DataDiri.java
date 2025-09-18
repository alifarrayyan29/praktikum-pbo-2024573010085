package modul_1.tipedata;

public class DataDiri {
    public static void main(String[] args) {
        String nama, alamat, jurusan, prodi, nim, tempat;
        int usia;
        double tinggi;
        boolean StatusMahasiswa = true;
        char gender;

        nama = "Muhammad Alif Arrayyan";
        nim = "2024573010085";
        jurusan = "Teknologi Informasi dan Komputer";
        prodi = "Teknik Informatika";
        alamat  = "Alue Awe";
        tempat = "Banda Aceh, 29 November 2006";
        tinggi = 164;
        usia = 18;
        gender = 'L';

        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("Prodi: " + prodi);
        System.out.println("Alamat: " + alamat);
        System.out.println("Tempat/Tanggal Lahir: " + tempat);
        System.out.println("Tinggi: " + tinggi);
        System.out.println("Usia: " + usia);
        System.out.println("Gender: " + gender);
        System.out.println("StatusMahasiswa: " + StatusMahasiswa);
    }
}