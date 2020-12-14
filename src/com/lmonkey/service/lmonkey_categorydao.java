package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEYUSER;
import com.lmonkey.entity.LmonkeyCate;


public class lmonkey_categorydao {
	public static ArrayList<LmonkeyCate>selectAll()
	{
		ArrayList<LmonkeyCate> list = new ArrayList<LmonkeyCate>();
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql = "select * from lmonkey_category ";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			
			
				
			
			
			while(rs.next()){
				LmonkeyCate u = new LmonkeyCate(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
						
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
	//插入分类
	public static int insert(LmonkeyCate u){
		String sql = "insert into lmonkey_category values(null, ?, ?)";
		
		Object[] parmas = {
				u.getCATE_NAME(),
				u.getCATE_PARENT_ID()
				};
		return Basedao.exectuIUD(sql, parmas);
	}
	
	public static LmonkeyCate selectById(int id)
	{
		LmonkeyCate u = null;
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql ="select * from lmonkey_category  where CATE_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
		
			rs = ps.executeQuery();
			while(rs.next()){
				 u = new LmonkeyCate(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
						);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		 
		return u;
		
	}
	public static int update(LmonkeyCate u){
		String sql = "update lmonkey_category set CATE_NAME=?,CATE_PARENT_ID=? where CATE_ID=?";
		
		Object[] parmas = {
				u.getCATE_NAME(),
				u.getCATE_PARENT_ID(),
				u.getCATE_ID()
				};
		return Basedao.exectuIUD(sql, parmas);
	}
	public static int Del(int id){
		String sql = "delete from lmonkey_category where CATE_ID=?";
		Object[] parmas = {id};
		return Basedao.exectuIUD(sql, parmas);
		
	}
	//查询分类,子分类父分类
	public static ArrayList<LmonkeyCate>selectCate(String flag)
	{
		ArrayList<LmonkeyCate> list = new ArrayList<LmonkeyCate>();
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql = null;
			if(flag!=null && flag.equals("father")){
				sql = "select * from lmonkey_category where CATE_PARENT_ID=0";
			}
			else{
				sql = "select * from lmonkey_category where CATE_PARENT_ID!=0";
			}

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			
			
				
			
			
			while(rs.next()){
				LmonkeyCate u = new LmonkeyCate(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
						
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
