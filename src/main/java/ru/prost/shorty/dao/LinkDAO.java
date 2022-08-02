package ru.prost.shorty.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.prost.shorty.links.CreatorShortLink;
import ru.prost.shorty.links.Link;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;



@Component
public class LinkDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LinkDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Link> index() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(Link.class));
    }

    public Link show(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", new BeanPropertyRowMapper<>(Link.class), id).
                stream().findAny().orElse(null);
    }

    public Link redirect(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", new BeanPropertyRowMapper<>(Link.class), id).
                stream().findAny().orElse(null);
    }

    public void save(Link link) {
        String shortLink = CreatorShortLink.cutLink(link.getLongLink());
        jdbcTemplate.update("INSERT INTO users (longLink, shortLink, date) VALUES(?, ?, ?)", link.getLongLink(), shortLink, LocalDate.now());
    }

//    public void update(int id, Link updatedLink) {
//        jdbcTemplate.update("UPDATE users SET longLink=?, shortLink=? WHERE id=?", updatedLink.getLongLink(), updatedLink.getShortLink(), id);
//    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);

    }

//    public void cut(int id, Link uplongLink){
//        jdbcTemplate.update("UPDATE users SET shortLink=? WHERE id=?", CreatorShortLink.cutLink(uplongLink.getLongLink()), id);
//    }
}
