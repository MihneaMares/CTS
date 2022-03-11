package Seminar3;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static Seminar3.AppConstants.MongoConstants.*;

public class MongoOperations {
    public void mongoDb() {
        MongoClient mongoClient = new MongoClient("localhost", Port);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");

        if(mongoDb.getCollection(employeesCollection) != null) {
            mongoDb.getCollection(employeesCollection).drop();
        }

        mongoDb.createCollection(employeesCollection);

        Document employee1 = new Document().append(employeeName, "Popescu Ion").
                append(employeeAddress, "Bucharest").append(employeeSalary, 4000);

        MongoCollection<Document> collection = mongoDb.getCollection(employeesCollection);
        collection.insertOne(employee1);

        Document employee2 = new Document().append(employeeName, "Ionescu Vasile").
                append(employeeSalary, 4500);
        collection.insertOne(employee2);

        FindIterable<Document> result = collection.find();
        for(Document doc : result) {
            System.out.println(doc);
        }
        mongoClient.close();
    }

}
