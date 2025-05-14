import com.google.gson.Gson;

public class JsonParaGson {
    private final Gson gson;

    public JsonParaGson() {
        this.gson = new Gson();
    }

    public Resposta parse(String json) {
        return gson.fromJson(json, Resposta.class);
    }

}

