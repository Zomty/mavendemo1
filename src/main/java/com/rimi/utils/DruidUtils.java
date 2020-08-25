package com.rimi.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;
    private static Properties ps;
    private static InputStream in;

    static {
        in = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        ps = new Properties();
        try {
            ps.load(in);
            ds = DruidDataSourceFactory.createDataSource(ps);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
