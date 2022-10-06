//Created by Campus
package tinh_thu_nhap_cho_nhan_vien;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import java.text.*;
//
class Salary implements Comparable<Salary>{
    static int id = 0;
    private String code = "NV", name, position;
    private long allowance, salary, advance, remain, salaryOfDay, day;
    public Salary(String name, String position, long salaryOfDay, long day){
        id += 1;
        this.code += String.format("%02d", id);
        this.name = name;
        this.position = position;
        this.salaryOfDay = salaryOfDay;
        this.day = day;
        this.salary = this.salaryOfDay * this.day;
        this.allowance = this.getAllowance();
        this.advance = this.getAdvance();
        this.remain = this.salary + this.allowance - this.advance;
    }
    //
    private long getAllowance(){
        if(this.position.compareTo("GD") == 0) return 500;
        else if(this.position.compareTo("PGD") == 0) return 400;
        else if(this.position.compareTo("TP") == 0) return 300;
        else if(this.position.compareTo("KT") == 0) return 250;
        else return 100;
    }
    //
    private long getAdvance(){
        long solve = this.salary + this.allowance;
        if(solve * 2 / 3 < 25000) {
            //return (long) Math.ceil((double)((Math.round((double) (solve * 2) / 3))) / 1000) * 1000;
            return (long) Math.round((double)Math.round((double)(solve * 2) / 3) / 1000) * 1000;
        }
        else return 25000;
    }
    //
    @Override
    public int compareTo(Salary x){
        return this.code.compareTo(x.code);
    }
    //
    @Override
    public String toString(){
        return this.code + " " + this.name + " " + this.allowance + " " + this.salary + " " + this.advance + " " + this.remain;
    }
    //
}
//
public class Tinh_Thu_Nhap_Cho_Nhan_Vien {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Salary> solve = new ArrayList<>();
        while(t-- > 0){
            solve.add(new Salary(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine())));
        }
        Collections.sort(solve);
        for(Salary x: solve){
            System.out.println(x);
        }
    }
    
}
