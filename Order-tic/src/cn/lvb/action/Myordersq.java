package cn.lvb.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lvb.bean.Order;
import cn.lvb.dao.OrderDAO;
import cn.lvb.dao.UserDao;
import cn.lvb.dao.impl.OrderDAOImpl;
import cn.lvb.dbutil.JdbcUtil;
import cn.lvb.impl.UserDaoImpl;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Myordersq
 */
public class Myordersq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myordersq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		OrderDAO dao = new  OrderDAOImpl();	
		List<Order> orders = dao.getAllorder();
		try {
			JSONObject json = new JSONObject();
		
			json.put("orders",JSONObject.fromObject(orders));
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
