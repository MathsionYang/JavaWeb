package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.IMAGESTICHING;


public class IMAGESTICHINGDAO {
	public static int insert(IMAGESTICHING img){
		
		String sql = "insert into IMAGESTICHING values(null, ?, ?, ?, ?,?)";
		
		Object[] parmas = {
				
				img.getIMAGE_ONE_FILE(),
				img.getIMAGE_ONE_DESCRIPTION(),
				img.getIMAGE_TWO_FILE(),
				img.getIMAGE_TWO_DESCRIPTION(),
				img.getIMAGE_RESULT()
				
				};
		
		return Basedao.exectuIUD(sql, parmas);
	}
	public static ArrayList<IMAGESTICHING>selectAll()
	{
		ArrayList<IMAGESTICHING> imglist = new ArrayList<IMAGESTICHING>();
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql = "select * from IMAGESTICHING ";
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
			
			
				
			
			
			while(rs.next()){
				IMAGESTICHING u = new IMAGESTICHING(
						rs.getInt("IMAGE_ID"),
						rs.getString("IMAGE_ONE_FILE"),
						rs.getString("IMAGE_ONE_DESCRIPTION"),
						rs.getString("IMAGE_TWO_FILE"),
						rs.getString("IMAGE_TWO_DESCRIPTION"),
						rs.getString("IMAGE_RESULT")
						);
				imglist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		 
		return imglist;
		
	}
	public static int Del(int id){
		String sql = "delete from IMAGESTICHING where IMAGE_ID=?";
		Object[] parmas = {id};
		return Basedao.exectuIUD(sql, parmas);
		
	}
	//获取影像总记录
	public static int[] totalPage(int count){
		int arr[] = {0,1};
		ResultSet rs =null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps =null;

		try {
			String sql = "select count(*) from LMONKEYUSER";
			ps = conn.prepareStatement(sql);
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
}
