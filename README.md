# Project Description
Para arrancar el proyecto se debe seguir los siguientes pasos:

1. Crear la base de datos en postgrees

CREATE DATABASE employeevaccine
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE employeevaccine
    IS 'Base de datos empledos vacunacion';
    
 2. Ejecutar la clase EmployeevaccinationApplication.java (run-> 1 Java application)
 
 Nota: la clase genera insert roles y ciertos usuarios, catalogos
 
 3. Para probar los servicios
  
  	se adjunta los curls (curls.txt), se uso la herramienta Insomnia
  	
  	- http://localhost:8080/api/login: Permite obetener los tocken
  	- http://localhost:8080/api/token/refresh: Permite usarse para consumir dentro de la aplicacion
  	- http://localhost:8080/api/users : Retorna todos los usuarios
  	- http://localhost:8080/api/role/addroletouser : Añsade el rol al usuario
  	- http://localhost:8080/api/employee/create : Crea un empleado 
  	- http://localhost:8080/api/employee/createvaccinated: Actualiza informacion del empleado
  	- http://localhost:8080/api/employee/delete/ : Borra un empleado
  	- http://localhost:8080/api/employee/addinformation : Añade informacion extra
  	- http://localhost:8080/api/employees/vaccines: Crea los empleados vacunados 
  	
  4. En la clase SecurityConfig.java se encuentran los permisos a las urls y el rol que se les asigna	 
     
