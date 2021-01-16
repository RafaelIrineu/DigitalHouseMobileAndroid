package com.example.aula46_exerciciofirebase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

data class Usuario(val name: String = "", val idade: Int = 1)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("usuario")

        //myRef.setValue("Hello, World!")

        //myRef.setValue(Usuario(RafaelIrineu,20))

        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val usuarioSalvo = DataSnapshot.getValue(Usuario::class.java)
                Toast.makeText(applicationContext, value?.name, Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(error: DatabaseError) {
                //Failed
            }
        })
    }
}