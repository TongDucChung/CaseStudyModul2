package com.company;

public class NhanVien {
    private String name;
    private String id;
    private boolean status;
    private int luong;

    public NhanVien (String name,String id, boolean status, int luong) {
        this.name = name;
        this.status = status;
        this.luong = luong;
        this.id=id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public boolean isStatus () {
        return status;
    }

    public void setStatus (boolean status) {
        this.status = status;
    }

    public int getLuong () {
        return luong;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public void setLuong (int luong) {
        this.luong = luong;
    }

    @Override
    public String toString () {
        return
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", status=" + status +
                ", luong=" + luong +
                '}';
    }
    public String ghi(){
        return name + ","
                + id + "," +
               status +","+
                 luong ;
    }
}
