package git;

import java.util.ArrayList;

public class LocalRepository {
    
    private ArrayList<Commit> Commits = new ArrayList<>();
    
    public ArrayList<Commit> getCommits() {
        return Commits;
    }

    public void setCommits(ArrayList<Commit> Commits) {
        this.Commits = Commits;
    }

    @Override
    public String toString() {
        return "LocalRepository{" + "Commits=" + Commits + '}';
    }
}
