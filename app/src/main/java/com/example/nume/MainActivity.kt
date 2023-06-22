package com.example.nume
import com.example.nume.Domain.CategoryDomain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nume.Adapter.CategoryAdapter
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import android.widget.VideoView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewCategoryList: RecyclerView
    private lateinit var imageView: ImageView
    private val CAMERA_REQUEST_CODE = 1
    private lateinit var videoView: VideoView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewCategory()

        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            openCamera()

        }

        videoView = findViewById(R.id.videoView)
        val videoUri = Uri.parse("android.resource://$packageName/${R.raw.movie}")
        videoView.setVideoURI(videoUri)
        videoView.start()

        val homeView = findViewById<ImageView>(R.id.homeView)
        homeView.setOnClickListener {
            startActivity(Intent(this@MainActivity, IntroActivity::class.java))
        }

        val profilView = findViewById<ImageView>(R.id.profilView)
        profilView.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
        }

        val contactView = findViewById<ImageView>(R.id.contactView)
        contactView.setOnClickListener {
            startActivity(Intent(this@MainActivity, ContactActivity::class.java))
        }
        val fabButton = findViewById<FloatingActionButton>(R.id.fabButton)
        val animator = ObjectAnimator.ofFloat(fabButton, "rotation", 0f, 360f)
        animator.duration = 1000 // Set the animation duration in milliseconds
        animator.repeatCount = ObjectAnimator.INFINITE // Repeat the animation indefinitely
        animator.start() // Start the rotation animation
    }

    private fun recyclerViewCategory() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCategoryList = findViewById(R.id.recyclerView)
        recyclerViewCategoryList.layoutManager = linearLayoutManager
        val category = ArrayList<CategoryDomain>()
        category.add(CategoryDomain("Piept", "cat_1"))
        category.add(CategoryDomain("Spate", "cat_2"))
        category.add(CategoryDomain("Umeri", "cat_3"))
        category.add(CategoryDomain("Biceps", "cat_4"))
        category.add(CategoryDomain("Triceps", "cat_5"))
        category.add(CategoryDomain("Picioare", "cat_6"))

        val adapter = CategoryAdapter(category)
        recyclerViewCategoryList.adapter = adapter
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
    }
    private fun shareImage(imageUri: Uri) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/jpeg"
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
        startActivity(Intent.createChooser(shareIntent, "Share Image"))
    }
    private fun getImageUri(bitmap: Bitmap): Uri {
        val path = MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Image Title", null)
        return Uri.parse(path)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
            showNotification("Image captured!")
            val imageUri = getImageUri(imageBitmap)
            shareImage(imageUri)
        }
    }
    private fun showNotification(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}
