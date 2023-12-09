package com.example.appquanlynhansu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appquanlynhansu.Activity.DangNhap_Activity
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.bson.Document

class MainActivity : AppCompatActivity() {

    private lateinit var mongoDatabase: MongoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonHello = findViewById<Button>(R.id.buttonHello)

        buttonHello.setOnClickListener {
            val intent = Intent(this, DangNhap_Activity::class.java)
            intent.putExtra("key", "value")
            startActivity(intent)
        }

        if (connectToMongoDB()) {
            Log.d("MongoDB Connection", "Connection OK")
            showToast("MongoDB OK")
            // Thực hiện các thao tác với MongoDB ở đây
//            val collection = mongoDatabase.getCollection("TaiKhoan")
//            val firstDocument = collection.find().first()
//            if (firstDocument != null) {
//
//                // Process the first document
//                Toast.makeText(this,firstDocument.toJson(), Toast.LENGTH_LONG)
//                Log.e("Infor",firstDocument.toJson())
//            } else {
//                Toast.makeText(this,"Không có dữ liệu", Toast.LENGTH_LONG)
//            }
        } else {
            Log.e("MongoDB Connection", "Connection failed")
            showToast("NO")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun connectToMongoDB(): Boolean {
        return try {
            Log.e("Infor","Connect database begin")
            //val uri = MongoClientURI("mongodb://ducnt:mtDD11mw40doOhZs@localhost:27017/QuanLyNhanSu")
            val uri = MongoClientURI("mongodb://ducnt:v6jRdlo8AwKMbcOM@cluster0.b19vchi.mongodb.net/?retryWrites=true&w=majority")
            val mongoClient = MongoClient(uri)
            mongoDatabase = mongoClient.getDatabase("QuanLyNhanSu")

            true
        } catch (e: Exception) {
            Log.e("MongoDB Connection", "Error: ${e.message}")
            false
        }
    }
    private fun performMongoDBOperations() {
        // Them Tao lieu
        val collection = mongoDatabase.getCollection("QuanLyNhanSu")
        val document = Document("key", "value")
        collection.insertOne(document)

        // Truy Van
        val query = Filters.eq("key", "value")
        val cursor = collection.find(query).iterator()
        while (cursor.hasNext()) {
            val result = cursor.next()
            // Ket qua
        }
    }
}