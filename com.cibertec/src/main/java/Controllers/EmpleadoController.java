package Controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Empleado;

public class EmpleadoController {

	//CREAR EMPLEADO
	public String CrearEmpleado(String apellido,String nombre,int edad, String sexo, double salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			Empleado empleado= new Empleado(apellido,nombre,edad,sexo,salario);
			
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();			
			sessionFactory.close();		
			
			return "Nuevo empleado registrado ["+nombre+"]";
			
		}catch(Exception e){			
			e.printStackTrace();
		}
		return "Error al registrar empleado";
	}
	
	
	//ELIMINAR EMPLEADO
	
	public String EliminarEmpleado(int idEmpleado){
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado= session.get(Empleado.class,idEmpleado);
			session.delete(empleado);
			session.getTransaction().commit();			
			sessionFactory.close();
			return "Empleado ["+idEmpleado+"] eliminado correctamente";
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return "Error al eliminar empleado";
	 }
	
	
	//ACTUALIZAR EMPLEADO
	
	public String ActualizarUsuario(int idEmpleado, String apellido, String nombre,int edad, String sexo, double salario) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, idEmpleado);				
				empleado.setApellido(apellido);
				empleado.setNombre(nombre);
				empleado.setEdad(edad);
				empleado.setSexo(sexo);
				empleado.setSalario(salario);		
				
				session.update(empleado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Empleado "+ nombre+" actualizado correctamente";
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return "Error al actualizar empleado";
		 }
	
	
	//LEER EMPLEADO
	
	//LEER USUARIO
	 
		public String LeerEmpleado(int idEmpleado) {
			
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idEmpleado);
			session.getTransaction().commit();
			sessionFactory.close();
			return empleado.toString();
			
		}catch(Exception e){
			
			e.printStackTrace();
			return "No existe el empleado "+ idEmpleado  ;
		}
		
		}

}
