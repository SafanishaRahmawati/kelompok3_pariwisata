package com.example.kelompok3.adapters.pengguna

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok3.R
import com.example.kelompok3.activity.pengguna.religi.DetailReligiActivity
import com.example.kelompok3.model.WisataReligi
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class RVReligi : RecyclerView.Adapter<RVReligi.MyViewHolder?>, Filterable {
    private var mContext: Context? = null
    private var mData: MutableList<WisataReligi?>? = mutableListOf()
    var option: RequestOptions? = null

    constructor(mContext: Context?, mData: MutableList<WisataReligi?>?) {
        this.mContext = mContext
        this.mData = mData
        option = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)
    }

    constructor(mData: MutableList<WisataReligi?>?) {
        this.mData = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val inflater = LayoutInflater.from(mContext)
        view = inflater.inflate(R.layout.item_religi, parent, false)
        val viewHolder: MyViewHolder = MyViewHolder(view)
        viewHolder.view_containerR?.setOnClickListener(View.OnClickListener {
            val i = Intent(mContext, DetailReligiActivity::class.java)
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
        val b = mData?.get(position)?.getNon_aktif()
        if (b == "1") {
            holder.tvNamaWisataR?.setText(mData?.get(position)?.getNama_wisata())
            holder.tvDeskripsiR?.setText(mData?.get(position)?.getDeskripsi_wisata())
            holder.tv_navigasiR?.setText(mData?.get(position)?.getNavigasi_wisata())
            holder.tvNoTelpR?.setText(mData?.get(position)?.getNotelp_wisata())
            holder.tvEmailR?.setText(mData?.get(position)?.getEmail_wisata())
            holder.tvAlamatR?.setText(mData?.get(position)?.getAlamat_wisata())

            //Load Image
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_wisata()).apply(option!!).into(holder.img_thumbR!!)
        } else {
            holder.tvNamaWisataR?.setText(mData?.get(position)?.getNama_wisata())
            holder.llmanupulasi?.setVisibility(View.VISIBLE)
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_wisata()).apply(option!!).into(holder.img_thumbR!!)
        }
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNamaWisataR: TextView?
        var tvDeskripsiR: TextView?
        var tv_navigasiR: TextView?
        var tvEmailR: TextView?
        var tvNoTelpR: TextView?
        var tvAlamatR: TextView?
        var img_thumbR: ImageView?
        var view_containerR: RelativeLayout?
        var llmanupulasi: LinearLayout?

        init {
            tvNamaWisataR = itemView.findViewById(R.id.tvHomestayR)
            tvDeskripsiR = itemView.findViewById(R.id.tvDeskripsiR)
            img_thumbR = itemView.findViewById(R.id.imgThumbR)
            tv_navigasiR = itemView.findViewById(R.id.tvNavigasiiR)
            tvEmailR = itemView.findViewById(R.id.emailR)
            tvAlamatR = itemView.findViewById(R.id.alamatR)
            tvNoTelpR = itemView.findViewById(R.id.notelpR)
            view_containerR = itemView.findViewById(R.id.container1R)
            llmanupulasi = itemView.findViewById(R.id.llManipulasi002)
        }
    }

    override fun getFilter(): Filter? {
        return pariwisataFilter
    }

    private val pariwisataFilter: Filter? = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults? {
            val filteredList: MutableList<WisataReligi?> = ArrayList()
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
            mData?.addAll(results?.values as Collection<WisataReligi?>)
            notifyDataSetChanged()
        }
    }
}