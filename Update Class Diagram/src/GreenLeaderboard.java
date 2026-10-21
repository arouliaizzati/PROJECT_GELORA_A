import java.util.Locale;

public class GreenLeaderboard {
    private String idLeaderboard;
    private Event event;
    private float totalPoinOrmawa;
    private int peringkat;

    public GreenLeaderboard(String idLeaderboard, Event event) {
        this.idLeaderboard = idLeaderboard;
        this.event = event;
        event.setLeaderboard(this);
    }

    public void updatePeringkat() {
        totalPoinOrmawa += event.getZeroWasteScore();
        peringkat = totalPoinOrmawa >= 80 ? 1 : (totalPoinOrmawa >= 50 ? 2 : 3);
    }

    public void tampilkanPapan() {
        System.out.printf(Locale.US, "[Leaderboard] %s | total poin %.1f | peringkat %d%n",
                event.getNamaEvent(), totalPoinOrmawa, peringkat);
    }

    public String getIdLeaderboard() { return idLeaderboard; }
    public float getTotalPoinOrmawa() { return totalPoinOrmawa; }
    public int getPeringkat() { return peringkat; }
}
