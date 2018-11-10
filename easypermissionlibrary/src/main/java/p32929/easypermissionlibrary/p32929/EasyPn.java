package p32929.easypermissionlibrary.p32929;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

import p32929.easypermissionlibrary.bitpermission.BitPermission;
import p32929.easypermissionlibrary.bitpermission.PermissionListener;

/**
 * Created by p32929 on 11/10/2018.
 */

public class EasyPn {

    // To get single permission
    public static void getPermission(String permission, Context context, PermissionListener listener) {
        BitPermission bitPermission = BitPermission.with((Activity) context)
                .setPermissionListener(listener)
                .setPermissions(permission)
                .build();
        bitPermission.request();
    }

    // To get multiple permissions
    public static void getPermissions(ArrayList<String> permissions, Context context, PermissionListener listener) {
        BitPermission bitPermission = BitPermission.with((Activity) context)
                .setPermissionListener(listener)
                .setPermissions(permissions)
                .build();
        bitPermission.request();
    }
}
