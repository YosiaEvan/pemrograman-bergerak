package com.example.aplikasifieldtrip;

public class DataMahasiswa {
    private String namaMhs;
    private String nimMhs;
    private String noHPMhs;
    private String noMakanMhs;
    private int id;

    // membuat beberapa fungsi getter dan setter
    public String getNamaMhs() {
        return namaMhs;
    }
    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }
    public String getNimMhs() {
        return nimMhs;
    }
    public void setNimMhs(String nimMhs) {
        this.nimMhs = nimMhs;
    }
    public String getNoHPMhs() {
        return noHPMhs;
    }
    public void setNoHPMhs(String noHPMhs) {
        this.noHPMhs = noHPMhs;
    }
    public String getNoMakanMhs() {
        return noMakanMhs;
    }
    public void setNoMakanMhs(String noMakanMhs) {
        this.noMakanMhs = noMakanMhs;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // membuat constructor dari data mahasiswa
    public DataMahasiswa(String namaMhs, String nimMhs, String noHPMhs, String noMakanMhs) {
        this.namaMhs = namaMhs;
        this.nimMhs = nimMhs;
        this.noHPMhs = noHPMhs;
        this.noMakanMhs = noMakanMhs;
    }
}
