import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // --- objek yang hidup mandiri ---
        Panitia panitia = new Panitia("PNT-01", "HIMATRPL", "himatrpl@apps.ipb.ac.id", "rahasia123", "081234567890");
        Admin admin = new Admin("ADM-01", "Admin Sarpras", "admin@ipb.ac.id", "admin123");
        Pengunjung pengunjung = new Pengunjung("PGJ-01", "mahasiswa@apps.ipb.ac.id");
        Advisory advisory = new Advisory("ADV-01", "Bank Sampah Dramaga", "Mitra Daur Ulang",
                "0812-0000-1111", "Kemasan kompos 5 kg");

        panitia.register();
        System.out.println("Login berhasil? " + panitia.login("himatrpl@apps.ipb.ac.id", "rahasia123"));

        // --- 1. Perencanaan: Event dibuat lalu dikelola Panitia (aggregation) ---
        Event event = new Event("EVT-01", "Dies Natalis Sekolah Vokasi", LocalDate.of(2026, 11, 20), 400, "Seminar & Bazar");
        event.buatEvent();
        panitia.kelolaEvent(event);
        panitia.hitungEcoBudgeting(event);
        event.getJadwal().aturJadwal(LocalDate.of(2026, 11, 20), LocalDate.of(2026, 11, 21), "Pelaksanaan");
        event.tambahAdvisory(advisory);                                    // aggregation
        event.tambahTitik("Gerbang Utama", -6.5560f, 106.7260f, "Organik");   // composition
        event.tambahTitik("Aula Barat", -6.5565f, 106.7268f, "Daur Ulang");
        new GreenLeaderboard("LB-01", event);                               // association
        advisory.tampilkanKatalogAdvisory();

        // --- 2. Admin menyetujui event ---
        admin.verifikasiEvent(event);

        // --- 3. Pengunjung ---
        pengunjung.lihatPetaSampah(event);
        pengunjung.kirimFeedback(event, 5, "Tempat sampahnya jelas dan bersih");

        // --- 4. Audit pasca-acara ---
        panitia.generateSertifikat(event);                      // belum bisa
        panitia.inputTimbangan(event, 40f, 25f, 10f, "uploads/timbangan_evt01.jpg");
        admin.validasiAudit(event);
        admin.approveSertifikat(event);
        panitia.generateSertifikat(event);

        // --- 5. Hasil ---
        event.tampilkanDetailEvent();
        System.out.println("Verifikasi kode sah? "
                + event.getSertifikat().verifikasiKeabsahan("GELORA-EVT-01"));
        event.getLeaderboard().tampilkanPapan();
        event.terimaFeedback(pengunjung, 4, "Perlu tambah titik di parkiran");
        System.out.println("Total feedback pengunjung: " + pengunjung.getRiwayatFeedback().size());
    }
}
