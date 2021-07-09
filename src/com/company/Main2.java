package com.company;

import java.util.Scanner;

public class Main2 {
     public static void Main1(){
         Scanner scanner=new Scanner(System.in);
         QLNV qlnv=new QLNV();

         while (true){
             System.out.println("Quản Lí Nhân Viên");
             System.out.println("1.Thêm Nhân Viên");
             System.out.println("2.Tìm kiếm Nhân Viên");
             System.out.println("3.Kiểm tra trạng thái Nhân Viên");
             System.out.println("4.Sửa thông tin nhân viên");
             System.out.println("5.Thay đổi trạng thái nhân viên");
             System.out.println("6.Thông tin tài khoản");
             System.out.println("7.Đăng xuất");

             int choise=Integer.parseInt(scanner.nextLine());
             switch (choise){
                 case 1:
                     try {
                         System.out.println("Nhập vào lựa chọn");
                         System.out.println("1.Thêm nhân viên FullTime");
                         System.out.println("2.Thêm nhân viên PartTime");
                         int choise1=Integer.parseInt(scanner.nextLine());
                         QLNV.addNhanVien(choise1);
                     }catch (Exception e){
                         e.printStackTrace();
                     }
                 case 2:
                     try {
                         QLNV.findByName();
                     }catch (Exception e){
                         e.printStackTrace();
                     }
                 case 3:
                     try {
                         QLNV.checkStatusNhanVien();
                     }catch (Exception e){
                         e.printStackTrace();
                     }
                 case 4:
                     try {
                         QLNV.editNhanVien();
                     }catch (Exception e){
                         e.printStackTrace();
                     }
                 case 5:try {
                     QLNV.changeStatus();
                 }catch (Exception e){
                     e.printStackTrace();
                 }
                 case 6:try {
                     QLNV.show();
                 }catch (Exception e){
                     e.printStackTrace();
                 }
                 case 7:
                     System.exit(0);
             }
         }
     }
}
