package com.example.kelompok3.model

class WisataKonvensional {
    private var nama_wisata: String? = null
    private var deskripsi_wisata: String? = null
    private var thumb_wisata: String? = null
    private var navigasi_wisata: String? = null
    private var notelp_wisata: String? = null
    private var email_wisata: String? = null
    private var alamat_wisata: String? = null
    private var id: String? = null
    private var non_aktif: String? = null

    constructor() {}
    constructor(nama_wisata: String?, deskripsi_wisata: String?, thumb_wisata: String?, navigasi_wisata: String?, notelp_wisata: String?, email_wisata: String?, alamat_wisata: String?, id: String?, non_aktif: String?) {
        this.nama_wisata = nama_wisata
        this.deskripsi_wisata = deskripsi_wisata
        this.thumb_wisata = thumb_wisata
        this.navigasi_wisata = navigasi_wisata
        this.notelp_wisata = notelp_wisata
        this.email_wisata = email_wisata
        this.alamat_wisata = alamat_wisata
        this.id = id
        this.non_aktif = non_aktif
    }

    fun getNama_wisata(): String? {
        return nama_wisata
    }

    fun setNama_wisata(nama_wisata: String?) {
        this.nama_wisata = nama_wisata
    }

    fun getDeskripsi_wisata(): String? {
        return deskripsi_wisata
    }

    fun setDeskripsi_wisata(deskripsi_wisata: String?) {
        this.deskripsi_wisata = deskripsi_wisata
    }

    fun getThumb_wisata(): String? {
        return thumb_wisata
    }

    fun setThumb_wisata(thumb_wisata: String?) {
        this.thumb_wisata = thumb_wisata
    }

    fun getNavigasi_wisata(): String? {
        return navigasi_wisata
    }

    fun setNavigasi_wisata(navigasi_wisata: String?) {
        this.navigasi_wisata = navigasi_wisata
    }

    fun getNotelp_wisata(): String? {
        return notelp_wisata
    }

    fun setNotelp_wisata(notelp_wisata: String?) {
        this.notelp_wisata = notelp_wisata
    }

    fun getEmail_wisata(): String? {
        return email_wisata
    }

    fun setEmail_wisata(email_wisata: String?) {
        this.email_wisata = email_wisata
    }

    fun getAlamat_wisata(): String? {
        return alamat_wisata
    }

    fun setAlamat_wisata(alamat_wisata: String?) {
        this.alamat_wisata = alamat_wisata
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getNon_aktif(): String? {
        return non_aktif
    }

    fun setNon_aktif(non_aktif: String?) {
        this.non_aktif = non_aktif
    }
}