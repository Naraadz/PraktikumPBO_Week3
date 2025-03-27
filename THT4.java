class Produk {
    private String kodeProduk;
    private String namaProduk;
    private double harga;
    private int stok;

    public Produk(String kodeProduk, String namaProduk, double harga, int stok) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanInfoProduk() {
        System.out.println("Kode Produk: " + kodeProduk);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }

    public boolean kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
            return true;
        }
        System.out.println("Stok kurang!");
        return false;
    }

    public double getPrice() {
        return harga;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }
}

class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String email;
    private double saldo;

    public Pelanggan(String idPelanggan, String nama, String email, double saldo) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.saldo = saldo;
    }

    public void tampilkanInfoPelanggan() {
        System.out.println("ID Pelanggan: " + idPelanggan);
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("Saldo: " + saldo);
    }

    public boolean kurangiSaldo(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        System.out.println("Saldo kurang!");
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }
}

class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Produk produk;
    private int jumlahBeli;
    private double totalHarga;

    public Transaksi(String idTransaksi, Pelanggan pelanggan, Produk produk, int jumlahBeli) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlahBeli = jumlahBeli;
        this.totalHarga = jumlahBeli * produk.getPrice();
    }

    public void prosesTransaksi() {
        if (pelanggan.getSaldo() >= totalHarga && produk.kurangiStok(jumlahBeli)) {
            if (pelanggan.kurangiSaldo(totalHarga)) {
                System.out.println("Transaksi berhasil!");
            }
        } else {
            System.out.println("Transaksi gagal! Cek saldo atau stok.");
        }
    }

    public void tampilkanDetailTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        pelanggan.tampilkanInfoPelanggan();
        produk.tampilkanInfoProduk();
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total Harga: " + totalHarga);
    }
}

class ManajemenToko {
    private Produk[] daftarProduk = new Produk[10]; 
    private Pelanggan[] daftarPelanggan = new Pelanggan[5]; 
    private Transaksi[] daftarTransaksi = new Transaksi[10]; 
    private int produkCount = 0;
    private int pelangganCount = 0;
    private int transaksiCount = 0;

    public void tambahProduk(Produk produk) {
        if (produkCount < daftarProduk.length) {
            daftarProduk[produkCount++] = produk;
            System.out.println("Produk berhasil ditambahkan!");
        } else {
            System.out.println("Penyimpanan produk penuh!");
        }
    }

    public void tampilkanProduk() {
        for (int i = 0; i < produkCount; i++) {
            daftarProduk[i].tampilkanInfoProduk();
            System.out.println("--------------------");
        }
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        if (pelangganCount < daftarPelanggan.length) {
            daftarPelanggan[pelangganCount++] = pelanggan;
            System.out.println("Pelanggan berhasil ditambahkan!");
        } else {
            System.out.println("Penyimpanan pelanggan penuh!");
        }
    }

    public void tampilkanPelanggan() {
        for (int i = 0; i < pelangganCount; i++) {
            daftarPelanggan[i].tampilkanInfoPelanggan();
            System.out.println("--------------------");
        }
    }

    public void tambahTransaksi(Transaksi transaksi) {
        if (transaksiCount < daftarTransaksi.length) {
            transaksi.prosesTransaksi();
            daftarTransaksi[transaksiCount++] = transaksi;
            System.out.println("Transaksi berhasil ditambahkan!");
        } else {
            System.out.println("Penyimpanan transaksi penuh!");
        }
    }

    public void tampilkanTransaksi() {
        for (int i = 0; i < transaksiCount; i++) {
            daftarTransaksi[i].tampilkanDetailTransaksi();
            System.out.println("--------------------");
        }
    }
}

public class THT4 {
    public static void main(String[] args) {
        ManajemenToko toko = new ManajemenToko();

        Produk produk1 = new Produk("101", "blush", 200000, 10);
        Produk produk2 = new Produk("102", "cushion", 105000, 20);
        toko.tambahProduk(produk1);
        toko.tambahProduk(produk2);

        Pelanggan pelanggan1 = new Pelanggan("101", "Aeri", "uchiaeri@gmail.com", 700000);
        Pelanggan pelanggan2 = new Pelanggan("102", "Trivia", "trva@gmail.com", 1000000);
        toko.tambahPelanggan(pelanggan1);
        toko.tambahPelanggan(pelanggan2);

        System.out.println("===== Daftar Produk =====");
        toko.tampilkanProduk();

        System.out.println("===== Daftar Pelanggan =====");
        toko.tampilkanPelanggan();

        Transaksi transaksi1 = new Transaksi("101", pelanggan1, produk1, 2);
        toko.tambahTransaksi(transaksi1);

        Transaksi transaksi2 = new Transaksi("102", pelanggan2, produk2, 1);
        toko.tambahTransaksi(transaksi2);

        System.out.println("===== Daftar Transaksi =====");
        toko.tampilkanTransaksi();
    }
}
