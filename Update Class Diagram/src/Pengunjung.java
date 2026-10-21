import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pengunjung {
    private String idPengunjung;
    private String email;
    private final List<FeedbackPengunjung> riwayatFeedback = new ArrayList<>();

    public Pengunjung(String idPengunjung, String email) {
        this.idPengunjung = idPengunjung;
        this.email = email;
    }

    public void lihatPetaSampah(Event event) {
        System.out.println("[Peta Sampah] " + event.getNamaEvent());
        for (TitikSampah t : event.getDaftarTitik()) {
            t.tampilkanInfo();
        }
    }

     public void kirimFeedback(Event event, int rating, String catatan) {
        event.terimaFeedback(this, rating, catatan);
    }

    void tambahRiwayat(FeedbackPengunjung f) { riwayatFeedback.add(f); }

    public String getIdPengunjung() { return idPengunjung; }
    public String getEmail() { return email; }
    public List<FeedbackPengunjung> getRiwayatFeedback() { return Collections.unmodifiableList(riwayatFeedback); }
}
