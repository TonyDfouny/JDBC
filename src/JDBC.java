import java.util.List;
import java.util.Set;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class JDBC {
    public static void main(String[] args )throws Exception{
        try{
            MongoClient mongoClient = new MongoClient("localhost",27017);
            //DB db = mongoClient.getDB("test");
            List<String> databases = mongoClient.getDatabaseNames();
            System.out.println("Conected");
            for (String dbName : databases) {
                System.out.println("- Database: " + dbName);

                DB db = mongoClient.getDB(dbName);

                Set<String> collections = db.getCollectionNames();
                for (String colName : collections) {
                    System.out.println("\t + Collection: " + colName);
                }
            }

            mongoClient.close();

        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
