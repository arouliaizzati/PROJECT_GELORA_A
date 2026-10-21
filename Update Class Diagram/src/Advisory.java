public class Advisory {
    private String idAdvisory;
    private String namaReferensi;
    private String jenisReferensi;
    private String kontakMitraLokal;
    private String katalogKemasan;

    public Advisory(String idAdvisory, String namaReferensi, String jenisReferensi,
                    String kontakMitraLokal, String katalogKemasan) {
        this.idAdvisory = idAdvisory;
        this.namaReferensi = namaReferensi;
        this.jenisReferensi = jenisReferensi;
        this.kontakMitraLokal = kontakMitraLokal;
        this.katalogKemasan = katalogKemasan;
    }

    public void tampilkanKatalogAdvisory() {
        System.out.println("[Advisory] " + namaReferensi + " (" + jenisReferensi + ") | Mitra: "
                + kontakMitraLokal + " | Kemasan: " + katalogKemasan);
    }

    public String getIdAdvisory() { return idAdvisory; }
    public String getNamaReferensi() { return namaReferensi; }
}
