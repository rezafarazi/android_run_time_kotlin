package com.sorapp.android_runtime_permission_kotlin

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.jar.Manifest

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE),200)
        };
    }


    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray)
    {
        if (requestCode==200)
        {
            var check=true;
            for (result in grantResults)
            {
                if(PackageManager.PERMISSION_DENIED==result)
                {
                    check=false;
                }
            }

            if(check)
            {
                Log.i("Errt","All Permissions Is OK");
            }
            else
            {
                Log.i("Errt","All Permissions Is Not OK");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }



}