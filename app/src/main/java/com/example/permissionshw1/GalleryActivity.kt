package com.example.permissionshw1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.permissionshw1.databinding.ActivityGalleryBinding
import com.example.permissionshw1.databinding.ActivityMainBinding

class GalleryActivity : AppCompatActivity() {

    private var _binding: ActivityGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        _binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ExitButtonBTN.setOnClickListener{
            this.finishAffinity()
        }

        binding.BackButtonBTN.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}