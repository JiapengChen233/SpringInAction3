package com.cjp.spitter.persistence;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcSpitterDao extends SimpleJdbcDaoSupport implements SpitterDao {

    private static final String SQL_INSERT_SPITTER = "insert into spitter(username, password, fullname, email, update_by_email) values(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username=?, password=?, fullname=?, email=? where id=?";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname, email from spitter";
    private static final String SQL_SELECT_SPITTER_BY_ID = SQL_SELECT_SPITTER + " where id=?";

    @Override
    public void addSpitter(Spitter spitter) {
        getSimpleJdbcTemplate().update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
        spitter.setId(queryForIdentity());
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        getSimpleJdbcTemplate().update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.getId());
    }

    @Override
    public Spitter getSpitterById(long id) {
        return getSimpleJdbcTemplate().queryForObject(SQL_SELECT_SPITTER_BY_ID, new ParameterizedRowMapper<Spitter>() {
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
        return getSimpleJdbcTemplate().query(SQL_SELECT_SPITTER, new ParameterizedRowMapper<Spitter>() {
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
        return null;
    }

    private long queryForIdentity() {
        return getSimpleJdbcTemplate().queryForLong("CALL IDENTITY()");
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return null;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
    }

    @Override
    public List<Spittle> getSpittlesByUsername(Spitter spitter) {
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
