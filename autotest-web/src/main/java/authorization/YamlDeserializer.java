package authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlDeserializer {

    public Authorization deserialize() {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        Authorization auth = null;
        try {
            auth = mapper.readValue(new File("C:\\java\\Simple_BDD\\autotest-web\\src\\main\\resources\\auth.yaml"), Authorization.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auth;
    }
}
