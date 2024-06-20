	package com.awd.project.model.DAO;
	
	import java.sql.Connection;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

	
	import java.util.ArrayList;
	import java.util.List;

	
	import javax.sql.DataSource;
	
	import com.awd.project.model.BEANS.Advisor;
	import com.awd.project.model.BEANS.Company;
	import com.awd.project.model.BEANS.Expert;
	import com.awd.project.model.BEANS.Graduate;
	import com.awd.project.model.BEANS.Undergraduate;
	import com.awd.project.model.BEANS.Professional;
	


	
	public class AdminDBUtil {
		
		private DataSource dataSource;
		
	/////////// DB CONNECTOR
		public AdminDBUtil (DataSource theDataSource) 
		{
			//declare the data type data source in method AdminDBUtil
			dataSource = theDataSource;
		}
		
		
		public List<Expert> searchExperts(String theSearchName) throws Exception{
			
			List<Expert> experts = new ArrayList<>();

			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRs=null;
			
			try {
				
				myConn= dataSource.getConnection();
				
				// only search by name
				if (theSearchName !=null&& theSearchName.trim().length()>0) {
					
					//sql query
					String sql ="select * from expert where lower(first_name)like? or lower (last_name)like?";
					myStmt = myConn.prepareStatement(sql);
					String theSearchNameLike = "%" + theSearchName.toLowerCase()+ "%";
					myStmt.setString(1, theSearchNameLike);
					myStmt.setString(2, theSearchNameLike);
				}
				else {
					String sql ="select * from expert2 order by last_name";
					myStmt= myConn.prepareStatement(sql);
				}
				
				myRs=myStmt.executeQuery();
				// retrieve from result set
				while(myRs.next()) {
					int id=myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String qualifications = myRs.getString("qualifications");
					String expertise = myRs.getString("expertise");
					String email = myRs.getString("email");
					
					//create new student object
					
					Expert tempExpert= new Expert(id, firstName, lastName, qualifications, expertise, email);
					experts.add(tempExpert);
					
				}
			}
				finally {
					
					// clean jdbc objects
					close(myConn, myStmt, null);
				}
			
		
			return experts;
		
		}
		
		public void addExpert(Expert theExpert) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="insert into expert "+"(first_name,last_name,qualifications,expertise,email)"+"values(?,?,?,?,?)";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1,theExpert.getFirst_name());
				myStmt.setString(2,theExpert.getLast_name());
				myStmt.setString(3,theExpert.getQualifications());
				myStmt.setString(4,theExpert.getExpertise());
				myStmt.setString(5,theExpert.getEmail());
				
				myStmt.execute();
				
			
			} finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public List<Expert>getExpert() throws Exception{
			List<Expert> experts = new ArrayList<>();
			
			Connection myConn=null;
			Statement myStmt=null;
			ResultSet myRs=null;
			
			try {
				//get a connection
				myConn=dataSource.getConnection();
				
				//create SQL statement
				
				String sql ="select * from expert order by last_name";
				
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
			    while(myRs.next()) {
					
					//retrieve data from the result set
					int id=myRs.getInt("id");
					
					String FirstName=myRs.getString("first_name");
					String LastName=myRs.getString("last_name");
					String qualifications=myRs.getString("qualifications");
					String expertise=myRs.getString("expertise");
					String email=myRs.getString("email");
					
					//create new student object
					Expert tempExpert= new Expert(id,FirstName,LastName,qualifications,expertise,email);
					
					//add it to the List students
					experts.add(tempExpert);
					
				}
				return experts;
			}finally {
				// close JDBC objects
				
				close(myConn,myStmt,myRs);
				
			}
		}
		
		public List<Professional> searchProfessionals(String theSearchName) throws Exception{
			
			List<Professional> professionals = new ArrayList<>();

			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRs=null;
			
			try {
				
				myConn= dataSource.getConnection();
				
				// only search by name
				if (theSearchName !=null&& theSearchName.trim().length()>0) {
					
					//sql query
					String sql ="select * from professional where lower(first_name)like? or lower (profession)like?";
					myStmt = myConn.prepareStatement(sql);
					String theSearchNameLike = "%" + theSearchName.toLowerCase()+ "%";
					myStmt.setString(1, theSearchNameLike);
					myStmt.setString(2, theSearchNameLike);
				}
				else {
					String sql ="select * from professional2 order by last_name";
					myStmt= myConn.prepareStatement(sql);
				}
				
				myRs=myStmt.executeQuery();
				// retrieve from result set
				while(myRs.next()) {
					int id=myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String profession = myRs.getString("profession");
					String experience = myRs.getString("experience");
					String project = myRs.getString("project");
					String email = myRs.getString("email");
					
					//create new student object
					
					Professional tempProfessional = new Professional(id, firstName, lastName, profession, experience, project, email);
					professionals.add(tempProfessional);
					
				}
			}
				finally {
					
					// clean jdbc objects
					close(myConn, myStmt, null);
				}
			
		
			return professionals;
		
		}
		
		public void addProfessional (Professional theProfessional) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="insert into professional "+"(first_name,last_name,profession,experience,project,email)"+"values(?,?,?,?,?,?)";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1,theProfessional.getFirst_name());
				myStmt.setString(2,theProfessional.getLast_name());
				myStmt.setString(3,theProfessional.getProfession());
				myStmt.setString(4,theProfessional.getExperience());
				myStmt.setString(5,theProfessional.getProject());
				myStmt.setString(6,theProfessional.getEmail());
				
				myStmt.execute();

			
			} finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public List<Professional>getProfessional() throws Exception{
			List<Professional> professionals = new ArrayList<>();
			
			Connection myConn=null;
			Statement myStmt=null;
			ResultSet myRs=null;
			
			try {
				//get a connection
				myConn=dataSource.getConnection();
				
				//create SQL statement
				
				String sql ="select * from professional order by last_name";
				
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
				while(myRs.next()) {
					
					//retrieve data from the result set
					int id=myRs.getInt("id");
					
					String FirstName=myRs.getString("first_name");
					String LastName=myRs.getString("last_name");
					String profession=myRs.getString("profession");
					String experience=myRs.getString("experience");
					String project=myRs.getString("project");
					String email=myRs.getString("email");
					
					//create new student object
					Professional tempProfessional = new Professional(id,FirstName,LastName,profession,experience,project,email);
					
					//add it to the List students
					professionals.add(tempProfessional);
					
				}
				return professionals;
			}finally {
				// close JDBC objects
				
				close(myConn,myStmt,myRs);
				
			}
		}
		
		
		public List<Graduate> searchGraduates(String theSearchName) throws Exception{
			
			List<Graduate> graduates = new ArrayList<>();

			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRs=null;
			
			try {
				
				myConn= dataSource.getConnection();
				
				// only search by name
				if (theSearchName !=null&& theSearchName.trim().length()>0) {
					
					//sql query
					String sql ="select * from graduate where lower(first_name)like? or lower (last_name)like?";
					myStmt = myConn.prepareStatement(sql);
					String theSearchNameLike = "%" + theSearchName.toLowerCase()+ "%";
					myStmt.setString(1, theSearchNameLike);
					myStmt.setString(2, theSearchNameLike);
				}
				else {
					String sql ="select * from graduate2 order by last_name";
					myStmt= myConn.prepareStatement(sql);
				}
				
				myRs=myStmt.executeQuery();
				// retrieve from result set
				while(myRs.next()) {
					int id=myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String expertise = myRs.getString("expertise");
					String experience = myRs.getString("experience");
					String education = myRs.getString("education");
					String email = myRs.getString("email");
					
					//create new student object
					
					Graduate tempGraduate = new Graduate(id, firstName, lastName, expertise,experience,education,email);
					graduates.add(tempGraduate);
					
				}
			}
				finally {
					
					// clean jdbc objects
					close(myConn, myStmt, null);
				}
			
		
			return graduates;
		
		}
		
		public void updateGraduate(Graduate theGraduate)throws Exception{
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="update graduate "+"set first_name=?, last_name=?, expertise=?, experience=?, education=?, email=?"+" where id=?";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1, theGraduate.getFirst_name());
				myStmt.setString(2, theGraduate.getLast_name());
				myStmt.setString(3, theGraduate.getExpertise());
				myStmt.setString(4, theGraduate.getExperience());
				myStmt.setString(5, theGraduate.getEducation());
				myStmt.setString(6, theGraduate.getEmail());
				myStmt.setInt(7, theGraduate.getId());
				
				myStmt.execute();
				
			}finally {
				close(myConn,myStmt,null);
			}
		}
		
		public Graduate getGraduate(String theGraduateId) throws Exception{
			Graduate theGraduate =null;
			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRS=null;
			int graduateId;
			try {
				//convert student into int 
				graduateId=Integer.parseInt(theGraduateId);
				
				myConn=dataSource.getConnection();
				String sql="Select * from graduate where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setInt(1, graduateId);
				
				myRS=myStmt.executeQuery();
				if(myRS.next()) {
					String firstName=myRS.getString("first_name");
					String lastName=myRS.getString("last_name");
					String expertise=myRS.getString("expertise");
					String experience=myRS.getString("experience");
					String education=myRS.getString("education");
					String email=myRS.getString("email");
					
					theGraduate = new Graduate (graduateId,firstName,lastName,expertise,experience,education,email);
					
				}else {
					throw new Exception("Could not find student id "+graduateId);
				}
				
				
			}finally {
					close(myConn,myStmt,myRS);
				}
				return theGraduate;
		}
		
		public void addGraduate (Graduate theGraduate) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="insert into graduate "+"(first_name,last_name,expertise,experience,education,email)"+"values(?,?,?,?,?,?)";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1,theGraduate.getFirst_name());
				myStmt.setString(2,theGraduate.getLast_name());
				myStmt.setString(3,theGraduate.getExpertise());
				myStmt.setString(4,theGraduate.getExperience());
				myStmt.setString(5,theGraduate.getEducation());
				myStmt.setString(6,theGraduate.getEmail());
				
				myStmt.execute();
				
				
			
			} finally {
				close(myConn,myStmt,null);
			}
		}
		
		public void deleteGraduate(String theGraduateId) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				int graduateId=Integer.parseInt(theGraduateId);
				myConn=dataSource.getConnection();
				String sql="delete from graduate where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setInt(1, graduateId);
				myStmt.execute();
				
			}
			finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public List<Graduate>getGraduate() throws Exception{
			List<Graduate> graduates = new ArrayList<>();
			
			Connection myConn=null;
			Statement myStmt=null;
			ResultSet myRs=null;
			
			try {
				//get a connection
				myConn=dataSource.getConnection();
				
				//create SQL statement
				
				String sql ="select * from graduate order by last_name";
				
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
				while(myRs.next()) {
					
					//retrieve data from the result set
					int id=myRs.getInt("id");
					
					String FirstName=myRs.getString("first_name");
					String LastName=myRs.getString("last_name");
					String expertise=myRs.getString("expertise");
					String experience=myRs.getString("experience");
					String education=myRs.getString("education");
					String email=myRs.getString("email");
					
					//create new student object
					Graduate tempGraduate = new Graduate(id,FirstName,LastName,expertise,experience,education,email);
					
					//add it to the List students
					graduates.add(tempGraduate);
					
				}
				return graduates;
			}finally {
				// close JDBC objects
				
				close(myConn,myStmt,myRs);
				
			}
		}
		
		public void addCompany(Company theCompany) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="insert into company "+"(first_name,status,activities,profile,employers,email)"+"values(?,?,?,?,?,?)";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1,theCompany.getFirst_name());
				myStmt.setString(2,theCompany.getStatus());
				myStmt.setString(3,theCompany.getActivities());
				myStmt.setString(4,theCompany.getProfile());
				myStmt.setString(5,theCompany.getEmployers());
				myStmt.setString(6,theCompany.getEmail());
				
				myStmt.execute();

			} finally {
				close(myConn,myStmt,null);
			}
		}
		
		public void updateCompany(Company theCompany)throws Exception{
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="update company "+"set first_name=?, status=?,activities=?,profile=?,employers=?, email=?"+" where id=?";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1, theCompany.getFirst_name());
				myStmt.setString(2, theCompany.getStatus());
				myStmt.setString(3, theCompany.getActivities());
				myStmt.setString(4, theCompany.getProfile());
				myStmt.setString(5, theCompany.getEmployers());
				myStmt.setString(6, theCompany.getEmail());
				myStmt.setInt(7, theCompany.getId());
				
				myStmt.execute();
				
			}finally {
				close(myConn,myStmt,null);
			}
		}
		
		public Company getCompany(String theCompanyId) throws Exception{
			Company theCompany =null;
			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRS=null;
			int companyId;
			try {
				//convert student into int 
				companyId=Integer.parseInt(theCompanyId);
				
				myConn=dataSource.getConnection();
				String sql="Select * from company where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setInt(1, companyId);
				
				myRS=myStmt.executeQuery();
				if(myRS.next()) {
					String firstName=myRS.getString("first_name");
					String status =myRS.getString("status");
					String activities =myRS.getString("activities");
					String profile =myRS.getString("profile");
					String employers =myRS.getString("employers");
					String email=myRS.getString("email");
					
					theCompany=new Company(companyId,firstName,status,activities, profile, employers, email);
					
				}else {
					throw new Exception("Could not find company id "+companyId);
				}
				
				
			}finally {
					close(myConn,myStmt,myRS);
				}
				return theCompany;
		}
		
		
		public void deleteCompany(String theCompanyId) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				//  change the declared string variable 'the companyId' to an int >>'theCompanyId'
				int companyId=Integer.parseInt(theCompanyId);
				myConn=dataSource.getConnection();
				// some sql query to delete content in my data table
				String sql="delete from company where id=?";
				// prepare for execution
				myStmt=myConn.prepareStatement(sql);
				// set myStmt to integer 1 and the id 
				myStmt.setInt(1, companyId);
				//excecute the sql
				myStmt.execute();
			}
			finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public List<Company> searchCompanys(String theSearchName) throws Exception{
			
			List<Company> companys = new ArrayList<>();

			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRs=null;
			
			try {
				
				myConn= dataSource.getConnection();
				
				// only search by name
				if (theSearchName !=null&& theSearchName.trim().length()>0) {
					
					//sql query
					String sql ="select * from company where lower(first_name)like? or lower (activities)like?";
					myStmt = myConn.prepareStatement(sql);
					String theSearchNameLike = "%" + theSearchName.toLowerCase()+ "%";
					myStmt.setString(1, theSearchNameLike);
					myStmt.setString(2, theSearchNameLike);
				}
				else {
					String sql ="select * from comapny2 order by firstname_name";
					myStmt= myConn.prepareStatement(sql);
				}
				
				myRs=myStmt.executeQuery();
				// retrieve from result set
				while(myRs.next()) {
					int id=myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String status = myRs.getString("status");
					String activities = myRs.getString("activities");
					String profile = myRs.getString("profile");
					String employers = myRs.getString("employers");
					String email = myRs.getString("email");
					
					//create new student object
					
					Company tempCompany = new Company(id, firstName, status,activities,profile, employers, email);
					companys.add(tempCompany);
					
				}
			}
				finally {
					
					// clean jdbc objects
					close(myConn, myStmt, null);
				}
			
		
			return companys;
		
		}
		
		public List<Company>getCompany() throws Exception{
			List<Company> companys= new ArrayList<>();
			
			Connection myConn=null;
			Statement myStmt=null;
			ResultSet myRs=null;
			
			try {
				//get a connection
				myConn=dataSource.getConnection();
				
				//create SQL statement and defined my order by the company name
				
				String sql ="select * from company order by first_name";
				
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
				while(myRs.next()) {
					
					//retrieve data from the result set
					int id=myRs.getInt("id");
					
					String FirstName=myRs.getString("first_name");
					String status=myRs.getString("status");
					String activities=myRs.getString("activities");
					String profile=myRs.getString("profile");
					String employers=myRs.getString("employers");
					String email=myRs.getString("email");
					
					//create new student object
					Company tempCompany = new Company(id,FirstName,status,activities,profile,employers,email);
					
					//add it to the List students
					companys.add(tempCompany);
					
				}
				return companys;
			}finally {
				// close JDBC objects
				
				close(myConn,myStmt,myRs);
				
			}
		}
		
		public Undergraduate getUndergraduate(String theUndergraduateId) throws Exception{
			Undergraduate theUndergraduate =null;
			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRS=null;
			int undergraduateId;
			try {
				//convert student into int 
				undergraduateId=Integer.parseInt(theUndergraduateId);
				
				myConn=dataSource.getConnection();
				String sql="Select * from undergraduate where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setInt(1, undergraduateId);
				
				myRS=myStmt.executeQuery();
				if(myRS.next()) {
					String firstName=myRS.getString("first_name");
					String lastName=myRS.getString("last_name");
					String expertise=myRS.getString("expertise");
					String experience=myRS.getString("experience");
					String email=myRS.getString("email");
					
					theUndergraduate =new Undergraduate(undergraduateId,firstName,lastName,expertise,experience,email);
					
				}else {
					throw new Exception("Could not find student id "+undergraduateId);
				}
				
				
			}finally {
					close(myConn,myStmt,myRS);
				}
				return theUndergraduate;
		}
		
		public void updateUndergraduate(Undergraduate theUndergraduate)throws Exception{
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				String sql="update undergraduate "+"set first_name=?, last_name=?, expertise=?, experience=? email=?"+" where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setString(1, theUndergraduate.getFirst_name());
				myStmt.setString(2, theUndergraduate.getLast_name());
				myStmt.setString(3, theUndergraduate.getExpertise());
				myStmt.setString(4, theUndergraduate.getExperience());
				myStmt.setString(5, theUndergraduate.getEmail());
				myStmt.setInt(6, theUndergraduate.getId());
				
				myStmt.execute();
			}finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public void deleteUndergraduate(String theUndergraduateId) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				int undergraduateId=Integer.parseInt(theUndergraduateId);
				myConn=dataSource.getConnection();
				String sql="delete from undergraduate where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setInt(1, undergraduateId);
				myStmt.execute();
				
			}
			finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public void addUndergraduate(Undergraduate theUndergraduate) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="insert into undergraduate "+"(first_name,last_name,expertise,experience,email)"+"values(?,?,?,?,?)";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1,theUndergraduate.getFirst_name());
				myStmt.setString(2,theUndergraduate.getLast_name());
				myStmt.setString(3,theUndergraduate.getExpertise());
				myStmt.setString(4,theUndergraduate.getExperience());
				myStmt.setString(5,theUndergraduate.getEmail());
				
				myStmt.execute();
		
			} finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public void updateAdvisor(Advisor theAdvisor)throws Exception{
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				String sql="update advisor "+"set first_name=?, last_name=?, email=?"+" where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setString(1, theAdvisor.getFirst_name());
				myStmt.setString(2, theAdvisor.getLast_name());
				myStmt.setString(3, theAdvisor.getEmail());
				myStmt.setInt(4, theAdvisor.getId());
				
				myStmt.execute();
			}finally {
				close(myConn,myStmt,null);
			}
		}
		
		public void addAdvisor(Advisor theAdvisor) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				myConn=dataSource.getConnection();
				
				String sql="insert into advisor "+"(first_name,last_name,email)"+"values(?,?,?)";
				myStmt=myConn.prepareStatement(sql);
				
				myStmt.setString(1,theAdvisor.getFirst_name());
				myStmt.setString(2,theAdvisor.getLast_name());
				myStmt.setString(3,theAdvisor.getEmail());
				
				myStmt.execute();
				
			} finally {
				close(myConn,myStmt,null);
			}
		}
		
		
		public Advisor getAdvisor(String theAdvisorId) throws Exception{
			Advisor theAdvisor =null;
			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRS=null;
			int advisorId;
			try {
				//convert student into int 
				advisorId=Integer.parseInt(theAdvisorId);
				
				myConn=dataSource.getConnection();
				String sql="Select * from Advisor where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setInt(1, advisorId);
				
				myRS=myStmt.executeQuery();
				if(myRS.next()) {
					String firstName=myRS.getString("first_name");
					String lastName=myRS.getString("last_name");
					String email=myRS.getString("email");
					
					theAdvisor=new Advisor(advisorId,firstName,lastName,email);
					
				}else {
					throw new Exception("Could not find student id "+advisorId);
				}
				
				
			}finally {
					close(myConn,myStmt,myRS);
				}
				return theAdvisor;
				
				
		}
		
		public void deleteAdvisor(String theAdvisorId) throws Exception {
			Connection myConn=null;
			PreparedStatement myStmt=null;
			try {
				int advisorId=Integer.parseInt(theAdvisorId);
				myConn=dataSource.getConnection();
				String sql="delete from advisor where id=?";
				myStmt=myConn.prepareStatement(sql);
				myStmt.setInt(1, advisorId);
				myStmt.execute();
				
			}
			finally {
				close(myConn,myStmt,null);
			}
		}


		public List<Advisor> searchAdvisors(String theSearchName) throws Exception{
			
			List<Advisor> advisors = new ArrayList<>();

			Connection myConn=null;
			PreparedStatement myStmt=null;
			ResultSet myRs=null;
			
			try {
				
				myConn= dataSource.getConnection();
				
				// only search by name
				if (theSearchName !=null&& theSearchName.trim().length()>0) {
					
					//sql query
					String sql ="select * from advisor where lower(first_name)like? or lower (last_name)like?";
					myStmt = myConn.prepareStatement(sql);
					String theSearchNameLike = "%" + theSearchName.toLowerCase()+ "%";
					myStmt.setString(1, theSearchNameLike);
					myStmt.setString(2, theSearchNameLike);
				}
				else {
					String sql ="select * from advisor order by last_name";
					myStmt= myConn.prepareStatement(sql);
				}
				
				myRs=myStmt.executeQuery();
				// retrieve from result set
				while(myRs.next()) {
					int id=myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String email = myRs.getString("email");
					
					//create new student object
					
					Advisor tempAdvisor = new Advisor(id, firstName, lastName, email);
					advisors.add(tempAdvisor);
					
				}
			}
				finally {
					
					// clean jdbc objects
					close(myConn, myStmt, null);
				}
			
		
			return advisors;
		
		}	
		
	
	public List<Undergraduate> getUndergraduates() throws Exception{
			
			List<Undergraduate> undergraduates = new ArrayList<>();
	
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
	
			try 
			{
				// get a connection
				myConn = dataSource.getConnection();
	
				// create sql statement
				String sql = "select * from undergraduate order by last_name";
				myStmt = myConn.createStatement();
	
				// execute query
				myRs = myStmt.executeQuery(sql);
	
				// process result set
				while (myRs.next()) 
				{
					// retrieve data from result set row
					int id = myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String expertise = myRs.getString("expertise");
					String experience = myRs.getString("experience");
					String email = myRs.getString("email");
					// create new student object
					Undergraduate tempUndergraduate = new Undergraduate(id, firstName, lastName, expertise, experience, email);
			                 	// add it to the list of students
					undergraduates.add(tempUndergraduate);				
				}
				
				return undergraduates;		
			}
			finally 
			{
				// close JDBC objects
				close(myConn, myStmt, myRs);
			}		
		}
		
		
		
		public List<Advisor> getAdvisors() throws Exception 
		{
		
			List<Advisor> advisors = new ArrayList<>();
	
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
	
			try 
			{
				// get a connection
				myConn = dataSource.getConnection();
	
				// create sql statement
				String sql = "select * from advisor order by last_name";
				myStmt = myConn.createStatement();
	
				// execute query
				myRs = myStmt.executeQuery(sql);
	
				// process result set
				while (myRs.next()) 
				{
					// retrieve data from result set row
					int id = myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String email = myRs.getString("email");
					// create new student object
			Advisor tempAdvisor = new Advisor(id, firstName, lastName, email);
			                 	// add it to the list of students
					advisors.add(tempAdvisor);				
				}
				
				return advisors;		
			}
			finally 
			{
				// close JDBC objects
				close(myConn, myStmt, myRs);
			}		
		}
		
			
		private void close(Connection myConn, Statement myStmt, ResultSet myRs) 
		{
	
			try 
			{
	
				if (myRs != null) 
				{
					myRs.close();
				}
				if (myStmt != null) 
				{
					myStmt.close();
				}
				if (myConn != null) 
				{
				    myConn.close();  
	                                     // doesn't really close it ... just puts back in connection pool
			                }
		                 }
	                	catch (Exception exc) 
		                {
				exc.printStackTrace();
		                }
		}
		
		
		
	}
		
	
