package git;

import java.util.ArrayList;

public class RemoteRepository {
    
    private ArrayList<Commit> Commits = new ArrayList<>();
    
    public ArrayList<Commit> getCommits() {
        return Commits;
    }

    public void setCommits(ArrayList<Commit> Commits) {
        this.Commits = Commits;
    }

    @Override
    public String toString() {
        return "RemoteRepository{" + "Commits=" + Commits + '}';
    }    
}
