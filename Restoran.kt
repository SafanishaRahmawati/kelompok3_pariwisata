package com.example.kelompok3.model

class Restoran {
    private var nama_restoran: String? = null
    private var deskripsi_restoran: String? = null
    private var thumb_restoran: String? = null
    private var navigasi_restoran: String? = null
    private var notelp_restoran: String? = null
    private var email_restoran: String? = null
    private var alamat_restoran: String? = null
    private var non_aktif: String? = null
    private var id: String? = null

    constructor() {}
    constructor(nama_restoran: String?, deskripsi_restoran: String?, thumb_restoran: String?, navigasi_restoran: String?, notelp_restoran: String?, email_restoran: String?, alamat_restoran: String?, non_aktif: String?, id: String?) {
        this.nama_restoran = nama_restoran
        this.deskripsi_restoran = deskripsi_restoran
        this.thumb_restoran = thumb_restoran
        this.navigasi_restoran = navigasi_restoran
        this.notelp_restoran = notelp_restoran
        this.email_restoran = email_restoran
        this.alamat_restoran = alamat_restoran
        this.non_aktif = non_aktif
        this.id = id
    }

    fun getNama_restoran(): String? {
        return nama_restoran
    }

    fun setNama_restoran(nama_restoran: String?) {
        this.nama_restoran = nama_restoran
    }

    fun getDeskripsi_restoran(): String? {
        return deskripsi_restoran
    }

    fun setDeskripsi_restoran(deskripsi_restoran: String?) {
        this.deskripsi_restoran = deskripsi_restoran
    }

    fun getThumb_restoran(): String? {
        return thumb_restoran
    }

    fun setThumb_restoran(thumb_restoran: String?) {
        this.thumb_restoran = thumb_restoran
    }

    fun getNavigasi_restoran(): String? {
        return navigasi_restoran
    }

    fun setNavigasi_restoran(navigasi_restoran: String?) {
        this.navigasi_restoran = navigasi_restoran
    }

    fun getNotelp_restoran(): String? {
        return notelp_restoran
    }

    fun setNotelp_restoran(notelp_restoran: String?) {
        this.notelp_restoran = notelp_restoran
    }

    fun getEmail_restoran(): String? {
        return email_restoran
    }

    fun setEmail_restoran(email_restoran: String?) {
        this.email_restoran = email_restoran
    }

    fun getAlamat_restoran(): String? {
        return alamat_restoran
    }

    fun setAlamat_restoran(alamat_restoran: String?) {
        this.alamat_restoran = alamat_restoran
    }

    fun getNon_aktif(): String? {
        return non_aktif
    }

    fun getId(): String? {
        return id
    }
}