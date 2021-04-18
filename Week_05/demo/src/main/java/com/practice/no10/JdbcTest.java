package com.practice.no10;

import java.sql.*;

public class JdbcTest {

    static {
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        //2. 获取数据库连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:MySQL://47.100.125.213:3306/A", "root", "123456");
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接异常" + e);
        }
        //3.获取执行sql语句的执行者对象Statement
        Statement statement = connection.createStatement();
        //4.执行sql语句,获取结果
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user_a");

//        int row = resultSet.executeUpdate("INSERT INTO user_a (name) VALUES(\"tom\")"); 新增
//        int row = resultSet.executeUpdate("DELETE FROM user_a WHERE id IN(4,5)");  删除
//        int row = resultSet.executeUpdate("UPDATE user_a SET name='Amanda' WHERE id=5");  修改

        //5.处理结果
        while(resultSet.next()){
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            System.out.println(name + "    " + age);
        }
        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void query(Connection connection) {
        try {
            String sqlTemplate = "SELECT * FROM user_a";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlTemplate);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBatch(Connection connection) {
        try {
            String sqlTemplate = "INSERT into user_a values (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlTemplate);

            for (int i = 1; i <= 10; i++) {
                preparedStatement.setLong(1,i*10);
                preparedStatement.setString(2,"Jack"+i);
                preparedStatement.setInt(3,15);
                preparedStatement.setString(4,"email"+i);
                preparedStatement.addBatch();
            }

            int[] ints = preparedStatement.executeBatch();
            //ints为新增出来的数组记录

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
