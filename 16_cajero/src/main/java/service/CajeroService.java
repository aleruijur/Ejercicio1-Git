package service;

import java.util.Date;
import java.util.List;

import dtos.CuentaDto;
import dtos.MovimientoDto;

public interface CajeroService {
	boolean existeCuenta(int numeroCuenta);
	void ingresar(int numeroCuenta, double cantidad);
	boolean extraer(int numeroCuenta, double cantidad);
	boolean transferencia(int emisor, int receptor, double cantidad);
	List<MovimientoDto> verMovimientos(int numeroCuenta, Date inicio, Date fin);
	CuentaDto getCuenta(int numeroCuenta);
}
