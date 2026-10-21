public class FeedbackPengunjung {
    private String idFeedback;
    private String idEvent;
    private String idPengunjung;
    private int ratingKebersihan;
    private String catatanSaran;

    public FeedbackPengunjung(String idFeedback, String idEvent, String idPengunjung, int ratingKebersihan, String catatanSaran) {
        this.idFeedback = idFeedback;
        this.idEvent = idEvent;
        this.idPengunjung = idPengunjung;
        this.ratingKebersihan = ratingKebersihan;
        this.catatanSaran = catatanSaran;
    }

    public void kirimFeedback() {
        System.out.println("Feedback dari pengunjung " + idPengunjung + " berhasil dikirim.");
    }
}