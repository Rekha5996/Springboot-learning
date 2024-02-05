package com.rest.webservices.learning.rest.Exceptions;

import java.time.LocalDate;

public class ErrorDetails {

    private LocalDate etimestamp;
    private String emsg;
    private String edes;

    public LocalDate getEtimestamp() {
        return etimestamp;
    }

    public void setEtimestamp(LocalDate etimestamp) {
        this.etimestamp = etimestamp;
    }

    public String getEmsg() {
        return emsg;
    }

    public void setEmsg(String emsg) {
        this.emsg = emsg;
    }

    public String getEdes() {
        return edes;
    }

    public void setEdes(String edes) {
        this.edes = edes;
    }

    public ErrorDetails(LocalDate etimestamp, String emsg, String edes) {
        this.etimestamp = etimestamp;
        this.emsg = emsg;
        this.edes = edes;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "etimestamp=" + etimestamp +
                ", emsg='" + emsg + '\'' +
                ", edes='" + edes + '\'' +
                '}';
    }
}
