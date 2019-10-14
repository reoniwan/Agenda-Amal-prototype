package com.frozenproject.agendaamalku


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.pantis_detail.*


class DetailPantis : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantis_detail)

        val actionBar = supportActionBar
        actionBar!!.title = ""

        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvAddress: TextView = findViewById(R.id.tv_item_address)
        val tvDetails: TextView = findViewById(R.id.tv_item_detail)
        val ivPhoto: ImageView = findViewById(R.id.img_item_photo)

        val showName = intent.getStringExtra(nama)
        val showAddress = intent.getStringExtra(alamat)
        val showDetails = intent.getStringExtra(details)
        val showPhoto = intent.getIntExtra(photos, 0)

        val textNama = showName
        tvName.text = textNama

        val textAddress = showAddress
        tvAddress.text = textAddress

        val textDetail = showDetails
        tvDetails.text = textDetail

        Glide.with(this)
            .asBitmap()
            .load(showPhoto)
            .apply(RequestOptions())
            .into(ivPhoto)

        btn_Donasi.setOnClickListener {
            Toast.makeText(this, "Anda Memilih untuk Berdonasi", Toast.LENGTH_LONG).show()
        }

        btn_Kunjungi.setOnClickListener {
            Toast.makeText(this, "Anda Memilih Untuk Berkunjung", Toast.LENGTH_LONG).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val nama = "Nama_Panti"
        const val alamat = "Alamat_Panti"
        const val details = "Detail_Panti"
        const val photos = "Photo"
    }


}
