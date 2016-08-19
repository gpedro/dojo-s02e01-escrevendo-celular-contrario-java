import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CelularInverso {

	private final String entrada;
	private final Map<String, Integer> teclas;
	private final String permitidos;

	public CelularInverso() {
		this(null);
	}
	
	public CelularInverso(final String entrada) {
		// Se a entrada for null ou vazia, estoura exception
		if (entrada == null || entrada.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		this.entrada = entrada.toUpperCase();
		
		// Configura Teclado
		// Defini uma capacidade inicial pq o inicial é 16
		// Economizar memória :P
		teclas = new HashMap<>(8);
		teclas.put("ABC", 2);
		teclas.put("DEF", 3);
		teclas.put("GHI", 4);
		teclas.put("JKL", 5);
		teclas.put("MNO", 6);
		teclas.put("PQRS", 7);
		teclas.put("TUV", 8);
		teclas.put("WXYZ", 9);
		
		// Configura Caracteres Especiais
		permitidos = "*#-";
	}
	
	public String resolve() {
		final StringBuilder resultado = new StringBuilder(entrada.length());
		
		String[] letras = entrada.split("");
		for (String letra: letras) {
			if (isInt(letra) || permitidos.contains(letra)) {
				resultado.append(letra);
				continue;
			}
			
			// Java8 é lindão
			Stream<String> stream = teclas.keySet().parallelStream();
			stream
				.filter(p -> {
					return p.contains(letra);
				})
				.forEach(a -> {
					resultado.append(teclas.get(a));
				});
			stream.close();
		}
		
		return resultado.toString();
	}

	private boolean isInt(String value) {
		try {
			// estou usando Integer#parseInt pq eu não
			// preciso do valor primitivo
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			// usando exception pq vai q dá um nullpointer :P
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		CelularInverso obj = new CelularInverso("VIVO");
		System.out.println(obj.resolve());
	}
}
