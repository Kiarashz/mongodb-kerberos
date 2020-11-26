package test

import com.mongodb.*
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients

fun main(args: Array<String>) {
    val user = "kiarash"
    val uri = "mongodb://${user}%40EXAMPLE.COM@server1.example.com:27017,server2.example.com:27017,server3.example.com/?authMechanism=GSSAPI&ssl=true"
    var mongoClient: MongoClient? = null
    println("""java.security.krb5.realm: ${System.getProperty("java.security.krb5.realm")}""")
    println(""":javax.net.ssl.trustStore ${System.getProperty("javax.net.ssl.trustStore")}""")
    println("""java.security.krb5.kdc: ${System.getProperty("java.security.krb5.kdc")}""")
    println("""mongodb URI: ${uri}""")
    try {
        mongoClient = MongoClients.create(uri)
        println("Created MongoClient.")
        val database = mongoClient.getDatabase("test")
        val collection = database.getCollection("users")
        println(collection.countDocuments())
    } catch (e: MongoException) {
        e.printStackTrace()
    } finally {
        mongoClient!!.close()
    }
}
