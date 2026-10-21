import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    private String idEvent;
    private String idPanitia;
    private String namaEvent;
    private Date tanggalEvent;
    private int targetPeserta;
    private String jenisKegiatan;
    private float volumeEstimasiSampah;
    private String rekLogistikTempatSampah;
    private float diversionRate;
    private float reduksiKarbon;
    private float zeroWasteScore;

    // Relasi Multiplicity berdasarkan Class Diagram:
    // 1. Composition ke JadwalEvent (1)
    private JadwalEvent jadwalEvent;

    // 2. Composition ke TimbanganSampah (1)
    private TimbanganSampah timbanganSampah;

    // 3. Association ke Sertifikat (1)
    private Sertifikat sertifikat;

    // 4. Association ke GreenLeaderboard (1)
    private GreenLeaderboard greenLeaderboard;

    // 5. Association ke Advisory (0..*)
    private List<Advisory> daftarAdvisory = new ArrayList<>();

    // 6. Composition/Association ke TitikSampah (0..*)
    private List<TitikSampah> daftarTitikSampah = new ArrayList<>();

    // 7. Composition/Association ke FeedbackPengunjung (0..*)
    private List<FeedbackPengunjung> daftarFeedback = new ArrayList<>();

    public Event(String idEvent, String idPanitia, String namaEvent, Date tanggalEvent, int targetPeserta, String jenisKegiatan) {
        this.idEvent = idEvent;
        this.idPanitia = idPanitia;
        this.namaEvent = namaEvent;
        this.tanggalEvent = tanggalEvent;
        this.targetPeserta = targetPeserta;
        this.jenisKegiatan = jenisKegiatan;

        // Composition: JadwalEvent & TimbanganSampah langsung dibuat bersamaan dengan Event
        this.jadwalEvent = new JadwalEvent("JAD-" + idEvent, idEvent);
        this.timbanganSampah = new TimbanganSampah("TIMB-" + idEvent, idEvent);
    }

    public void buatEvent() {
        System.out.println("Event " + namaEvent + " berhasil dibuat.");
    }

    public void hitungEstimasiSampah() {
        System.out.println("Menghitung estimasi sampah...");
    }

    public void hitungDiversionRateAndKarbon() {
        System.out.println("Menghitung diversion rate dan karbon...");
    }

    public void tampilkanDetailEvent() {
        System.out.println("Detail Event: " + namaEvent);
    }

    // Getter & Setter pendukung
    public String getNamaEvent() { return namaEvent; }
    public String getIdEvent() { return idEvent; }
    
    public void setSertifikat(Sertifikat sertifikat) { this.sertifikat = sertifikat; }
    public void setGreenLeaderboard(GreenLeaderboard greenLeaderboard) { this.greenLeaderboard = greenLeaderboard; }
    
    public void tambahAdvisory(Advisory advisory) { this.daftarAdvisory.add(advisory); }
    public void tambahTitikSampah(TitikSampah titik) { this.daftarTitikSampah.add(titik); }
    public void tambahFeedback(FeedbackPengunjung feedback) { this.daftarFeedback.add(feedback); }
}