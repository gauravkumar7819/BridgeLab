public class EarthVolume {
    public static void main(String[] args) {
        double earthRadius = 6378; // in km
        double volumeKm = (4.0/3.0) * Math.PI * Math.pow(earthRadius, 3);
        double volumeMiles = volumeKm / Math.pow(1.6, 3);
        System.out.printf("The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f%n", 
                         volumeKm, volumeMiles);
    }
}