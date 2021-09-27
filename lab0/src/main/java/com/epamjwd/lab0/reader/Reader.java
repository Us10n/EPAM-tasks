package com.epamjwd.lab0.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private FileReader fReader;

    public Reader(File file) throws FileNotFoundException {
        this.fReader=new FileReader(file);
    }

    public String readAll() throws IOException {
        String result="";
        int ch;

        while((ch=fReader.read())!=-1){
            result+=(char)ch;
        }
        return result;
    }

    public void close() throws IOException {
        fReader.close();
    }
}
