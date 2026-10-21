public class FeedbackPengunjung {
    private String idFeedback;
    private String idEvent;
    private String idPengunjung;
    private int ratingKebersihan;
    private String catatanSaran;
    private Event event;
    private Pengunjung pengunjung;

    public FeedbackPengunjung(String idFeedback, Event event, Pengunjung pengunjung, int ratingKebersihan, String catatanSaran) {
        this.idFeedback = idFeedback;
        this.idEvent = event.getIdEvent();
        this.idPengunjung = pengunjung.getIdPengunjung();
        this.ratingKebersihan = ratingKebersihan;
        this.catatanSaran = catatanSaran;
        this.event = event;
        this.pengunjung = pengunjung;
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