package com.cjp.spitter.persistence;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleJdbcTemplateSpitterDao implements SpitterDao {

    private static final String SQL_INSERT_SPITTER = "insert into spitter(username, password, fullname, email, update_by_email) values(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username=?, password=?, fullname=?, email=? where id=?";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname, email from spitter";
    private static final String SQL_SELECT_SPITTER_BY_ID = SQL_SELECT_SPITTER + " where id=?";
    private static final String SQL_SELECT_SPITTER_BY_USERNAME = SQL_SELECT_SPITTER + " where username=?";
    private static final String SQL_INSERT_SPITTLE = "insert into spittle(spitter_id, text, posted_time) values(?, ?, ?)";
    private static final String SQL_DELETE_SPITTLE = "delete from spittle where id=?";
    private static final String SQL_UPDATE_SPITTLE = "update spittle set spitter_id=?, text=?, posted_time=? where id=?";
    private static final String SQL_SELECT_SPITTLE = "select id, spitter_id, text, posted_time from spittle";
    private static final String SQL_SELECT_SPITTLE_BY_ID = SQL_SELECT_SPITTLE + " where id=?";
    private static final String SQL_SELECT_SPITTLE_BY_USERNAME = SQL_SELECT_SPITTLE + " s1, spitter s2 where s1.spitter_id = s2.id and s2.username=?";


    private SimpleJdbcTemplate simpleJdbcTemplate;

    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return simpleJdbcTemplate;
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        simpleJdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
        spitter.setId(queryForIdentity());
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        simpleJdbcTemplate.update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.getId());
    }

    @Override
    public Spitter getSpitterById(long id) {
        return simpleJdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_ID, new ParameterizedRowMapper<Spitter>() {
            @Override
            public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spitter spitter = new Spitter();
                spitter.setId(rs.getLong(1));
                spitter.setUsername(rs.getString(2));
                spitter.setPassword(rs.getString(3));
                spitter.setFullName(rs.getString(4));
                spitter.setEmail(rs.getString(5));
                return spitter;
            }
        }, id);
    }

    @Override
    public List<Spitter> findAllSpitters() {
        return simpleJdbcTemplate.query(SQL_SELECT_SPITTER, new ParameterizedRowMapper<Spitter>() {
            @Override
            public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spitter spitter = new Spitter();
                spitter.setId(rs.getLong(1));
                spitter.setUsername(rs.getString(2));
                spitter.setPassword(rs.getString(3));
                spitter.setFullName(rs.getString(4));
                spitter.setEmail(rs.getString(5));
                return spitter;
            }
        }, new Object[0]);
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return simpleJdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_USERNAME, new ParameterizedRowMapper<Spitter>() {
            @Override
            public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spitter spitter = new Spitter();
                spitter.setId(rs.getLong(1));
                spitter.setUsername(rs.getString(2));
                spitter.setPassword(rs.getString(3));
                spitter.setFullName(rs.getString(4));
                spitter.setEmail(rs.getString(5));
                return spitter;
            }
        }, username);
    }

    private long queryForIdentity() {
        return simpleJdbcTemplate.queryForLong("CALL IDENTITY()");
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return simpleJdbcTemplate.query(SQL_SELECT_SPITTLE, new ParameterizedRowMapper<Spittle>() {
            @Override
            public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spittle spittle = new Spittle();
                spittle.setId(rs.getLong(1));
                Spitter spitter = getSpitterById(rs.getLong(2));
                spittle.setSpitter(spitter);
                spittle.setText(rs.getString(3));
                spittle.setPostedTime(rs.getDate(4));
                return spittle;
            }
        }, new Object[0]);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        simpleJdbcTemplate.update(SQL_UPDATE_SPITTLE,
                spittle.getSpitter().getId(),
                spittle.getText(),
                spittle.getPostedTime(),
                spittle.getId());
    }

    @Override
    public void addSpittle(Spittle spittle) {
        simpleJdbcTemplate.update(SQL_INSERT_SPITTLE,
                spittle.getSpitter().getId(),
                spittle.getText(),
                spittle.getPostedTime());
        spittle.setId(queryForIdentity());
    }

    @Override
    public List<Spittle> getSpittlesByUsername(Spitter spitter) {
        return simpleJdbcTemplate.query(SQL_SELECT_SPITTLE_BY_USERNAME, new ParameterizedRowMapper<Spittle>() {
            @Override
            public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spittle spittle = new Spittle();
                spittle.setId(rs.getLong(1));
                Spitter spitter = getSpitterById(rs.getLong(2));
                spittle.setSpitter(spitter);
                spittle.setText(rs.getString(3));
                spittle.setPostedTime(rs.getDate(4));
                return spittle;
            }
        }, spitter.getUsername());
    }

    @Override
    public void deleteSpittle(long id) {
        simpleJdbcTemplate.update(SQL_DELETE_SPITTLE, id);
    }

    @Override
    public Spittle getSpittleById(long id) {
        return simpleJdbcTemplate.queryForObject(SQL_SELECT_SPITTLE_BY_ID, new ParameterizedRowMapper<Spittle>() {
            @Override
            public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spittle spittle = new Spittle();
                spittle.setId(rs.getLong(1));
                Spitter spitter = getSpitterById(rs.getLong(2));
                spittle.setSpitter(spitter);
                spittle.setText(rs.getString(3));
                spittle.setPostedTime(rs.getDate(4));
                return spittle;
            }
        }, id);
    }

}
