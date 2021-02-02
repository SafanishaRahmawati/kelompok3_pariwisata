package com.example.kelompok3.adapters.pengguna

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok3.R
import com.example.kelompok3.activity.pengguna.konvensional.DetailKonvensionalActivity
import com.example.kelompok3.model.WisataKonvensional
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class RVKonvensional : RecyclerView.Adapter<RVKonvensional.MyViewHolder?>, Filterable {
    private var mContext: Context? = null
    private var mData: MutableList<WisataKonvensional?>? = mutableListOf()
    var option: RequestOptions? = null

    constructor(mContext: Context?, mData: MutableList<WisataKonvensional?>?) {
        this.mContext = mContext
        this.mData = mData

        //Request option for glide
        option = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)
    }

    constructor(mData: MutableList<WisataKonvensional?>?) {
        this.mData = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val inflater = LayoutInflater.from(mContext)
        view = inflater.inflate(R.layout.item_konvensional, parent, false)
        val viewHolder: MyViewHolder = MyViewHolder(view)
        viewHolder.view_container?.setOnClickListener(View.OnClickListener {
            val i = Intent(mContext, DetailKonvensionalActivity::class.java)
            i.putExtra("tvHomestay", mData?.get(viewHolder.adapterPosition)?.getNama_wisata())
            i.putExtra("tvDeskripsi", mData?.get(viewHolder.adapterPosition)?.getDeskripsi_wisata())
            i.putExtra("imgThumb", mData?.get(viewHolder.adapterPosition)?.getThumb_wisata())
            i.putExtra("tvNavigasii", mData?.get(viewHolder.adapterPosition)?.getNavigasi_wisata())
            i.putExtra("email", mData?.get(viewHolder.adapterPosition)?.getEmail_wisata())
            i.putExtra("alamat", mData?.get(viewHolder.adapterPosition)?.getAlamat_wisata())
            i.putExtra("notelp", mData?.get(viewHolder.adapterPosition)?.getNotelp_wisata())
            mContext?.startActivity(i)
        })
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val A = mData?.get(position)?.getNon_aktif()
        if (A == "1") {
            holder.tvNamaWisata?.setText(mData?.get(position)?.getNama_wisata())
            holder.tvDeskripsi?.setText(mData?.get(position)?.getDeskripsi_wisata())
            holder.tv_navigasi?.setText(mData?.get(position)?.getNavigasi_wisata())
            holder.tvNoTelp?.setText(mData?.get(position)?.getNotelp_wisata())
            holder.tvEmail?.setText(mData?.get(position)?.getEmail_wisata())
            holder.tvAlamat?.setText(mData?.get(position)?.getAlamat_wisata())

            //Load Image
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_wisata()).apply(option!!).into(holder.img_thumb!!)
        } else {
            holder.tvNamaWisata?.setText(mData?.get(position)?.getNama_wisata())
            holder.manipulasiKonvensional?.setVisibility(View.VISIBLE)
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_wisata()).apply(option!!).into(holder.img_thumb!!)
        }
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNamaWisata: TextView?
        var tvDeskripsi: TextView?
        var tv_navigasi: TextView?
        var tvEmail: TextView?
        var tvNoTelp: TextView?
        var tvAlamat: TextView?
        var img_thumb: ImageView?
        var view_container: RelativeLayout?
        var manipulasiKonvensional: LinearLayout?

        init {
            tvNamaWisata = itemView.findViewById(R.id.tvHomestay)
            tvDeskripsi = itemView.findViewById(R.id.tvDeskripsi)
            img_thumb = itemView.findViewById(R.id.imgThumb)
            view_container = itemView.findViewById(R.id.container1)
            tv_navigasi = itemView.findViewById(R.id.tvNavigasii)
            tvEmail = itemView.findViewById(R.id.email)
            tvAlamat = itemView.findViewById(R.id.alamat)
            tvNoTelp = itemView.findViewById(R.id.notelp)
            manipulasiKonvensional = itemView.findViewById(R.id.llManipulasi001)
        }
    }

    override fun getFilter(): Filter? {
        return pariwsataFilter
    }

    private val pariwsataFilter: Filter? = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults? {
            val filteredList: MutableList<WisataKonvensional?> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(mData!!)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
                for (item in mData!!) {
                    if (item?.getNama_wisata()?.toLowerCase()?.contains(filterPattern) == true) {
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
            mData?.addAll(results?.values as Collection<WisataKonvensional?>)
            notifyDataSetChanged()
        }
    }
}