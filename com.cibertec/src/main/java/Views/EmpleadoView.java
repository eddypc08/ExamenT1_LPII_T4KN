package Views;

import Controllers.EmpleadoController;

public class EmpleadoView {

	
	public static void main(String[] args) {
		//CREAR USUARIO
		//String empleado = new EmpleadoController().CrearEmpleado("Alata","Marco",23,"Masculino",3000);
		
		//ELIMINAR USUARIO
		//String empleado = new EmpleadoController().EliminarEmpleado(2);
		
		//ACTUALIZAR USUARIO
		//String empleado = new EmpleadoController().ActualizarUsuario(5,"Alfaro","Marco Antonio",22,"Masculino",1800);

		//LEER USUARIO
		String empleado = new EmpleadoController().LeerEmpleado(4);	
		
		System.out.print(empleado);
	
	}
}
