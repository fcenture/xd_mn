package com.agasa.xd_f371_v0_0_1.model;

import com.agasa.xd_f371_v0_0_1.entity.LoaiXangDau;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QDatabase {
    public void test(){
        List<LoaiXangDau> result = new ArrayList<>();


        String SQL_SELECT = "Select * from test";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/xd_f371", "postgres", "");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String id = resultSet.getString("ID");
                String maXd = resultSet.getString("name");
                String tenXD = resultSet.getString("year");
                LoaiXangDau obj = new LoaiXangDau();
                obj.setId(id);
                obj.setMaXD(maXd);
                obj.setTenXD(tenXD);
                result.add(obj);

            }
            result.forEach(x -> System.out.println(x.getMaXD()));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
