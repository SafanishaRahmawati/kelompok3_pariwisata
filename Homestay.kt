package com.example.kelompok3.model

class Homestay {
    private var nama_homestay: String? = null
    private var deskripsi_homestay: String? = null
    private var thumb_homestay: String? = null
    private var navigasi_homestay: String? = null
    private var notelp_homestay: String? = null
    private var email_homestay: String? = null
    private var alamat_homestay: String? = null
    private var non_aktif: String? = null
    private var id: String? = null

    constructor() {}
    constructor(nama_homestay: String?, deskripsi_homestay: String?, thumb_homestay: String?, navigasi_homestay: String?, notelp_homestay: String?, email_homestay: String?, alamat_homestay: String?, non_aktif: String?, id: String?) {
        this.nama_homestay = nama_homestay
        this.deskripsi_homestay = deskripsi_homestay
        this.thumb_homestay = thumb_homestay
        this.navigasi_homestay = navigasi_homestay
        this.notelp_homestay = notelp_homestay
        this.email_homestay = email_homestay
        this.alamat_homestay = alamat_homestay
        this.non_aktif = non_aktif
        this.id = id
    }

    fun getNama_homestay(): String? {
        return nama_homestay
    }

    fun setNama_homestay(nama_homestay: String?) {
        this.nama_homestay = nama_homestay
    }

    fun getDeskripsi_homestay(): String? {
        return deskripsi_homestay
    }

    fun setDeskripsi_homestay(deskripsi_homestay: String?) {
        this.deskripsi_homestay = deskripsi_homestay
    }

    fun getThumb_homestay(): String? {
        return thumb_homestay
    }

    fun setThumb_homestay(thumb_homestay: String?) {
        this.thumb_homestay = thumb_homestay
    }

    fun getNavigasi_homestay(): String? {
        return navigasi_homestay
    }

    fun setNavigasi_homestay(navigasi_homestay: String?) {
        this.navigasi_homestay = navigasi_homestay
    }

    fun getNotelp_homestay(): String? {
        return notelp_homestay
    }

    fun setNotelp_homestay(notelp_homestay: String?) {
        this.notelp_homestay = notelp_homestay
    }

    fun getEmail_homestay(): String? {
        return email_homestay
    }

    fun setEmail_homestay(email_homestay: String?) {
        this.email_homestay = email_homestay
    }

    fun getAlamat_homestay(): String? {
        return alamat_homestay
    }

    fun setAlamat_homestay(alamat_homestay: String?) {
        this.alamat_homestay = alamat_homestay
    }

    fun getNon_aktif(): String? {
        return non_aktif
    }

    fun getId(): String? {
        return id
    }
}