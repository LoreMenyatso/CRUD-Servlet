	package com.awd.project.model.controller;
	
	import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.awd.project.model.BEANS.Advisor;
import com.awd.project.model.BEANS.Company;
import com.awd.project.model.BEANS.Expert;
import com.awd.project.model.BEANS.Graduate;
import com.awd.project.model.BEANS.Professional;
import com.awd.project.model.BEANS.Undergraduate;
import com.awd.project.model.DAO.AdminDBUtil;




@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AdminDBUtil AdminDBUtil;
	
	@Resource(name="jdbc/admin")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException 
	{
		super.init();
		// create our student db util ... and pass in the conn pool / datasource
		try 
		{
			AdminDBUtil = new AdminDBUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	public ControllerServlet() {
		super();
	}

	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//list the students in mvc fashion
		try {
			String theCommand=request.getParameter("command");
			
			if(theCommand==null) {
				theCommand="listAdvisors";
			}
			switch(theCommand) {
			///////////////////////////////ADVISORS//////////////////////////////////////////
			case "listAdvisors":listAdvisor(request,response);
			break;
			case "searchAdvisors":searchAdvisor(request,response);
			break;
			case "deleteAdvisors":deleteAdvisor(request,response);
			break;
			case "updateAdvisors":updateAdvisor(request,response);
			break;
			case "loadAdvisors":loadAdvisor(request,response);
			break;
			case "addAdvisors":addAdvisor(request,response);
			break;
			///////////////////////////////UNDERGRADS//////////////////////////////////////////
			case "listUndergraduates":listUndergraduate(request,response);
			break;
			case "addUndergraduates":addUndergraduate(request,response); /// re do the methods
			break;
			case "deleteUndergraduates":deleteUndergraduate(request,response);
			break;
			case "updateUndergraduates":updateUndergraduate(request,response); /// re do the methods.
			break;
			case "loadUndergraduates":loadUndergraduate(request,response);
			break;
			///////////////////////////////COMPANIES/////////////////////////////////////////
			case "listCompanys":listCompany(request,response);
			break;
			case "searchCompanys":searchCompany(request,response);
			break;
			case "deleteCompanys":deleteCompany(request,response);
			break;
			case "updateCompanys":updateCompany(request,response);
			break;
			case "loadCompanys":loadCompany(request,response);
			break;
			case "addCompanys":addCompany(request,response);
			break;
            /////////////////////////////////GRADUATES/////////////////////////////////////////
			case "listGraduates":listGraduate(request,response);
			break;
			case "deleteGraduates":deleteGraduate(request,response);
			break;
			case "addGraduates":addGraduate(request,response);
			break;
			case "updateGraduates":updateGraduate(request,response);
			break;
			case "loadGraduates":loadGraduate(request,response);
			break;
			case "searchGraduates":searchGraduate(request,response);
			break;
			/////////////////////////////////PROFESSIONALS/////////////////////////////////////////
			case "listProfessionals":listProfessional(request,response);
			break;
			case "addProfessionals":addProfessional(request,response);
			break;
			case "searchProfessionals":searchProfessional(request,response);
			break;
			/////////////////////////////////////////////////EXPERTS////////////////////////////
			case "listExperts":listExpert(request,response);
			break;
			case "addExperts":addExpert(request,response);
			break;
			case "searchExperts":searchExpert(request,response);
			break;
			
			

			}
			
		}
		
		catch(Exception exc) {
			exc.printStackTrace();	
		}	
	}
	
	private void searchExpert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theSearchName = request.getParameter("theSearchName");
		
		//search from the DButil helper class
		List<Expert> experts = AdminDBUtil.searchExperts(theSearchName);
		
		//add students to the request
		request.setAttribute("EXPERT_LIST", experts);
		
		//send JSP to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Experts.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addExpert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String qualifications=request.getParameter("qualifications");
		String expertise=request.getParameter("expertise");
		String email=request.getParameter("email");
		
		Expert theExpert=new Expert(0, firstName,lastName,qualifications,expertise,email);
		AdminDBUtil.addExpert(theExpert);
		listExpert(request,response);
		
	}

	private void listExpert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			List<Expert> experts = AdminDBUtil.getExpert();
	        
	        //add students to the request
	        request.setAttribute("EXPERT_LIST", experts);
	        
	        //send to JSP page(view)
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Experts.jsp");
	        dispatcher.forward(request, response);
		
	}

	private void searchProfessional(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		
        List<Professional> professionals = AdminDBUtil.getProfessional();
        
        //add students to the request
        request.setAttribute("PROFESSIONAL_LIST", professionals);
        
        //send to JSP page(view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Professionals.jsp");
        dispatcher.forward(request, response);
	}

	private void addProfessional(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String profession=request.getParameter("profession");
		String experience=request.getParameter("experience");
		String project=request.getParameter("project");
		String email=request.getParameter("email");
		
		Professional theProfessional=new Professional(0, firstName,lastName,profession,experience,project,email);
		AdminDBUtil.addProfessional(theProfessional);
		listProfessional(request,response);
		
	}

	private void listProfessional(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//get students from the database(DB) util
        List<Professional> professionals = AdminDBUtil.getProfessional();
        
        //add students to the request
        request.setAttribute("PROFESSIONAL_LIST", professionals);
        
        //send to JSP page(view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Professionals.jsp");
        dispatcher.forward(request, response);
		
	}

	private void searchGraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theSearchName = request.getParameter("theSearchName");
		
		//search from the DButil helper class
		List<Graduate> graduates = AdminDBUtil.searchGraduates(theSearchName);
		
		//add students to the request
		request.setAttribute("GRADUATE_LIST", graduates);
		
		//send JSP to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Graduates.jsp");
		dispatcher.forward(request, response);
		
	}

	private void loadGraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String  theGraduateId=request.getParameter("graduateId");
		Graduate theGraduate =AdminDBUtil.getGraduate(theGraduateId);
		request.setAttribute("THE_GRADUATE",theGraduate);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Update-graduate-form1.jsp");
		dispatcher.forward(request, response);
	}

	private void updateGraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id=Integer.parseInt(request.getParameter("graduateId"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String expertise=request.getParameter("expertise");
		String experience=request.getParameter("experience");
		String education=request.getParameter("education");
		String email=request.getParameter("email");
		
		Graduate theGraduate =new Graduate(id,firstName,lastName,expertise,experience,education,email);
		AdminDBUtil.updateGraduate(theGraduate);
		listGraduate(request,response);
		
	}

	private void addGraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
				String firstName=request.getParameter("firstName");
				String lastName=request.getParameter("lastName");
				String expertise=request.getParameter("expertise");
				String experience=request.getParameter("experience");
				String education=request.getParameter("education");
				String email=request.getParameter("email");
				
				Graduate theGraduate=new Graduate(0, firstName,lastName,expertise,experience,education,email);
				AdminDBUtil.addGraduate(theGraduate);
				listGraduate(request,response);
		
	}

	private void deleteGraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
			
			String theGraduateId=request.getParameter("graduateId");
			String theGraduateId2=request.getParameter("first_name");
			System.out.println("this is: "+theGraduateId+"name is :"+theGraduateId2);
			AdminDBUtil.deleteGraduate(theGraduateId);
			listGraduate(request,response);
		}


	private void listGraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get students from the database(DB) util
        List<Graduate> graduates = AdminDBUtil.getGraduate();
        
        //add students to the request
        request.setAttribute("GRADUATE_LIST", graduates);
        
        //send to JSP page(view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Graduates.jsp");
        dispatcher.forward(request, response);
		
	}

	private void addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName=request.getParameter("firstName");
		String status=request.getParameter("status");
		String activities=request.getParameter("activities");
		String profile=request.getParameter("profile");
		String employers=request.getParameter("employers");
		String email=request.getParameter("email");
		
		Company theCompany=new Company(0, firstName,status,activities,profile,employers,email);
		AdminDBUtil.addCompany(theCompany);
		listCompany(request,response);
		
	}

	private void updateCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//the requested parameter is parsed as string and returns an integer.
		int id=Integer.parseInt(request.getParameter("companyId"));
		
		String firstName=request.getParameter("firstName");
		String status=request.getParameter("status");
		String activities=request.getParameter("activities");
		String profile=request.getParameter("profile");
		String employers=request.getParameter("employers");
		String email=request.getParameter("email");
		
		Company theCompany=new Company(id,firstName,status,activities,profile,employers,email);
		AdminDBUtil.updateCompany(theCompany);
		listCompany(request,response);
		
	}

	private void loadCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String  theCompanyId=request.getParameter("companyId");
		Company theCompany=AdminDBUtil.getCompany(theCompanyId);
		request.setAttribute("THE_COMPANY",theCompany);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Update-company-form1.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theCompanyId=request.getParameter("companyId");
		String theCompanyId2=request.getParameter("first_name");
		System.out.println("this is: "+theCompanyId+"name is :"+theCompanyId2);
		AdminDBUtil.deleteCompany(theCompanyId);
		listCompany(request,response);
	}

	private void searchCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theSearchName = request.getParameter("theSearchName");
		
		//search from the DButil helper class
		List<Company> companys = AdminDBUtil.searchCompanys(theSearchName);
		
		//add students to the request
		request.setAttribute("COMPANY_LIST", companys);
		
		//send JSP to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Companys.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get students from the database(DB) util
        List<Company> companys = AdminDBUtil.getCompany();
        
        //add students to the request
        request.setAttribute("COMPANY_LIST", companys);
        
        //send to JSP page(view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Companys.jsp");
        dispatcher.forward(request, response);
	}

	private void loadUndergraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String  theUndergraduateId=request.getParameter("UndergraduateId");
		Undergraduate theUndergraduate=AdminDBUtil.getUndergraduate(theUndergraduateId);
		request.setAttribute("THE_UNDERGRADUATE",theUndergraduate);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Update-undergraduate-form1.jsp");
		dispatcher.forward(request, response);
		
	}

	private void updateUndergraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id=Integer.parseInt(request.getParameter("UndergraduateId"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String expertise=request.getParameter("expertise");
		String experience=request.getParameter("experience");
		String email=request.getParameter("email");
		
		Undergraduate theUndergraduate=new Undergraduate(id,firstName,lastName,expertise,experience,email);
		AdminDBUtil.updateUndergraduate(theUndergraduate);
		listUndergraduate(request,response);
		
	}

	private void deleteUndergraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theUndergraduateId=request.getParameter("UndergraduateId");
		String theUndergraduateId2=request.getParameter("first_name");
		System.out.println("this is: "+theUndergraduateId+"name is :"+theUndergraduateId2);
		AdminDBUtil.deleteUndergraduate(theUndergraduateId);
		listUndergraduate(request,response);
		
	}

	private void addUndergraduate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String expertise=request.getParameter("expertise");
		String experience=request.getParameter("experience");
		String email=request.getParameter("email");
		
		Undergraduate theUndergraduate =new Undergraduate(0, firstName,lastName, expertise,experience,email);
		AdminDBUtil.addUndergraduate(theUndergraduate);
		listUndergraduate(request,response);
		
	}

	private void addAdvisor(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		Advisor theAdvisor=new Advisor(0, firstName,lastName,email);
		AdminDBUtil.addAdvisor(theAdvisor);
		listAdvisor(request,response);
		
	}

	private void loadAdvisor(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String  theAdvisorId=request.getParameter("AdvisorId");
		Advisor theAdvisor=AdminDBUtil.getAdvisor(theAdvisorId);
		request.setAttribute("THE_ADVISOR",theAdvisor);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Update-advisor-form1.jsp");
		dispatcher.forward(request, response);
		
	}

	private void updateAdvisor(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		
		int id=Integer.parseInt(request.getParameter("AdvisorId"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		Advisor theAdvisor =new Advisor (id,firstName,lastName,email);
		AdminDBUtil.updateAdvisor (theAdvisor );
		listAdvisor(request,response);
		
	}

	private void deleteAdvisor(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		String theAdvisorId=request.getParameter("AdvisorId");
		String theAdvisorId2=request.getParameter("firstName");
		System.out.println("this is: "+theAdvisorId+" name is: "+theAdvisorId2);
		AdminDBUtil.deleteAdvisor(theAdvisorId);
		// call case listAdvisor
		listAdvisor(request,response);

	}

	private void searchAdvisor(HttpServletRequest request, HttpServletResponse response) throws Exception{
				
				// search names from data
				String theSearchName = request.getParameter("theSearchName");
				
				//search from the DButil helper class
				List<Advisor> advisors = AdminDBUtil.searchAdvisors(theSearchName);
				
				//add students to the request
				request.setAttribute("ADVISOR_LIST", advisors);
				
				//send JSP to the view
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Advisors.jsp");
				dispatcher.forward(request, response);	
				
	}

	private void listUndergraduate(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//get students from the database(DB) util
				List<Undergraduate> undergraduates = AdminDBUtil.getUndergraduates();
				
				//add students to the request //USE THIS AS PARAM IN THE JSP TO RETRIEVE
		        request.setAttribute("UNDERGRADUATE_LIST", undergraduates);
				
		      //send to JSP page(view)
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Undergraduates.jsp");
		        dispatcher.forward(request, response);
	
	}

	private void listAdvisor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
				//get students from the database(DB) util
		        List<Advisor> advisors = AdminDBUtil.getAdvisors();
		        
		        //add students to the request //USE THIS AS PARAM IN THE JSP TO RETRIEVE
		        request.setAttribute("ADVISOR_LIST", advisors);
		        
		        //send to JSP page(view)
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/list_Advisors.jsp");
		        dispatcher.forward(request, response);
		
	}
	
	
	
}

