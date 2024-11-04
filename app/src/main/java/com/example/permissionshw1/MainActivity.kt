package com.example.permissionshw1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.permissionshw1.databinding.ActivityMainBinding
import android.Manifest
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contactsPermissionButton.setOnClickListener {
            permissionLauncherContacts.launch(Manifest.permission.READ_CONTACTS)
        }


        binding.cameraPermissionButton.setOnClickListener {
            permissionLauncherCamera.launch(Manifest.permission.CAMERA)

        }

        binding.ExitButtonBTN.setOnClickListener{
            this.finishAffinity()
        }

        binding.BackButtonBTN.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }


    }


    private val permissionLauncherCamera = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
        ) { isGranted ->
        if (isGranted) {
            startActivity(Intent(this@MainActivity,GalleryActivity::class.java))
            Toast.makeText(this@MainActivity, "Разрешение на использование камеры дано", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this@MainActivity, "Разрешение на использование камеры не дано!!", Toast.LENGTH_SHORT).show()
        }
    }

    private val permissionLauncherContacts = registerForActivityResult(
        ActivityResultContracts.RequestPermission()

    ) { isGranted ->
        if (isGranted) {
            startActivity(Intent(this@MainActivity,ContactsActivity::class.java))
            Toast.makeText(this@MainActivity, "Разрешение на использование контактов дано", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this@MainActivity, "Разрешение на использование контактов не дано!!", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}