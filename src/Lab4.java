import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lab4 {
    static List<MyDate> dateList=new ArrayList<>();
    static List<String> stringList =new ArrayList<>();
    final static List<String> monthList;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        List<String> array=new ArrayList<String>();
        array.add("январь");
        array.add("февраль");
        array.add("март");
        array.add("апрель");
        array.add("май");
        array.add("июнь");
        array.add("июль");
        array.add("август");
        array.add("сентябрь");
        array.add("октябрь");
        array.add("ноябрь");
        array.add("декабрь");
        monthList=array;
    }


    public static class MyDate{
        int dayMyDate, yearMyDate;
        String monthMyDate;

        public void setDayMyDate(int day){
            this.dayMyDate=day;
        }

        public int getDayMyDate(){
            return dayMyDate;
        }

        public int getYearMyDate() {
            return yearMyDate;
        }

        public void setYearMyDate(int yearMyDate) {
            this.yearMyDate = yearMyDate;
        }

        public String getMonthMyDate() {
            return monthMyDate;
        }

        public void setMonthMyDate(String monthMyDate) {
            this.monthMyDate = monthMyDate;
        }

        public String getMonthMyDateBy(){

                if(getMonthMyDate().equals("май")) return getMonthMyDate().replace("й","я");
                if(getMonthMyDate().equals("август")||getMonthMyDate().equals("март")) return getMonthMyDate()+"а";

            return getMonthMyDate().replace("ь","я");
        }

        @Override
        public String toString() {
            return getDayMyDate()+" "+getMonthMyDateBy()+" "+getYearMyDate()+" года";
        }
    }

    public static void printMyDateList(){
        for(MyDate s: dateList){
            System.out.println(s.toString());
        }
    }

    public static void printStringList(){
        for(String s: stringList){
            System.out.println(s);
        }
    }

    public static void printWinterDates(){
        for(MyDate s:dateList){
            if(s.getMonthMyDate().equals("январь")||s.getMonthMyDate().equals("февраль")||s.getMonthMyDate().equals("декабрь")) System.out.println(s.toString());
        }
    }

    public static void addMyDate(){
        MyDate myDate = new MyDate();
        Integer n=null;
        while (n==null) {
            System.out.print("Введите год:");
            try {
                n = Integer.parseInt(reader.readLine());
                if (n < 0) throw new NegativeArraySizeException("Вы ввели отрицательное число");
            }
            catch (IOException e){}
            catch (NumberFormatException ee) { System.out.println("Вы ввели не число!"); }
            catch  (NegativeArraySizeException q){ System.out.println(q.getMessage());
            n=null;
             }
        }
        myDate.setYearMyDate(n);
        n=null;
        while (n==null) {
            System.out.print("Выберите число месяца:");
            for(int i=0;i<12;i++) System.out.println((i+1)+" - "+monthList.get(i));
            try {
                n = Integer.parseInt(reader.readLine());
                if (n <= 0 && n>12) throw new NegativeArraySizeException("Вы ввели несоответсвующее число");
            }
            catch (IOException e){}
            catch (NumberFormatException ee) { System.out.println("Вы ввели не число!"); }
            catch  (NegativeArraySizeException q){ System.out.println(q.getMessage());
            n=null;
            }
        }
        myDate.setMonthMyDate(monthList.get(n-1));
        n=null;
        while (n==null) {
            System.out.print("Выберите день месяца:");
            try {
                n = Integer.parseInt(reader.readLine());
                if (n < 1&& n>31) throw new NegativeArraySizeException("Вы ввели несоответсвующее число месяца");
                if(myDate.getMonthMyDate().equals("февраль")){
                    if(myDate.getYearMyDate()%400==0&&n<30) myDate.setDayMyDate(n);
                    else if(myDate.getYearMyDate()%4==0&&n<30 &&myDate.getYearMyDate()%100!=0) myDate.setDayMyDate(n);
                    else if(n<29) myDate.setDayMyDate(n);
                    else throw new NegativeArraySizeException("Вы ввели несоответсвующее число месяца");
                }
                else if(myDate.getMonthMyDate().equals("апрель")||myDate.getMonthMyDate().equals("июнь")||myDate.getMonthMyDate().equals("сентябрь")||myDate.getMonthMyDate().equals("ноябрь")){
                    if(n<31) myDate.setDayMyDate(n);
                    else{ throw new NegativeArraySizeException("Вы ввели несоответсвующее число месяца");
                    }
                }
                else myDate.setDayMyDate(n);
            }
            catch (IOException e){}
            catch (NumberFormatException ee) { System.out.println("Вы ввели не число!"); }
            catch  (NegativeArraySizeException q){ System.out.println(q.getMessage());
                n=null;
            }
        }
        dateList.add(myDate);
    }

    public  static void addString(){
        String s="";
        while(!s.equals("выход")){
            System.out.println("Введите строку и нажмите Enter для отмены наберите слово <выход>:");
            try{
                s=reader.readLine();
                stringList.add(s);
            }
            catch (IOException e){
                System.out.println("Ошибка при вводе строки!");
            }
        }
    }

    public  static void deleteStringsWithNumbers(){
        for(int i=stringList.size()-1;i>=0;i--){
            if(!stringList.get(i).matches("^[^0-9]*$"))stringList.remove(i);
        }
    }

    public static void allActionForSelect(){
        System.out.println("0 - Добавить Дату");
        System.out.println("1 - Вывести на экран список внесенных Дат");
        System.out.println("2 - Вывести на экран зимние Даты");
        System.out.println("3 - Добавить Строку");
        System.out.println("4 - Вывести массив Строк");
        System.out.println("5 - Удалить строки имеющие цифры");
        System.out.println("6 - Выйти");
    }

    public static void main(String[] args) throws IOException {
        String s;
        while(true){
            System.out.println("Выберете действие(напишите цифру и нажмите Enter):");
            allActionForSelect();
            s=reader.readLine();
            if(s.equals("6")) break;
                switch (s) {
                    case "0":addMyDate();break;
                    case "1":printMyDateList();break;
                    case "2":printWinterDates();break;
                    case "3":addString();break;
                    case "4":printStringList();break;
                    case "5":deleteStringsWithNumbers();break;
                    default:System.out.println("Ввели неправильную команду");
                }
        }
        reader.close();
    }
}
