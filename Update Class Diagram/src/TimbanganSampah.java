public class TimbanganSampah {
    private String idTimbangan;
    private Event event;
    private float beratOrganik;
    private float beratDaurUlang;
    private float beratResidu;
    private String fotoBukti;

    
    TimbanganSampah(String idTimbangan, Event event) {
        this.idTimbangan = idTimbangan;
        this.event = event;
    }

    public void inputBerat(float organik, float daurUlang, float residu) {
        if (organik < 0 || daurUlang < 0 || residu < 0) {
            throw new IllegalArgumentException("Berat tidak boleh negatif");
        }
        this.beratOrganik = organik;
        this.beratDaurUlang = daurUlang;
        this.beratResidu = residu;
    }

    public void uploadFoto(String pathFoto) {
        this.fotoBukti = pathFoto;
    }

    public boolean isValid() {
        return fotoBukti != null && !fotoBukti.isBlank() && getTotal() > 0;
    }

    public float getTotal() { return beratOrganik + beratDaurUlang + beratResidu; }
    public String getIdTimbangan() { return idTimbangan; }
    public float getBeratOrganik() { return beratOrganik; }
    public float getBeratDaurUlang() { return beratDaurUlang; }
    public float getBeratResidu() { return beratResidu; }
    public String getFotoBukti() { return fotoBukti; }
}
