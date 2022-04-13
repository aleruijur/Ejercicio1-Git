package modelo.negocio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GestorUsuario {
	
	public boolean loginGet(String nombre, String contraseña) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("http://localhost:8080/EjercicioWebLogin/usuarios/login?nombre=" + nombre + "&password=" + contraseña))
					.GET()
					.build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			Gson gson = new Gson();
			JsonObject jsonObj = gson.fromJson(response.body(), JsonObject.class);
			
			if(jsonObj.get("validado").getAsBoolean()) {
				return true;
			}else {
				return false;
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean loginPost(String nombre, String contraseña) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.header("Content-Type", "application/x-www-form-urlencoded")
					.POST(HttpRequest.BodyPublishers.ofString("nombre=" + nombre + "&password=" + contraseña))
					.uri(new URI("http://localhost:8080/EjercicioWebLogin/usuarios/login"))
					.build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			Gson gson = new Gson();
			JsonObject jsonObj = gson.fromJson(response.body(), JsonObject.class);
			
			if(jsonObj.get("validado").getAsBoolean()) {
				return true;
			}else {
				return false;
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
