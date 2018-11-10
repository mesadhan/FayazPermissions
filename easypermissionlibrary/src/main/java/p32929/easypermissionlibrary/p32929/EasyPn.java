package p32929.easypermissionlibrary.p32929;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

import p32929.easypermissionlibrary.bitpermission.BitPermission;
import p32929.easypermissionlibrary.bitpermission.PermissionListener;

/*
MIT License

Copyright (c) 2018 Fayaz Bin Salam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
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
