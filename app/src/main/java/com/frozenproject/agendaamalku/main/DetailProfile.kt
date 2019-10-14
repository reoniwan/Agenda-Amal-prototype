package com.frozenproject.agendaamalku

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_detail)

        val actionBar = supportActionBar
        actionBar!!.title = "About"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvDeveloper: TextView = findViewById(R.id.tv_developer)
        val tvEmail: TextView = findViewById(R.id.tv_email)
        val ivFoto: ImageView = findViewById(R.id.profile_picture)

        val showDeveloper = intent.getStringExtra(namaDeveloper)
        val showEmail = intent.getStringExtra(emailDeveloper)
        val showFoto = intent.getIntExtra(fotoProfile, 0)

        val textDeveloper = showDeveloper
        tvDeveloper.text = textDeveloper

        val textEmail = showEmail
        tvEmail.text = textEmail

        Glide.with(this)
            .load(showFoto)
            .apply(RequestOptions())
            .into(ivFoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val namaDeveloper = "Nama_Developer"
        const val emailDeveloper = "Email_Developer"
        const val fotoProfile = "Foto_Profil"
    }
}