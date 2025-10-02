# Laporan Modul 2: Dasar Pemrograman Java

**Mata Kuliah:** Praktikum Pemrograman Berorientasi Objek   
**Nama:** Muhammad Alif Arrayyan  
**NIM:** 2024573010085  
**Kelas:** Teknik Informatika - 2E

---

## 1. Abstrak
Laporan ini membahas konsep-konsep dasar dalam bahasa pemrograman Java yang mencakup variabel, tipe data, operator, struktur kontrol keputusan (if-else, switch-case), dan struktur kontrol perulangan (for, while, do-while). Tujuan dari laporan ini adalah untuk mendokumentasikan pemahaman dan hasil dari praktikum dasar-dasar Java sebagai fondasi untuk mempelajari pemrograman berorientasi objek lebih lanjut.

---
## 2. Praktikum
### Praktikum 1 - Variabel dan Tipe Data
#### Dasar Teori
Variabel adalah sebuah nama yang digunakan sebagai wadah atau lokasi di dalam memori komputer untuk menyimpan sebuah nilai. Nilai yang disimpan ini dapat diubah selama program berjalan. Agar komputer tahu jenis nilai apa yang boleh disimpan, setiap variabel harus memiliki tipe data. Tipe data mendefinisikan jenis dan ukuran data, seperti int untuk bilangan bulat, double untuk bilangan desimal, char untuk satu karakter, dan String untuk kumpulan karakter atau teks. Deklarasi variabel dengan tipe data yang tepat sangat penting untuk memastikan operasi yang dilakukan pada data tersebut valid dan efisien.
#### Langkah Praktikum
1. Pertama-tama, di dalam package modul_2 tersebut, buatlah sebuah class Java baru dan simpan dengan nama VariabelDemo.java.
2. Setelah file berhasil dibuat, isikan dengan potongan kode yang telah disiapkan untuk mempraktikkan cara deklarasi variabel dan penerapan tipe data.
#### Screenshoot Hasil
**Program-VariabelDemo.Java**   
![Program-VariabelDemo](./gambar/vd.png)    
**Output-VariabelDemo.Java**    
![Gambar_VariabelDemo](./gambar/VariabelDemo.png)   
#### Analisa dan Pembahasan
Pada praktikum ini, program berhasil mendemonstrasikan konsep paling fundamental dalam Java, yaitu deklarasi dan inisialisasi variabel dengan tipe data yang sesuai. Penggunaan tipe data yang berbeda seperti String untuk teks, int untuk bilangan bulat, dan double untuk desimal menunjukkan sifat statically typed pada Java, di mana setiap variabel harus memiliki tipe yang jelas. Operasi aritmatika yang dilakukan juga berjalan sesuai dengan aturan matematika dasar. Praktikum ini menegaskan bahwa pemahaman variabel dan tipe data adalah langkah awal yang krusial karena menjadi dasar untuk menyimpan, mengelola, dan memanipulasi semua data di dalam program.

### Praktikum 2 - Input, Output dan Scanner
#### Dasar Teori
Dalam pemrograman, Input adalah proses menerima data dari luar program, misalnya dari ketikan pengguna di keyboard. Sebaliknya, Output adalah proses mengirimkan data atau informasi dari dalam program ke luar, seperti menampilkannya di layar. Di Java, salah satu cara paling umum untuk menangani input dari pengguna adalah dengan menggunakan kelas Scanner. Kelas Scanner menyediakan fungsi-fungsi untuk membaca berbagai jenis data (seperti teks, angka, dll.) dari sumber input, sehingga program dapat berinteraksi dengan pengguna secara dinamis.
#### Langkah Praktikum
1. Awali praktikum ini dengan membuat sebuah file Java baru di dalam package modul_2 Anda, lalu berikan nama InputOutputDemo.java.
2. Di dalam file tersebut, implementasikan kode program yang memanfaatkan class Scanner untuk menangkap data yang diketik oleh pengguna melalui konsol.
#### Screenshoot Hasil
**Program-InputOutputDemo.Java**    
![Program-InputOutputDemo](./gambar/iod.png)    
**Output-InputOutputDemo.Java**     
![Gambar_InputOutputDemo](./gambar/InputOutputDemo.png)     
#### Analisa dan Pembahasan
Program berhasil menunjukkan kemampuan interaksi dasar dengan pengguna melalui console. Penggunaan kelas Scanner terbukti efektif untuk menangkap berbagai jenis input (String, int, double) dari keyboard. Analisanya adalah program ini berhasil menjembatani antara pengguna dan mesin, di mana data tidak lagi bersifat statis (ditulis langsung di kode), melainkan dinamis sesuai masukan pengguna. Pembahasan pentingnya adalah keharusan untuk mengimpor pustaka java.util.Scanner sebelum digunakan dan pentingnya menggunakan metode yang tepat (nextLine(), nextInt(), dll.) untuk menghindari error saat parsing data. Praktikum ini adalah fondasi untuk membuat aplikasi console yang interaktif.

