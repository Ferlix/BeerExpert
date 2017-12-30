BrewExpert (CLIPS for Android)
==============

The *BeerExpert* is a project created to include `CLIPS <http://clipsrules.sourceforge.net/>`_ to Android, encapsulating the knowledge elicited from a beer brewer.


The project is organized as follows:

BeerExpert
  It is an application embedding an expert system specialized in beers and in brewing beers. It gives suggestions based on the user preference. It contains the rules and the facts (in the folder assets) necessary to make inference with forward chaining. The information about the beers are stored in a SQLite database. 
  
APK
  It's the folder containing the APK file for the installation of the application on your phone. To install it, just open this file on an Android device. 

ClipsAndroid
  It is an Android library which is intended to be used by other Android applications. To compile the project with Android Studio, it is necessary to compile the CLIPS module for Android first (see `Compiling CLIPS for Android`_.).


Compiling CLIPS for Android
---------------------------
To compile the app in Android Studio, it's necessary to compile CLIPS first (it should be already compiled anyway). 
Follow the following steps to compile the CLIPS module, written in C:

*Compiling CLIPS from Android Studio*
 1. Open the SDK manager in Android Studio
 2. Go to the SDK tools section
 3. Check the boxes next to NDK, LLDB and C-make and apply the changes to download them clicking OK
 4. Link the C module (the folder ClipsAndroid) with Gradle in the project explorer pane (with right-click)
 5. Select the file Android.mk to be build with ndk-build 
 6. Clean the environment and build the app

*Compiling CLIPS from command line*
 1. Install the `NDK <http://developer.android.com/tools/sdk/ndk/index.html>`_
 2. Go to the *jni* folder
 3. Run *ndk-build* [*]_

 .. [*] Providing you have added it to your *PATH*.



Debugging CLIPS on Android
--------------------------

The cleanest way to show messages from a native library in Android is by simply redirecting its output (see `Redirecting stdout`_).
The CLIPS' module is forced to show all its messages using Logcat (see `Logcat from native code`_).


Redirecting stdout
******************

CLIPS may throw *system exits*.
As a result, the Android process using CLIPS can unexpectedly crash without giving any useful information.
To show CLIPS' original error messages, redirect NDK's standard output to *LogCat* using the following commands:

.. code-block:: bash

  $ adb shell stop
  $ adb shell setprop log.redirect-stdio true
  $ adb shell start


Logcat from native code
***********************

Sometimes the previous property does not work (I don't know why yet).
Since `messages can be directly logged on Logcat <http://stackoverflow.com/questions/10274920/how-to-get-printf-messgaes-written-in-ndk-application/10275209#10275209>`_,
we replaced the printf's with these *Logcat*'s logs in the `issue 2 <https://github.com/gomezgoiri/CLIPSonAndroid/issues/2>`_ .

To that end, we have done an `utility macro <https://github.com/gomezgoiri/CLIPSonAndroid/blob/master/ClipsAndroid/jni/clips/logcat.h>`_.
Common usage:

.. code-block:: c

  #include "logcat.h"

  ...

  aprintf("This is an standard message\n");


License
-------

CLIPS's source files remain licensed in the *public domain*.

The rest of the parts of this project will be licensed also as *public domain*  unless the contrary is stated.


Acknowledgements and remarks
----------------
The original project was downloaded from `CLIPS4Android project <https://github.com/gomezgoiri/CLIPS4Android>`_ and modified
for the development of an app at the University of Groningen (Netherlands).

The development was possible with the work done in the `CLIPSJNI project <http://clipsrules.sourceforge.net/CLIPSJNIBeta.html>`_.
Besides, this project is supported or has been supported by the `THOFU R&D project <http://www.thofu.es/>`_ (project grant CEN-20101019).
