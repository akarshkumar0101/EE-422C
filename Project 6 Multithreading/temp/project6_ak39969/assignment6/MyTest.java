//package assignment6;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.util.*;
//
//import static org.junit.Assert.*;
//
//public class MyTest {
//
//    private static String show = "The Conjuring";
//    private static List<Theater.Ticket> concurrencyTestLog;
//
//    private static void joinAllThreads(List<Thread> threads)
//            throws InterruptedException {
//        for (Thread t : threads) {
//            t.join();
//        }
//    }
//
//    /**
//     * Initialize tests for concurrency by simulating BookingClient with
//     * 1) BX1: 100 clients
//     * 2) BX2: 100 clients
//     * 3) Theater: 100 rows, 2 seats per row
//     * <p>
//     * Stores the transactions into concurrencyTestLog
//     *
//     * @throws InterruptedException
//     */
//    @BeforeClass
//    public static void setupBeforeClass() throws InterruptedException {
//        Map<String, Integer> offices = new HashMap<String, Integer>() {{
//            put("BX1", 20);
//            put("BX2", 20);
//            put("BX3", 20);
//            put("BX4", 20);
//            put("BX5", 20);
//            put("BX6", 20);
//        }};
//
//        Theater t = new Theater(6, 20, show);
//        BookingClient bc = new BookingClient(offices, t);
//        joinAllThreads(bc.simulate());
//
//        concurrencyTestLog = t.getTransactionLog();
//    }
//    @Test(timeout = 120000)
//    public void testSeatUniqunes(){
//        boolean isUnique = true;
//
//        Set<Theater.Seat> seenSeats = new HashSet<>();
//        for(Theater.Ticket ticket: concurrencyTestLog){
//            Theater.Seat seat = ticket.getSeat();
//            if(seenSeats.contains(seat)){
//                isUnique = false;
//            }
//            seenSeats.add(seat);
//        }
//
//        assertTrue(isUnique);
//    }
//    @Test(timeout = 120000)
//    public void testListOrder(){
//        boolean isSorted = true;
//        for(int i=1;i<concurrencyTestLog.size();i++){
//            Theater.Ticket prevTicket = concurrencyTestLog.get(i-1);
//            Theater.Ticket ticket = concurrencyTestLog.get(i);
//            if(ticket.getSeat().getRowNum()<prevTicket.getSeat().getRowNum()){
//                isSorted = false;
//            }
//            else if(ticket.getSeat().getRowNum()==prevTicket.getSeat().getRowNum()){
//                if(ticket.getSeat().getSeatNum()<=prevTicket.getSeat().getSeatNum()){
//                    isSorted = false;
//                }
//            }
//        }
//        assertTrue(isSorted);
//    }
//
//    /**
//     * Tests that bestAvailableSeat() can calculate seats with two letters (ex: AA)
//     * <p>
//     * Precondition: 30 seats sold
//     * Expected: AE1
//     *
//     * @throws InterruptedException
//     */
//    @Test(timeout = 120000)
//    public void testBestSeatDouble() throws InterruptedException {
//        Map<String, Integer> offices = new HashMap<String, Integer>() {{
//            put("BX1", 15);
//            put("BX2", 15);
//        }};
//
//        Theater t = new Theater(50, 1, show);
//        BookingClient bc = new BookingClient(offices, t);
//        joinAllThreads(bc.simulate());
//
//        Theater.Seat best = t.bestAvailableSeat();
//        assertNotNull(best);
//        assertEquals("AE1", best.toString());
//    }
//
//    /**
//     * Tests that bestAvailableSeat() can handle an empty theater
//     * <p>
//     * Precondition: Theater has not sold any seats yet
//     * Expected: A1
//     */
//    @Test(timeout = 120000)
//    public void testBestSeatEmpty() {
//        Theater t = new Theater(1, 1, show);
//        Theater.Seat best = t.bestAvailableSeat();
//        assertNotNull(best);
//        assertTrue(best.toString().equalsIgnoreCase("A1"));
//    }
//}
