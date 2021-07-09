package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

public class QLTK {
    static Scanner scanner=new Scanner(System.in);

    static File file=new File("Account.txt");
    static ArrayList<Account>list=docFile();


    public static void ghiFile(File file)throws IOException{
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter=new FileWriter(file,false);
            bufferedWriter= new BufferedWriter(fileWriter);

            for (Account a: list) {
                bufferedWriter.write(a.ghi1());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            bufferedWriter.close();
        }
    }

    public static ArrayList<Account>docFile(){
        ArrayList<Account>list2=new ArrayList<>();
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                String[] str=line.split(",");
                if(str.length>=2){
                    list2.add(new Account(str[0],str[1]));
                }
            }bufferedReader.close();
            }catch (IOException e){
            e.printStackTrace();
        }
        return list2;
        }

        public static boolean signIn(){
            System.out.println("Nhập tài khoản");
            String acc=scanner.nextLine();
            System.out.println("Nhập mật khẩu");
            String pass=scanner.nextLine();
            for (Account a :list) {
                if(a.getAcc().equals(acc)&&a.getPass().equals(pass)){
                    return true;
                }
            }return false;
        }

        public static void addAcount()throws Exception{

                String account = getAccount();
                System.out.println("Nhập mật khẩu ");
                String pass = scanner.nextLine();
                list.add(new Account(account, pass));
                ghiFile(file);
            }


          public static String getAccount() {
                while (true) {
                    try {
                        System.out.println("Nhập tên tài khoản: ");
                        String acc = scanner.nextLine();
                        for (Account nv : list) {
                            if (nv.getAcc().equals(acc))
                                throw new InterruptedException();
                        }
                        return acc;
                    } catch (InterruptedException e) {
                        System.out.println("Đã tồn tại ");
                    }
                }
            }


        public static void removeAcc(){
            System.out.println("Nhập tài khoản bạn muốn xóa:");
            String acc=scanner.nextLine();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getAcc().equals(acc)){
                    list.remove(i);
                    i--;
                }
            }
        }
    }



