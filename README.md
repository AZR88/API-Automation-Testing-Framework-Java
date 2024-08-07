# API-Automation-Testing-Framework-Java

## Tujuan
Repository ini dibuat untuk mengembangkan framework otomatisasi pengujian API dengan tujuan utama menguji API dari [Regres.in](https://reqres.in/). Framework ini dirancang untuk mempermudah dan mempercepat proses pengujian API dengan pendekatan yang terstruktur dan mudah diadaptasi.

## Teknologi
- **Bahasa Pemrograman:** Java
- **Framework Pengujian:** TestNG
- **Dependency Management:** Maven

## Fitur Utama
- **Otomatisasi Pengujian API:** Framework ini menyediakan serangkaian skrip dan struktur untuk melakukan pengujian otomatis pada endpoint API. Setiap endpoint dapat diuji untuk memastikan bahwa API berfungsi sebagaimana mestinya.
- **Kemudahan Pengaturan Variabel:** Framework ini memungkinkan perubahan variabel pengujian dengan mudah melalui file konfigurasi, sehingga pengujian dapat disesuaikan tanpa perlu mengubah kode sumber.
- **Laporan Pengujian Terintegrasi:** Dengan menggunakan TestNG, hasil pengujian secara otomatis dihasilkan dalam format yang mudah dibaca, termasuk laporan HTML yang memberikan rincian setiap pengujian yang dilakukan.
- **Skalabilitas dan Ekstensibilitas:** Struktur framework ini memungkinkan pengembang untuk dengan mudah menambah dan mengubah kasus uji serta endpoint yang akan diuji.

## Struktur Proyek
- **src/main/java:** Berisi kode sumber utama untuk framework.
- **src/test/java:** Berisi skrip pengujian yang ditulis dalam TestNG.
- **Test.xml:** File konfigurasi TestNG yang digunakan untuk menjalankan suite pengujian.
- **pom.xml:** File Maven untuk mengelola dependensi proyek.

## Cara Menggunakan

1. **Clone Repository:**
   ```bash
   git clone https://github.com/username/API-Automation-Testing-Framework-Java.git
   cd API-Automation-Testing-Framework-Java
2. **Mengatur Dependensi**
Pastikan Anda memiliki Maven terinstal di sistem Anda, lalu jalankan perintah berikut untuk mengunduh semua dependensi yang diperlukan:
   ```bash
   mvn clean install

3. **Menjalankan Pengujian:**
Untuk menjalankan pengujian, cukup jalankan file Test.xml dengan TestNG melalui command line atau IDE yang mendukung TestNG.
   ```bash
   mvn test -DsuiteXmlFile=Test.xml
Atau Anda bisa melakukannya melalui IDE:

IntelliJ IDEA: Klik kanan pada file Test.xml dan pilih "Run 'Test.xml'".
Eclipse: Klik kanan pada file Test.xml, pilih "Run As" dan kemudian "TestNG Suite".

## Konfigurasi
Mengubah Variabel Pengujian:
Anda dapat mengubah variabel pengujian dengan mengedit file konfigurasi di direktori 
