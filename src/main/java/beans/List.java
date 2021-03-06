package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class List {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("pos")
    @Expose
    private Integer pos;
    @SerializedName("idBoard")
    @Expose
    private String idBoard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(List.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null) ? "<null>" : this.closed));
        sb.append(',');
        sb.append("pos");
        sb.append('=');
        sb.append(((this.pos == null) ? "<null>" : this.pos));
        sb.append(',');
        sb.append("idBoard");
        sb.append('=');
        sb.append(((this.idBoard == null) ? "<null>" : this.idBoard));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.closed == null) ? 0 : this.closed.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.idBoard == null) ? 0 : this.idBoard.hashCode()));
        result = ((result * 31) + ((this.pos == null) ? 0 : this.pos.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof List)) {
            return false;
        }
        List rhs = ((List) other);
        return (((((Objects.equals(this.name, rhs.name))
                && (Objects.equals(this.closed, rhs.closed)))
                && (Objects.equals(this.id, rhs.id)))
                && (Objects.equals(this.idBoard, rhs.idBoard)))
                && (Objects.equals(this.pos, rhs.pos)));
    }

}
