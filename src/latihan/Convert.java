package latihan;

import java.util.Scanner;

public class Convert {

    private static String[] huruf = {"", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam",
        "Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas"};

    public static String ubah(int a) {
        if (a < 0) {
            return "Angka harus positif..";
        }
        if (a < 12) {
            return huruf[a];
        }
        if (a > 11 && a < 20) {
            return huruf[a % 10] + " Belas";
        }
        if (a >= 20 && a <= 99) {
            return ubah(a / 10) + " Puluh " + ubah(a % 10);
        }
        if (a >= 100 && a < 200) {
            return "Seratus " + ubah(a % 100);
        }
        if (a >= 200 && a <= 999) {
            return ubah(a / 100) + " Ratus " + ubah(a % 100);
        }
        if (a == 1000) {
            return "Seribu";
        }
        return "Range 1 - 1000 only";
    }

    public static String ubah(String a) {
        String pisah[] = a.split(" ");
        if (pisah[0].equalsIgnoreCase("seratus") && pisah.length == 1) {
            return "100";
        } else if (pisah[1].equalsIgnoreCase("ratus") && pisah.length == 2) {
            for (int i = 0; i < huruf.length; i++) {
                if (huruf[i].equalsIgnoreCase(pisah[0])) {
                    return String.valueOf(i) + "00";
                }
            }
        } else {
            for (int i = 0; i <= 1000; i++) {
                if (a.equalsIgnoreCase(ubah(i))) {
                    return Integer.toString(i);                
                } else if (a.equalsIgnoreCase("nol")) {
                    return Integer.toString(0);
                }
            }
        }
        return "Inputan salah..";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Menu : ");
        System.out.println("1. Konversi Angka ke Huruf");
        System.out.println("2. Konversi Huruf ke Angka");
        System.out.print("Masukkan pilihan : ");
        int pilih = in.nextInt();
        if (pilih == 1) {
            int angka = in.nextInt();
            System.out.println(ubah(angka));
        } else if (pilih == 2) {
            in.nextLine();
            String huruf = in.nextLine();
            System.out.println(ubah(huruf));
        } else {
            System.out.println("Input salah...");
        }
    }
}
