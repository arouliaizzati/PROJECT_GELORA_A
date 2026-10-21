public class TimbanganSampah {
    private String idTimbangan;
    private String idEvent;
    private float beratOrganik;
    private float beratDaurUlang;
    private float beratResidu;
    private String fotoBukti;

    public TimbanganSampah(String idTimbangan, String idEvent) {
        this.idTimbangan = idTimbangan;
        this.idEvent = idEvent;
    }

    public void inputBerat(float organik, float daurUlang, float residu) {
        this.beratOrganik = organik;
        this.beratDaurUlang = daurUlang;
        this.beratResidu = residu;
        System.out.println("Berat timbangan sampah dicatat.");
    }

    public void uploadFoto(String fotoBukti) {
        this.fotoBukti = fotoBukti;
        System.out.println("Foto bukti timbangan berhasil diunggah.");
        
    }

    public float getTotal() { return beratOrganik + beratDaurUlang + beratResidu; }
    public String getIdTimbangan() { return idTimbangan; }
    public float getBeratOrganik() { return beratOrganik; }
    public float getBeratDaurUlang() { return beratDaurUlang; }
    public float getBeratResidu() { return beratResidu; }
    public String getFotoBukti() { return fotoBukti; }

}
