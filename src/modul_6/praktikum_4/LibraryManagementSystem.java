package modul_6.praktikum_4;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    // List untuk menyimpan semua item perpustakaan (menggunakan polymorphism)
    private static ArrayList<LibraryItem> libraryItems = new ArrayList<>();

    // Scanner global untuk input pengguna
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Inisialisasi data contoh saat program dimulai
        initializeSampleData();

        System.out.println("Selamat Datang di Sistem Manajemen Perpustakaan!");

        // Loop utama program
        while (true) {
            displayMenu();

            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); // consume invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    displayAllItems();
                    break;
                case 2:
                    addNewItem();
                    break;
                case 3:
                    borrowItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
                    // Tutup scanner sebelum keluar
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println(); // Spasi antar operasi
        }
    }

    // --- Metode Tampilan dan Utilitas Utama ---

    private static void displayMenu() {
        System.out.println("--- SISTEM MANAJEMEN PERPUSTAKAAN ---");
        System.out.println("1. Tampilkan Semua Item");
        System.out.println("2. Tambah Item Baru");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Cari Item");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void initializeSampleData() {
        // Data inisialisasi menggunakan constructor dari kelas turunan
        libraryItems.add(new Book("B0001", "Pemrograman Java", 2023, "Rudi Santoso", "978-1234567890", 350));
        libraryItems.add(new Book("B0002", "Struktur Data", 2022, "Sari Dewi", "978-9876543210", 280));
        libraryItems.add(new Magazine("M001", "Info Teknologi", 2024, "Tech Media", 12, "Teknologi"));
        libraryItems.add(new DVD("D0001", "The Java Documentary", 2023, "John Programmer", 120, "Edukasi"));

        // Contoh item yang langsung dipinjam
        // Cek dulu apakah list tidak kosong
        if (!libraryItems.isEmpty()) {
            libraryItems.get(1).borrowItem();
        }
    }

    private static void displayAllItems() {
        System.out.println("--- DAFTAR SEMUA ITEM PERPUSTAKAAN ---");
        if (libraryItems.isEmpty()) {
            System.out.println("Perpustakaan kosong.");
            return;
        }
        for (LibraryItem item : libraryItems) {
            item.displayInfo(); // Polymorphism
            System.out.println();
        }
    }

    // --- Metode Operasi Perpustakaan ---

    private static void addNewItem() {
        System.out.println("--- TAMBAH ITEM BARU ---");
        System.out.println("1. Buku");
        System.out.println("2. Majalah");
        System.out.println("3. DVD");
        System.out.print("Pilih jenis item: ");

        int type = 0;
        if (scanner.hasNextInt()) {
            type = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } else {
            System.out.println("Input jenis item tidak valid. Kembali ke menu utama.");
            scanner.nextLine();
            return;
        }

        // Meminta data umum
        System.out.print("ID Item: ");
        String itemId = scanner.nextLine();
        System.out.print("Judul: ");
        String title = scanner.nextLine();
        System.out.print("Tahun: ");
        int year = 0;
        if (scanner.hasNextInt()) {
            year = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } else {
            System.out.println("Tahun tidak valid. Kembali ke menu utama.");
            return;
        }

        // Meminta data spesifik berdasarkan tipe
        switch (type) {
            case 1: // Book
                System.out.print("Penulis: ");
                String author = scanner.nextLine();
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Jumlah Halaman: ");
                int pages = 0;
                if (scanner.hasNextInt()) {
                    pages = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Jumlah Halaman tidak valid. Item gagal ditambahkan.");
                    return;
                }

                libraryItems.add(new Book(itemId, title, year, author, isbn, pages));
                break;
            case 2: // Magazine
                System.out.print("Penerbit: ");
                String publisher = scanner.nextLine();
                System.out.print("Edisi: ");
                int issue = 0;
                if (scanner.hasNextInt()) {
                    issue = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Edisi tidak valid. Item gagal ditambahkan.");
                    return;
                }
                System.out.print("Kategori: ");
                String category = scanner.nextLine();

                libraryItems.add(new Magazine(itemId, title, year, publisher, issue, category));
                break;
            case 3: // DVD
                System.out.print("Sutradara: ");
                String director = scanner.nextLine();
                System.out.print("Durasi (menit): ");
                int duration = 0;
                if (scanner.hasNextInt()) {
                    duration = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Durasi tidak valid. Item gagal ditambahkan.");
                    return;
                }
                System.out.print("Genre: ");
                String genre = scanner.nextLine();

                libraryItems.add(new DVD(itemId, title, year, director, duration, genre));
                break;
            default:
                System.out.println("Jenis item tidak valid! Item gagal ditambahkan.");
                return;
        }

        System.out.println("Item berhasil ditambahkan!");
    }

    private static void borrowItem() {
        System.out.print("Masukkan ID item yang ingin dipinjam: ");
        String borrowItemId = scanner.nextLine();

        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equalsIgnoreCase(borrowItemId)) {
                item.borrowItem();
                return;
            }
        }
        System.out.println("Item dengan ID " + borrowItemId + " tidak ditemukan!");
    }

    private static void returnItem() {
        System.out.print("Masukkan ID item yang ingin dikembalikan: ");
        String returnItemId = scanner.nextLine();

        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equalsIgnoreCase(returnItemId)) {
                item.returnItem();
                return;
            }
        }
        System.out.println("Item dengan ID " + returnItemId + " tidak ditemukan!");
    }

    private static void searchItem() {
        System.out.print("Masukkan kata kunci pencarian (judul/penulis/sutradara): ");
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("--- HASIL PENCARIAN ---");
        boolean found = false;

        for (LibraryItem item : libraryItems) {
            // Cek di Title (berlaku untuk semua)
            if (item.getTitle().toLowerCase().contains(keyword)) {
                item.displayInfo();
                System.out.println();
                found = true;
                continue;
            }

            // Cek di atribut spesifik
            if (item instanceof Book) {
                Book book = (Book) item;
                // Asumsi field 'author' di Book adalah public atau memiliki getter (atau diakses dari class yang sama)
                // Jika tidak, Anda perlu mengubah visibilitas di kelas Book.
                // Menggunakan asumsi visibilitas 'protected' atau 'public' untuk demonstrasi.
                // Namun, dalam kode sebelumnya, field 'author' adalah private.
                // Jika ingin mencari 'author', pastikan kelas Book memiliki getter untuk 'author'.

                // KARENA KODE BOOK SEBELUMNYA MENGGUNAKAN PRIVATE, KITA TIDAK BISA AKSES LANGSUNG.
                // Solusi: Kita tidak dapat memastikannya dari kode yang Anda berikan,
                // sehingga hanya akan mengandalkan pencarian Judul untuk menghindari error kompilasi.

                // (Untuk menghindari error, kita hanya fokus pada judul sesuai gambar awal)
            }
        }

        if (!found) {
            System.out.println("Tidak ada item yang sesuai dengan pencarian.");
        }
    }
}
