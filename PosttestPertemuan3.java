import java.util.Scanner;

public class PosttestPertemuan3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan total belanja: ");
        if (!input.hasNextDouble()) {
            System.out.println("Error: Total belanja tidak valid! Gunakan angka.");
            input.close();
            return;
        }
        double totalBelanja = input.nextDouble();
        input.nextLine();

        if (totalBelanja < 0) {
            System.out.println("Error: Total Belanja dibawah maksimal!");
            input.close();
        
            return;
        }

        System.out.print("Masukkan kategori member: ");
        String member = input.nextLine();

        double diskon1 = 0;
        if (totalBelanja > 500000) {
            diskon1 = 0.20;
        } else if (totalBelanja >= 250000) {
            diskon1 = 0.10;
        }

        double hargaTerbaru1 = totalBelanja - (totalBelanja * diskon1);

        double diskonTambahan = 0;
        switch (member.toLowerCase()) {
            case "Platinum":
                diskonTambahan = 0.05;
                break;
            case "Gold":
                diskonTambahan = 0.03;
                break;
            case "Silver":
                diskonTambahan = 0.02;
                break;
            default:
                System.out.println("Error: Kategori member tidak valid!");
                input.close();
                return;
        }

        double hargaTerbaru2 = hargaTerbaru1 - (hargaTerbaru1 * diskonTambahan);

        String getDiskon = (diskon1 > 0) ? "Anda mendapatkan diskon! " : "Anda tidak mendapat diskon.";

        System.out.println("\n---Data transaksi ---");
        System.out.println("Total belanja awal: Rp" + totalBelanja);
        System.out.println("Diskon1: " + (diskon1 * 100) + "%");
        System.out.println("Harga setelah diskon pertama: Rp" + hargaTerbaru1);
        System.out.println("Diskon Tambahan untuk member " + member + ": "+ (diskonTambahan * 100) + "%");
        System.out.println("Total yang harus dibayar: Rp" + hargaTerbaru2);
        System.out.println(getDiskon);

        input.close();
        }
    } 

