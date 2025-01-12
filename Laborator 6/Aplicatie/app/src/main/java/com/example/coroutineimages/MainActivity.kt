package com.example.coroutineimages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coroutineimages.ui.theme.CoroutineImagesTheme
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val imageUrls = listOf(
        "http://cti.ubm.ro/cmo/digits/img0.jpg",
        "http://cti.ubm.ro/cmo/digits/img1.jpg",
        "http://cti.ubm.ro/cmo/digits/img2.jpg",
        "http://cti.ubm.ro/cmo/digits/img3.jpg",
        "http://cti.ubm.ro/cmo/digits/img4.jpg",
        "http://cti.ubm.ro/cmo/digits/img5.jpg",
        "http://cti.ubm.ro/cmo/digits/img6.jpg",
        "http://cti.ubm.ro/cmo/digits/img7.jpg",
        "http://cti.ubm.ro/cmo/digits/img8.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViews = listOf(
            findViewById<ImageView>(R.id.image1),
            findViewById<ImageView>(R.id.image2),
            findViewById<ImageView>(R.id.image3),
            findViewById<ImageView>(R.id.image4),
            findViewById<ImageView>(R.id.image5),
            findViewById<ImageView>(R.id.image6),
            findViewById<ImageView>(R.id.image7),
            findViewById<ImageView>(R.id.image8),
            findViewById<ImageView>(R.id.image9)
        )

        CoroutineScope(Dispatchers.Main).launch {
            loadImages(imageViews)
        }
    }

    private suspend fun loadImages(imageViews: List<ImageView>) {
        imageUrls.zip(imageViews).forEach { (url, imageView) ->
            Picasso.get().load(url).into(imageView)
        }
    }
}