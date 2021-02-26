import java.util.Scanner;
public class DayofMonth{
    static int month;
    static int checkMonth(String n){
        switch (n) {
            case "1":
            case "Jan":
            case "Jan.":
            case "January":
            case "3":
            case "Mar":
            case "Mar.":
            case "March":
            case "5":
            case "May":
            case "May.":
            case "7":
            case "Jul":
            case "Jul.":
            case "July":
            case "8":
            case "Aug":
            case "Aug.":
            case "August":
            case "10":
            case "Oct":
            case "Oct.":
            case "October":
            case "12":
            case "Dec":
            case "Dec.":
            case "December":
                return 31;
            case "2":
            case "Feb":
            case "Feb.":
            case "February":
                return 1;
            case "4":
            case "Apr":
            case "Apr.":
            case "April":
            case "6":
            case "Jun":
            case "Jun.":
            case "June":
            case "9":
            case "Sep":
            case "Sep.":
            case "September":
            case "11":
            case "Nov":
            case "Nov.":
            case "November":
                return 30;
            default:
                return 0;
        }
    }
    static boolean checkYear(int n){
        if (n <= 0 )return false;
        return true;
    }
    public static void main (String[] args){
        Scanner keyboard = new Scanner(System.in);
        String n;
        int year;
        do {
            System.out.println("Enter month:");
             n = keyboard.nextLine();
             month = checkMonth(n);
        } while (month==0);
        do {
            System.out.println("Enter Year:");
             year = keyboard.nextInt();
        } while (!checkYear(year));
        if (month == 1){
            if (year%100==0&&year%400!=0){
                month =28;
                System.out.println(n+" "+year+" have "+month+"days");
            }else if (year%4==0){
                month =29;
                System.out.println(n+" "+year+" have "+month+"days");
            }else {
                month =28;
                System.out.println(n+" "+year+" have "+month+"days");
            }
        }
    }
}