package ru.prost.shorty.links;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.LocalDate;

public class Link {
    private int id;
    private String longLink;
    private String shortLink;
    private LocalDate date;

    public Link() {
    }

    public Link(int id, String longLink, String shortLink, LocalDate date) {
        this.id = id;
        this.longLink = longLink;
        this.shortLink = shortLink;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongLink() {
        return longLink;
    }

    public void setLongLink(String longLink) {
        this.longLink = longLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
