package p32929.easypermissionlibrary.bitpermission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import java.util.ArrayList;

public class PermissionActivity extends AppCompatActivity {

    private static PermissionListener permissionListener;
    private ArrayList<String> permissions;
    private final int PERMISSIONS_REQUEST_CODE = 32929;

    public static void startActivity(Context context, Intent intent, PermissionListener listener) {
        PermissionActivity.permissionListener = listener;
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        if (getIntent() != null) {
            if (getIntent().hasExtra("LIST")) {
                permissions = getIntent().getStringArrayListExtra("LIST");
            }
        }

        checkPermission();
    }


    private void checkPermission() {
        ArrayList<String> permissionList = new ArrayList<>();

        for (String per : permissions) {
            if (ContextCompat.checkSelfPermission(this, per) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(per);
            }
        }

        if (permissionList.size() > 0) {
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), PERMISSIONS_REQUEST_CODE);
        } else {
            permissionListener.onPermissionGranted();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE: {
                ArrayList<String> deniedPermissions = getDeniedPermissions(this, permissions);
                permissionResult(deniedPermissions);

            }

        }
    }

    private void permissionResult(ArrayList<String> deniedPermissions) {

        if (deniedPermissions == null || deniedPermissions.isEmpty()) {
            if (permissionListener != null) permissionListener.onPermissionGranted();
        } else {
            if (permissionListener != null)
                permissionListener.onPermissionDenied(deniedPermissions);
        }
        PermissionActivity.permissionListener = null;
        finish();
    }

    public static boolean isDenied(Context context, @NonNull String permission) {
        return ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED;
    }

    private static boolean isGranted(Context context, @NonNull String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private static ArrayList<String> getDeniedPermissions(Context context, @NonNull String... permissions) {
        ArrayList<String> deniedPermissions = new ArrayList<>();
        for (String permission : permissions) {
            if (isDenied(context, permission)) {
                deniedPermissions.add(permission);
            }
        }
        return deniedPermissions;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
