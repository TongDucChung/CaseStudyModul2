package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QLNV {
   static File file = new File("QLNV.txt");
    static ArrayList<NhanVien> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addNhanVien (int choise1) {
        NhanVien nhanVien;
        if (choise1 == 1)
            nhanVien = taoNhanVienFullTime();
        else
            nhanVien = taoNhanVienPartTime();

        list.add(nhanVien);
    }


    private static NhanVienPartTime taoNhanVienPartTime () {
        System.out.println("Nhap ten nhan vien Part Time");
        String name = scanner.nextLine();
        boolean status = getstatus();
        int luong = getluong();
        System.out.println("Nhập id");
        String id = scanner.nextLine();
        System.out.println("Nhập vào số giờ");
        int soGio = Integer.parseInt(scanner.nextLine());

        NhanVienPartTime nhanVienPartTime = new NhanVienPartTime(name, id, status, luong, soGio);
        return nhanVienPartTime;
    }

    private static NhanVienFullTime taoNhanVienFullTime () {
        System.out.println("Nhap ten nhan vien Full Time");
        String name = scanner.nextLine();
        boolean status = getstatus();
        int luong = getluong();
        System.out.println("Nhập id");
        String id = scanner.nextLine();
        NhanVienFullTime nhanVienFullTime = new NhanVienFullTime(name, id, status, luong);
        return nhanVienFullTime;
    }

    public static void findByName () {
        System.out.println(" Nhập vào tên cần tìm");
        String name1 = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name1)) {
                index = i;
                System.out.println(list.get(i));
            }
        }
        if (index == -1) {
            System.out.println(" Không có nhân viên này ");
        }
    }

    public static void checkStatusNhanVien () {
        System.out.println("Nhập vào tên nhân viên muốn check");
        String name = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                index = i;
                System.out.println(list.get(i).isStatus());
            }
        }
        if (index == -1) {
            System.out.println(" Không có nhân viên này ");
        }

    }

    public static void editNhanVien () {
        System.out.println("Nhập vào id nhân viên cần chỉnh sửa");
        String id = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                index = i;
                if (list.get(i) instanceof NhanVienPartTime) {
                    list.set(i, taoNhanVienPartTime());
                } else {
                    list.set(i, taoNhanVienFullTime());
                }
            }


        }
        if (index == -1) {
            System.out.println("Không có nhân viên này ");
        }
    }


    public static void show () {
        for (NhanVien c : list) {
            System.out.println(c);
        }
    }

    public static boolean getstatus () {
        while (true) {
            try {
                System.out.println("Nhập trạng thái ");
                System.out.println("1.Đang làm việc ");
                System.out.println("2.Đang nghỉ ");
                System.out.print("Nhập lựa chọn của bạn : ");
                int x = Integer.parseInt(scanner.nextLine());
                if (x == 1) {
                    return true;
                } else if (x == 2) {
                    return false;
                } else throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("Sai định dạng !!!");
            }
        }
    }

    public static int getluong () {
        while (true) {
            try {
                System.out.print("Nhập lương của nhân viên : ");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Sai định dạng");
            }
        }
    }

    public static void changeStatus () {
        System.out.println("Nhập vào Id");
        String id = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                if (getstatus() == true) {
                    list.get(i).setStatus(false);
                    System.out.println("Nhân viên có id " + id + "đang nghỉ.");
                } else {
                    list.get(i).setStatus(true);
                    System.out.println("Nhân viên có id " + id + "đang làm");
                }
            }
        }
    }

    public static ArrayList<NhanVien> docFile () {
        ArrayList<NhanVien> list2 = new ArrayList<>();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length >= 4) {
                    list2.add(new NhanVien(str[0],str[1],Boolean.parseBoolean(scanner.nextLine()),Integer.parseInt(scanner.nextLine())));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list2;
    }

    public static void ghiFile (File file) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (NhanVien a : list) {
                bufferedWriter.write(a.ghi());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
    }

}

