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
        if (ratingKebersihan < 1 || ratingKebersihan > 5) {
            throw new IllegalArgumentException("Rating kebersihan harus 1-5");
        }
        System.out.println("[Feedback] " + pengunjung.getEmail() + " memberi rating " + ratingKebersihan
                + " untuk '" + event.getNamaEvent() + "': " + catatanSaran);
    }

    public String getIdFeedback() { return idFeedback; }
    public int getRatingKebersihan() { return ratingKebersihan; }
}