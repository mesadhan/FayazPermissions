package p32929.easypermissionsdemoapp;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import p32929.easypermissionlibrary.bitpermission.PermissionListener;
import p32929.easypermissionlibrary.p32929.EasyPn;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getPermissions(View view) {
        ArrayList<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.READ_CONTACTS);
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        EasyPn.getPermissions(permissions, this, new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Log.d(TAG, "onPermissionGranted: ");
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                for (int i = 0; i < deniedPermissions.size(); i++) {
                    Log.d(TAG, "onPermissionDenied: DeniedPermissions: " + deniedPermissions.get(i).toString());
                }
            }
        });
    }
}
