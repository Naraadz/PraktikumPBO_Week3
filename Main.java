public class Main {
    public static void main(String[] args) {

    Mahasiswa mhs1 = new Mahasiswa();
        mhs1.nama = "Rey";
        mhs1.nim = "12345";
        mhs1.jurusan = "Teknik Kimia";
        mhs1.ipk = 3.0;
        mhs1.belajar();

        Mahasiswa.kuliah();
        System.out.println("Angkatan: " + Mahasiswa.angkatan);

        System.out.println(mhs1.nama);
        System.out.println(mhs1.nim);
        System.out.println(mhs1.jurusan);

        mhs1.nama = "Budi";
        System.out.println(mhs1.nama);

        mhs1.belajar();
        mhs1.belajar("Rin");
       
        System.out.println("\n=== Informasi Mahasiswa 1 ===");
        mhs1.tampilkanInfo();
        System.out.println("Lulus: " + mhs1.cekLulus());

        Mahasiswa mhs2 = new Mahasiswa();
        mhs2.nama = "Len";
        mhs2.nim = "65432";
        mhs2.jurusan = "Teknik Mesin";
        mhs2.ipk = 2.7;
        mhs2.belajar(); 

        System.out.println("\n=== Informasi Mahasiswa 2 ===");
        mhs2.tampilkanInfo();
        System.out.println("Lulus: " + mhs2.cekLulus());
    } 
}

