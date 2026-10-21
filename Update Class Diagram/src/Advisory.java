public class Advisory {
    private String idAdvisory;
    private String namaReferensi;
    private String jenisReferensi;
    private String kontakMitraLokal;
    private String katalogKemasan;

    public Advisory(String idAdvisory, String namaReferensi, String jenisReferensi, String kontakMitraLokal, String katalogKemasan) {
        this.idAdvisory = idAdvisory;
        this.namaReferensi = namaReferensi;
        this.jenisReferensi = jenisReferensi;
        this.kontakMitraLokal = kontakMitraLokal;
        this.katalogKemasan = katalogKemasan;
    }

    public void tampilKatalogAdvisory() {
        System.out.println("Menampilkan katalog advisory: " + namaReferensi);
    }
}
