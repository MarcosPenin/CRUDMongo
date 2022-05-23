import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class Operaciones {

	public static void insertar(DBCollection collection) {

		ArrayList<String> d1 = new ArrayList<>();
		d1.add("Loquesea");
		Futbolista f1 = new Futbolista("Perfecto", "Perez", 44, d1, false);
		collection.insert(f1.toDBObjectFutbolista());
		
	}
	
	

	
	
	public static void consultarDocumentos_R(MongoCollection <Document> coleccion){
      
        MongoCursor <Document> cursor = coleccion.find().iterator();
        System.out.println("Usando Cursor");
        while(cursor.hasNext()) {
            Document doc = cursor.next();
            System.out.println(doc.toJson());
        }
    }
	
	public static void filtrosConsultas(MongoCollection <Document> coleccion){
        System.out.println("Filtros Consultas");
        Document doc = coleccion.find(Filters.eq("nombre","Pedro")).first();
        try {
            System.out.println("Encontrado: " +doc.toJson());
        }catch(NullPointerException np) {
            System.out.println("No existe");
        }

        MongoCursor <Document> cursor1 = coleccion.find(Filters.gt("edad", 30)).iterator();
        while(cursor1.hasNext()) {
            Document alumno = cursor1.next();
            System.out.println(alumno.toJson());
        }
        cursor1.close();
     
    }
    
	
	
	
}
