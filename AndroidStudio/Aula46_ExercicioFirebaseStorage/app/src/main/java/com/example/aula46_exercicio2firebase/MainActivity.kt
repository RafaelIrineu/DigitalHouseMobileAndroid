package com.example.aula46_exercicio2firebase

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.net.toFile
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import java.lang.System.currentTimeMillis

class MainActivity : AppCompatActivity() {

    private var imageURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        obterArquivo()

        findViewById<Button>(R.id.btnProcurar).setOnClickListener {
            procurarArquivo()
        }

        findViewById<Button>(R.id.btnEnviar).setOnClickListener {
            enviarArquivo()
        }
    }

    fun procurarArquivo() {
        val intent = Intent()
        //type é o tipo de informação que eu quero buscar (mime type)
        //se colocar image/* aceita-se qualquer formato, png, gif etc
        //se colocar só * ele aceita tudo
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, CONTENT_REQUEST_CODE)
    }

    fun obterArquivo() {
        val firebase = FirebaseStorage.getInstance()
        val storage = firebase.getReference("uploads")

        storage.child("1610760346695.jpg").downloadUrl.addOnSuccessListener {
            Picasso.get().load(it).into(findViewById<ImageView>(R.id.imgPreview))
        }
    }

    fun enviarArquivo() {
        imageURI?.run {
            val firebase = FirebaseStorage.getInstance()
            val storage = firebase.getReference("uploads")

            val extension = MimeTypeMap.getSingleton()
                .getExtensionFromMimeType(contentResolver.getType(imageURI!!))

            val fileReference = storage.child("${currentTimeMillis()}.${extension}")

            //bytes para arquivos pequenos, files arquivos normais e stream para arquivos grandes
            fileReference.putFile(this)
                .addOnSuccessListener {
                    Toast.makeText(this@MainActivity, "Sucesso", Toast.LENGTH_SHORT).show()
                    Log.d("PROGRESS", fileReference.toString())
                }
                .addOnFailureListener {
                    Toast.makeText(this@MainActivity, "Deu ruim", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener {
                    Log.d("PROGRESS",(it.bytesTransferred / it.totalByteCount * 100.0).toString())
                    //Log.d("PROGRESS", it.toString())
                    //val p: ProgressBar? = null
                    //p.progress = it
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CONTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            imageURI = data?.data
            findViewById<ImageView>(R.id.imgPreview).setImageURI(imageURI)
        }
    }

    companion object {
        const val CONTENT_REQUEST_CODE = 1
    }
}