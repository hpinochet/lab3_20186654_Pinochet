package git;

public class ZonaTrabajo {
    
    private String nombreRepositorio;
    private String nombreAutor;
    private Workspace workspace;
    private Index index;
    private LocalRepository local;
    private RemoteRepository remote;
    
    public ZonaTrabajo(String nombreRepositorio, String nombreAutor) {
        this.nombreRepositorio = nombreRepositorio;
        this.nombreAutor = nombreAutor;
        this.workspace = new Workspace();
        this.index = new Index();
        this.local = new LocalRepository();
        this.remote = new RemoteRepository();
    }

    public String getNombreRepositorio() {
        return nombreRepositorio;
    }

    public void setNombreRepositorio(String nombreRepositorio) {
        this.nombreRepositorio = nombreRepositorio;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public LocalRepository getLocal() {
        return local;
    }

    public void setLocal(LocalRepository local) {
        this.local = local;
    }

    public RemoteRepository getRemote() {
        return remote;
    }

    public void setRemote(RemoteRepository remote) {
        this.remote = remote;
    }

    @Override
    public String toString() {
        return "ZonaTrabajo{" + "\nnombreRepositorio=" + nombreRepositorio + ", \nnombreAutor=" + nombreAutor + ", \nworkspace=" + workspace + ", \nindex=" + index + ", \nlocal=" + local + ", \nremote=" + remote + '}';
    }
    
}
