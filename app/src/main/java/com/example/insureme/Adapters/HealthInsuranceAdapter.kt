package com.example.insureme
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insureme.ViewModel.HealthInsuranceViewModel
import com.example.insureme.Views.healthinsurance_dataclass

import com.example.insureme.Views.standard_packageinsurancepage_health

class HealthInsuranceAdapterNew(private val Healthinsurances: List<healthinsurance_dataclass>) :
    RecyclerView.Adapter<HealthInsuranceAdapterNew.HealthInsuranceViewHolder>() {

    class HealthInsuranceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val image = itemView.findViewById<ImageView>(R.id.insurance_company_image)
        val title = itemView.findViewById<TextView>(R.id.healthinsurance_company_title)
        val description = itemView.findViewById<TextView>(R.id.healthinsurance_company_description)
        val price = itemView.findViewById<TextView>(R.id.healthinsurance_company_price)
        val image=itemView.findViewById<ImageView>(R.id.healthinsurance_company_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthInsuranceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.healthinsurance_list_cards, parent, false)
        return HealthInsuranceViewHolder(view)
    }
    override fun getItemCount() = Healthinsurances.size

    override fun onBindViewHolder(holder: HealthInsuranceViewHolder, position: Int) {
        val insurance = Healthinsurances[position]
        holder.title.text = insurance.companyName
        holder.description.text = insurance.desc
        holder.price.text = insurance.price.toString()
        holder.itemView.setOnClickListener{
            val context=holder.itemView.context
            val intent=Intent(context,standard_packageinsurancepage_health::class.java)
            intent.putExtra("title",insurance.companyName)
            intent.putExtra("price",insurance.price.toString())
            intent.putExtra("desc",insurance.desc)
            context.startActivity(intent)
        }
        if(holder.title.text.equals("Bajaj Allianz"))
        {
            holder.image.setImageResource(R.drawable.maxlife)
        }
        if (holder.title.text.equals("HDFC Life Insurance"))
        {
            holder.image.setImageResource(R.drawable.insurance1)
        }
        if(holder.title.text.equals("SBI General Insurance"))
        {
            holder.image.setImageResource(R.drawable.sbigen)
        }

        if(holder.title.text.equals("Max Life Insurance"))
        {
            holder.image.setImageResource(R.drawable.maxlife)
        }

        else {
            holder.image.setImageResource(R.drawable.insurance2)
        }

//        else
//        {
//            holder.image.setImageResource(R.drawable.insurance2)
//        }
        // Use Picasso or Glide library to load the image from the URL
        // Picasso.get().load(insurance.image).into(holder.image)
    }
}
class HealthInsuranceActivityNew : AppCompatActivity() {
    private lateinit var viewModel: HealthInsuranceViewModel
    private lateinit var adapter: HealthInsuranceAdapterNew
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.healthinsurance_list_cards)
        val HealthinsuranceCompanyListViewNew = findViewById<RecyclerView>(R.id.healthinsurance_company_list)
        viewModel = ViewModelProvider(this).get(HealthInsuranceViewModel::class.java)
        lifecycleScope.launch {

            viewModel.healthfetchInsurances()
        }
        viewModel.Healthinsurances.observe(this, Observer {
            adapter = HealthInsuranceAdapterNew(it)
            HealthinsuranceCompanyListViewNew.adapter = adapter
        })

        HealthinsuranceCompanyListViewNew.layoutManager = LinearLayoutManager(this)
    }
    fun goToStandardInsuranceHealth(view:View)
    {
        startActivity(Intent(this, standard_packageinsurancepage_health::class.java))
    }
}

