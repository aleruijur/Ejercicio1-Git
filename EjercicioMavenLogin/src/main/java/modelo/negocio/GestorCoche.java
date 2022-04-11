package modelo.negocio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {
	private DaoCoche daoCoche = new DaoCocheMySql();
	
	public int alta(Coche c){
		if(c.getKilometros()>=0) {
			if(c.getMatricula().length() == 7) {
				Coche existe = daoCoche.buscarPorMatricula(c.getMatricula());
				if(existe==null) {
					boolean alta = daoCoche.alta(c);
					if(alta) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 3;
				}
			}else {
				return 2;
			}
		}else {
			return 4;
		}
		
	}
	
	public boolean baja(int id){
		return daoCoche.baja(id);
	}
	
	public int modificar(Coche c){
		if(c.getKilometros()>=0) {
			if(c.getMatricula().length() == 7) {
				Coche existe = daoCoche.buscarPorMatricula(c.getMatricula());
				if(existe==null || existe.getId()==c.getId()) {
					boolean modificar = daoCoche.modificar(c);
					if(modificar) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 3;
				}
			}else {
				return 2;
			}
		}else {
			return 4;
		}
	}
	
	public Coche buscarPorID(int id){
		return daoCoche.buscarPorID(id);
	}
	
	public Coche buscarPorMatricula(String matricula){
		return daoCoche.buscarPorMatricula(matricula);
	}
	
	public List<Coche> buscarPorMarca(String marca){
		return daoCoche.buscarPorMarca(marca);
	}
	
	public List<Coche> buscarPorModelo(String modelo){
		return daoCoche.buscarPorModelo(modelo);
	}
	
	public List<Coche> listar(){
		return daoCoche.listar();
	}
	
	public void exportarAJson(){
		List<Coche> cs = daoCoche.listar();
		Gson gson = new Gson();
		String json = gson.toJson(cs);
		
		String path = "src/main/resources/coches.json";
		try {
			FileWriter myWriter = new FileWriter(path);
		    myWriter.write(json);
		    myWriter.close();
		    System.out.println("JSON guardado en " + path);
		} catch (IOException e) {
		    System.out.println("Ha ocurrido un error");
		    e.printStackTrace();
		}
	}
	
	public void exportarAExcel(){
		String path = "src/main/resources/coches.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Lista de Coches");
        
        List<Coche> cs = daoCoche.listar();
  
        XSSFRow row = spreadsheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Id");
        cell = row.createCell(1);
        cell.setCellValue("Matrícula");
        cell = row.createCell(2);
        cell.setCellValue("Marca");
        cell = row.createCell(3);
        cell.setCellValue("Modelo");
        cell = row.createCell(4);
        cell.setCellValue("Kilómetros");
        
        int rowid = 1;
        for(Coche c: cs) {
        	row = spreadsheet.createRow(rowid++);
  
            cell = row.createCell(0);
            cell.setCellValue(c.getId());
            cell = row.createCell(1);
            cell.setCellValue(c.getMatricula());
            cell = row.createCell(2);
            cell.setCellValue(c.getMarca());
            cell = row.createCell(3);
            cell.setCellValue(c.getModelo());
            cell = row.createCell(4);
            cell.setCellValue(c.getKilometros());
        }
  
        try {
        	FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("Excel guardado en " + path);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error");
		    e.printStackTrace();
		}
        
	}
	
}
