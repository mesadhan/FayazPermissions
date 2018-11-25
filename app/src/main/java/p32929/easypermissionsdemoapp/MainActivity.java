package p32929.easypermissionsdemoapp;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import p32929.easypermissionlibrary.bitpermission.PermissionListener;
import p32929.easypermissionlibrary.p32929.EasyPn;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyPn.getPermission(Manifest.permission.READ_PHONE_STATE, this, new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Denied", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getPermissions(View view) {
        EasyPn.getPermission(Manifest.permission.READ_PHONE_STATE, this, new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Denied", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
