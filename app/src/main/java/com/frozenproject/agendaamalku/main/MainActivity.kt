package com.frozenproject.agendaamalku.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frozenproject.agendaamalku.DetailPantis
import com.frozenproject.agendaamalku.DetailProfile
import com.frozenproject.agendaamalku.R
import com.frozenproject.agendaamalku.adapter.ListPantisAdapter
import com.frozenproject.agendaamalku.data.PantisData


class MainActivity : AppCompatActivity() {
    private lateinit var rvPanti_Asuhan: RecyclerView
    private var list: ArrayList<Panti_Asuhan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPanti_Asuhan = findViewById(R.id.rv_panti_asuhan)
        rvPanti_Asuhan.setHasFixedSize(true)

        list.addAll(PantisData().listData)
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_profile -> {
            val profileDetail = Intent(this@MainActivity, DetailProfile::class.java)
            profileDetail.putExtra(DetailProfile.namaDeveloper, "Gusti Reno Kurniawan")
            profileDetail.putExtra(DetailProfile.emailDeveloper, "renokurniawan39@gmail.com")
            profileDetail.putExtra(DetailProfile.fotoProfile, R.drawable.profile_picture)
            startActivity(profileDetail)

            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun showRecyclerList() {
        rvPanti_Asuhan.layoutManager = LinearLayoutManager(this)

        val listPantisAdapter = ListPantisAdapter(list)

        rvPanti_Asuhan.adapter = listPantisAdapter

        listPantisAdapter.setOnItemClickCallback(object : ListPantisAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Panti_Asuhan) {
                val pantiDetail = Intent(this@MainActivity, DetailPantis::class.java)
                pantiDetail.putExtra(DetailPantis.nama, data.name)
                pantiDetail.putExtra(DetailPantis.alamat, data.address)
                pantiDetail.putExtra(DetailPantis.details, data.detail)
                pantiDetail.putExtra(DetailPantis.photos, data.photo)

                startActivity(pantiDetail)
            }
        })
    }


}

