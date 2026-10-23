package com.example.seminar4;

public class Brad {
    double inaltime;
    double pret;
    boolean esteAdult;
    boolean areSuport;
    String tip;

    public  Brad(){};
    public Brad(double _inaltime, double _pret, boolean _esteAdult, boolean _areSuport, String _tip){
        this.inaltime=_inaltime;
        this.tip=_tip;
        this.pret=_pret;
        this.esteAdult=_esteAdult;
        this.areSuport=_areSuport;
    }

    public double getInaltime() {
        return inaltime;
    }

    public void setInaltime(double inaltime) {
        this.inaltime = inaltime;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public boolean isEsteAdult() {
        return esteAdult;
    }

    public void setEsteAdult(boolean esteAdult) {
        this.esteAdult = esteAdult;
    }

    public boolean isAreSuport() {
        return areSuport;
    }

    public void setAreSuport(boolean areSuport) {
        this.areSuport = areSuport;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Brad{" +
                "inaltime=" + inaltime +
                ", pret=" + pret +
                ", esteAdult=" + esteAdult +
                ", areSuport=" + areSuport +
                ", tip='" + tip + '\'' +
                '}';
    }
}
