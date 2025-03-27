import java.util.Scanner;

public class LatihanPertemuan3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan kalimat");
        String kalimat = input.nextLine();

        int jumlahVokal = 0;
        String vokal = "a, i, u, e, o";

        for (char c : kalimat.toCharArray()) {
            if (vokal.indexOf(c) != -1) {
                jumlahVokal++;
            }
        }

        if (jumlahVokal % 2 == 0) {
            System.out.println("jumlah vokal genap");
        } else {
            System.out.println("jumlah vokal ganjil");
        }

        System.out.println("String terbalik: ");
        for (int i = kalimat.length() -1; i >= 0; i--) {
            System.out.println(kalimat.charAt(i));
        }

        input.close();

    }
}
