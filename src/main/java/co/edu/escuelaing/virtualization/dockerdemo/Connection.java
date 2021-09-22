package co.edu.escuelaing.virtualization.dockerdemo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.ArrayList;
import org.bson.Document;

public class Connection {
    MongoClient mongoClient;

    public Connection() {
        String connectionString = System.getProperty("mongodb://localhost:27017");
        mongoClient = MongoClients.create(connectionString);
    }

    public ArrayList<String[]> getNames(){
        MongoDatabase database = mongoClient.getDatabase("AREPMongo");
        MongoCollection<Document> collection =database.getCollection("logs");
        FindIterable fit = collection.find();
        ArrayList<Document> docs = new ArrayList<Document>();
        ArrayList<String[]> results = new ArrayList<>();
        fit.into(docs);
        for (Document doc : docs) {
            if (doc.get("mensaje")!= null && doc.get("fecha")!=null){
                results.add(new String[]{doc.get("mensaje").toString(), doc.get("fecha").toString()});
            }
        }
        return results;
    }
}
