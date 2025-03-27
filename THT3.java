import java.util.Scanner;

public class THT3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Gaji karyawan");
        System.out.print("Masukkan jumlah karyawan: ");
        int jumlahKaryawan = input.nextInt();
        input.nextLine(); 

        Karyawan[] karyawanList = new Karyawan[jumlahKaryawan];

        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.println("\nData Karyawan ke-" + (i + 1));

            System.out.print("Masukkan ID Karyawan: ");
            String id = input.nextLine();

            System.out.print("Masukkan Nama Karyawan: ");
            String nama = input.nextLine();

            int shift;
            while (true) {
                System.out.print("Masukkan Shift (1=Pagi, 2=Siang, 3=Malam): ");
                shift = input.nextInt();
                if (shift >= 1 && shift <= 3) break;
                System.out.println("Shift tidak valid! Masukkan 1, 2, atau 3.");
            }

            int jamKerja;
            while (true) {
                System.out.print("Masukkan Total Jam Kerja dalam Seminggu: ");
                jamKerja = input.nextInt();
                if (jamKerja >= 0 && jamKerja <= 60) break;
                System.out.println("Jam kerja tidak masuk akal! Masukkan antara 0-60.");
            }

            int absen;
            while (true) {
                System.out.print("Masukkan Jumlah Hari Absen: ");
                absen = input.nextInt();
                if (absen >= 0 && absen <= 7) break;
                System.out.println("Jumlah hari absen tidak masuk akal! Masukkan antara 0-7.");
            }

            input.nextLine(); 

            karyawanList[i] = new Karyawan(id, nama, shift, jamKerja, absen);
        }

        System.out.println("\n=== Laporan Gaji Karyawan ===");
        System.out.printf("| %-10s | %-15s | %-5s | %-8s | %-8s | %-12s |\n", 
                          "ID", "Nama", "Shift", "Jam", "Absen", "Total Gaji");
        System.out.println("----------------------------------------------------------------------------------");

        for (Karyawan k : karyawanList) {
            System.out.printf("| %-10s | %-15s | %-5d | %-8d | %-8d | Rp%,10.2f |\n", 
                              k.id, k.nama, k.shift, k.jamKerja, k.absen, k.hitungGaji());
        }

        System.out.println("----------------------------------------------------------------------------------");

        input.close();
    }
}

class Karyawan {
    String id;
    String nama;
    int shift;
    int jamKerja;
    int absen;

    public Karyawan(String id, String nama, int shift, int jamKerja, int absen) {
        this.id = id;
        this.nama = nama;
        this.shift = shift;
        this.jamKerja = jamKerja;
        this.absen = absen;
    }

    public double hitungGaji() {
        double tarifPerJam;
        switch (shift) {
            case 1: 
                tarifPerJam = 25000; 
                break; 
            case 2: 
                tarifPerJam = 27000; 
                break; 
            case 3: 
                tarifPerJam = 30000; 
                break; 

            default: 
                return 0; 
        }

        double gaji = jamKerja * tarifPerJam;

        if (jamKerja > 40) {
            int jamLembur = jamKerja - 40;
            gaji += jamLembur * (tarifPerJam * 1.5);
        }

        gaji = (jamKerja < 30) ? gaji * 0.9 : gaji;

        gaji -= absen * 100000;

        return Math.max(gaji, 0);
    }
}