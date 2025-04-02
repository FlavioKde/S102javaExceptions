package level3.exercise1.classData;

public class Seat {
    private int row;
    private int seat;
    private String name;

    public  Seat(int row, int seat, String name){
        this.row = row;
        this.seat = seat;
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public String getName() {
        return name;
    }
    public boolean equals(int rowA, int rowB, int seatA, int seatB){

            return rowA == rowB && seatA == seatB;
    }

    @Override
    public String toString() {
        return "SeatCinema: " +"\n"+
                "row= " + row +"\n"+
                "seat= " + seat +"\n"+
                "name= " + name + "\n"
                ;
    }
}
