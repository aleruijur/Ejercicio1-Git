package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.CuentasDao;
import dao.MovimientosDao;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

@Service
public class CajeroServiceImpl implements CajeroService {

	@Autowired
	ConversorEntityDto conversor;

	CuentasDao cuentasDao;
	
	MovimientosDao movimientosDao;
	
	public CajeroServiceImpl(@Autowired CuentasDao cuentasDao, @Autowired MovimientosDao movimientosDao) {
		this.cuentasDao = cuentasDao;
		this.movimientosDao = movimientosDao;
	}
	
	@Override
	public boolean existeCuenta(int numeroCuenta) {
		return cuentasDao.existsById(numeroCuenta);
	}
	
	@Override
	public CuentaDto getCuenta(int numeroCuenta) {
		return conversor.cuentaToDto(cuentasDao.getById(numeroCuenta));
	}

	@Override
	public void ingresar(int numeroCuenta, double cantidad) {
		Cuenta c = cuentasDao.getById(numeroCuenta);
		c.setSaldo(c.getSaldo() + cantidad);
		cuentasDao.save(c);
		Movimiento m = new Movimiento(new Date(), cantidad, "ingreso", c);
		movimientosDao.save(m);
	}

	@Override
	public boolean extraer(int numeroCuenta, double cantidad) {
		Cuenta c = cuentasDao.getById(numeroCuenta);
		if(c.getSaldo()>=cantidad) {
			c.setSaldo(c.getSaldo() - cantidad);
			cuentasDao.save(c);
			Movimiento m = new Movimiento(new Date(), cantidad, "extracción", c);
			movimientosDao.save(m);
			return true;
		}else {
			return false;
		}

	}

	@Override
	public boolean transferencia(int emisor, int receptor, double cantidad) {
		Cuenta cEmisor = cuentasDao.getById(emisor);
		Optional<Cuenta> cReceptorOp = cuentasDao.findById(receptor);
		if(cReceptorOp.isPresent() && cEmisor.getSaldo()>=cantidad) {
			cEmisor.setSaldo(cEmisor.getSaldo() - cantidad);
			cuentasDao.save(cEmisor);
			Movimiento m = new Movimiento(new Date(), cantidad, "extracción", cEmisor);
			movimientosDao.save(m);
			
			Cuenta cReceptor = cReceptorOp.get();
			cReceptor.setSaldo(cReceptor.getSaldo() + cantidad);
			cuentasDao.save(cReceptor);
			m = new Movimiento(new Date(), cantidad, "ingreso", cReceptor);
			movimientosDao.save(m);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<MovimientoDto> verMovimientos(int numeroCuenta, Date inicio, Date fin) {
		return movimientosDao.findByCuentaNumeroCuentaAndFechaBetween(numeroCuenta, inicio, fin)
				.stream()
				.map(m->conversor.movimientoToDto(m))
				.collect(Collectors.toList());
	}

}
