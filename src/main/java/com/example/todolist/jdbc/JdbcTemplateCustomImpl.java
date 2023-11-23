package com.example.todolist.jdbc;

import com.example.todolist.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class JdbcTemplateCustomImpl implements JdbcTemplateCustom {

    private final static String INSERT_BATCH = """
            INSERT INTO users (email)
            VALUES (?)
            """;

    private final static String DELETE_BATCH = """
            DELETE FROM users
            WHERE id =:ids
            """;

    private final static String SELECT_BATCH = """
            SELECT u.id, u.email
            FROM users u
            """;

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate jdbcTemplateNamed;

    @Override
    public int insertBatch(User... users) {
        List<Object[]> objects = Arrays.stream(users).map(usr -> new Object[]{
                usr.getEmail()
        }).toList();
        return jdbcTemplate.batchUpdate(INSERT_BATCH, objects).length;
    }

    @Override
    public int deleteBatch(Long... ids) {
        MapSqlParameterSource[] mapQuery = Arrays.stream(ids).map(usr -> Map.of(
                        "ids", usr
                )).map(MapSqlParameterSource::new)
                .toArray(MapSqlParameterSource[]::new);


        return jdbcTemplateNamed.batchUpdate(DELETE_BATCH, mapQuery).length;
    }

    @Override
    public List<User> selectBatch() {
        return jdbcTemplate.query(SELECT_BATCH, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return User.builder()
                        .id(rs.getLong("id"))
                        .email(rs.getString("email"))
                        .build();
            }
        });
    }


}
