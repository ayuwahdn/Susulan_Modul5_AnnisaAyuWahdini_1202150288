package com.example.android.Susulan_Modul5_AnnisaAyuWahdini_1202150288;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;


//pengaturan fragment dari setting.xml
public class SetFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.setting, rootKey);
    }
}