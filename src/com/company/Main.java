package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        QLNV=new QLNV();
//        QLTK qltk=new QLTK();

        while (true){

            System.out.println("-----WELCOME------");
            System.out.println("1.Đăng Nhập");
            System.out.println("2.Bạn chưa có tài khoản? Hãy đăng kí");

            int choise=Integer.parseInt(scanner.nextLine());
           switch (choise) {
               case 1:
                   if(QLTK.signIn()==true){
                       Main2.Main1();
                   }
                   else {
                       System.out.println("Tài khoản mật khẩu không chính xác");
                   }break;
               case 2:
                   try {
                       QLTK.addAcount();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
           }
           }
        }
    }

