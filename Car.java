public class Car {
    private String nomorPlat;
    private String brand;
    private double hargaSewaPerHari;
    private boolean tersedia;

    public Car() {
    this.nomorPlat = "UNKNOWN";
    this.brand = "UNKNOWN";
    this.hargaSewaPerHari = 0;
    this.tersedia = true;
}


    public Car(String nomorPlat, String brand, double hargaSewaPerHari) {
        this.nomorPlat = nomorPlat;
        this.brand = brand;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.tersedia = true;
    }

    public String getNomorPlat() { 
        return nomorPlat; 
    }
    public String getBrand() { 
        return brand; 
    }
    public double getHargaSewaPerHari() { 
        return hargaSewaPerHari; 
    }
    public boolean isTersedia() { 
        return tersedia; 
    }
    
    public void setTersedia(boolean status) {
        this.tersedia = status;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Plat: " + nomorPlat);
        System.out.println("Brand: " + brand);
        System.out.println("Harga Sewa per Hari: " + hargaSewaPerHari);
        System.out.println("Status: " + (tersedia ? "Tersedia" : "Tidak Tersedia"));
        System.out.println("--------------------------");
    }

}

class Pembeli {
    private String nama;
    private String nomorKTP;
    private String nomorHP;

    public Pembeli(String nama, String nomorKTP, String nomorHP) {
        this.nama = nama;
        this.nomorKTP = nomorKTP;
        this.nomorHP = nomorHP;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Nomor KTP: " + nomorKTP);
        System.out.println("Nomor HP: " + nomorHP);
    }
}

class Utility {
    public static double hitungDiskon(int lamaSewa, double totalBiaya) {
        if (lamaSewa > 5) {
            return totalBiaya * 0.10; 
        }
        return 0;
    }

    public static String formatRupiah(double jumlah) {
        return String.format("Rp%,.2f", jumlah);
    }
}

class Sewa {
    private Pembeli pembeli;
    private Car car;
    private int lamaSewa;
    private double totalBiaya;
    private boolean berhasil;

    public Sewa(Pembeli pembeli, Car car, int lamaSewa) {
        if (car.isTersedia()) {
            this.pembeli = pembeli;
            this.car = car;
            this.lamaSewa = lamaSewa;
            this.totalBiaya = lamaSewa * car.getHargaSewaPerHari();

            double diskon = Utility.hitungDiskon(lamaSewa, totalBiaya);
            this.totalBiaya -= diskon;
            this.berhasil = true;

            car.setTersedia(false);
        } else {
            this.berhasil = false;
        }
    }

    public void tampilkanStruk() {
        if (berhasil) {
            System.out.println("\n===== Struk Penyewaan =====");
            pembeli.tampilkanInfo();
            System.out.println("\nMobil yang Disewa:");
            car.tampilkanInfo();
            System.out.println("Lama Sewa: " + lamaSewa + " hari");
            System.out.println("Total Biaya: " + Utility.formatRupiah(totalBiaya));
            System.out.println("============================\n");
        } else {
            System.out.println("\nTransaksi gagal! Mobil tidak tersedia.\n");
        }
    }
}