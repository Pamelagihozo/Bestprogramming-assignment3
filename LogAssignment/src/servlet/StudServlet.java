package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class StudServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	private static final Logger logger = LogManager.getLogger(StudServlet.class);
	
    public StudServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("Insert get Method");
		String theId = request.getParameter("id");
		if(theId == null || !theId.matches("\\d+")) {
			response.sendRedirect("studentForm.html");
			logger.error("Invalid Id");
			response.getWriter().print("<h1>Id Invalid</h1>");
			return;
		}		
		Integer id = Integer.parseInt(theId);
		try {
			String db_url = "jdbc:postgresql://localhost:5432/auca";
			String username = "postgres";
			String password = "";	
	
			Class.forName("org.postgresql.Driver");
			logger.info("Loaded postgresql driver");
			Connection con = DriverManager.getConnection(db_url,username,password);
			
			PreparedStatement pst =con.prepareStatement("select * from students where id = ?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				String lname = rs.getString("lname");

				logger.info("Name is "+lname+" and Id is "+id);
				response.getWriter().print("<h1>The name is "+lname+" and Id is "+id+"</h1>");
			}
			else {
				logger.info("Inserted id does not exist");
				response.getWriter().print("<h1>Invalid Id</h1>");
			}
			
		} catch (SQLException e) {
			logger.error("SQL exceptions caught : database connection failed: "+e);
			e.printStackTrace(response.getWriter());
		} catch (ClassNotFoundException e) {
			logger.error("classes were not found"+e);
			response.getWriter().print(e);
//			e.printStackTrace(response.getWriter());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Entered Post Method");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		if(!id.matches("\\d+")) {
			logger.warn("invalid id");
			response.getWriter().print("<h1>Id must be an integer</h1>");
			response.sendRedirect("studentForm.html");
			return;
		}
		else {
			Integer theId = Integer.parseInt(id);
			try {
				String db_url = "jdbc:postgresql://localhost:5432/auca";
				String username = "postgres";
				String password = "";			
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection(db_url,username,password);
				PreparedStatement pst =con.prepareStatement("insert into students(id,lname) values(?,?)");
				pst.setInt(1, theId);
				pst.setString(2, name);
				int rowsAffected = pst.executeUpdate();
				if(rowsAffected !=0) {		
					logger.info("Inserted data in databse");
					response.getWriter().print("<h1>Inserted success</h1>");
				}
				else {
					logger.error("Insert in database falied");
					response.getWriter().print("<h1>Inserted Failed</h1>");
				}
								
			} catch (SQLException e) {
				logger.error("SQL exceptions caught : connection to db failed: "+e);

			} catch (ClassNotFoundException e) {
				logger.error("Some class was not found"+e);

			}
		}
		
	}

}
