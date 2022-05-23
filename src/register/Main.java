package register;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {

		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		MongoClient cliente = new MongoClient("localhost",
				MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
		
		MongoDatabase db = cliente.getDatabase("AADDMarcos");
		MongoCollection<Document> collection = db.getCollection("futbol");
		MongoCollection<FutbolistaNew> collection2 = db.getCollection("futbol",FutbolistaNew.class);

		Operaciones.contarInternacionales(collection2);
		Operaciones.insertar(collection2);
		Operaciones.modificar(collection2);

	}

}
