package ru.otus.bee.changelog;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "addLermontov", author = "Anton")
    public void insertLermontov(DB db) {
        DBCollection myCollection = db.getCollection("books");
        BasicDBObject doc = new BasicDBObject().append("name_book", "Война и мир")
                .append("author","Толстой")
                .append("genre","Роман");
        myCollection.insert(doc);
    }
}
