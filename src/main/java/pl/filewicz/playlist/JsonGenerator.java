package pl.filewicz.playlist;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonGenerator {
    public static void main(String[] args) {

        Artist ericCarmen = new Artist("Eric", "Carmen", 56);
        Artist edSheeran = new Artist("Ed", "Sheeran", 28);

        List<Item> items = new ArrayList();

        items.add(new Item(1, new Track("Hungry Eyes", ericCarmen, Genre.POP, "3:45")));
        items.add(new Item(2, new Track("Shape of You", edSheeran, Genre.POP, "3:15")));

        Playlist playlist = new Playlist("My Best Playslist", items);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("jukebox.json"), playlist);

            String jsonPrettyString = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(playlist);

            System.out.println(jsonPrettyString);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
