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
import com.example.insureme.ViewModel.CarInsuranceViewModel
import com.example.insureme.DataClasses.carinsurance_dataclass

import com.example.insureme.Views.standard_packageinsurancepage_car
import com.example.insureme.Views.standard_packageinsurancepage_health

class InsuranceAdapterNew(private val insurances: List<carinsurance_dataclass>) :
    RecyclerView.Adapter<InsuranceAdapterNew.InsuranceViewHolder>() {

    class InsuranceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // val image = itemView.findViewById<ImageView>(R.id.insurance_company_image)
        val title = itemView.findViewById<TextView>(R.id.insurance_company_title)
        val description = itemView.findViewById<TextView>(R.id.insurance_company_description)
        val price = itemView.findViewById<TextView>(R.id.insurance_company_price)
        val image=itemView.findViewById<ImageView>(R.id.insurance_company_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuranceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.insurance_list_cards, parent, false)
        return InsuranceViewHolder(view)
    }
    override fun getItemCount() = insurances.size

    override fun onBindViewHolder(holder: InsuranceViewHolder, position: Int) {
        val insurance = insurances[position]
        holder.title.text = insurance.companyName
        holder.description.text = insurance.desc
        holder.price.text = "₹"+insurance.price.toString()
        holder.itemView.setOnClickListener{
            val context=holder.itemView.context
            val intent=Intent(context,standard_packageinsurancepage_car::class.java)
            intent.putExtra("title",insurance.companyName)
            intent.putExtra("price",insurance.price.toString())
            intent.putExtra("desc",insurance.desc)
            context.startActivity(intent)
        }
        if (holder.title.text.equals("HDFC"))
        {
            holder.image.setImageResource(R.drawable.insurance1)
        }
        else if (holder.title.text.equals("MAX"))
        {
            holder.image.setImageResource(R.drawable.maxlife)
        }
        else if(holder.title.text.equals(("ICICI Lombard")))
        {
            holder.image.setImageResource(R.drawable.icici)
        }
        else if(holder.title.text.equals(("TATA AIG")))
        {
            holder.image.setImageResource(R.drawable.tata)
        }
        else if(holder.title.text.equals(("Reliance General Insurance")))
        {
            holder.image.setImageResource(R.drawable.reliance)
        }
        else
        {
            holder.image.setImageResource(R.drawable.insurance2)
        }
        // Use Picasso or Glide library to load the image from the URL
        // Picasso.get().load(insurance.image).into(holder.image)
    }
}
class InsuranceActivityNew : AppCompatActivity() {
    private lateinit var viewModel: CarInsuranceViewModel
    private lateinit var adapter: InsuranceAdapterNew
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.insurance_list_cards)
        val insuranceCompanyListViewNew = findViewById<RecyclerView>(R.id.insurance_company_list)
        viewModel = ViewModelProvider(this).get(CarInsuranceViewModel::class.java)
        lifecycleScope.launch {

            viewModel.fetchInsurances()
        }
        viewModel.insurances.observe(this, Observer {
            adapter = InsuranceAdapterNew(it)
            insuranceCompanyListViewNew.adapter = adapter
        })

        insuranceCompanyListViewNew.layoutManager = LinearLayoutManager(this)
    }
    fun goToStandardInsuranceCar(view:View)
    {
        startActivity(Intent(this, standard_packageinsurancepage_car::class.java))

    }

}