### Praktikum 3 - Struktur Kontrol: Percabangan
#### Dasar Teori
Struktur Kontrol Percabangan adalah mekanisme dalam pemrograman yang memungkinkan alur eksekusi program untuk memilih jalur yang berbeda berdasarkan kondisi tertentu. Jika suatu kondisi bernilai benar (true), maka blok kode tertentu akan dieksekusi. Jika bernilai salah (false), blok kode tersebut akan dilewati atau blok kode alternatif yang akan dijalankan. Struktur ini adalah fondasi untuk membuat program yang dapat mengambil keputusan. Contoh paling umum dari struktur ini adalah perintah if-else dan switch-case.
#### Langkah Praktikum
1. Program Penentu Grade: Untuk studi kasus pertama, ciptakan file baru bernama GradeDemo.java. Di dalamnya, tuliskan logika program yang menggunakan struktur if-else if-else untuk mengonversi nilai menjadi sebuah predikat (misalnya, A, B, C).
2. Program Menu dengan Switch: Lanjutkan dengan membuat file bernama MenuDemo.java. Kali ini, manfaatkan switch statement untuk membangun sebuah sistem pemilihan menu yang sederhana dan efisien.
3. Program Nested If: Terakhir, buatlah file NestedIfDemo.java. Di sini, Anda akan mengimplementasikan sebuah program yang menggunakan if bersarang untuk menentukan kategori usia berdasarkan masukan dari pengguna.
#### Screenshoot Hasil
**Program-GradeDemo.Java**  
![Program-GradeDemo](./gambar/gd.png)   
**Output-GradeDemo.Java**   
![Gambar_GradeDemo](./gambar/GradeDemo.png)     
**Program-MenuDemo.Java**   
![Program-MenuDemo](./gambar/md.png)    
**Output-MenuDemo.Java**    
![Gambar_MenuDemo](./gambar/MenuDemo.png)   
**Program-NestedIfDemo.Java**   
![Program-NestedIfDemo](./gambar/nid.png)   
**Output-NestedIfDemo.Java**     
![Gambar_NestedIfDemo](./gambar/NestedIfDemo.png)   
#### Analisa dan Pembahasan
Praktikum ini berhasil mengimplementasikan logika pengambilan keputusan untuk mengontrol alur program.
- Pada GradeDemo.java, penggunaan struktur if-else if-else sangat efektif untuk menangani kondisi berupa rentang nilai, yang tidak bisa ditangani oleh switch-case.
- Pada MenuDemo.java, struktur switch-case terbukti lebih rapi dan mudah dibaca dibandingkan if-else if untuk kondisi yang memeriksa satu variabel dengan banyak kemungkinan nilai konstan.
- Pada NestedIfDemo.java, penggunaan if bersarang menunjukkan cara membangun logika yang lebih kompleks dan bertingkat, seperti validasi multi-langkah.
Pembahasannya, pemilihan antara if-else dan switch bergantung pada kasusnya. if-else lebih fleksibel untuk kondisi boolean yang kompleks, sementara switch lebih unggul untuk percabangan berdasarkan nilai tunggal yang diskrit.

