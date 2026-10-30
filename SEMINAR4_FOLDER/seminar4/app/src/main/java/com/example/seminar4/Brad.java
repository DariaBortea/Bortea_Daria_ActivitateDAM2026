package com.example.seminar4;

import java.io.Serializable;

public class Brad implements Serializable {
    private double inaltime;
    private double pret;
    private boolean esteAdult;
    private boolean areSuport;
    private String tip;
    private boolean artificial;
    private float rating;

    public Brad() {}

    public Brad(double inaltime, double pret, boolean esteAdult, boolean areSuport,
                String tip, boolean artificial, float rating) {
        this.inaltime = inaltime;
        this.pret = pret;
        this.esteAdult = esteAdult;
        this.areSuport = areSuport;
        this.tip = tip;
        this.artificial = artificial;
        this.rating = rating;
    }

    public double getInaltime() { return inaltime; }
    public void setInaltime(double inaltime) { this.inaltime = inaltime; }
    public double getPret() { return pret; }
    public void setPret(double pret) { this.pret = pret; }
    public boolean isEsteAdult() { return esteAdult; }
    public void setEsteAdult(boolean esteAdult) { this.esteAdult = esteAdult; }
    public boolean isAreSuport() { return areSuport; }
    public void setAreSuport(boolean areSuport) { this.areSuport = areSuport; }
    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }
    public boolean isArtificial() { return artificial; }
    public void setArtificial(boolean artificial) { this.artificial = artificial; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Brad{" +
                "inaltime=" + inaltime +
                ", pret=" + pret +
                ", esteAdult=" + esteAdult +
                ", areSuport=" + areSuport +
                ", tip='" + tip + '\'' +
                ", artificial=" + artificial +
                ", rating=" + rating +
                '}';
    }
}
//seminar 5