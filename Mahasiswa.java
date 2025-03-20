public class Mahasiswa {

    // Atribut
    String nama;
    String nim;
    String jurusan;
    double ipk;
    boolean isLulus =  false;
    static int angkatan = 2020;

    Mahasiswa() {
        this("no name", "00000", "no jurusan", 0.0);
    }

    Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    void tampilkanInfo() {
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("IPK : " + ipk);
        System.out.println("Angkatan : " + angkatan);
    }
    boolean cekLulus() {
        return ipk >= 3.0;
    }

    void belajar() {
        System.out.println(nama + " sedang belajar di class");
    }

    void belajar(String teman) {
        System.out.println(nama + " Sedang belajar bersama " + " teman");
    }

    static void kuliah() {
        System.out.println("Mahasiswa sedang kuliah");
    }
}