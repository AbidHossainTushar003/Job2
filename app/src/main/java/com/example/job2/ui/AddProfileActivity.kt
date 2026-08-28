package com.example.job2.ui

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.job2.R
import com.example.job2.data.local.ProfileDatabase
import com.example.job2.data.model.UserProfile
import com.example.job2.data.repository.ProfileRepository
import com.example.job2.databinding.ActivityAddProfileBinding
import com.example.job2.viewmodel.ProfileViewModel
import com.example.job2.viewmodel.ProfileViewModelFactory
import java.util.Calendar

class AddProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private var editProfile: UserProfile? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = ProfileDatabase.getDatabase(this).profileDao()
        viewModel = ViewModelProvider(
            this,
            ProfileViewModelFactory(ProfileRepository(dao))
        )[ProfileViewModel::class.java]

        editProfile = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("profile", UserProfile::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("profile") as? UserProfile
        }

        editProfile?.let {
            binding.etName.setText(it.name)
            binding.etEmail.setText(it.email)
            binding.etDob.setText(it.dob)
            binding.etDistrict.setText(it.district)
            binding.etMobile.setText(it.mobile)
            binding.btnSave.text = getString(R.string.update_profile)
        }

        binding.etDob.setOnClickListener {
            showDatePicker()
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val dob = binding.etDob.text.toString().trim()
            val district = binding.etDistrict.text.toString().trim()
            val mobile = binding.etMobile.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || dob.isEmpty() || district.isEmpty() || mobile.isEmpty()) {
                Toast.makeText(this, getString(R.string.fill_all_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val profile = UserProfile(
                id = editProfile?.id ?: 0,
                name = name,
                email = email,
                dob = dob,
                district = district,
                mobile = mobile,
            )

            if (editProfile == null) {
                viewModel.insert(profile)
                Toast.makeText(this, getString(R.string.profile_saved), Toast.LENGTH_SHORT).show()
            } else {
                viewModel.update(profile)
                Toast.makeText(this, getString(R.string.profile_updated), Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        
        val dobString = binding.etDob.text.toString()
        if (dobString.isNotEmpty()) {
            val parts = dobString.split("/")
            if (parts.size == 3) {
                try {
                    calendar.set(Calendar.DAY_OF_MONTH, parts[0].toInt())
                    calendar.set(Calendar.MONTH, parts[1].toInt() - 1)
                    calendar.set(Calendar.YEAR, parts[2].toInt())
                } catch (_: Exception) {}
            }
        }
        
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.etDob.setText(date)
            },
            year,
            month,
            day
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show()
    }
}
