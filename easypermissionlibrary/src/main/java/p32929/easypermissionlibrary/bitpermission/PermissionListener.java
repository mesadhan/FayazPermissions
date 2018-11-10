package p32929.easypermissionlibrary.bitpermission;

import java.util.ArrayList;


public interface PermissionListener {
    void onPermissionGranted();
    void onPermissionDenied(ArrayList<String> deniedPermissions);
}
