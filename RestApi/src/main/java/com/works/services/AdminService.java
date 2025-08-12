package com.works.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class AdminService {

    final private DB db;

    public boolean login(String username, String password) {
        String sql = "select * from admin where username=? and password=? ";
        try {
            PreparedStatement st = db.getDataSource().getConnection().prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            return rs.next();
        }catch (Exception ex){
            return false;
        }
    }

}
