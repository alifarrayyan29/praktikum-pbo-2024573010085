# Laporan Modul 3: Dasar Pemograman Java Lanjutan
**Mata Kuliah:** Praktikum Pemrograman Berorientasi Objek  
**Nama:** Muhammad Alif Arrayyan  
**NIM:** 2024573010085  
**Kelas:** TI-2E

---

## Abstrak

Laporan ini berisi rangkuman hasil praktikum Modul 3: Dasar Pemrograman Java Lanjutan, yang berfokus pada tiga topik utama, yaitu Array, Method/Function, dan String/Manipulasi String. Tujuan utama penyusunan laporan ini adalah untuk mendokumentasikan pemahaman konsep, langkah implementasi kode, hasil eksekusi, serta analisis dari setiap kegiatan praktikum dan tugas yang dilakukan.

Melalui serangkaian kegiatan tersebut, mahasiswa mampu mengimplementasikan penggunaan array satu dan dua dimensi, membuat serta memanggil method dengan berbagai tipe, dan melakukan manipulasi string yang kompleks seperti validasi dan pemformatan data. Dengan demikian, laporan ini menjadi bukti pemahaman yang kuat terhadap konsep lanjutan dalam pemrograman Java.
    
---

## Praktikum 1.1 - Array Satu Dimensi

### Dasar Teori
Array adalah struktur data homogen yang menyimpan kumpulan nilai dengan tipe data yang sama. Array di Java memiliki ukuran yang tetap (*fixed size*) dan elemennya diakses melalui indeks yang dimulai dari 0.

### Langkah Praktikum
1. Membuat package `modul_3` dan class `ArraySatuDimensi.java`.
2. Mendeklarasikan dan menginisialixsasi array integer `nilaiSiswa`.
3. Menambahkan perulangan *enhanced for* untuk mencari nilai tertinggi dan terendah dalam array.
4. Menampilkan hasil array, akses elemen spesifik, serta hasil pencarian nilai ekstrem.

### Screenshoot Hasil Praktikum
![Program](./gambar/asd.png)    
![Output](./gambar/output3.png)

### Penjelasan Latihan
Pada tugas ini, saya diminta untuk membuat array satu dimensi yang menyimpan nilai ujian dari 10 siswa. Tugas ini mencakup:
- Menampilkan nilai seluruh siswa yang disimpan dalam array.
- Menghitung rata-rata nilai ujian seluruh siswa.
- Mencari nilai tertinggi dan terendah dari array yang telah dibuat.

### Screenshoot Hasil Latihan
![Program](./gambar/l1.png)   
![Output](./gambar/output-1.png)

### Analisa dan Pembahasan
Array `nilaiSiswa` berhasil dideklarasikan dan diakses. Modifikasi kode untuk mencari nilai tertinggi dan terendah dilakukan dengan inisialisasi awal `nilaiTertinggi` dan `nilaiTerendah` menggunakan elemen pertama array (`nilaiSiswa[0]`). Perulangan *for-each* digunakan untuk membandingkan setiap elemen dengan nilai ekstrem yang tersimpan, memperbarui variabel jika ditemukan nilai baru.

---

## Praktikum 1.2 - Array Dua Dimensi

### Dasar Teori
Array dua dimensi (2D) atau matriks adalah array dari array. Array 2D digunakan untuk merepresentasikan data dalam bentuk baris dan kolom. Akses elemen memerlukan dua indeks: `namaArray[baris][kolom]`.

### Langkah Praktikum
1. Membuat class `ArrayDuaDimensi.java`.
2. Mendeklarasikan array 2D `nilai` yang merepresentasikan nilai 3 siswa untuk 4 mata pelajaran.
3. Menjalankan program dan menganalisis struktur data.

### Screenshoot Hasil Praktikum
![Program](./gambar/add.png)    
![Output](./gambar/output1.png)

### Penjelasan Latihan
Pada tugas ini, saya diminta untuk membuat array dua dimensi untuk menyimpan nilai ujian siswa pada beberapa mata pelajaran.

### Screenshoot Hasil Latihan
![Program](./gambar/l2-1.png)   
![Program](./gambar/l2-2.png)    
![Output](./gambar/output-2.png)

### Analisa dan Pembahasan
Array 2D berhasil diimplementasikan, di mana indeks pertama merepresentasikan siswa (baris) dan indeks kedua merepresentasikan mata pelajaran (kolom).

---

## Praktikum 2.1 - Method Dasar

### Dasar Teori
Method (atau Function) adalah blok kode yang menjalankan tugas tertentu. Praktikum ini mengeksplorasi pembuatan method dengan berbagai jenis: `void` (tidak mengembalikan nilai) dan `return method` (mengembalikan nilai).

### Langkah Praktikum
1. Membuat class `MethodDasar.java`.
2. Membuat method `tampilkanHeader()` dan `tampilkanHasil()`.
3. Membuat method matematika (`tambah`, `kurang`, `kali`, `bagi`) dengan return value.
4. Membuat method `validasiAngka()` untuk memastikan input valid.
5. Memanggil semua method di `main`.

