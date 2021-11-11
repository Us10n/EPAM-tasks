package com.epamjwd.task4;

import com.epamjwd.task4.entity.CompositeComponent;
import com.epamjwd.task4.exception.FileException;
import com.epamjwd.task4.parcer.TextParser;
import com.epamjwd.task4.parcer.impl.ParagraphParser;
import com.epamjwd.task4.reader.impl.CustomReaderImpl;
import com.epamjwd.task4.service.impl.TextServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String fileName= "/data/text.txt";
    public static void main(String[] args) throws FileException {
        CustomReaderImpl reader=new CustomReaderImpl();
        String text=reader.readAll(fileName);
        TextParser textParser=new ParagraphParser();
        CompositeComponent textComposite =textParser.parse(text);
        TextServiceImpl textService=new TextServiceImpl();
    }
}
