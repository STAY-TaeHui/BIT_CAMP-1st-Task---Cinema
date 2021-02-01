package Cinema_Main;


import Cinema_Reservation.Cinema_Reservation;

public class Main {
    public static void main(String args[]){

        Cinema_Reservation cr = new Cinema_Reservation();
//        cr.printSeat();

        switch (cr.optionChoice()){
            case 1: {
                System.out.println("case 1");
                cr.reseveSeatCheck();
                break;
            }
            case 2:{
                System.out.println("case 2");
                cr.printSeat();
                break;

            }
            case 3:{
                System.out.println("case 3");break;
            }
        }


    }
}
