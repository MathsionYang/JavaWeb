package com.lmonkey.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEYUSER;


public class lmonkeyuserdao {
	//增加用户
	public static int insert(LMONKEYUSER u){
		String sql = "insert into LMONKEYUSER values(?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), ?, ?, ?, ?, ?)";
		
		Object[] parmas = {
				u.getUSER_ID(),
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_PHONE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS()};
		return Basedao.exectuIUD(sql, parmas);
	}
	
	public static int update(LMONKEYUSER u){
		String sql = "update LMONKEYUSER set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d'),USER_IDENITY_CODE=?,USER_EMAIL=?,USER_PHONE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID = ?";
		
		Object[] parmas = {
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_PHONE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS(),
				u.getUSER_ID()
				};
		return Basedao.exectuIUD(sql, parmas);
	}
	
	public static int del(String id){
		String sql = "delete from LMONKEYUSER  where USER_ID=? and USER_STATUS!=2";
		Object[] parmas = {id};
	    return 	Basedao.exectuIUD(sql, parmas);
		
	}
	//获取总记录数，总页数
	public static int[] totalPage(int count ,String keyword){
		int arr[] = {0,1};
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;

		try {
			String sql ="";
			if(keyword!=null){
				sql = "select count(*) from LMONKEYUSER where USER_NAME like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}
			else{
				sql = "select count(*) from LMONKEYUSER";
				ps = conn.prepareStatement(sql);
			}
	
			rs = ps.executeQuery();
			while(rs.next()){

						arr[0] = rs.getInt(1);
						if(arr[0]%count ==0){
							arr[1] = arr[0]/count;
						}else{
							arr[1] = arr[0]/count+1;
						}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return arr;
		
		
	}
	public static ArrayList<LMONKEYUSER>selectAll(int cpage,int count,String keyword)
	{
		ArrayList<LMONKEYUSER> list = new ArrayList<LMONKEYUSER>();
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql ="";
			if(keyword!=null){
				sql = "select * from LMONKEYUSER where USER_NAME like ? order by USER_BIRTHDAY desc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
				rs = ps.executeQuery();
			}
			else{
				sql = "select * from LMONKEYUSER order by USER_BIRTHDAY desc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				LMONKEYUSER u = new LMONKEYUSER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
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
	public static LMONKEYUSER selectByID(String id)
	{
		LMONKEYUSER u = null;
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql ="select m.*,DATE_FORMAT(m.user_birthday, '%Y-%m-%d') birthday from LMONKEYUSER m where USER_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				 u = new LMONKEYUSER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("birthday"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
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
	//判断用户名是否存在
	public static int selectByName(String id){
	
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		int count = 0;
		try {
			String sql ="select count(*) from LMONKEYUSER where USER_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
	
			rs = ps.executeQuery();
			while(rs.next()){

				count = rs.getInt(1);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return count;
		
		
	}
	public static int selectByNMandPass(String Name,String Pass){
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		int count = 0;
		try {
			String sql ="select count(*) from LMONKEYUSER where USER_ID=? and USER_PASSWORD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Name);
			ps.setString(2, Pass);
	
			rs = ps.executeQuery();
			while(rs.next()){

				count = rs.getInt(1);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return count;
	}
	//通过密码与用户名查找用户
	public static LMONKEYUSER selectAdmin(String Name,String Pass){
		LMONKEYUSER u = null;
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql ="select m.*,DATE_FORMAT(m.user_birthday, '%Y-%m-%d') birthday from LMONKEYUSER m where USER_ID=? and USER_PASSWORD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Name);
			ps.setString(2, Pass);
			rs = ps.executeQuery();
			while(rs.next()){
				 u = new LMONKEYUSER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("birthday"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
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
}
