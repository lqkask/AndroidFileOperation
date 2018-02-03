package com.example.xfw.myapplication.utils;

import android.text.TextUtils;
import android.util.Log;

import com.example.xfw.myapplication.error.ErrorCode;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kyleli on 2018/2/3.
 */

public class Utilities {

    public static int setmentFile(String path, String file) {

        if (TextUtils.isEmpty(path) || TextUtils.isEmpty(fileName)) {
            return ErrorCode.FILE_PARAMTER_ERROR;
        }

        File originFile = new File(path, fileName);

        String fileName = originFile.

        File oldFile = new File(FILE_DIRECTORY, FILE_NAME + FILE_EXTENSION);
        OutputStream out = null;
        InputStream in = null;
        int len = 0;
        int fileIndex = 1;
        byte[] buffer = new byte[2048];
        int size = 1000;

        Log.d("AHELLO", "set size 1000");

        try {
            in = new FileInputStream(oldFile);
            int i;
            while (true) {
                Log.d("AHELLO", "in while");
                out = new FileOutputStream(FILE_DIRECTORY + "new" + File.separator + FILE_NAME + fileIndex + FILE_EXTENSION);
                for (i = 0; i < size; i++ ) {
                    if ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    } else {
                        return 0;
                    }
                }
                fileIndex++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;

    }



}
