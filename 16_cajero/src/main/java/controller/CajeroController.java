package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.CuentaDto;
import dtos.MovimientoDto;
import service.CajeroService;

@CrossOrigin("*")
@Controller
public class CajeroController {

	@Autowired
	CajeroService service;
	
	@GetMapping(value="Cuenta")
	public String buscarAlumnos(@RequestParam("numeroCuenta") int numeroCuenta, HttpSession httpSession){
		boolean exist = service.existeCuenta(numeroCuenta);
		
		if(exist) {
			httpSession.setAttribute("numeroCuenta", numeroCuenta);
			return "menu";
		}else {
			return "error";
		}
	}
	
	@GetMapping(value="VerMovimientos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MovimientoDto> verMovimientos(@RequestParam("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date inicio,
			@RequestParam("fin") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date fin, HttpSession httpSession){
		int numeroCuenta = (int) httpSession.getAttribute("numeroCuenta");
		return service.verMovimientos(numeroCuenta,inicio,fin);
	}
	
	@PostMapping(value="Ingresar")
	public String ingresar(@RequestParam("cantidad") double cantidad, HttpSession httpSession){
		int numeroCuenta = (int) httpSession.getAttribute("numeroCuenta");
		service.ingresar(numeroCuenta,cantidad);
		return "menu";
	}
	
	@PostMapping(value="Extraer")
	public String extraer(@RequestParam("cantidad") double cantidad, HttpSession httpSession){
		int numeroCuenta = (int) httpSession.getAttribute("numeroCuenta");
		boolean ok = service.extraer(numeroCuenta,cantidad);
		return ok?"menu":"errorCantidad";
	}
	
	@PostMapping(value="Transferencia")
	public String transferencia(@RequestParam("cantidad") double cantidad, @RequestParam("receptor") int receptor, HttpSession httpSession){
		int numeroCuenta = (int) httpSession.getAttribute("numeroCuenta");
		boolean ok = service.transferencia(numeroCuenta, receptor, cantidad);
		return ok?"menu":"errorCantidad";
	}
	
	@GetMapping(value="CuentaEnSesion", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CuentaDto cuentaEnSesion(HttpSession httpSession){
		int numeroCuenta = (int) httpSession.getAttribute("numeroCuenta");
		return service.getCuenta(numeroCuenta);
	}
	
}
