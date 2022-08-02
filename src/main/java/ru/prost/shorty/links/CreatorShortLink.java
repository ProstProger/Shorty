package ru.prost.shorty.links;

public class CreatorShortLink {

    public static String cutLink(String longLink) {
        String hashLink = "http://localhost:8080/links/" + longLink.hashCode();
        return hashLink;
    }
}
