import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Event {
    public static final String PENDING_VERIFIKASI = "PENDING_VERIFIKASI";
    public static final String DISETUJUI = "DISETUJUI";
    public static final String VERIFIED = "VERIFIED";

<<<<<<< HEAD
    private String idEvent;
    private String namaEvent;
    private LocalDate tanggalEvent;
    private int targetPeserta;
    private String jenisKegiatan;
    private String status = PENDING_VERIFIKASI;
=======
    private final String idEvent;
    private final String idPanitia;
    private final String namaEvent;
    private String status;
    private final Date tanggalEvent;
    private final int targetPeserta;
    private final String jenisKegiatan;
>>>>>>> c912a973c485abb9936974cabf625574cbda9fc0
    private float volumeEstimasiSampah;
    private String rekLogistikTempatSampah;
    private float diversionRate;
    private float reduksiKarbon;
    private float zeroWasteScore;

    private Panitia panitia;
    private Admin verifikator;
    private GreenLeaderboard leaderboard;
    private final List<Advisory> daftarAdvisory = new ArrayList<>();
    private final JadwalEvent jadwal;
    private final List<TitikSampah> daftarTitik = new ArrayList<>();
    private final List<FeedbackPengunjung> daftarFeedback = new ArrayList<>();
    private TimbanganSampah timbangan;
    private Sertifikat sertifikat;

    public Event(String idEvent, String namaEvent, LocalDate tanggalEvent, int targetPeserta, String jenisKegiatan) {
        this.idEvent = idEvent;
        this.namaEvent = namaEvent;
        this.tanggalEvent = tanggalEvent;
        this.targetPeserta = targetPeserta;
        this.jenisKegiatan = jenisKegiatan;
<<<<<<< HEAD
        this.jadwal = new JadwalEvent("JDW-" + idEvent, this, tanggalEvent, tanggalEvent, "Perencanaan");
=======

        LocalDate tanggal = tanggalEvent.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.jadwal = new JadwalEvent("JDW-" + idEvent, this, tanggal, tanggal, "Perencanaan");
>>>>>>> c912a973c485abb9936974cabf625574cbda9fc0
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
        TitikSampah t = new TitikSampah("TTK-" + idEvent + "-" + (daftarTitik.size() + 1), idEvent, nama, x, y, jenisTerpilah);
        daftarTitik.add(t);
        return t;
    }

    public void terimaFeedback(Pengunjung pengunjung, int rating, String catatan) {
        FeedbackPengunjung f = new FeedbackPengunjung("FB-" + idEvent + "-" + (daftarFeedback.size() + 1),
            idEvent, pengunjung.getIdPengunjung(), rating, catatan);
        f.kirimFeedback(); // validasi dulu; kalau gagal, tidak tersimpan
        daftarFeedback.add(f);
        pengunjung.tambahRiwayat(f);
    }

    public void catatTimbangan(float organik, float daurUlang, float residu, String fotoBukti) {
        if (timbangan == null) {
            timbangan = new TimbanganSampah("TMB-" + idEvent, idEvent);
        }
        timbangan.inputBerat(organik, daurUlang, residu);
        timbangan.uploadFoto(fotoBukti);
    }

    public Sertifikat terbitkanSertifikat() {
        if (sertifikat == null) {
            sertifikat = new Sertifikat("SRT-" + idEvent, idEvent, namaEvent, new Date(), "GELORA-" + idEvent);
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
    public String getIdPanitia() { return idPanitia; }
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
