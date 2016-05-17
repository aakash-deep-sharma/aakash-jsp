package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.dto.BookDto;
import com.utility.Utility;

public class AdminDao {

	private Connection con;
	private PreparedStatement pst,pst1,pst2,pst3,pst4;
	
	public AdminDao() {
		
	}
	
	public String getPst() throws Exception 
	{	
		System.out.println("in pst");
		pst = con.prepareStatement("select * from accounts where user_name=? and user_pass=? and user_type=?");
		pst1 = con.prepareStatement("select max(book_id) from books");
		pst2 = con.prepareStatement("insert into books values(?,?,?,?)");
		pst3 = con.prepareStatement("select * from books");
		pst4 = con.prepareStatement("delete from books where book_id=?");
		return "sucess";
	}
	
	
	

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	public String addBook(int maxId,String bName,String bAuthor,double bPrice) throws SQLException
	{
		pst2.setInt(1, maxId+1);
		pst2.setString(2, bName);
		pst2.setString(3, bAuthor);
		pst2.setDouble(4, bPrice);
		int res =pst2.executeUpdate();
		
		if(res == 1)
			return "Book Added Successfully";
		else
			return "Book Not Added";
	}
	
	public int maxBookId() throws SQLException
	{
		int maxId=1;
		ResultSet rs = pst1.executeQuery();
		System.out.println("pst1");
		if(rs.next())
			maxId = rs.getInt(1);
		return maxId;
	}
	public List<BookDto> getBooks() throws SQLException
	{
		
		List<BookDto> list = new LinkedList<BookDto>(); 
		ResultSet rst = pst3.executeQuery();
		System.out.println("show book starts");
		while(rst.next())
		{
			System.out.println("in while");
			
			BookDto b = new BookDto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
			list.add(b);
			
		}
		System.out.println("show book ends"+list);
		return list;
	}
	
	public String deleteBook(String[] ids)throws SQLException
	{
		
		for(int i =0;i<ids.length;i++)
		{
			int id = Integer.parseInt(ids[i]);
			pst4.setInt(1, id);
			pst4.executeUpdate();
		}
		
		return "sucsess";
	}
	
	
	
}