import java.util.Locale;

public class TitikSampah {
    private String idTitik;
    private Event event;
    private String namaLokasi;
    private float koordinatX;
    private float koordinatY;
    private String jenisTerpilah;

    TitikSampah(String idTitik, Event event, String namaLokasi, float koordinatX, float koordinatY, String jenisTerpilah) {
        this.idTitik = idTitik;
        this.event = event;
        this.namaLokasi = namaLokasi;
        this.koordinatX = koordinatX;
        this.koordinatY = koordinatY;
        this.jenisTerpilah = jenisTerpilah;
    }

    public void tambahTitik() {
        System.out.println("[Titik Sampah] Ditambahkan: " + namaLokasi + " (" + jenisTerpilah + ")");
    }

    public void updateTitik(String namaLokasi, float koordinatX, float koordinatY, String jenisTerpilah) {
        this.namaLokasi = namaLokasi;
        this.koordinatX = koordinatX;
        this.koordinatY = koordinatY;
        this.jenisTerpilah = jenisTerpilah;
        System.out.println("[Titik Sampah] Diperbarui: " + namaLokasi);
    }

    public void tampilkanInfo() {
        System.out.printf(Locale.US, "  - %s [%s] (%.4f, %.4f)%n", namaLokasi, jenisTerpilah, koordinatX, koordinatY);
    }

    public String getIdTitik() { return idTitik; }
    public String getNamaLokasi() { return namaLokasi; }
}
