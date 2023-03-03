import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Banco {

    private String nombreBanco;
    private String direccionBanco;
    private ArrayList<CuentaBancaria> listaCuentas;


    public Banco() {
    }

    public Banco(String nombreBanco, String direccionBanco) {
        this.nombreBanco = nombreBanco;
        this.direccionBanco = direccionBanco;
        this.listaCuentas = new ArrayList<>();
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public String getDireccionBanco() {
        return direccionBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public void setDireccionBanco(String direccionBanco) {
        this.direccionBanco = direccionBanco;
    }

    public ArrayList<CuentaBancaria> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<CuentaBancaria> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    @Override
    public String toString() {
        return "Banco [nombreBanco=" + nombreBanco + ", direccionBanco=" + direccionBanco + "]";
    }



    public String crearCuenta(String nombre, String apellidos, String numCuenta, String tipoCuenta, double saldoCuenta)throws Exception{
        String salida = "Cuenta creada con éxito";
        boolean cuentaFind = verificarCuenta(numCuenta);

        if(cuentaFind==true){
            throw new Exception("Cuenta ya está registrada en la base de datos");


        }
        else{
            CuentaBancaria cuentaBancaria = new CuentaBancaria(nombre, apellidos, numCuenta, tipoCuenta, saldoCuenta);
            listaCuentas.add(cuentaBancaria);
        }
        
        return salida;

    }



    private boolean verificarCuenta(String numCuenta) {
        boolean find = false;

        for (CuentaBancaria cuentaBancaria : listaCuentas) {
            if(cuentaBancaria.getNumCuenta().equals(numCuenta)){
                find = true;
            }
    
        }

        return find;
    }
    
    public  int leerInt(String mensaje) {
		int dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return dato;
	}
	public  String leerString(String mensaje) {
        String dato = (JOptionPane.showInputDialog(mensaje));
        return dato;
    }
    public void imprimir(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
		
	}

    public void crearMenú() throws Exception{
        int menu = 0;

        boolean flag = false;
        while(flag!=true){
             menu = leerInt("Ingrese la opción que desea realizar" + "\n" + "1). Registrar una nueva cuenta" + "\n" + "2). Consultar información de cuenta"
                + "\n" + "3). Retirar saldo" + "\n" + "4). Consignar a una cuenta" + "\n" + "5). Consignar de una cuenta a otra"
                + "\n" + "6). Comparar saldo entre dos cuentas" + "\n"+ "7). Salir");
            switch (menu){
                case 1:
                    
                    String nombre = leerString("Ingrese su nombre:  ");
                    String apellido = leerString("Ingrese sus apellidos:  ");
                    String numCuenta = leerString("Ingrese le número que desea para su cuenta:  ");
                    String tipoCuenta = leerString("Ingrese el tipo de cuenta que quiere [Cuenta de ahorros o Corriente]:  ");
                    double saldoCuenta = 0;

                    crearCuenta(nombre, apellido, numCuenta, tipoCuenta, saldoCuenta);
                   
                    break;

                case 2:
                    String numcuenta = leerString("Ingrese el número de la cuenta que desea buscar:  ");

                    String cuenta = consultarInfo(numcuenta);
                    imprimir(cuenta);
                    
                    break;
                case 3:
                    String numcuenta2 = leerString("Ingrese el número de la cuenta a la que desea retirar:  ");
                    double valorRetirar = Funciones.leerDouble("Ingrese el valor a retirar: ");
                    String cr = retirarSaldo(numcuenta2, valorRetirar);
                    imprimir(cr);

                    break;

                    
                case 4:
                    String numcuenta1 = leerString("Ingrese el número de la cuenta a la que desea consignar:  ");
                    double valorConsignar1 = Funciones.leerDouble("Ingrese el valor a consignar: ");
                    String infosaldo = consignarSaldo(numcuenta1, valorConsignar1);
                    imprimir(infosaldo);
                       
                    break;
                    

                case 5:
                    String numcuenta3 = leerString("Ingrese el número de la cuenta de la que desea transferir");
                    String numcuenta3_2 = leerString("Ingrese el número de la cuenta destino");
                    double suma = Funciones.leerDouble("Ingrese la suma a transferir");
                    boolean centi = consignarCuenta2(numcuenta3, numcuenta3_2, suma);
                    if(centi==true){
                        imprimir("Consignación realizada con éxito");
                    }
                    else{
                        imprimir("Consignación no realizada, por favor verique su saldo");
                    }
                    break;
                case 6:
                    String numcuenta4 = leerString("Ingrese el número de la cuenta 1");
                    String numcuenta4_2 = leerString("Ingrese el número de la cuenta 2");
                    boolean cent = compareSaldo(numcuenta4, numcuenta4_2);
                    if(cent==true){
                        imprimir("La cuenta 1 tiene mayor saldo que la cuenta 2");
                    }
                    else{
                        imprimir("La cuenta 2 tiene mayor saldo que la 1");
                    }
                    break;
                        

                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo");
                    flag = true;
                    break;                    




                default:
                    JOptionPane.showMessageDialog(null, "opción inválida, leer detenidamente el menú");
                    break;

            }
        }    

    }
    public String consultarInfo(String numcuenta){
        String exit = "";
        if(!listaCuentas.isEmpty()){
                for (int i = 0; i < listaCuentas.size(); i++) {
                    if(listaCuentas.get(i).getNumCuenta().equals(numcuenta)){
                        exit = "CuentaBancaria" + "\nNombre:   " + listaCuentas.get(i).getNombre() + "\nApellidos:  " + listaCuentas.get(i).getApellidos() + "\nNúmero de Cuenta:  " + listaCuentas.get(i).getNumCuenta()
                        + "\nTipo de Cuenta:  " + listaCuentas.get(i).getTipoCuenta() + "\nSaldo de Cuenta:  " + listaCuentas.get(i).getSaldoCuenta(); 
                        break;
                    }
                    else{ 

                        exit = "No se ha encontrado la cuenta";
                    }
                    
                }
        }   
        
        return exit;
        
        
    }
    public String consignarSaldo(String numcuenta, double saldoConsignar){
        double saldoCuenta = 0;
        String exit = "";
        if(verificarCuenta(numcuenta)==true){
            for (int i = 0; i < listaCuentas.size(); i++) {
                if(listaCuentas.get(i).getNumCuenta().equals(numcuenta)){
                    saldoCuenta = listaCuentas.get(i).getSaldoCuenta();
                    saldoCuenta = saldoCuenta + saldoConsignar;

                    listaCuentas.get(i).setSaldoCuenta(saldoCuenta);
                    exit = "Valor consignado con éxito" + "\n El saldo actual de su tarjeta es: " + saldoCuenta;
                    break;
                }

                
            }
        }
        return exit;
    }

    public String retirarSaldo(String numcuenta, double saldoRetirar){
        double saldoCuenta = 0;
        String exit = "";
        if(verificarCuenta(numcuenta)==true){
            for (int i = 0; i < listaCuentas.size(); i++) {
                if(listaCuentas.get(i).getNumCuenta().equals(numcuenta)){
                    saldoCuenta = listaCuentas.get(i).getSaldoCuenta();
                    if(saldoCuenta<saldoRetirar){
                        exit = "No se puede retirar una suma mayor al saldo disponible" + "\nEl saldo actual es de: " + saldoCuenta;
                        
                    }
                    else{ 
                        saldoCuenta = saldoCuenta-saldoRetirar;
                        listaCuentas.get(i).setSaldoCuenta(saldoCuenta);
                        exit = "El saldo se ha retirado correctamente" + "\nSaldo restante: " + saldoCuenta;
                    }

                }
            }
        }
        return exit;
    }

    public boolean compareSaldo(String numCuenta1 , String numCuenta2){
        boolean flag = false;
        double saldo1 = 0, saldo2 = 0;

        if(verificarCuenta(numCuenta1)==true && verificarCuenta(numCuenta2)){
            for (int index = 0; index < listaCuentas.size(); index++) {

                if(listaCuentas.get(index).getNumCuenta().equals(numCuenta1)){
                    saldo1 = listaCuentas.get(index).getSaldoCuenta();
    
                }
                else{
    
                    if(listaCuentas.get(index).getNumCuenta().equals(numCuenta2)){
                        saldo2 = listaCuentas.get(index).getSaldoCuenta();
                    }
                }
            }
            
            if(saldo2 < saldo1){
                flag = true;
            }
        }
        return flag;
    }

    public boolean consignarCuenta2(String cuenta1 , String cuenta2, double suma){
        boolean flag = false;
        
        if(verificarCuenta(cuenta1)==true && verificarCuenta(cuenta2)== true){
            double saldo1 = 0;
            for (int i = 0; i < listaCuentas.size(); i++) {
                if(listaCuentas.get(i).getNumCuenta()==cuenta1){
                    saldo1 = listaCuentas.get(i).getSaldoCuenta();
                    break;
                }
                
            }
            
            if (saldo1 <= suma) {
                retirarSaldo(cuenta1, suma);
                consignarSaldo(cuenta2, suma);
                flag = true;
                
            }
           
        }
        return flag;


    }
    




}