### Screenshoot Hasil Praktikum
![Program](./gambar/md1.png)   
![Program](./gambar/md2.png)   
![Output](./gambar/output4.png)

### Penjelasan Latihan
Tugas ini mencakup operasi matematika dasar, validasi pembagian dengan nol, dan penggunaan method dengan parameter dan return type.

### Screenshoot Hasil Latihan
![Program](./gambar/l3-1.png)   
![Program](./gambar/l3-2.png)   
![Program](./gambar/l3-3.png)   
![Output](./gambar/output-3.png)

### Analisa dan Pembahasan
Implementasi berjalan baik. Pemisahan logika ke dalam method membuat kode lebih bersih dan mudah dipahami, menunjukkan prinsip modularitas.

---

## Praktikum 2.2 - Method Dengan Array

### Dasar Teori
Method dapat menerima dan mengembalikan array sebagai parameter.

### Langkah Praktikum
1. Membuat class `ArrayMethod.java`.
2. Membuat method `inputArray`, `tampilkanArray`, `cariMaksimum`, `cariMinimum`, `hitungRataRata`, dan `urutkanArray`.
3. Menggabungkan semua method di `main` untuk alur analisis array lengkap.

### Screenshoot Hasil Praktikum
![Program](./gambar/am1.png)   
![Program](./gambar/am2.png)   
![Program](./gambar/am3.png)   
![Output](./gambar/output2.png)


### Penjelasan Latihan
Program menghitung rata-rata nilai dalam array, mencari nilai maksimum dan minimum, serta mengurutkan array.

### Screenshoot Hasil Latihan
![Program](./gambar/l4-1.png)   
![Program](./gambar/l4-2.png)   
![Program](./gambar/l4-3.png)   
![Output](./gambar/output-4.png)

### Analisa dan Pembahasan
Pemisahan logika pemrosesan array ke dalam method yang berbeda terbukti efektif. Method `urutkanArray` menggunakan `array.clone()` agar array asli tidak berubah.

---

## Praktikum 3.1 - Manipulasi String Dasar

### Dasar Teori
String di Java bersifat *immutable* (tidak dapat diubah setelah dibuat). Java menyediakan berbagai method built-in seperti `length()`, `charAt()`, `toUpperCase()`, `toLowerCase()`, dan `contains()`.

### Langkah Praktikum
1. Membuat class `StringDasar.java`.
2. Membuat method `analysisString`, `hitungVokal`, `reverseString`, dan `isPalindrome`.
3. Menggunakan `Scanner` untuk input dinamis.

### Screenshoot Hasil Praktikum
![Program](./gambar/sd1.png)   
![Program](./gambar/sd2.png)   
![Program](./gambar/sd3.png)   
![Output](./gambar/output5.png)

### Penjelasan Latihan
Tugas ini mencakup menghitung jumlah vokal, mengubah case string, dan menampilkan jumlah kata.

### Screenshoot Hasil Latihan
![Program](./gambar/l5-1.png)   
![Program](./gambar/l5-2.png)   
![Program](./gambar/l5-3.png)   
![Output](./gambar/output-5.png)

### Analisa dan Pembahasan
String manipulation berjalan efisien dengan method bawaan Java. Penggunaan *regular expression* dan *StringBuilder* membantu efisiensi.

---

## Praktikum 3.2 - Pengolahan Data Text

### Dasar Teori
Pemrosesan data teks melibatkan *tokenizing*, *formatting*, dan *validation*.

### Langkah Praktikum
1. Membuat class `TextProcessing.java`.
2. Membuat method `prosesDataMahasiswa` untuk memecah data nama.
3. Membuat method `formatTitleCase`, `formatKataInitial`, dan `buatUsername`.

### Screenshoot Hasil Praktikum
![Program](./gambar/tp1.png)   
![Program](./gambar/tp2.png)   
![Program](./gambar/tp3.png)   
![Output](./gambar/output6.png)

### Penjelasan Latihan
Program memvalidasi format nama dan membuat alamat email berdasarkan nama lengkap.

### Screenshoot Hasil Latihan
![Program](./gambar/l6-1.png)   
![Program](./gambar/l6-2.png)   
![Program](./gambar/l6-3.png)   
![Output](./gambar/output-6.png)

### Analisa dan Pembahasan
Penggunaan `split(",")` efektif untuk memecah data teks menjadi array yang dapat diproses. Pengurutan nama menggunakan `compareToIgnoreCase()` untuk hasil alfabetis yang konsisten.

---

## Kesimpulan

Melalui modul ini, pemahaman mendalam mengenai tiga konsep fundamental telah tercapai. Struktur data Array terbukti sangat efektif untuk mengelola kumpulan data yang sejenis. Sementara itu, penerapan Method secara signifikan meningkatkan modularitas kode, menjadikannya lebih terorganisir dan mudah dikelola. Terakhir, kapabilitas manipulasi teks yang kompleks dapat diatasi melalui penggunaan String.

Secara keseluruhan, penguasaan materi ini membekali kemampuan untuk merancang alur program yang jauh lebih terstruktur dan efisien.

---

## Referensi

1. [Java Documentation: Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
2. [Java Documentation: Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
3. [Java Documentation: The String Class](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
   """