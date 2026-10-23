package com.project.exp10

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    data class Contact(val name: String, val number: String)

    private lateinit var tvContactCount: TextView
    private lateinit var tvEmpty: TextView
    private lateinit var layoutContactList: View
    private lateinit var llContactItems: LinearLayout
    private lateinit var layoutContactDetail: View
    private lateinit var tvDetailName: TextView
    private lateinit var tvDetailNumber: TextView
    private lateinit var btnBackToList: Button

    private val permissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            if (granted) {
                loadContacts()
            } else {
                Toast.makeText(
                    this,
                    "Permission is required to read contacts",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvContactCount = findViewById(R.id.tvContactCount)
        tvEmpty = findViewById(R.id.tvEmpty)
        layoutContactList = findViewById(R.id.layoutContactList)
        llContactItems = findViewById(R.id.llContactItems)
        layoutContactDetail = findViewById(R.id.layoutContactDetail)
        tvDetailName = findViewById(R.id.tvDetailName)
        tvDetailNumber = findViewById(R.id.tvDetailNumber)
        btnBackToList = findViewById(R.id.btnBackToList)

        val btnLoadContacts = findViewById<Button>(R.id.btnLoadContacts)

        btnLoadContacts.setOnClickListener {
            checkPermissionAndLoad()
        }

        btnBackToList.setOnClickListener {
            showContactList()
        }
    }

    private fun checkPermissionAndLoad() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            loadContacts()
        } else {
            permissionLauncher.launch(
                Manifest.permission.READ_CONTACTS
            )
        }
    }

    private fun loadContacts() {
        val contacts = mutableListOf<Contact>()
        var count = 0

        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )

        try {
            contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                projection,
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
            )?.use { cursor ->

                val nameIndex = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                )

                val numberIndex = cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.NUMBER
                )

                while (cursor.moveToNext()) {
                    val name = cursor.getString(nameIndex)
                        ?: "Unknown Contact"

                    val number = cursor.getString(numberIndex)
                        ?: "No phone number"

                    contacts.add(Contact(name, number))
                    count++
                }
            }

            tvContactCount.text = "$count phone entries found"
            llContactItems.removeAllViews()

            if (contacts.isNotEmpty()) {
                for (contact in contacts) {
                    val itemView = TextView(this).apply {
                        text = "👤  ${contact.name}\n      ${contact.number}"
                        textSize = 15f
                        setTextColor(0xFF1E293B.toInt())
                        setPadding(32, 28, 32, 28)
                        setBackgroundResource(R.drawable.bg_card)
                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        ).apply {
                            setMargins(0, 0, 0, 16)
                        }
                        isClickable = true
                        isFocusable = true

                        setOnClickListener {
                            showContactDetail(contact)
                        }
                    }
                    llContactItems.addView(itemView)
                }

                layoutContactList.visibility = View.VISIBLE
                layoutContactDetail.visibility = View.GONE
                tvEmpty.visibility = View.GONE
            } else {
                layoutContactList.visibility = View.VISIBLE
                layoutContactDetail.visibility = View.GONE
                tvEmpty.text = "No contacts found on this device."
                tvEmpty.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            layoutContactList.visibility = View.VISIBLE
            layoutContactDetail.visibility = View.GONE
            tvEmpty.text = "Unable to load contacts. Please try again."
            tvEmpty.visibility = View.VISIBLE

            Toast.makeText(
                this,
                "Error loading contacts",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun showContactDetail(contact: Contact) {
        tvDetailName.text = contact.name
        tvDetailNumber.text = contact.number
        layoutContactList.visibility = View.GONE
        layoutContactDetail.visibility = View.VISIBLE
    }

    private fun showContactList() {
        layoutContactDetail.visibility = View.GONE
        layoutContactList.visibility = View.VISIBLE
    }
}
