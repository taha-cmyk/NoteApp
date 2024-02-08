package com.example.selfmd.data.settings

interface ISettingsRepository {
    fun getpreferedMode(): Int
    fun getpreferedFont(): String
    fun getpreferedFontSize(): Int
}