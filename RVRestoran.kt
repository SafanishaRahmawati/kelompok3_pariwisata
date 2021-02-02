package com.example.kelompok3.adapters.pengguna

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok3.R
import com.example.kelompok3.activity.pengguna.restoran.DetailRestoranActivity
import com.example.kelompok3.model.Restoran
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class RVRestoran : RecyclerView.Adapter<RVRestoran.MyViewHolder?>, Filterable {
    private var mContext: Context? = null
    private var mData: MutableList<Restoran?>? = mutableListOf()
    var option: RequestOptions? = null

    constructor(mContext: Context?, mData: MutableList<Restoran?>?) {
        this.mContext = mContext
        this.mData = mData
        option = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)
    }

    constructor(mData: MutableList<Restoran?>?) {
        this.mData = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val inflater = LayoutInflater.from(mContext)
        view = inflater.inflate(R.layout.item_restoran, parent, false)
        val viewHolder: MyViewHolder = MyViewHolder(view)
        viewHolder.view_containerRR?.setOnClickListener(View.OnClickListener {
            val i = Intent(mContext, DetailRestoranActivity::class.java)
            i.putExtra("tvHomestay", mData?.get(viewHolder.adapterPosition)?.getNama_restoran())
            i.putExtra("tvDeskripsi", mData?.get(viewHolder.adapterPosition)?.getDeskripsi_restoran())
            i.putExtra("imgThumb", mData?.get(viewHolder.adapterPosition)?.getThumb_restoran())
            i.putExtra("tvNavigasii", mData?.get(viewHolder.adapterPosition)?.getNavigasi_restoran())
            i.putExtra("email", mData?.get(viewHolder.adapterPosition)?.getEmail_restoran())
            i.putExtra("alamat", mData?.get(viewHolder.adapterPosition)?.getAlamat_restoran())
            i.putExtra("notelp", mData?.get(viewHolder.adapterPosition)?.getNotelp_restoran())
            mContext?.startActivity(i)
        })
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val c = mData?.get(position)?.getNon_aktif()
        if (c == "1") {
            holder.tvNamaR?.setText(mData?.get(position)?.getNama_restoran())
            holder.tvDeskripsiR?.setText(mData?.get(position)?.getDeskripsi_restoran())
            holder.tv_navigasiR?.setText(mData?.get(position)?.getNavigasi_restoran())
            holder.tvNoTelR?.setText(mData?.get(position)?.getNotelp_restoran())
            holder.tvEmailR?.setText(mData?.get(position)?.getEmail_restoran())
            holder.tvAlamatR?.setText(mData?.get(position)?.getAlamat_restoran())

            //Load Image
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_restoran()).apply(option!!).into(holder.img_thumbR!!)
        } else {
            holder.tvNamaR?.setText(mData?.get(position)?.getNama_restoran())
            holder.llmanipulasi?.setVisibility(View.VISIBLE)
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_restoran()).apply(option!!).into(holder.img_thumbR!!)
        }
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNamaR: TextView?
        var tvDeskripsiR: TextView?
        var tv_navigasiR: TextView?
        var tvEmailR: TextView?
        var tvNoTelR: TextView?
        var tvAlamatR: TextView?
        var img_thumbR: ImageView?
        var view_containerRR: RelativeLayout?
        var llmanipulasi: LinearLayout?

        init {
            tvNamaR = itemView.findViewById(R.id.tvHomestayRR)
            tvDeskripsiR = itemView.findViewById(R.id.tvDeskripsiRR)
            tv_navigasiR = itemView.findViewById(R.id.tvNavigasiiRR)
            tvEmailR = itemView.findViewById(R.id.emailRR)
            tvNoTelR = itemView.findViewById(R.id.notelpRR)
            tvAlamatR = itemView.findViewById(R.id.alamatRR)
            img_thumbR = itemView.findViewById(R.id.imgThumbRR)
            view_containerRR = itemView.findViewById(R.id.containerRR)
            llmanipulasi = itemView.findViewById(R.id.llManipulasi004)
        }
    }

    override fun getFilter(): Filter? {
        return pariwisataFilter
    }

    private val pariwisataFilter: Filter? = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults? {
            val filteredList: MutableList<Restoran?> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(mData!!)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
                for (item in mData!!) {
                    if (item?.getNama_restoran()?.toLowerCase()?.contains(filterPattern) == true) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            mData?.clear()
            mData?.addAll(results?.values as Collection<Restoran?>)
            notifyDataSetChanged()
        }
    }
}