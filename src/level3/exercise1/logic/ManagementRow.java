package level3.exercise1.logic;

import level3.exercise1.classData.Seat;
import level3.exercise1.exceptions.ExceptionReservedSeat;
import level3.exercise1.exceptions.ExceptionSeatFree;

import java.util.ArrayList;


public class ManagementRow {
    private ArrayList<Seat>seatCinemas;

    public ManagementRow(){
        this.seatCinemas = new ArrayList<>();
    }

    public ArrayList<Seat> getSeatCinemas() {
        return seatCinemas;
    }

    public void addSeat(Seat newSeat) throws ExceptionReservedSeat {

        int index = lookForSeat(newSeat.getRow() ,newSeat.getSeat());

        if (index != -1){
            throw new ExceptionReservedSeat("The seat at row" + newSeat.getRow() + ", seat " + newSeat.getSeat() + " is already reserved.");

        }
        seatCinemas.add(newSeat);
        System.out.println("Seat successfully added: Row " + newSeat.getRow() + ", Seat " + newSeat.getSeat());
        }

    public void deleteSeat(int row, int seat) throws ExceptionSeatFree {
        int index = lookForSeat(row, seat);

        if(index == -1) {
            throw new ExceptionSeatFree("The seat at row " + row + ", seat " + seat + " is not reserved.");
        }
        seatCinemas.remove(index);
        System.out.println("Seat at row " + row + ", seat " + seat + " has been successfully deleted.");

    }
    public int lookForSeat(int row ,int seat){
        for (int i = 0; i <seatCinemas.size(); i++){
          Seat seatCinema = seatCinemas.get(i);
          if (seatCinema.getRow() == row && seatCinema.getSeat() == seat){
              return i;
          }
        }
        return -1;
        }
    }

