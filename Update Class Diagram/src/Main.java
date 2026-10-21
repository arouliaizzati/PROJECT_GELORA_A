import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM GELORA: SIMULASI PENGUJIAN AKTOR & EVENT ===");

        // 1. Buat Akun Panitia & Admin
        Panitia panitia = new Panitia("PAN-01", "HIMATANI", "panitia@gelora.org", "pass123", "08123456789");
        panitia.register();
        panitia.login();

        Admin admin = new Admin("ADM-01", "Admin Kampus", "admin@ipb.ac.id", "admin123");

        // 2. Buat Event
        Event event = new Event("EVT-101", "PAN-01", "Green Campus Festival 2026", new Date(), 500, "Edukasi Lingkungan");
        event.buatEvent();
        panitia.tambahEvent(event);

        // 3. Admin Memverifikasi Event
        admin.verifikasiEvent(event);

        // 4. Tambah Titik Sampah & Advisory
        TitikSampah titik1 = new TitikSampah("TITIK-01", "EVT-101", "Lapangan Utama", -6.55f, 106.72f, "Anorganik & Organik");
        titik1.tambahTitik();
        event.tambahTitikSampah(titik1);

        Advisory advisory = new Advisory("ADV-01", "Pengurangan Wadah Plastik", "Panduan Mitra", "0899887766", "Katalog Ramah Lingkungan");
        advisory.tampilKatalogAdvisory();
        event.tambahAdvisory(advisory);

        // 5. Pengunjung Berpartisipasi & Mengirim Feedback
        Pengunjung pengunjung = new Pengunjung("PGN-01", "bunga@student.ipb.ac.id");
        pengunjung.lihatPetaSampah();

        FeedbackPengunjung feedback = new FeedbackPengunjung("FBD-01", "EVT-101", pengunjung.getIdPengunjung(), 5, "Acara sangat bersih dan teratur!");
        feedback.kirimFeedback();
        event.tambahFeedback(feedback);

        // 6. Penimbangan Sampah Pasca Event
        panitia.inputTimbangan();
        event.hitungDiversionRateAndKarbon();

        // 7. Terbitkan Sertifikat & Leaderboard
        Sertifikat sertifikat = new Sertifikat("SRT-01", "EVT-101", "KODE-GELORA-2026", new Date(), "https://gelora.org/verify/SRT-01");
        sertifikat.generateSertifikat();
        event.setSertifikat(sertifikat);

        GreenLeaderboard leaderboard = new GreenLeaderboard("LDB-01", "EVT-101", 95.5f, 1);
        leaderboard.tampilkanPapan();
        event.setGreenLeaderboard(leaderboard);

        System.out.println("\n=== SIMULASI SELESAI ===");
    }
}