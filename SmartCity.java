import java.time.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.*;

public class SmartCity {

    enum TransportType { BUS, METRO, TAXI, FERRY, AMBULANCE, FIRE }

    static class Route {
        final String name;
        final double startLat, startLon, endLat, endLon;
        Route(String name, double startLat, double startLon, double endLat, double endLon) {
            this.name = name; this.startLat = startLat; this.startLon = startLon; this.endLat = endLat; this.endLon = endLon;
        }
        @Override public String toString() { return name; }
    }

    interface TransportService {
        String getId();
        String getName();
        TransportType getType();
        Route getRoute();
        double getBaseFarePerKm();
        boolean isActive();
        LocalDateTime getDeparture();
        LocalDateTime getArrival();
        boolean isEV();

        default void printServiceDetails() {
            System.out.printf(Locale.US,
                "[%s] %s | route=%s | dep=%s | arr=%s | baseFare/km=%.2f | active=%s\n",
                getType(), getName(), getRoute(), getDeparture(), getArrival(), getBaseFarePerKm(), isActive());
        }

        default boolean departsAfter(LocalDateTime t) { return getDeparture().isAfter(t); }
    }

    interface EmergencyService { /* marker – no methods */ }

    interface GeoUtils {
        static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
            double R = 6371.0; // km
            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lon2 - lon1);
            double a = Math.sin(dLat/2)*Math.sin(dLat/2)
                    + Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))
                    * Math.sin(dLon/2)*Math.sin(dLon/2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            return R * c;
        }
    }

    @FunctionalInterface
    interface FareCalculator {
        double calculateFare(TransportService service, double distanceKm);
    }

    static class FareUtils {
        static double defaultFare(TransportService s, double distanceKm) {
            return s.getBaseFarePerKm() * distanceKm;
        }
        static double evDiscounted(TransportService s, double distanceKm) {
            double base = defaultFare(s, distanceKm);
            return s.isEV() ? base * 0.9 : base; // 10% off for EV
        }
        static double peakSurcharge(TransportService s, double distanceKm) {
            return defaultFare(s, distanceKm) * 1.2; // 20% surcharge
        }
    }

    static abstract class BaseService implements TransportService {
        private final String id, name; private final TransportType type; private final Route route;
        private final double baseFarePerKm; private final boolean active; private final boolean ev;
        private final LocalDateTime dep, arr;
        BaseService(String id, String name, TransportType type, Route route, double baseFarePerKm,
                    boolean active, boolean ev, LocalDateTime dep, LocalDateTime arr) {
            this.id=id; this.name=name; this.type=type; this.route=route; this.baseFarePerKm=baseFarePerKm;
            this.active=active; this.ev=ev; this.dep=dep; this.arr=arr;
        }
        public String getId(){return id;} public String getName(){return name;} public TransportType getType(){return type;}
        public Route getRoute(){return route;} public double getBaseFarePerKm(){return baseFarePerKm;} public boolean isActive(){return active;}
        public boolean isEV(){return ev;} public LocalDateTime getDeparture(){return dep;} public LocalDateTime getArrival(){return arr;}
    }

    static class BusService extends BaseService { BusService(String id, String name, Route r, double f, boolean active, boolean ev, LocalDateTime d, LocalDateTime a){ super(id,name,TransportType.BUS,r,f,active,ev,d,a);} }
    static class MetroService extends BaseService { MetroService(String id, String name, Route r, double f, boolean active, boolean ev, LocalDateTime d, LocalDateTime a){ super(id,name,TransportType.METRO,r,f,active,ev,d,a);} }
    static class TaxiService extends BaseService { TaxiService(String id, String name, Route r, double f, boolean active, boolean ev, LocalDateTime d, LocalDateTime a){ super(id,name,TransportType.TAXI,r,f,active,ev,d,a);} }
    static class FerryService extends BaseService { FerryService(String id, String name, Route r, double f, boolean active, boolean ev, LocalDateTime d, LocalDateTime a){ super(id,name,TransportType.FERRY,r,f,active,ev,d,a);} }

    static class AmbulanceService extends BaseService implements EmergencyService { AmbulanceService(String id, String name, Route r, double f, boolean active, boolean ev, LocalDateTime d, LocalDateTime a){ super(id,name,TransportType.AMBULANCE,r,f,active,ev,d,a);} }
    static class FireService extends BaseService implements EmergencyService { FireService(String id, String name, Route r, double f, boolean active, boolean ev, LocalDateTime d, LocalDateTime a){ super(id,name,TransportType.FIRE,r,f,active,ev,d,a);} }

    static class Passenger {
        final String id, name;
        Passenger(String id, String name){this.id=id; this.name=name;}
    }
    static class Trip {
        final Passenger passenger; final TransportService service; final double distanceKm; final double farePaid; final LocalDateTime time; final boolean peak;
        Trip(Passenger p, TransportService s, double distanceKm, double farePaid, LocalDateTime time, boolean peak){
            this.passenger=p; this.service=s; this.distanceKm=distanceKm; this.farePaid=farePaid; this.time=time; this.peak=peak;
        }
        Route getRoute(){ return service.getRoute(); }
        String getRouteName(){ return service.getRoute().name; }
        double getFarePaid(){ return farePaid; }
        boolean isPeak(){ return peak; }
        TransportType getType(){ return service.getType(); }
    }

    static List<TransportService> seedServices() {
        Route r1 = new Route("Airport ↔ Downtown", 28.5562,77.1000, 28.6139,77.2090);
        Route r2 = new Route("IT Park ↔ Central", 28.4595,77.0266, 28.6353,77.2250);
        Route r3 = new Route("University ↔ Old Port", 28.7041,77.1025, 28.6692,77.4538);
        LocalDateTime now = LocalDateTime.now();
        return Arrays.asList(
            new BusService("B1","City Bus 24A", r1, 2.5, true, false, now.plusMinutes(10), now.plusMinutes(55)),
            new MetroService("M1","Blue Line M7", r2, 3.0, true, true, now.plusMinutes(5), now.plusMinutes(30)),
            new TaxiService("T1","Taxi #4321", r1, 15.0, true, true, now.plusMinutes(2), now.plusMinutes(35)),
            new TaxiService("T2","Taxi #8765", r3, 14.0, false, false, now.plusMinutes(25), now.plusMinutes(60)),
            new FerryService("F1","River Ferry R3", r3, 4.0, true, false, now.plusMinutes(12), now.plusMinutes(70)),
            new AmbulanceService("A1","Ambulance A-12", r1, 0.0, true, true, now.plusMinutes(1), now.plusMinutes(20)),
            new FireService("FS1","Fire Brigade F-7", r2, 0.0, false, true, now.plusMinutes(3), now.plusMinutes(25))
        );
    }

    static List<Passenger> seedPassengers() {
        return Arrays.asList(new Passenger("P1","Gaurav"), new Passenger("P2","Asha"), new Passenger("P3","Vikram"), new Passenger("P4","Neha"));
    }

    static List<Trip> simulateTrips(List<Passenger> pax, List<TransportService> services, FareCalculator calc) {
        List<Trip> trips = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (Passenger p : pax) {
            TransportService s = services.get(ThreadLocalRandom.current().nextInt(services.size()));
            double dist = GeoUtils.calculateDistance(s.getRoute().startLat, s.getRoute().startLon, s.getRoute().endLat, s.getRoute().endLon);
            boolean peak = s.getDeparture().getHour() >= 8 && s.getDeparture().getHour() <= 10;
            double fare = calc.calculateFare(s, dist);
            trips.add(new Trip(p, s, dist, fare, now, peak));
        }
        return trips;
    }

}
