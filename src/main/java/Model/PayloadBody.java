package Model;

public class PayloadBody {

    public static Model dataFromModel(String title, String description) {
        Model model = new Model(title, description);
        return model;
    }
}
