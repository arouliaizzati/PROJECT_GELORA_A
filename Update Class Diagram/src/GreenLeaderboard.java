public class GreenLeaderboard {
    private String idLeaderboard;
    private String idEvent;
    private float totalPoinOrmawa;
    private int peringkat;

    public GreenLeaderboard(String idLeaderboard, String idEvent, float totalPoinOrmawa, int peringkat) {
        this.idLeaderboard = idLeaderboard;
        this.idEvent = idEvent;
        this.totalPoinOrmawa = totalPoinOrmawa;
        this.peringkat = peringkat;
    }

    public void updatePeringkat(int peringkatBaru) {
        this.peringkat = peringkatBaru;
        System.out.println("Peringkat leaderboard diperbarui.");
    }

    public void tampilkanPapan() {
        System.out.println("Tampilkan Green Leaderboard.");
    }
}