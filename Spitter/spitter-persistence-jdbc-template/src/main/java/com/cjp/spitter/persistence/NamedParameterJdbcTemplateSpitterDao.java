package com.cjp.spitter.persistence;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamedParameterJdbcTemplateSpitterDao implements SpitterDao {

    private static final String SQL_INSERT_SPITTER = "insert into spitter(username, password, fullname, email, update_by_email) values(:username, :password, :fullname, :email, :updateByEmail)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username=:username, password=:password, fullname=:fullname, email=:email where id=:id";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname, email from spitter";
    private static final String SQL_SELECT_SPITTER_BY_ID = SQL_SELECT_SPITTER + " where id=?";

    private SimpleJdbcTemplate simpleJdbcTemplate;

    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return simpleJdbcTemplate;
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    public void addSpitter(Spitter spitter) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", spitter.getUsername());
        params.put("password", spitter.getPassword());
        params.put("fullname", spitter.getFullName());
        params.put("email", spitter.getEmail());
        params.put("updateByEmail", spitter.isUpdateByEmail());
        simpleJdbcTemplate.update(SQL_INSERT_SPITTER, params);
        spitter.setId(queryForIdentity());
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", spitter.getUsername());
        params.put("password", spitter.getPassword());
        params.put("fullname", spitter.getFullName());
        params.put("email", spitter.getEmail());
        params.put("id", spitter.getId());
        simpleJdbcTemplate.update(SQL_UPDATE_SPITTER, params);
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
    public List<Spittle> getSpittlesByUsername(Spitter spitter) {
        return null;
    }

    private long queryForIdentity() {
        return simpleJdbcTemplate.queryForLong("CALL IDENTITY()");
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return null;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return null;
    }

    @Override
    public void deleteSpittle(long id) {
    }

    @Override
    public Spittle getSpittleById(long id) {
        return null;
    }
}
