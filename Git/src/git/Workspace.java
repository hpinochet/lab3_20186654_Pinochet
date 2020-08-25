package git;

import java.util.ArrayList;

public class Workspace {
    
    private ArrayList<TextoPlano> TextosPlanos = new ArrayList<>();
    
    public ArrayList<TextoPlano> getTextosPlanos() {
        return TextosPlanos;
    }

    public void setTextosPlanos(ArrayList<TextoPlano> TextosPlanos) {
        this.TextosPlanos = TextosPlanos;
    }

    @Override
    public String toString() {
        return "Workspace{" + "TextosPlanos=" + TextosPlanos + '}';
    }
}
