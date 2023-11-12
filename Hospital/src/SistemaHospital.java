import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class SistemaHospital {
     private List<Pacientes> pacientes;
    private List<Doctores> doctores;

    public SistemaHospital() {
        this.pacientes = new ArrayList<>();
        this.doctores = new ArrayList<>();
    }
     public void setDoctores(List<Doctores> doctores) {
        this.doctores = doctores;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }

    public void registrarPaciente() {
       
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI:");
        String dni = scanner.next();

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = scanner.next();

        System.out.println("Ingrese la dirección:");
        String direccion = scanner.next();

        System.out.println("Ingrese el peso:");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese la temperatura:");
        double temperatura = scanner.nextDouble();

        
        Pacientes nuevoPaciente = new Pacientes(dni, nombre, direccion, peso, temperatura, apellido);
        
        pacientes.add(nuevoPaciente);

        System.out.println("Paciente registrado");
    }

    public void eliminarPaciente(int posicion) {
        
        if (posicion >= 0 && posicion < pacientes.size()) {
            Pacientes pacienteEliminado = pacientes.remove(posicion);
            System.out.println("Paciente eliminado: " + pacienteEliminado.getNombre());
        } else {
            System.out.println("No se eliminó ningún paciente");
        }
        
    }

    public void modificarDatosPaciente(int posicion) {
        
         if (posicion >= 0 && posicion < pacientes.size()) {
            Scanner scanner = new Scanner(System.in);
            Pacientes pacienteAModificar = pacientes.get(posicion);

            System.out.println("Modificando datos del paciente: " + pacienteAModificar.getNombre());
            System.out.println("Ingrese el nuevo nombre:");
            String nuevoNombre = scanner.next();
            pacienteAModificar.setNombre(nuevoNombre);

            System.out.println("Ingrese la nueva dirección:");
            String nuevaDireccion = scanner.next();
            pacienteAModificar.setDireccion(nuevaDireccion);

            System.out.println("Ingrese el nuevo peso:");
            double nuevoPeso = scanner.nextDouble();
            pacienteAModificar.setPeso(nuevoPeso);

            System.out.println("Ingrese la nueva temperatura:");
            double nuevaTemperatura = scanner.nextDouble();
            pacienteAModificar.setTemperatura(nuevaTemperatura);

            System.out.println("Datos del paciente modificado.");
        } else {
            System.out.println("No se modificaron los datos del paciente");
        }
       
    }

    public void mostrarPesoMasRepetido() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados");
            return;
        }

        List<Double> pesos = new ArrayList<>();

        for (Pacientes paciente : pacientes) {
            pesos.add(paciente.getPeso());
        }

     
        Collections.sort(pesos);
        double pesoMasRepetido = 0;
        int frecuenciaActual = 1;
        int maxFrecuencia = 1;

 
        for (int i = 1; i < pesos.size(); i++) {
            if (pesos.get(i).equals(pesos.get(i - 1))) {
                frecuenciaActual++;

                if (frecuenciaActual > maxFrecuencia) {
                    maxFrecuencia = frecuenciaActual;
                    pesoMasRepetido = pesos.get(i);
                }
            } else {
                frecuenciaActual = 1;
            }
        }

        System.out.println("El peso que más se repite es: " + pesoMasRepetido);
    }

    public void mostrarCantidadPacientesConPesoRepetido() {
        if (pacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados");
        return;
    }

   
    List<Double> pesos = new ArrayList<>();

    
    for (Pacientes paciente : pacientes) {
        pesos.add(paciente.getPeso());
    }

   
    Collections.sort(pesos);

    
    double pesoMasRepetido = 0;
    int frecuenciaActual = 1;
    int maxFrecuencia = 1;

   
    for (int i = 1; i < pesos.size(); i++) {
        if (pesos.get(i).equals(pesos.get(i - 1))) {
            frecuenciaActual++;

            if (frecuenciaActual > maxFrecuencia) {
                maxFrecuencia = frecuenciaActual;
                pesoMasRepetido = pesos.get(i);
            }
        } else {
            frecuenciaActual = 1;
        }
    }
    
    int cantidadPacientesConPesoRepetido = 0;
    for (Pacientes paciente : pacientes) {
        if (paciente.getPeso() == pesoMasRepetido) {
            cantidadPacientesConPesoRepetido++;
        }
    }

    System.out.println("Cantidad de pacientes con el peso que más se repite: " + cantidadPacientesConPesoRepetido);

    }

    public void mostrarPesoMayorYMenor() {
        
        if (pacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados");
        return;
    }

    double pesoMayor = pacientes.get(0).getPeso();
    double pesoMenor = pacientes.get(0).getPeso();

    
    for (Pacientes paciente : pacientes) {
        double pesoActual = paciente.getPeso();
        
        if (pesoActual > pesoMayor) {
            pesoMayor = pesoActual;
        }

        if (pesoActual < pesoMenor) {
            pesoMenor = pesoActual;
        }
    }

    System.out.println("Peso mayor: " + pesoMayor);
    System.out.println("Peso menor: " + pesoMenor);
    
    }

    public void dividirRangoPesos() {
        
       if (pacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados");
        return;
    }

   
    double pesoMinimo = pacientes.get(0).getPeso();
    double pesoMaximo = pacientes.get(0).getPeso();

    for (Pacientes paciente : pacientes) {
        double pesoActual = paciente.getPeso();

        if (pesoActual < pesoMinimo) {
            pesoMinimo = pesoActual;
        }

        if (pesoActual > pesoMaximo) {
            pesoMaximo = pesoActual;
        }
    }

    
    int numRangos = 4;
    double rango = (pesoMaximo - pesoMinimo) / numRangos;

    
    int[] conteoRangos = new int[numRangos];

    
    for (Pacientes paciente : pacientes) {
        double pesoActual = paciente.getPeso();

        for (int i = 0; i < numRangos; i++) {
            double rangoMinimo = pesoMinimo + i * rango;
            double rangoMaximo = pesoMinimo + (i + 1) * rango;

            if (pesoActual >= rangoMinimo && pesoActual < rangoMaximo) {
                conteoRangos[i]++;
                break;  
            }
        }
    }

   
    for (int i = 0; i < numRangos; i++) {
        double rangoMinimo = pesoMinimo + i * rango;
        double rangoMaximo = pesoMinimo + (i + 1) * rango;

        System.out.println("Rango " + (i + 1) + ": " + conteoRangos[i] + " pacientes (" +
                "de " + rangoMinimo + " a " + rangoMaximo + " kg)");
    }
}

    public void mostrarListaPacientesOrdenados() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados");
            return;
        }
        Collections.sort(pacientes, Comparator.comparing(Pacientes::getApellido));

        
        System.out.println("Lista de pacientes ordenados por apellidos:");

        for (Pacientes paciente : pacientes) {
            System.out.println("Nombre: " + paciente.getNombre() + " Apellido: " + paciente.getApellido());
           
        }
    }
    
    public void indicarDoctorQueAtendioPaciente() {
        
        Scanner scanner = new Scanner(System.in);

    if (pacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados");
        return;
    }

    System.out.println("Lista de pacientes:");
    for (int i = 0; i < pacientes.size(); i++) {
        System.out.println((i + 1) + ". " + pacientes.get(i).getNombre());
    }

    System.out.println("Ingrese el número del paciente:");
    int numeroPaciente = scanner.nextInt();

    if (numeroPaciente >= 1 && numeroPaciente <= pacientes.size()) {
        Pacientes pacienteSeleccionado = pacientes.get(numeroPaciente - 1);

        System.out.println("Lista de doctores:");
        for (int i = 0; i < doctores.size(); i++) {
            System.out.println((i + 1) + ". " + doctores.get(i).getNombre());
        }

        System.out.println("Ingrese el número del doctor que atendió al paciente:");
        int numeroDoctor = scanner.nextInt();

        if (numeroDoctor >= 1 && numeroDoctor <= doctores.size()) {
            Doctores doctorSeleccionado = doctores.get(numeroDoctor - 1);

            pacienteSeleccionado.setMedicoAtendido(doctorSeleccionado);

            System.out.println("Se ha registrado que el doctor " + doctorSeleccionado.getNombre() +
                    " atendió al paciente " + pacienteSeleccionado.getNombre() + ".");
        } else {
            System.out.println("Número de doctor incorrecto");
        }
    } else {
        System.out.println("Número de paciente incorrecto");
    }

    }
        
    public void buscarDoctoresPorEspecialidad() {
      
       Scanner scanner = new Scanner(System.in);

    
    System.out.println("Especialidades disponibles:");
    for (Doctores doctor : doctores) {
        System.out.println("- " + doctor.getEspecialidad());
    }

    
    System.out.println("Ingrese la especialidad a buscar:");
    String especialidadBuscada = scanner.nextLine();

    
    boolean encontrados = false;
    System.out.println("Doctores con la especialidad '" + especialidadBuscada + "':");
    for (Doctores doctor : doctores) {
        if (doctor.getEspecialidad().equalsIgnoreCase(especialidadBuscada)) {
            System.out.println("- " + doctor.getNombre());
            encontrados = true;
        }
    }

    if (!encontrados) {
        System.out.println("No se encontraron doctores con la especialidad '" + especialidadBuscada + "'.");
    }
    }

    public static void main(String[] args) {
        
      Scanner scanner = new Scanner(System.in);
    SistemaHospital hospital = new SistemaHospital();
    
    List<Doctores> doctores = new ArrayList<>();
    doctores.add(new Doctores(12345, "Dr. Firulais", "Cardiología"));
    doctores.add(new Doctores(67890, "Dr. Maanaky", "Neurología"));

    
    List<Pacientes> pacientes = new ArrayList<>();
   pacientes.add(new Pacientes("78246874", "Diego", "EL AGUSTINO", 73, 28, "Inca"));
   pacientes.add(new Pacientes("88462578", "Josue", "SJL", 1.65, 28, "Gonzales"));

    
    hospital.setDoctores(doctores); 
    hospital.setPacientes(pacientes);


    int opcion;

    do {
        System.out.println("1. Registrar paciente");
        System.out.println("2. Eliminar paciente");
        System.out.println("3. Modificar datos del paciente");
        System.out.println("4. Mostrar el peso que mas se repite");
        System.out.println("5. Mostrar la cantidad de pacientes con el peso repetido");
        System.out.println("6. Mostrar el peso mayor y menor");
        System.out.println("7. Mostrar los pesos en rangos");
        System.out.println("8. Mostrar la lista de pacientes ordenados por apellido");
        System.out.println("9. Mostrar el doctor que atendio al paciente");
        System.out.println("10. Buscar Doctores por especialidad");
        System.out.println("0. Salir");
        System.out.println("Ingrese la opción: ");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                hospital.registrarPaciente();
                break;
            case 2:
              
                System.out.println("Ingrese la posición del paciente que va a eliminar:");
                int posicionEliminar = scanner.nextInt();
                hospital.eliminarPaciente(posicionEliminar);
                break;
            case 3:
                
                System.out.println("Ingrese la posición del paciente que va a modificar:");
                int posicionModificar = scanner.nextInt();
                hospital.modificarDatosPaciente(posicionModificar);
                break;
            case 4:
                hospital.mostrarPesoMasRepetido();
                break;
            case 5:
                hospital.mostrarCantidadPacientesConPesoRepetido();
                break;
            case 6:
                hospital.mostrarPesoMayorYMenor();
                break;
            case 7:
                hospital.dividirRangoPesos();
                break;
            case 8:
                hospital.mostrarListaPacientesOrdenados();
                break;
            case 9:
                hospital.indicarDoctorQueAtendioPaciente();
                break;
            case 10:
                hospital.buscarDoctoresPorEspecialidad();
                break;
            case 0:
                System.out.println("Saliendo.");
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }

    } while (opcion != 0);

  
}

     
        
    }
