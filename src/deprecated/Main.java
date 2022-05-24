package deprecated;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {

		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("AADDMarcos");
		MongoCollection<Document> collection =  db.getCollection("futbol");

		Operaciones.insertar((DBCollection) collection);
		//Operaciones.consultarDocumentos_R(collection);
		//Operaciones.filtrosConsultas(collection);				
		cliente.close();
	}
}
