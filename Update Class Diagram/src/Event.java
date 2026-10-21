import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Event {

    public static final String PENDING_VERIFIKASI = "PENDING_VERIFIKASI";
    public static final String DISETUJUI = "DISETUJUI";
    public static final String VERIFIED = "VERIFIED";

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

    // ===== ASSOCIATION =====
    private Panitia panitia; 
    private Admin verifikator;
    private GreenLeaderboard leaderboard;

    // ===== AGGREGATION =====
    private final List<Advisory> daftarAdvisory = new ArrayList<>();

   // ===== COMPOSITION (part dibuat & dimiliki Event) =====
    private final JadwalEvent jadwal;                                   // 1
    private final List<TitikSampah> daftarTitik = new ArrayList<>();    // 0..*
    private final List<FeedbackPengunjung> daftarFeedback = new ArrayList<>(); // 0..*
    private TimbanganSampah timbangan;                                  // 0..1
    private Sertifikat sertifikat;   

    public Event(String idEvent, String idPanitia, String namaEvent, Date tanggalEvent, int targetPeserta, String jenisKegiatan) {
        this.idEvent = idEvent;
        this.idPanitia = idPanitia;
        this.namaEvent = namaEvent;
        this.tanggalEvent = tanggalEvent;
        this.targetPeserta = targetPeserta;
        this.jenisKegiatan = jenisKegiatan;

        this.jadwal = new JadwalEvent("JDW-" + idEvent, this, tanggalEvent, tanggalEvent, "Perencanaan");
    }


    public void buatEvent() {
        this.status = PENDING_VERIFIKASI;
        System.out.println("[Event] '" + namaEvent + "' dibuat, status " + status);
    }

    public void hitungEstimasiSampah() {
        this.volumeEstimasiSampah = targetPeserta * 0.25f; // asumsi 0,25 kg/peserta
        int set = (int) Math.ceil(volumeEstimasiSampah / 20f); // asumsi 1 set tong per 20 kg
        this.rekLogistikTempatSampah = set + " set tong (organik, daur ulang, residu)";
    }

    public void hitungDiversionRateAndKarbon() {
        if (timbangan == null || timbangan.getTotal() <= 0) {
            throw new IllegalStateException("Audit timbangan belum diinput");
        }
        float total = timbangan.getTotal();
        this.diversionRate = (timbangan.getBeratOrganik() + timbangan.getBeratDaurUlang()) / total * 100f;
        this.reduksiKarbon = timbangan.getBeratOrganik() * 0.5f + timbangan.getBeratDaurUlang() * 1.2f;
        this.zeroWasteScore = diversionRate;
        if (leaderboard != null) {
            leaderboard.updatePeringkat();
        }
    }

    public void tampilkanDetailEvent() {
        System.out.println("=== DETAIL EVENT ===");
        System.out.println("ID / Nama      : " + idEvent + " / " + namaEvent);
        System.out.println("Tanggal        : " + tanggalEvent + " | Jenis: " + jenisKegiatan);
        System.out.println("Target peserta : " + targetPeserta);
        System.out.println("Status         : " + status);
        System.out.println("Panitia        : " + (panitia != null ? panitia.getNamaOrmawa() : "-"));
        System.out.println("Titik sampah   : " + daftarTitik.size() + " | Feedback: " + daftarFeedback.size()
                + " | Advisory: " + daftarAdvisory.size());
        System.out.printf(Locale.US, "Estimasi sampah: %.1f kg | Rek. logistik: %s%n",
                volumeEstimasiSampah, rekLogistikTempatSampah);
        System.out.printf(Locale.US, "Diversion rate : %.1f%% | Reduksi karbon: %.1f kg CO2e | Zero-waste score: %.1f%n",
                diversionRate, reduksiKarbon, zeroWasteScore);
    }

    // ===== Pembuat part (COMPOSITION) =====
    public TitikSampah tambahTitik(String nama, float x, float y, String jenisTerpilah) {
        TitikSampah t = new TitikSampah("TTK-" + idEvent + "-" + (daftarTitik.size() + 1), this, nama, x, y, jenisTerpilah);
        daftarTitik.add(t);
        t.tambahTitik();
        return t;
    }

    public void terimaFeedback(Pengunjung pengunjung, int rating, String catatan) {
        FeedbackPengunjung f = new FeedbackPengunjung("FB-" + idEvent + "-" + (daftarFeedback.size() + 1),
                this, pengunjung, rating, catatan);
        f.kirimFeedback(); // validasi dulu; kalau gagal, tidak tersimpan
        daftarFeedback.add(f);
        pengunjung.tambahRiwayat(f);
    }

    public void catatTimbangan(float organik, float daurUlang, float residu, String fotoBukti) {
        if (timbangan == null) {
            timbangan = new TimbanganSampah("TMB-" + idEvent, this);
        }
        timbangan.inputBerat(organik, daurUlang, residu);
        timbangan.uploadFoto(fotoBukti);
    }

    public Sertifikat terbitkanSertifikat() {
        if (sertifikat == null) {
            sertifikat = new Sertifikat("SRT-" + idEvent, this, "GELORA-" + idEvent);
        }
        return sertifikat;
    }

    // ===== Penghubung relasi non-composition =====
    public void tambahAdvisory(Advisory advisory) {   // AGGREGATION: advisory dibuat di luar
        if (!daftarAdvisory.contains(advisory)) {
            daftarAdvisory.add(advisory);
        }
    }

    void setPanitia(Panitia panitia) { this.panitia = panitia; }
    void setVerifikator(Admin admin) { this.verifikator = admin; }
    void setLeaderboard(GreenLeaderboard lb) { this.leaderboard = lb; }
    void setStatus(String status) { this.status = status; }

    // ===== Getter =====
    public String getIdEvent() { return idEvent; }
    public String getNamaEvent() { return namaEvent; }
    public String getStatus() { return status; }
    public String getRekLogistikTempatSampah() { return rekLogistikTempatSampah; }
    public float getZeroWasteScore() { return zeroWasteScore; }
    public JadwalEvent getJadwal() { return jadwal; }
    public TimbanganSampah getTimbangan() { return timbangan; }
    public Sertifikat getSertifikat() { return sertifikat; }
    public GreenLeaderboard getLeaderboard() { return leaderboard; }
    public Panitia getPanitia() { return panitia; }
    public Admin getVerifikator() { return verifikator; }
    public List<TitikSampah> getDaftarTitik() { return Collections.unmodifiableList(daftarTitik); }
    public List<FeedbackPengunjung> getDaftarFeedback() { return Collections.unmodifiableList(daftarFeedback); }
    public List<Advisory> getDaftarAdvisory() { return Collections.unmodifiableList(daftarAdvisory); }
}
