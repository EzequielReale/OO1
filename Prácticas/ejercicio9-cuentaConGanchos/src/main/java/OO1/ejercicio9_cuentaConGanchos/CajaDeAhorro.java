package OO1.ejercicio9_cuentaConGanchos;

public class CajaDeAhorro extends Cuenta {

	
	public CajaDeAhorro() {
		super();
	}
	
	@Override
	public boolean puedeExtraer(double monto) {
		return (this.getSaldo() - monto >= 0) ? true : false;
	}
	
	@Override
	public void depositar(double monto) {
		super.depositar(monto * 0.98);
	}

	@Override
	public boolean extraer(double monto) {
		return super.extraer(monto * 1.02);
	}

	@Override
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(monto * 1.02)) {
			this.extraerSinControlar(monto * 0.02);
			return super.transferirACuenta(monto, cuentaDestino); //Siempre true
		}
		return false;
	}
}
