/* MULTITHREADING <BookingClient.java>
 * EE422C Project 6 submission by
 * Replace <...> with your actual data.
 * Akarsh Kumar
 * ak39969
 * 16185
 * Slip days used: 0
 * Fall 2019
 */
package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.lang.Thread;

public class BookingClient {

    /**
     * The Box Office numbers, people in the queue.
     */
    private final Map<String, Integer> office;
    /**
     * The theater of this box office clients.
     */
    private final Theater theater;

    /**
     * Next client available.
     */
    private int nextClientID;

    /**
     * @param office  maps box office id to number of customers in line
     * @param theater the theater where the show is playing
     */
    public BookingClient(Map<String, Integer> office, Theater theater) {
        this.office = office;
        this.theater = theater;
        this.nextClientID = 0;
    }

    private synchronized int getNextAvailableClientID(){
        return nextClientID++;
    }

    /**
     * Starts the box office simulation by creating (and starting) threads
     * for each box office to sell tickets for the given theater
     *
     * @return list of threads used in the simulation,
     * should have as many threads as there are box offices
     */
    public List<Thread> simulate() {
        //the threads to return
        List<Thread> boxOfficeThreads = new ArrayList<>();
        for(String officeID: office.keySet()){
            Thread thread = new BoxOfficeThread(officeID, office.get(officeID));
            boxOfficeThreads.add(thread);
        }
        for(Thread thread:boxOfficeThreads){
            thread.start();
        }
        //this threads waits for others to be done then prints out a sold out message if neccessary
        Thread outOfTicketsPrintThread = new Thread(){
            @Override
            public void run(){
                for(Thread thread: boxOfficeThreads){
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(!theater.hasNextSeat()){
                    System.out.println("Sorry, we are sold out!");
                }
            }
        };
        outOfTicketsPrintThread.start();


        return boxOfficeThreads;
    }

    public static void main(String[] args) {
        Theater theater = new Theater(3,5, "Ouija");
        Map<String, Integer> office = new HashMap<>();

        office.put("BX1",3);
        office.put("BX3",3);
        office.put("BX2",4);
        office.put("BX5",3);
        office.put("BX4",3);

        BookingClient bookingClient = new BookingClient(office, theater);
        List<Thread> threads = bookingClient.simulate();


        for(Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        int i = 0;
//        for(Theater.Ticket ticket: theater.getTransactionLog()){
//            System.err.println(i++ +" "+ticket);
//        }

    }

    /**
     * The box office thread that runs a box office.
     */
    class BoxOfficeThread extends Thread {

        private final String officeID;
        private final int numCustomers;

        public BoxOfficeThread(String officeID, int numCustomers){
            this.officeID = officeID;
            this.numCustomers = numCustomers;
        }
        @Override
        public void run(){
            for(int i=0;i<numCustomers;i++){
                int currentClient = getNextAvailableClientID();
                synchronized (theater) {
                    //synchronizing so that bestAvailableSeat and printTicket run together
                    //is allowed because of
                    //https://piazza.com/class/jzit9xib6hf65g?cid=195
                    Theater.Seat seat = theater.bestAvailableSeat();
                    if(seat==null){
                        break;
                    }
                    theater.printTicket(officeID, seat, currentClient);
                }
                try {
                    Thread.sleep(theater.getPrintDelay());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
