/* MULTITHREADING <Theater.java>
 * EE422C Project 6 submission by
 * Replace <...> with your actual data.
 * Akarsh Kumar
 * ak39969
 * 16185
 * Slip days used: 0
 * Fall 2019
 */
package assignment6;

import java.util.*;

public class Theater {

    /**
     * the delay time you will use when print tickets
     */
    private int printDelay = 50; // 50 ms.  Use it in your Thread.sleep()

    public void setPrintDelay(int printDelay) {
        this.printDelay = printDelay;
    }

    public int getPrintDelay() {
        return printDelay;
    }

    /**
     * Represents a seat in the theater
     * A1, A2, A3, ... B1, B2, B3 ...
     */
    static class Seat {
        private int rowNum;
        private int seatNum;

        public Seat(int rowNum, int seatNum) {
            this.rowNum = rowNum;
            this.seatNum = seatNum;
        }

        public int getSeatNum() {
            return seatNum;
        }

        public int getRowNum() {
            return rowNum;
        }

        @Override
        public String toString() {
            String result = "";
            int tempRowNumber = rowNum + 1;
            do {
                tempRowNumber--;
                result = ((char) ('A' + tempRowNumber % 26)) + result;
                tempRowNumber = tempRowNumber / 26;
            } while (tempRowNumber > 0);
            result += seatNum;
            return result;
        }
        @Override
        public boolean equals(Object another){
            return another instanceof Seat && ((Seat) another).rowNum == rowNum && ((Seat) another).seatNum == seatNum;
        }
        @Override
        public int hashCode(){
            return rowNum*10000 + seatNum;
        }
    }

    /**
     * Represents a ticket purchased by a client
     */
    static class Ticket {
        private String show;
        private String boxOfficeId;
        private Seat seat;
        private int client;
        public static final int ticketStringRowLength = 31;


        public Ticket(String show, String boxOfficeId, Seat seat, int client) {
            this.show = show;
            this.boxOfficeId = boxOfficeId;
            this.seat = seat;
            this.client = client;
        }

        public Seat getSeat() {
            return seat;
        }

        public String getShow() {
            return show;
        }

        public String getBoxOfficeId() {
            return boxOfficeId;
        }

        public int getClient() {
            return client;
        }

        @Override
        public String toString() {
            String result, dashLine, showLine, boxLine, seatLine, clientLine, eol;

            eol = System.getProperty("line.separator");

            dashLine = new String(new char[ticketStringRowLength]).replace('\0', '-');

            showLine = "| Show: " + show;
            for (int i = showLine.length(); i < ticketStringRowLength - 1; ++i) {
                showLine += " ";
            }
            showLine += "|";

            boxLine = "| Box Office ID: " + boxOfficeId;
            for (int i = boxLine.length(); i < ticketStringRowLength - 1; ++i) {
                boxLine += " ";
            }
            boxLine += "|";

            seatLine = "| Seat: " + seat.toString();
            for (int i = seatLine.length(); i < ticketStringRowLength - 1; ++i) {
                seatLine += " ";
            }
            seatLine += "|";

            clientLine = "| Client: " + client;
            for (int i = clientLine.length(); i < ticketStringRowLength - 1; ++i) {
                clientLine += " ";
            }
            clientLine += "|";

            result = dashLine + eol +
                    showLine + eol +
                    boxLine + eol +
                    seatLine + eol +
                    clientLine + eol +
                    dashLine;

            return result;
        }
    }


    private final int numRows;
    private final int seatsPerRow;
    private final String show;

    private Seat bestSeatAvailable;

    private final List<Ticket> transactionLog;


    public Theater(int numRows, int seatsPerRow, String show) {
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        this.show = show;

        bestSeatAvailable = new Seat(0,1);

        this.transactionLog = new ArrayList<>();
    }

    /**
     * Calculates the best seat not yet reserved
     *
     * @return the best seat or null if theater is full
     */
    public Seat bestAvailableSeat() {
        Seat bestSeatAvailable = this.bestSeatAvailable;
        if(bestSeatAvailable==null){
            return null;
        }
        this.bestSeatAvailable = getNextSeat(bestSeatAvailable);
        return bestSeatAvailable;
    }

    /**
     * returns true if there is an available seat still.
     * @return
     */
    public synchronized boolean hasNextSeat(){
        return this.bestSeatAvailable != null;
    }

    /**
     * Get the next seat given a current seat
     * @param currentSeat
     * @return
     */
    private Seat getNextSeat(Seat currentSeat){
        int rowNum = currentSeat.getRowNum();
        int seatNum = currentSeat.getSeatNum();

        if(seatNum+1<=seatsPerRow){
            seatNum++;
        }
        else{
            seatNum = 1;
            rowNum++;
        }

        if(rowNum<numRows){
            return new Seat(rowNum,seatNum);
        }
        else{
            return null;
        }
    }


    /**
     * Prints a ticket for the client after they reserve a seat
     * Also prints the ticket to the console
     *
     * @param seat a particular seat in the theater
     * @return a ticket or null if a box office failed to reserve the seat
     */
    public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
        Ticket ticket = null;

        ticket = new Ticket(show,boxOfficeId,seat,client);
        transactionLog.add(ticket);

        System.out.println(ticket);
        return ticket;
    }

    /**
     * Lists all tickets sold for this theater in order of purchase
     *
     * @return list of tickets sold
     */
    public List<Ticket> getTransactionLog() {
         return transactionLog;
    }
}
