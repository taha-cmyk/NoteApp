package com.example.selfmd.data.settings

class SettingsRepositoryImpl:ISettingsRepository {
    override fun getpreferedMode(): Int {
        return 1
    }

    override fun getpreferedFont(): String {
        return "System"
    }

    override fun getpreferedFontSize(): Int {
        return 14
    }
}