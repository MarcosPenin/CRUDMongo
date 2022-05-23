package register;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class Operaciones {

	public static void insertar(MongoCollection<FutbolistaNew> collection2) {
		ArrayList<String> d1 = new ArrayList<>();
		d1.add("Loquesea");
		FutbolistaNew f1 = new FutbolistaNew("Laureano", "Gonzalez", 34, d1, false, 1);
		collection2.insertOne(f1);
	}

	public static void borrar(MongoCollection<FutbolistaNew> collection2) {
		collection2.findOneAndDelete(Filters.eq("nombre", "Laureano"));

	}

	public static void modificar(MongoCollection<FutbolistaNew> collection2) {
		ArrayList<String> d1 = new ArrayList<>();
		d1.add("Loquesea");
		FutbolistaNew nuevo = new FutbolistaNew("Pedro", "Campos", 34, d1, false, 1);		

		collection2.findOneAndReplace(Filters.eq("nombre", "Laureano"), nuevo);
		

	}
	
	
	
	
	
	
	
	
	

	public static void contar(MongoCollection<FutbolistaNew> collection2) {
		long doc = collection2.count();
		System.out.println(doc);
	}

	public static void contarInternacionales(MongoCollection<FutbolistaNew> collection2) {

		List<FutbolistaNew> futbolistas = collection2.find(Filters.eq("internacional", "true"))
				.into(new ArrayList<FutbolistaNew>());
		System.out.println(futbolistas.size());

	}

	public static void contarInternacionales2(MongoCollection<FutbolistaNew> collection2) {

	}

	public static void consultarDocumentos_R(MongoCollection<FutbolistaNew> collection2) {
		MongoCursor<FutbolistaNew> cursor = collection2.find().iterator();
		while (cursor.hasNext()) {
			FutbolistaNew f = cursor.next();
			System.out.println(f.toString());
		}
	}

	public static void filtrosConsultas(MongoCollection<Document> coleccion) {
		System.out.println("Filtros Consultas");
		Document doc = coleccion.find(Filters.eq("nombre", "Pedro")).first();
		try {
			System.out.println("Encontrado: " + doc.toJson());
		} catch (NullPointerException np) {
			System.out.println("No existe");
		}

		MongoCursor<Document> cursor1 = coleccion.find(Filters.gt("edad", 30)).iterator();
		while (cursor1.hasNext()) {
			Document alumno = cursor1.next();
			System.out.println(alumno.toJson());
		}
		cursor1.close();

	}

}
