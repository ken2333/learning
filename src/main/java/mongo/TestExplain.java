package mongo;

import com.alibaba.fastjson.JSONArray;
import com.mongodb.MongoClient;
import com.mongodb.ReadConcern;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.BSON;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.Configuration;

/**
 * describe: 连接mongo进行增删改查
 *
 * @author syh
 * @date 2020/05/19
 */
public class TestExplain {
    MongoClient mongoClient;

    @Before
    public void init() {
        //连接到 mongodb 服务
        mongoClient = new MongoClient("192.168.186.12");
    }


    @Test
    public void insert() {
        //获取指定的数据库
        MongoDatabase test = mongoClient.getDatabase("student");
        //获取指定的集合
        MongoCollection<Document> test1 = test.getCollection("student");
        Document document = new Document("name", "小明");
        document.append("age", 29);
        document.append("greed", "大五");
        document.append("tag", new String[]{"学生","党员"});

        //插入数据
        test1.insertOne(document);


    }

    @Test
    public void delete() {
        MongoDatabase student = mongoClient.getDatabase("student");
        MongoCollection<Document> collection = student.getCollection("student");
        //创建条件
        Bson filter = Filters.eq("name", "小米");
        //删除与之匹配的集合
        collection.deleteOne(filter);
    }

    @Test
    public void update() {
        MongoDatabase student = mongoClient.getDatabase("student");
        MongoCollection<Document> collection = student.getCollection("student");
        Bson filter = Filters.eq("name", "小赵");
        Document newDocument = new Document("age", 23);
        newDocument.append("greed", "大三");
        Document document = new Document("$set", newDocument);

        collection.updateOne(filter, document);
    }


    @Test
    public void find() {
        MongoDatabase student = mongoClient.getDatabase("student");
        MongoCollection<Document> collection = student.getCollection("student");
        Bson filiter = Filters.eq("age", 12);
        FindIterable<Document> documents = collection.find(filiter);
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            Document next = iterator.next();
            System.out.println(next.toString());
        }
    }
}
