package com.zhanglei.class7;

class Soap{
    private String s;
    Soap(){
        System.out.println("Soap()");
        s = "Constructed";
    }
}

public class Bath {
    private String
        s1 = "Happy",
        s2 = "Happy",
        s3,s4;
    private Soap castille;
    private int i;
    private float toy;

    public Bath(){
        System.out.println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    { i = 47;}

    @Override
    public String toString() {

        if(s4 == null){
            s4 = "Joy";
        }
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castille=" + castille +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }

}
