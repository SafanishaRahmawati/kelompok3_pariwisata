package com.example.kelompok3.adapters.pengguna

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok3.R
import com.example.kelompok3.activity.pengguna.homestay.DetaillHomestayActivity
import com.example.kelompok3.model.Homestay
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class RVHomestay : RecyclerView.Adapter<RVHomestay.MyViewHolder?>, Filterable {
    private var mContext: Context? = null
    private var mData: MutableList<Homestay?>? = mutableListOf()
    var option: RequestOptions? = null

    constructor(mContext: Context?, mData: MutableList<Homestay?>?) {
        this.mContext = mContext
        this.mData = mData
        option = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)
    }

    constructor(mData: MutableList<Homestay?>?) {
        this.mData = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val inflater = LayoutInflater.from(mContext)
        view = inflater.inflate(R.layout.item_homestay, parent, false)
        val viewHolder: MyViewHolder = MyViewHolder(view)
        viewHolder.view_containerR?.setOnClickListener(View.OnClickListener {
            val i = Intent(mContext, DetaillHomestayActivity::class.java)
            i.putExtra("tvHomestayH", mData?.get(viewHolder.adapterPosition)?.getNama_homestay())
            i.putExtra("tvDeskripsiH", mData?.get(viewHolder.adapterPosition)?.getDeskripsi_homestay())
            i.putExtra("imgThumbH", mData?.get(viewHolder.adapterPosition)?.getThumb_homestay())
            i.putExtra("tvNavigasiiH", mData?.get(viewHolder.adapterPosition)?.getNavigasi_homestay())
            i.putExtra("emailH", mData?.get(viewHolder.adapterPosition)?.getEmail_homestay())
            i.putExtra("alamatH", mData?.get(viewHolder.adapterPosition)?.getAlamat_homestay())
            i.putExtra("notelpH", mData?.get(viewHolder.adapterPosition)?.getNotelp_homestay())
            mContext?.startActivity(i)
        })
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val d = mData?.get(position)?.getNon_aktif()
        if (d == "1") {
            holder.tvNamaH?.setText(mData?.get(position)?.getNama_homestay())
            holder.tvDeskripsiH?.setText(mData?.get(position)?.getDeskripsi_homestay())
            holder.tv_navigasiH?.setText(mData?.get(position)?.getNavigasi_homestay())
            holder.tvEmailH?.setText(mData?.get(position)?.getEmail_homestay())
            holder.tvAlamatH?.setText(mData?.get(position)?.getAlamat_homestay())

            //Load Image
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_homestay()).apply(option!!).into(holder.img_thumbH!!)
        } else {
            holder.tvNamaH?.setText(mData?.get(position)?.getNama_homestay())
            holder.llManipulasi?.setVisibility(View.VISIBLE)
            Glide.with(mContext!!).load(mData?.get(position)?.getThumb_homestay()).apply(option!!).into(holder.img_thumbH!!)
        }
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    override fun getFilter(): Filter? {
        return pariwisataFilter
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNamaH: TextView?
        var tvDeskripsiH: TextView?
        var tv_navigasiH: TextView?
        var tvEmailH: TextView?
        var tvNoTelH: TextView?
        var tvAlamatH: TextView?
        var img_thumbH: ImageView?
        var view_containerR: RelativeLayout?
        var llManipulasi: LinearLayout?

        init {
            tvNamaH = itemView.findViewById(R.id.tvHomestayH)
            tvDeskripsiH = itemView.findViewById(R.id.tvDeskripsiH)
            tv_navigasiH = itemView.findViewById(R.id.tvNavigasiiH)
            tvEmailH = itemView.findViewById(R.id.emailH)
            tvNoTelH = itemView.findViewById(R.id.notelpH)
            tvAlamatH = itemView.findViewById(R.id.alamatH)
            img_thumbH = itemView.findViewById(R.id.imgThumbH)
            view_containerR = itemView.findViewById(R.id.container1H)
            llManipulasi = itemView.findViewById(R.id.llManipulasi003)
        }
    }

    private val pariwisataFilter: Filter? = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults? {
            val filteredList: MutableList<Homestay?> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                filteredList.addAll(mData!!)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
                for (item in mData!!) {
                    if (item?.getNama_homestay()?.toLowerCase()?.contains(filterPattern) == true) {
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
            mData?.addAll(results?.values as Collection<Homestay?>)
            notifyDataSetChanged()
        }
    }
}