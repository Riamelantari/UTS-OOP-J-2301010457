/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_2301010457;

import java.util.Scanner;

/**
 *
 * @author LAB F
 */
public class Hewan {
    private String jenisHewan;
    private String jenisMakanan;
    private int umurHewan;

    public Hewan(String jenisHewan, String jenisMakanan, int umurHewan) {
        this.jenisHewan = jenisHewan;
        this.jenisMakanan = jenisMakanan;
        this.umurHewan = umurHewan;
    }

    // Getter dan Setter
    public String getJenisHewan() { return jenisHewan; }
    public void setJenisHewan(String jenisHewan) { this.jenisHewan = jenisHewan; }
    public String getJenisMakanan() { return jenisMakanan; }
    public void setJenisMakanan(String jenisMakanan) { this.jenisMakanan = jenisMakanan; }
    public int getUmurHewan() { return umurHewan; }
    public void setUmurHewan(int umurHewan) { this.umurHewan = umurHewan; }

    @Override
    public String toString() {
        return "Hewan{" +
                "jenisHewan='" + jenisHewan + '\'' +
                ", jenisMakanan='" + jenisMakanan + '\'' +
                ", umurHewan=" + umurHewan +
                '}';
    }
}

class AplikasiHewan {
    private Hewan[] daftarHewan;
    private int jumlahHewan;
    private Scanner input;

    public AplikasiHewan() {
        daftarHewan = new Hewan[100]; // Batas maksimal hewan yang bisa disimpan
        jumlahHewan = 0;
        input = new Scanner(System.in);
    }

    public void menuAplikasi() {
        int pilihan;
        do {
            System.out.println("\nMenu Aplikasi Hewan");
            System.out.println("1. Tambah Hewan");
            System.out.println("2. Tampilkan Hewan");
            System.out.println("3. Ubah Data Hewan");
            System.out.println("4. Hapus Hewan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); // Consume newline

            switch (pilihan) {
                case 1: tambahHewan(); break;
                case 2: tampilkanHewan(); break;
                case 3: ubahHewan(); break;
                case 4: hapusHewan(); break;
                case 0: System.out.println("Keluar dari aplikasi."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        input.close();
    }

    private void tambahHewan() {
        System.out.print("Jenis Hewan: ");
        String jenis = input.nextLine();
        System.out.print("Jenis Makanan: ");
        String makanan = input.nextLine();
        System.out.print("Umur Hewan: ");
        int umur = input.nextInt();
        input.nextLine(); // Consume newline

        daftarHewan[jumlahHewan] = new Hewan(jenis, makanan, umur);
        jumlahHewan++;
        System.out.println("Hewan berhasil ditambahkan.");
    }

    private void tampilkanHewan() {
        if (jumlahHewan == 0) {
            System.out.println("Belum ada data hewan.");
            return;
        }
        System.out.println("\nDaftar Hewan:");
        for (int i = 0; i < jumlahHewan; i++) {
            System.out.println((i + 1) + ". " + daftarHewan[i]);
        }
    }

    private void ubahHewan() {
        tampilkanHewan();
        System.out.print("Pilih nomor hewan yang akan diubah (1-" + jumlahHewan + "): ");
        int index = input.nextInt();
        input.nextLine(); // Consume newline

        if (index >= 1 && index <= jumlahHewan) {
            System.out.print("Jenis Hewan baru: ");
            daftarHewan[index - 1].setJenisHewan(input.nextLine());
            System.out.print("Jenis Makanan baru: ");
            daftarHewan[index - 1].setJenisMakanan(input.nextLine());
            System.out.print("Umur Hewan baru: ");
            daftarHewan[index - 1].setUmurHewan(input.nextInt());
            input.nextLine(); // Consume newline
            System.out.println("Data hewan berhasil diubah.");
        } else {
            System.out.println("Nomor hewan tidak valid.");
        }
    }

    private void hapusHewan() {
        tampilkanHewan();
        System.out.print("Pilih nomor hewan yang akan dihapus (1-" + jumlahHewan + "): ");
        int index = input.nextInt();

        if (index >= 1 && index <= jumlahHewan) {
            for (int i = index - 1; i < jumlahHewan - 1; i++) {
                daftarHewan[i] = daftarHewan[i + 1];
            }
            jumlahHewan--;
            System.out.println("Hewan berhasil dihapus.");
        } else {
            System.out.println("Nomor hewan tidak valid.");
        }
    }
}