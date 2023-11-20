security4CRUD_MVC_JPAauthentication

Data JPA dependency should be selected

	Uses Controller for MVC CRUD operations
	Uses postgres database (for login details)
	Uses UserData as @Entity  (Roles are stored with comma. In service it is split while creating UserDetails)
	Uses authentication with the help of UserDetailsService
	Configuration:
		UserDetailsService with @Override method  loadUserByUsername(String username) which uses JPA Repository and returns UserDetails object
		DaoAthenticationProvider which uses UserDetailsService
		
	Uses password encryption while storing in DB
	Uses default form 
	
	UserDetailsInit is CommandLineRunner to add data to the tables using JPARepository

	


	