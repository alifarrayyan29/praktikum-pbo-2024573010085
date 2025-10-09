package modul_3.latihan;

public class latihan3 {

    // ... (method-method yang sudah ada) ...
    public static void tampilkanHeader() {
        System.out.println("========================================");
        System.out.println("======= PROGRAM KALKULATOR LANJUTAN =======");
        System.out.println("========================================");
    }

    public static void tampilkanHasil(String operasi, double a, double b, double hasil) {
        System.out.printf("%.2f %s %.2f = %.2f\n", a, operasi, b, hasil);
    }

    public static double tambah(double a, double b) {
        return a + b;
    }

    public static double kurang(double a, double b) {
        return a - b;
    }

    public static double kali(double a, double b) {
        return a * b;
    }

    // Method bagi disederhanakan, validasi dipindah ke method sendiri
    public static double bagi(double a, double b) {
        return a / b;
    }

    public static boolean validasiAngka(double angka) {
        return !Double.isNaN(angka) && Double.isFinite(angka);
    }

    // =======================================================
    // PENAMBAHAN DAN PERUBAHAN DI BAWAH INI
    // =======================================================

    /**
     * [BARU] Method untuk menghitung pangkat.
     * Menggunakan Math.pow() dari library Java.
     */
    public static double pangkat(double basis, double eksponen) {
        return Math.pow(basis, eksponen);
    }

    /**
     * [BARU] Method untuk menghitung akar kuadrat.
     * Menggunakan Math.sqrt() dan menambahkan validasi untuk angka negatif.
     */
    public static double akarKuadrat(double angka) {
        if (angka < 0) {
            System.out.println("Error: Akar kuadrat dari angka negatif tidak valid!");
            return 0;
        }
        return Math.sqrt(angka);
    }

    /**
     * [BARU] Method khusus untuk validasi pembagian dengan nol.
     * Mengembalikan boolean (true jika valid, false jika tidak).
     */
    public static boolean validasiPembagian(double pembagi) {
        if (pembagi == 0) {
            System.out.println("Error: Pembagian dengan nol tidak diizinkan!");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        tampilkanHeader();

        // Menggunakan nilai baru untuk menunjukkan fitur pangkat dan akar
        double x = 9.0;
        double y = 2.0;

        System.out.println("\nOperasi untuk x = " + x + " dan y = " + y);

        if (validasiAngka(x) && validasiAngka(y)) {
            // Operasi dasar
            tampilkanHasil("+", x, y, tambah(x, y));
            tampilkanHasil("-", x, y, kurang(x, y));
            tampilkanHasil("*", x, y, kali(x, y));

            // [REFACTOR] Panggil validasi sebelum melakukan pembagian
            if (validasiPembagian(y)) {
                double hasilBagi = bagi(x, y);
                tampilkanHasil("/", x, y, hasilBagi);
            }

            // [BARU] Panggil method pangkat
            double hasilPangkat = pangkat(x, y);
            tampilkanHasil("^", x, y, hasilPangkat);

            // [BARU] Panggil method akar kuadrat
            double hasilAkar = akarKuadrat(x);
            // Tampilkan hasil akar secara terpisah karena formatnya berbeda
            System.out.printf("Akar kuadrat dari %.2f = %.2f\n", x, hasilAkar);
        }
    }
}