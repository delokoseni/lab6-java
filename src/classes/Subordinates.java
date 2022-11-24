package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
public class Subordinates implements Cloneable{
    /** Кол-во подчиненных **/
    private int amount;
    /** Average seniority of subordinates - средний стаж подчиненных **/
    private float asos;

    /** Конструктор класса со всеми параметрами **/
    public Subordinates(int amount, float asos){
        if(amount >= 0)
            this.amount = amount;
        else {
            System.out.println("Указано недопустимое значение amount.");
            this.amount = 0;
        }
        if(asos >= 0)
            this.asos = asos;
        else {
            System.out.println("Указано недопустимое значение asos.");
            this.asos = 0;
        }
    }

    /** Конструктор класса с одним параметром **/
    public Subordinates(int allfields){
        if(allfields >= 0) {
            amount = allfields;
            asos = allfields;
        }
        else {
            System.out.println("Указано недопустимое значение allfields.");
            amount = 0;
            asos = 0;
        }
    }

    /** Конструктор класса без параметров **/
    public Subordinates(){
        amount = 0;
        asos = 0;
    }

    /** Метод подсчета среднего стажа **/
    public float averageseniority(int number){
        Scanner inp = new Scanner(System.in);
        float avesen = 0;
        int[] arr = new int[2*number];
        System.out.println("Вводите сначала целое число лет стажа, затем месяцы!" + "\n");
        for (int i = 0; i < 2 * number; i++) {
            arr[i] = inp.nextInt();
        }
        for (int i = 0; i < 2 * number; i+=2) {
            avesen += arr[i];
            avesen += (float)arr[i+1] / 12;
        }
        avesen = avesen / number;
        return avesen;
    }

    /** Метод установки значений **/
    public void set(Subordinates s){
        this.amount = s.amount;
        this.asos = s.asos;
    }

    /** Метод ввода **/
    public void input(){
        Scanner inp = new Scanner(System.in);
        int YesNo, amount;
        float asos;
        System.out.println("Введите количество подчиненных сотрудника: ");
        amount = inp.nextInt();
        if (amount > 0) {
            System.out.println("Вы знаете средний стаж подчиненных? 1 - да, 0 - нет");
            YesNo = inp.nextInt();
            if(YesNo == 1){
                System.out.println("Введите средний стаж подчиненных сотрудника: ");
                asos = inp.nextFloat();
            }
            else{
                asos = this.averageseniority(this.amount);
            }
        }
        else
            asos = 0;
        Subordinates s = new Subordinates(amount, asos);
        this.set(s);
    }

    /** Метод вывода **/
    public void output(){
        System.out.println("Кол-во подчиненных: " + amount);
        System.out.println("Средний стаж подчиненных: " + asos);
    }

    /** Метод возвращающий количество полчиненных **/
    public int getamount(){
        return amount;
    }

    /** Метод записи в файл **/
    public void tofile(File file){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(amount + "\n");
            pw.write(asos + "\n");
            pw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /** Метод записи из файла **/
    public void getfromfile(File file, Scanner sc){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            amount = Integer.parseInt(sc.nextLine());
            asos = Float.parseFloat(sc.nextLine());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}