# FayazPermissions
An Easier &amp; Lazier approach to getting runtime permission in Android 6.0+

# Installation:
Add it in your root build.gradle at the end of repositories:

```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
````

Add the dependency

```
dependencies {
     implementation 'com.github.p32929:FayazPermissions:1.0.0.1'
}
```

# Usage
1. Declare all the necessary permissions in your ```AndroidManifest.xml``` file
2. To get a single permission, call ```EasyPn.getPermission()``` and to get multiple permissions call ```EasyPn.getPermission()```

# Example:
## Get single permission:
```
EasyPn.getPermission(Manifest.permission.READ_CONTACTS, context, new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                // Do whatever you want to do
                // After permissions are granted
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                // Do whatever you want to do
                // After the permission is denied
            }
        });
```

## Get multiple permissions:
```
ArrayList<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.READ_CONTACTS);
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        EasyPn.getPermissions(permissions, context, new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                // Do whatever you want to do
                // After permissions are granted
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                 // Do whatever you want to do
                 // After some/all permissions are denied
            }
        });
```

# Thanks to:
Alex Beshine (https://github.com/alex31n) for his ```bit-permission``` library

# License:
```
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
```