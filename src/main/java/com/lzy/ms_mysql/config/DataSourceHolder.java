package com.lzy.ms_mysql.config;

public class DataSourceHolder {
    public static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    public static void putDataSource(String dataSource) {
        HOLDER.set(dataSource);
    }

    public static String getDataSource() {
        return HOLDER.get();
    }

    public static void clearDataSourceType(){
        HOLDER.remove();
    }
}
