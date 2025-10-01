import com.google.gson.annotations.SerializedName;

import java.security.PublicKey;
import java.util.List;

public class PokemonAtributos {
    private String name;
    private int id;
    private List<TypeInfo> types;
    private List<StatInfo> stats;

    public PokemonAtributos() {}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<TypeInfo> getTypes() {
        return types;
    }

    public List<StatInfo> getStats() {
        return stats;
    }
    // classe container, ela tem o objeto do tipo TYPE
    public static class TypeInfo {
        @SerializedName("type")
        private Type type;

        public TypeInfo() {}

        public Type getType() {
            return type;
        }
        @Override
        public String toString(){
            return type.getName();
        }
    }

    public static class Type {
        private String name;

        public Type() {}

        public String getName() {
            return name;
        }
    }

    public static class StatInfo {
        @SerializedName("base_stat")
        private int baseStat;

        @SerializedName("stat")
        private Stat stat;

        public StatInfo() {}

        public int getBaseStat() {
            return baseStat;
        }

        public Stat getStat() {
            return stat;
        }
        @Override
        public String toString() {
            return stat.getName() + ": " + baseStat;
        }

    }

    public static class Stat {
        private String name;

        public Stat() {}

        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return name;
        }

    }
}
