public class CuentaBancaria {

    private String nombre;
    private String apellidos;
    private String numCuenta;
    private String tipoCuenta;
    private double saldoCuenta;


    public CuentaBancaria() {
    }

    public CuentaBancaria(String nombre, String apellidos, String numCuenta, String tipoCuenta, double saldoCuenta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoCuenta = saldoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria" + "\nNombre:   " + nombre + "\nApellidos:  " + apellidos + "\nNúmero de Cuenta:  " + numCuenta
                + "\nTipo de Cuenta:  " + tipoCuenta + "\nSaldo de Cuenta:  " + saldoCuenta;
    }

    

    

    

    





}