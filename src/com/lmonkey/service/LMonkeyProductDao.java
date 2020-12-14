package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LmonkeyCate;
import com.lmonkey.entity.Lmonkey_product;

public class LMonkeyProductDao {
	public static int insert(Lmonkey_product u){
		String sql = "insert into Lmonkey_product values(null, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] parmas = {
				u.getPRODUCT_NAME(),
				u.getPRODUCT_DESCRIPTION(),
				u.getPRODUCT_PRICE(),
				u.getPRODUCT_STOCK(),
				u.getPRODUCT_FID(),
				u.getPRODUCT_CID(),
				u.getPRODUCT_FILENAME()};
		return Basedao.exectuIUD(sql, parmas);
	}
	public static ArrayList<Lmonkey_product>selectAll()
	{
		ArrayList<Lmonkey_product> list = new ArrayList<Lmonkey_product>();
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql = "select * from Lmonkey_product ";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			
			
				
			
			
			while(rs.next()){
				Lmonkey_product u = new Lmonkey_product(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getInt("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		 
		return list;
		
	}
	
}
