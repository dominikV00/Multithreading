package lab16;

public class multiThreading extends Thread {


    public static void main(String[] args) {

        firstList numberList1 = new firstList();
        secondList numberList2 = new secondList();

        numberList1.start();
        numberList2.start();

    }
}
