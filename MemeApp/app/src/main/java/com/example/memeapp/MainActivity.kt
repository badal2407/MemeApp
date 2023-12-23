package com.example.memeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.memeapp.databinding.ActivityMainBinding
import org.json.JSONObject
/*
class MainActivity : AppCompatActivity() {

    val url:String = "https://meme-api.com/gimme"
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMeme()

        binding.btnMeme.setOnClickListener{
            getMeme()
        }
    }

     fun getMeme() {

         val queue = Volley.newRequestQueue(this)
         val stringRequest = StringRequest(
                 Request.Method.GET,url,
             {response ->

                 var responseObject = JSONObject(response)

                 binding.memeTitle.text= responseObject.getString("title")
                 binding.memeAuthor.text = responseObject.getString("author")
                 Glide.with(this).load(responseObject.get("url")).into(binding.memeImage)

             },{
                 error ->
                 Toast.makeText(this,"${error.localizedMessage}",Toast.LENGTH_LONG).show()
             })

         queue.add(stringRequest)
    }
}
*/

class MainActivity : AppCompatActivity() {

    val url:String = "https://meme-api.com/gimme"
    lateinit var img:ImageView
    lateinit var tv_title:TextView
    lateinit var tv_author:TextView
    lateinit var btn_meme:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Base_Theme_MemeApp)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.memeImage)
        tv_title = findViewById(R.id.memeTitle)
        tv_author = findViewById(R.id.memeAuthor)
        btn_meme = findViewById(R.id.btn_meme)

        getMeme()

        btn_meme.setOnClickListener{
            getMeme()
        }
    }

    fun getMeme() {

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {response ->

                var responseObject = JSONObject(response)

                tv_title.text= responseObject.getString("title")
                tv_author.text = responseObject.getString("author")
                Glide.with(this).load(responseObject.get("url")).into(img)

            },{
                    error ->
                Toast.makeText(this,"${error.localizedMessage}",Toast.LENGTH_LONG).show()
            })

        queue.add(stringRequest)
    }
}