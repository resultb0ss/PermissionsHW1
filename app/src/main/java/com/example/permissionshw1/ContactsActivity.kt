package com.example.permissionshw1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.permissionshw1.databinding.ActivityContactsBinding
import com.example.permissionshw1.databinding.ActivityGalleryBinding

class ContactsActivity : AppCompatActivity() {

    private var _binding: ActivityContactsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val persons = PersonsDataBase.persons
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomAdapter(persons)


        binding.ExitButtonBTN.setOnClickListener{
            this.finishAffinity()
        }

        binding.BackButtonBTN.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}