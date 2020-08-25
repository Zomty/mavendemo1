package com.rimi.dao.Impl;

import com.rimi.bean.Student;
import com.rimi.dao.UserDao;
import com.rimi.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public List<Student> getUserListDao(HashMap<String, Object> param) {
        String sql = "select * from student limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<>(Student.class),param.get("page"),param.get("limit"));
    }

    @Override
    public int getUsersCountWithParamDao(HashMap<String, Object> param) {
        // 根据条件查询复合条件的所有数据条数
        StringBuilder sql = new StringBuilder("select count(*) from student where 1=1 ");
        // 创建的集合，用来保存字段对应的参数
        ArrayList<Object> paramValues = getSQLWithParam(param, sql);
        // 返回获取的条数
        return template.queryForObject(sql.toString(),paramValues.toArray(),Integer.class);
    }

    @Override
    public void deleteUserWithIdDao(String uid) {
        String sql = "delete from student where id=?";
        template.update(sql, uid);
    }

    @Override
    public boolean addUserDao(ArrayList<String> datas) {
        String sql = "insert into student (sname,gender,score,classname,img) values(?,?,?,?,null)";
        int update = template.update(sql,datas.toArray());
        return update > 0;
    }

    private ArrayList<Object> getSQLWithParam(Map<String, Object> param, StringBuilder sql) {
        ArrayList<Object> values = new ArrayList<>();
        // 名称、分类、日期
        for (String key : param.keySet()) {
            // 根据key获取值
            Object value = param.get(key);
            switch (key) {
                case "gname":
                case "classify":
                    sql.append(" and ").append(key).append(" like ?");
                    // 模糊查询的值需要先处理，
                    value = "%" + value + "%";
                    values.add(value);
                    break;
                // 屏蔽分页数据
                case "page":
                case "limit":
                    break;

                default:
                    sql.append(" and ").append(key).append("=?");
                    values.add(value);
                    break;
            }
        }
        return values;
    }
}
