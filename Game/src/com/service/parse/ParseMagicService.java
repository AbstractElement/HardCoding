package com.service.parse;

import com.skills.Magic;
import com.skills.impl.OffensiveMagic;
import com.skills.impl.ProtectiveMagic;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Vladislav on 31.01.2017.
 */
public class ParseMagicService {
    private static BufferedReader reader = null;
    private static HashMap<String, Magic> magics = new HashMap<String, Magic>();
    private final static String PATH_OFFENSIVE_MAGIC = "src/resources/offensiveMagic";
    private final static String PATH_PROTECTIVE_MAGIC = "src/resources/protectiveMagic";

    public static HashMap<String, Magic> getOffensiveMagic() throws IOException {
        reader = new BufferedReader(new FileReader(new File(PATH_OFFENSIVE_MAGIC)));
        while (reader.ready()){
            String[] line = reader.readLine().split(":");
            magics.put(line[0], new OffensiveMagic(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
        }
        reader.close();
        return magics;
    }

    public static HashMap<String, Magic> getProtectiveMagic() throws IOException {
        reader = new BufferedReader(new FileReader(new File(PATH_PROTECTIVE_MAGIC)));
        while (reader.ready()){
            String[] line = reader.readLine().split(":");
            magics.put(line[0], new ProtectiveMagic(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
        }
        reader.close();
        return magics;
    }

    public static HashMap<String, Magic> getAllMagic() throws IOException {
        getOffensiveMagic();
        return getProtectiveMagic();
    }
}
