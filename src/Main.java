import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Мелкое копирование **/
        Jobtitle jt = new Jobtitle(10);
        try {
            Jobtitle jt1 = (Jobtitle) jt.clone();
            jt.output();
            jt.input();
            jt.output();
            jt1.output();
        }
        catch(CloneNotSupportedException e){
            System.out.println(e);
        }
        /** Глубокое копирование **/
        Jobtitle jt2 = new Jobtitle(10);
        try {
            Jobtitle jt3 = (Jobtitle) jt2.deepclone();
            jt2.output();
            jt2.input();
            jt2.output();
            jt3.output();
        }
        catch(CloneNotSupportedException e1){
            System.out.println(e1);
        }
    }
}