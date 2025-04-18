import java.util.*;

public class SimulatedAnnealing {

    public static void main(String[] args) {
        // Inisialisasi rute awal: A-B-C-D-E-F-A
        List<Integer> currentRoute = Arrays.asList(0, 1, 2, 3, 4, 5, 0);
        double temperature = 100;      // Suhu awal
        double coolingRate = 0.95;     // Laju pendinginan

        // Hitung jarak awal dan simpan sebagai rute terbaik
        int bestDistance = calculateTotalDistance(currentRoute);
        List<Integer> bestRoute = new ArrayList<>(currentRoute);

        Random random = new Random();

        // Proses iterasi selama suhu belum mencapai 1
        while (temperature > 1) {
            // Salin rute saat ini untuk diubah
            List<Integer> newRoute = new ArrayList<>(currentRoute);

            // Tukar dua lokasi secara acak (kecuali posisi awal/akhir yaitu A)
            int i = 1 + random.nextInt(5);
            int j = 1 + random.nextInt(5);
            Collections.swap(newRoute, i, j);

            // Hitung jarak total rute baru
            int newDistance = calculateTotalDistance(newRoute);

            // Jika diterima berdasarkan probabilitas atau lebih baik, jadikan rute baru sebagai rute sekarang
            if (acceptanceProbability(bestDistance, newDistance, temperature) > Math.random()) {
                currentRoute = newRoute;
                // Jika lebih baik dari sebelumnya, perbarui rute terbaik
                if (newDistance < bestDistance) {
                    bestDistance = newDistance;
                    bestRoute = new ArrayList<>(newRoute);
                }
            }

            // Turunkan suhu sesuai cooling rate
            temperature *= coolingRate;
        }

        // Cetak hasil rute terbaik dan jaraknya
        printRoute(bestRoute);
        System.out.println("Distância total: " + bestDistance + " km");
    }

    // Fungsi untuk menghitung total jarak dari rute yang diberikan
    private static int calculateTotalDistance(List<Integer> route) {
        int distance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            distance += DistanceMatrix.DISTANCE[route.get(i)][route.get(i + 1)];
        }
        return distance;
    }

    // Fungsi probabilitas penerimaan solusi yang lebih buruk
    private static double acceptanceProbability(int oldDistance, int newDistance, double temp) {
        if (newDistance < oldDistance) return 1.0; // Selalu terima jika lebih baik
        return Math.exp((oldDistance - newDistance) / temp); // Probabilitas jika lebih buruk
    }

    // Fungsi untuk mencetak rute dengan huruf A-F
    private static void printRoute(List<Integer> route) {
        String[] names = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < route.size(); i++) {
            System.out.print(names[route.get(i)]);
            if (i < route.size() - 1) System.out.print(" → ");
        }
        System.out.println(); 
    }
}
