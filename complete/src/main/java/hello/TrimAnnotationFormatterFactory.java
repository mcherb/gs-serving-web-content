package hello;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;

public class TrimAnnotationFormatterFactory implements AnnotationFormatterFactory<Trim> {
    public TrimAnnotationFormatterFactory() {
    }

    public Set<Class<?>> getFieldTypes() {
        return Collections.singleton(String.class);
    }

    public Printer<String> getPrinter(Trim annotation, Class<?> fieldType) {
        return new TrimAnnotationFormatterFactory.TrimFormatter(annotation.squashMultipleSpaces());
    }

    public Parser<String> getParser(Trim annotation, Class<?> fieldType) {
        return new TrimAnnotationFormatterFactory.TrimFormatter(annotation.squashMultipleSpaces());
    }

    private static class TrimFormatter implements Formatter<String> {
        private final boolean squashMultipleSpaces;

        TrimFormatter(boolean squashMultipleSpaces) {
            this.squashMultipleSpaces = squashMultipleSpaces;
        }

        public String parse(String text, Locale locale) {
            System.out.println("PARSE");
            return this.process(text);
        }

        public String print(String object, Locale locale) {
            System.out.println("PRING");
            return this.process(object);
        }

        private String process(String text) {
            System.out.println("BEFORE: [" +  text + "]");
            if (text == null) {
                return null;
            } else {
                String newText = this.squashMultipleSpaces ? text.trim().replaceAll("\\s+", " ") : text.trim();

                System.out.println("AFTER: [" +  newText + "]");
                return newText;
            }
        }
    }
}
