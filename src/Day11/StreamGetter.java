package Day11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.function.Consumer;

public class StreamGetter implements Runnable {
    private InputStream inputstream;
    private Consumer<String> consumer;

    public StreamGetter(InputStream inputStream, Consumer<String> consumer){
        this.inputstream = inputStream;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            new BufferedReader(new InputStreamReader(inputstream, "MS949")).lines().forEach(consumer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