### Praktikum 4 - Struktur Kontrol: Perulangan
#### Dasar Teori
Struktur Kontrol Perulangan (atau looping) digunakan untuk mengeksekusi blok kode yang sama secara berulang-ulang selama suatu kondisi masih terpenuhi. Ini sangat efisien untuk tugas-tugas yang repetitif, seperti memproses semua elemen dalam daftar atau menjalankan simulasi hingga mencapai target tertentu. Tanpa perulangan, kita harus menulis kode yang sama berkali-kali. Jenis-jenis perulangan yang umum digunakan di Java meliputi for, while, dan do-while, yang masing-masing memiliki cara tersendiri dalam mendefinisikan kondisi berhenti dan iterasinya.
#### Langkah Praktikum
1. Perulangan For: Silakan buat file baru bernama ForLoopDemo.java. Isilah file tersebut dengan berbagai contoh implementasi for loop untuk memahami strukturnya.
2. Perulangan While dan Do-While: Berikutnya, buat file bernama WhileLoopDemo.java. Tuliskan kode untuk mendemonstrasikan penggunaan while dan do-while, serta pahami perbedaan utama antara keduanya.
3. Nested Loop (Perulangan Bersarang): Sebagai penutup, buatlah sebuah file bernama NestedLoopDemo.java. Implementasikan contoh kode yang menunjukkan bagaimana perulangan bisa dijalankan di dalam perulangan lain untuk menyelesaikan masalah yang lebih kompleks.
#### Screenshoot Hasil
**Program-ForLoopDemo.Java**    
![Program-ForLoopDemo](./gambar/fld.png)    
**Output-ForLoopDemo.Java**     
![Gambar_ForLoopDemo](./gambar/ForLoopDemo.png)     
**Program-WhileLoopDemo.Java**       
![Program-WhileLoopDemo](./gambar/wld.png)      
**Output-WhileLoopDemo.Java**   
![Gambar_WhileLoopDemo](./gambar/WhileLoopDemo.png)      
**Program-NestedLoopDemo.Java**     
![Program-VariabelDemo](./gambar/nld.png)   
**Output-NestedLoopDemo.Java**   
![Gambar_NestedLoopDemo](./gambar/NestedLoopDemo.png)   
#### Analisa dan Pembahasan
Program berhasil mendemonstrasikan cara melakukan tugas berulang secara efisien.
- ForLoopDemo.java: Perulangan for terbukti sangat cocok untuk iterasi yang jumlahnya sudah diketahui secara pasti (misalnya, mengulang 10 kali), karena inisialisasi, kondisi, dan increment didefinisikan dalam satu baris yang ringkas.
- WhileLoopDemo.java: Perulangan while menunjukkan fungsinya dalam kasus di mana perulangan bergantung pada sebuah kondisi yang bisa berubah saat runtime dan jumlah iterasinya tidak pasti.
- NestedLoopDemo.java: Perulangan bersarang berhasil digunakan untuk memproses data dalam format dua dimensi, seperti membuat pola bintang. Logikanya, loop luar mengontrol baris, dan loop dalam mengontrol kolom.
Pembahasannya, ketiga jenis perulangan memiliki kegunaan spesifik. Kesalahan dalam mendefinisikan kondisi pada while dapat menyebabkan infinite loop, sedangkan perulangan bersarang menunjukkan bagaimana kompleksitas sebuah algoritma dapat meningkat secara signifikan.
---

## 3. Kesimpulan

Praktikum Modul 2 ini memberikan pemahaman yang esensial mengenai fondasi pemrograman Java. Melalui serangkaian latihan, praktikan telah berhasil memahami konsep inti mulai dari cara menyimpan data menggunakan variabel dan tipe data, hingga membuat program menjadi interaktif dengan mekanisme input dan output menggunakan class Scanner.

Lebih lanjut, praktikum ini juga melatih kemampuan logika dalam mengontrol alur eksekusi program melalui struktur percabangan (if-else, switch) untuk pengambilan keputusan, serta struktur perulangan (for, while, do-while) untuk menangani tugas-tugas repetitif secara efisien. Penguasaan konsep-konsep dasar ini merupakan pilar utama yang akan menjadi bekal untuk membangun aplikasi Java yang lebih kompleks dan fungsional di masa mendatang.



---

## 5. Referensi
Berikut adalah beberapa sumber yang relevan dengan materi praktikum:

1. W3Schools Java Tutorial — https://www.w3schools.com/java/
2. The Java™ Tutorials: Language Basics (Oracle Documentation) — https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html
---